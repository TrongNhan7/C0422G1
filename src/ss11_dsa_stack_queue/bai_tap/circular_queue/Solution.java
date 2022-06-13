package ss11_dsa_stack_queue.bai_tap.circular_queue;

public class Solution {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.deQueue();
        queue.show();
    }
}
