package lab7;

public class MultiThreadedMaxFinder {
    public static void main(String[] args) throws InterruptedException {
        int[][] matrix = {
                {100, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 66, 13, 14, 15},
                {16, 17, 77, 19, 20},
                {21, 22, 23, 24, 25}
        };

        int rows = matrix.length;
        MaxTask[] tasks = new MaxTask[rows];
        Thread[] threads = new Thread[rows];

        for (int i = 0; i < matrix.length; i++) {
            tasks[i] = new MaxTask(matrix[i]);
            threads[i] = new Thread(tasks[i]);
            threads[i].start();
        }

        for (int i = 0; i < rows; i++) {
            threads[i].join();
        }

        int max = tasks[0].getMaxValue();
        for (int i = 1; i < rows; i++) {
            if (tasks[i].getMaxValue() > max) {
                max = tasks[i].getMaxValue();
            }
        }
        System.out.println("Максимальное значение: " + max);
    }
}
