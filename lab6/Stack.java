package lab6;

public class Stack<T> {
    private T[] data;
    private int size;

    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T element) {
        data[size++] = element;
    }

    public void pop() {
        if (size == 0) {
            throw new IllegalArgumentException("Стек пуст");
        }
        T element = data[size--];
        data[size] = null;
    }

    public T peek() {
        if (size == 0) {
            throw new IllegalArgumentException("Стек пуст");
        }
        return data[size - 1];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
