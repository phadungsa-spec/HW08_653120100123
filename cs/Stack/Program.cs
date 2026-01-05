using System;

class Node<T>
{
    public T Data;
    public Node<T> Next;

    public Node(T data)
    {
        Data = data;
        Next = null;
    }
}

class Stack<T>
{
    private Node<T> head;
    private int size;

    public Stack()
    {
        head = null;
        size = 0;
    }

    public bool IsEmpty()
    {
        return size == 0;
    }

    public void Push(T data)
    {
        Node<T> newNode = new Node<T>(data);
        if (IsEmpty())
        {
            head = newNode;
        }
        else
        {
            Node<T> cur = head;
            while (cur.Next != null)
                cur = cur.Next;
            cur.Next = newNode;
        }
        size++;
    }

    public void Pop()
    {
        if (IsEmpty()) return;

        if (size == 1)
        {
            head = null;
        }
        else
        {
            Node<T> cur = head;
            while (cur.Next.Next != null)
                cur = cur.Next;
            cur.Next = null;
        }
        size--;
    }

    public T Peek()
    {
        if (IsEmpty())
            throw new Exception("Stack is empty");

        Node<T> cur = head;
        while (cur.Next != null)
            cur = cur.Next;
        return cur.Data;
    }

    public void PrintStack()
    {
        if (IsEmpty())
        {
            Console.WriteLine("Stack is empty");
            return;
        }

        Node<T> cur = head;
        while (cur != null)
        {
            Console.Write(cur.Data + " -> ");
            cur = cur.Next;
        }
        Console.WriteLine("None");
    }

    public int Size => size;
}

class Program
{
    static void Main()
    {
        Stack<string> s = new Stack<string>();
        s.Push("Jack");
        s.Push("John");
        s.Push("Jub");
        s.PrintStack();

        s.Pop();
        s.PrintStack();
        
        Console.WriteLine("Peek: " + s.Peek());
    }
}
