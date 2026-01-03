package assignment1;

public class DoubleLinkedList implements List<Object> {
    private class ListNode {
        public ListNode(Object x) {
            key = x;
        }
        public Object key;
        public ListNode prev = null;
        public ListNode next = null;
    }
    private ListNode head;
    private ListNode tail;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;


    }

    public void prepend(Object x) {
        ListNode newNode = new ListNode(x);

        if (head == null) {
            head = newNode;
            tail = newNode;
        }

        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public Object getFirst() {

        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        else {
            return head.key;
        }
    }

    public void deleteFirst() {

        if (head == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
        }

        else {
            head = head.next;
            head.prev = null;
        }
    }

    public void append(Object x) {

        ListNode newNode = new ListNode(x);

        if (tail == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public Object getLast() {

        if (tail == null) {
            throw new RuntimeException("List is empty");
        }

        return tail.key;
    }

    public void deleteLast() {

        if (tail == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
        }

        else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public boolean empty() {

        return head == null;
    }

    public static void main(String[] args) {
        List<Object> test = new DoubleLinkedList();
        System.out.println(test.empty());
        for (int i=0; i<10; i++) {
            test.prepend(i + 100);
        }
        System.out.println(test.empty());
        for (int i=0; i<5; i++) {
            int x = (int)test.getFirst();
            System.out.print(x + " ");
            test.deleteFirst();
        }
        System.out.println();
        for (int i=0; i<10; i++) {
            test.append(i + 200);
        }
        while (!test.empty()) {
            int x = (int)test.getLast();
            System.out.print(x + " ");
            test.deleteLast();
        }
    }
}
