public class App {
    public static void main(String[] args) throws Exception {
        Stack<String> s = new Stack<>();
        s.push("Jack");
        s.push("John");
        s.push("Jub");
        s.printStack();

        s.pop();
        s.printStack();
        
        System.out.println("Peek: " + s.peek());
    }
}

class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class Stack<T> {
    private Node<T> head;
    private int size;

    public Stack() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node<T> cur = head;
            while (cur.next != null)
                cur = cur.next;
            cur.next = newNode;
        }
        size++;
    }

    public void pop() {
        if (isEmpty()) return;

        if (size == 1) {
            head = null;
        } else {
            Node<T> cur = head;
            while (cur.next.next != null)
                cur = cur.next;
            cur.next = null;
        }
        size--;
    }

    public T peek() {
        if (isEmpty())
            throw new RuntimeException("Stack is empty");

        Node<T> cur = head;
        while (cur.next != null)
            cur = cur.next;
        return cur.data;
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        Node<T> cur = head;
        while (cur != null) {
            System.out.print(cur.data + " -> ");
            cur = cur.next;
        }
        System.out.println("None");
    }

    public int getSize() {
        return size;
    }
}
