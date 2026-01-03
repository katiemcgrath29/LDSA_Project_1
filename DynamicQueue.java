package assignment1;

public class DynamicQueue implements Queue<Object> {
    List<Object> Q = new DoubleLinkedList();

    public void enqueue(Object x) {
        Q.append(x);
    }

    public Object dequeue() {
        if (Q.empty()) {
            throw new RuntimeException("Queue is empty");
        }

        Object element = Q.getFirst();
        Q.deleteFirst();
        return element;
    }

    public Object next() {

        if (Q.empty()) {
            throw new RuntimeException("Queue is empty");
        }

        return Q.getFirst();
    }

    public boolean empty() {

        return Q.empty();
    }

    public static void main(String[] args) {
        Queue<Object> test = new DynamicQueue();
        System.out.println(test.empty());
        for (int i=0; i<10; i++) {
            test.enqueue(i+100);
        }
        System.out.println(test.empty());
        System.out.println(test.next());
        for (int i=0; i<5; i++) {
            int x = (int)test.dequeue();
            System.out.print(x + " ");
        }
        System.out.println();
        for (int i=0; i<15; i++) {
            test.enqueue(i);
        }
        while (!test.empty()) {
            int x = (int)test.dequeue();
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
