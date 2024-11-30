package lab7;

public class MultiThreadedSum {
    public static void main(String[] args) throws InterruptedException {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int len = array.length;

        SumTask task = new SumTask(0, len / 2, array);
        SumTask task2 = new SumTask(len / 2, len, array);

        Thread thread = new Thread(task);
        Thread thread2 = new Thread(task2);

        thread.start();
        thread2.start();

        thread.join();
        thread2.join();

        int total = task.getSum() + task2.getSum();

        System.out.println("Сумма первого потока: " + task.getSum());
        System.out.println("Сумма второго потока: " + task2.getSum());
        System.out.println("Сумма двух потоков: " + total);
    }
}
