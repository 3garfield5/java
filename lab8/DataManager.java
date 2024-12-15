package lab8;

import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class DataManager {

    private static List<Method> dataProcessors = new ArrayList<>(); // список обработчиков данных <Object>
    private static final List<Object> dataFinal = new ArrayList<>(); // Список данных для обработки
    private static List<String> updatedData = new ArrayList<>();


    public void registerDataProcessor(Object processor) {
        Method[] methods = processor.getClass().getDeclaredMethods();

        for (Method method : methods) {
          if (method.isAnnotationPresent(DataProcessor.class)) {
            dataProcessors.add(method);
            return;
          }
        }
        System.out.println(processor.getClass().getSimpleName() + " has no method annotated with @DataProcessor");
    }

    public void loadData(String source) {

        File file = new File(source);
        Reader fileReader;
        String data;

        try {
            fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            data = br.readLine();

            while (data != null) {
                String[] words = data.split(" "); // split each line

                for (String word : words) {
                    dataFinal.add(word);
                }

                data= br.readLine();
            }

            br.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("Данные успешно загружены из файла: " + source);

    }

    public void processData() {
        // Создаём пул потоков
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        List<Future<Void>> tasks = new ArrayList<>();

        dataProcessors.stream()
                .filter(method -> method.getParameterCount() == 1 && method.getParameterTypes()[0] == List.class)
                .forEach(method -> {
                    // Создаём задачу для выполнения метода
                    Callable<Void> task = () -> {
                        try {
                            // Вызываем метод
                            Object result = method.invoke(null, dataFinal);

                            if (result instanceof List) {

                                String fileName = method.getName() + ".txt";
                                updatedData = (List<String>) result;
                                saveData(fileName, updatedData);

                                System.out.println("Результат метода " + method.getName() + " сохранён в файл: " + fileName);
                            } else {
                                System.err.println("Метод " + method.getName() + " не вернул список.");
                            }
                        } catch (Exception e) {
                            System.err.println("Ошибка при вызове метода " + method.getName() + ": " + e.getMessage());
                            e.printStackTrace();
                        }
                        return null;
                    };

                    tasks.add(executor.submit(task));
                });

        // Дожидаемся завершения всех задач
        for (Future<Void> task : tasks) {
            try {
                task.get(); // Ожидание выполнения задачи
            } catch (Exception e) {
                System.err.println("Ошибка при выполнении задачи: " + e.getMessage());
                e.printStackTrace();
            }
        }
        // Завершаем пул потоков
        executor.shutdown();
    }

    public void saveData(String destination, List<String> updatedData) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            for (String result : updatedData) {
                writer.write(result);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
            e.printStackTrace();
        }
    }

}

