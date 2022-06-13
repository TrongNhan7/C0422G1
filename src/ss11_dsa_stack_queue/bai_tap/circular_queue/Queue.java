package ss11_dsa_stack_queue.bai_tap.circular_queue;

public class Queue {
    Node front, rear;

    Queue() {
        front = rear = null;
    }

    public boolean isEmty() {
        return (front == null && rear == null);
    }

    public void enQueue(int data) {
        Node newNode = new Node(data);
        if (isEmty()) {
            this.front = this.rear = newNode;
        } else {
            this.rear.next = newNode;
            this.rear = newNode;
            newNode.next = this.front;
        }
    }

    public void deQueue() {
        if (isEmty()) {
            System.out.println("Queue is Empty");
        } else {
            int value;
            if (this.front == this.rear) {
                value = this.front.data;
                this.front = this.rear = null;
            } else {
                Node temp = this.front;
                value = temp.data;
                this.front = this.front.next;
                this.rear.next = this.front;
            }
        }
    }

    public void show() {
        if (isEmty()) {
            System.out.println("Queue is Empty!");
        } else {
            Node curNode = front;
            while (curNode.next != front) {
                System.out.println(curNode.data + " ");
                curNode = curNode.next;
            }
            System.out.println(curNode.data);
        }
    }
}
