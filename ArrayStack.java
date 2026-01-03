package assignment1;

public class ArrayStack implements Stack<Object> {

    private Object[] S;
    private int top;

    public ArrayStack(int capacity) {

        if (capacity <= 0) {
            throw new RuntimeException("Capacity Error - Must be positive");
        }
        S = new Object[capacity];
        top = -1;
    }

    public void push(Object x) {

        if (top >= S.length - 1) {
            throw new RuntimeException("Stack is full");

        }

        top++;
        S[top] = x;
    }

    public Object pop() {

        if (top == -1) {
            throw new RuntimeException("Stack is empty");
        }

        Object element = S[top];
        S[top] = null;
        top--;
        return element;
    }

    public Object peek() {

        if (top == -1) {
            throw new RuntimeException("Stack is empty");
        }

        return S[top];
    }

    public boolean empty() {

        return top == -1;
    }

    public static void main(String[] args) {
        Stack<Object> test = new ArrayStack(20);
        System.out.println(test.empty());
        for (int i=0; i<10; i++) {
            test.push(i+100);
        }
        System.out.println(test.empty());
        System.out.println(test.peek());
        for (int i=0; i<5; i++) {
            int x = (int)test.pop();
            System.out.print(x + " ");
        }
        System.out.println();
        for (int i=0; i<15; i++) {
            test.push(i);
        }
        while (!test.empty()) {
            int x = (int)test.pop();
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
