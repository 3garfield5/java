package lab6;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(10);
        System.out.println("Пустой? " + stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);


        System.out.println("Размер - " + stack.getSize());

        System.out.println("Верхний элемент до удаления " + stack.peek());

        stack.pop();
        System.out.println("Верхний элемент после удаления " + stack.peek());

        System.out.println("Пустой? " + stack.isEmpty());

        System.out.println("Размер - " + stack.getSize());

    }
}
