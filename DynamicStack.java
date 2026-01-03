package assignment1;

public class DynamicStack implements Stack<Object> {
    List<Object> S = new DoubleLinkedList();

    public void push(Object x) {
        S.prepend(x);
    }

    public Object pop() {

        if (S.empty()) {
            throw new RuntimeException("Stack is empty");
        }

        Object element = S.getFirst();
        S.deleteFirst();
        return element;
    }

    public Object peek() {

        if (S.empty()) {
            throw new RuntimeException("Stack is empty");
        }

        return S.getFirst();
    }

    public boolean empty() {

        return S.empty();
    }

    public static void main(String[] args) {
        Stack<Object> test = new DynamicStack();
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
