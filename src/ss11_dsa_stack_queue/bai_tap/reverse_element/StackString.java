package ss11_dsa_stack_queue.bai_tap.reverse_element;

public class StackString {
    private char[] arr;
    private int SIZE, topIndex;

    public StackString(int size) {
        this.SIZE = size;
        this.arr = new char[size];
        this.topIndex = -1;
    }

    public boolean isFull() {
        return topIndex == SIZE - 1;
    }

    public boolean isEmpty() {
        return topIndex < 0;
    }

    public boolean push(char value) {
        if (!isFull()) {
            topIndex++;
            arr[topIndex] = value;
            return true;
        }
        return false;
    }

    public char pop() {
        if (!isEmpty()) {
             char value = arr[topIndex];
            topIndex--;
            return value;
        }
        return 0;
    }
}

