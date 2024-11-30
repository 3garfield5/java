package lab7;

public class MaxTask implements Runnable {
    private int[] row;
    private int maxValue = Integer.MIN_VALUE;

    public MaxTask(int[] row) {
        this.row = row;
    }

    @Override
    public void run() {
        maxValue = row[0];
        for (int i = 1; i < row.length; i++) {
            if (row[i] > maxValue) {
                maxValue = row[i];
            }
        }

    }

    public int getMaxValue() {
        return maxValue;
    }
}
