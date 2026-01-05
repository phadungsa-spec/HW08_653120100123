class Node:
    def __init__(self, data:any=None):
        self.data = data
        self.next = None

class Stack:
    def __init__(self, node:Node=None):
        self.node = node
        self.size = 0
    
    def is_empty(self) -> bool:
        return self.size == 0
    
    def push(self, data):
        new_node = Node(data)
        if self.is_empty():
            self.node = new_node
        else:
            cur_node = self.node
            while cur_node.next:
                cur_node = cur_node.next
            cur_node.next = new_node
        self.size += 1

    def pop(self):
        if not self.is_empty():
            if self.size == 1:
                self.node = None
            else:
                cur_node = self.node
                while cur_node.next.next:
                    cur_node = cur_node.next
                cur_node.next = None
            self.size -= 1

    def peek(self):
        if self.is_empty():
            return "None"
        
        cur_node = self.node
        while cur_node.next != None:
            cur_node = cur_node.next
        return cur_node.data

    def print_stack(self):
        if self.is_empty():
            print("Stack is empty")
        else:
            cur_node = self.node
            while cur_node != None:
                print(cur_node.data, end=' -> ')
                cur_node = cur_node.next
            print("None")

################################################

myStack = Stack()
print("Is Stack Empty?", myStack.is_empty())
print("Stack size: ", myStack.size)

myStack.push("Jack")
myStack.print_stack()
myStack.push("John")
myStack.print_stack()
myStack.push("Jub")
myStack.print_stack()
myStack.push("Jan")
myStack.print_stack()

myStack.pop()
myStack.print_stack()

print("Is Stack Empty?", myStack.is_empty())
print("Stack size: ", myStack.size)

print("Is peek: ", myStack.peek())