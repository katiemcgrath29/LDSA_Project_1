package assignment1;

public class ArrayQueue implements Queue<Object> {
    private Object[] Q;
    private int maxSize;
    private int size;
    private int front;
    private int rear;

    public ArrayQueue(int capacity) {

        if  (capacity <= 0) {
            throw new RuntimeException("Capacity Error - Must be positive");
        }

        Q = new Object[capacity];
        maxSize = capacity;
        size = 0;
        front = 0;
        rear = 0;
    }

    public void enqueue(Object x) {

        if (size == maxSize) {
            throw new RuntimeException("Queue is full");
        }

        Q[rear] = x;
        rear = (rear + 1) % maxSize;
        size++;
    }

    public Object dequeue() {

        if (size == 0) {
            throw new RuntimeException("Queue is empty");
        }

        Object element = Q[front];
        Q[front] = null;
        front = (front + 1) % maxSize;
        size--;
        return element;
    }

    public Object next() {

        if  (size == 0) {
            throw new RuntimeException("Queue is empty");
        }

        return Q[front];
    }

    public boolean empty() {

        return size == 0;
    }

    public static void main(String[] args) {
        Queue<Object> test = new ArrayQueue(20);
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
