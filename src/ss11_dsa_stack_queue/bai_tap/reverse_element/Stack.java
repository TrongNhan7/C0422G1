package ss11_dsa_stack_queue.bai_tap.reverse_element;

public class Stack {
    private int[] arr;
    private int SIZE, topIndex;

    public Stack(int size) {
        this.SIZE = size;
        this.arr = new int[size];
        this.topIndex = -1;
    }

    public boolean isFull() {
        return topIndex == SIZE - 1;
    }

    public boolean isEmpty() {
        return topIndex < 0;
    }

    public boolean push(int value) {
        if (!isFull()) {
            topIndex++;
            arr[topIndex] = value;
            return true;
        }
        return false;
    }

    public int pop(){
        if(!isEmpty()){
            int value = arr[topIndex];
            topIndex--;
            return value;
        }
        return -1;
    }
}
