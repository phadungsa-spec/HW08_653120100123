#include <iostream>
using namespace std;

template <typename T>
class Node {
public:
    T data;
    Node<T>* next;

    Node(T value) {
        data = value;
        next = nullptr;
    }
};

template <typename T>
class Stack {
private:
    Node<T>* head;
    int size;

public:
    Stack() {
        head = nullptr;
        size = 0;
    }

    bool isEmpty() {
        return size == 0;
    }

    void push(T data) {
        Node<T>* newNode = new Node<T>(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node<T>* cur = head;
            while (cur->next)
                cur = cur->next;
            cur->next = newNode;
        }
        size++;
    }

    void pop() {
        if (isEmpty()) return;

        if (size == 1) {
            delete head;
            head = nullptr;
        } else {
            Node<T>* cur = head;
            while (cur->next->next)
                cur = cur->next;
            delete cur->next;
            cur->next = nullptr;
        }
        size--;
    }

    T peek() {
        if (isEmpty())
            throw runtime_error("Stack is empty");

        Node<T>* cur = head;
        while (cur->next)
            cur = cur->next;
        return cur->data;
    }

    void printStack() {
        if (isEmpty()) {
            cout << "Stack is empty\n";
            return;
        }
        Node<T>* cur = head;
        while (cur) {
            cout << cur->data << " -> ";
            cur = cur->next;
        }
        cout << "None\n";
    }

    int getSize() {
        return size;
    }
};

int main() {
    Stack<string> s;
    s.push("Jack");
    s.push("John");
    s.push("Jub");
    s.printStack();
    
    s.pop();
    s.printStack();

    cout << "Peek: " << s.peek() << endl;
}
