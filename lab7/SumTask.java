package lab7;

public class SumTask implements Runnable {
    private int start;
    private int end;
    private int[] array;
    private int sum;

    public SumTask(int start, int end, int[] array) {
        this.start = start;
        this.end = end;
        this.array = array;
    }

    @Override
    public void run() {
        sum = 0;
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
    }

    public int getSum() {
        return sum;
    }
}
