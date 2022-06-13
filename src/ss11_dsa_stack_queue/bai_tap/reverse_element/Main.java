package ss11_dsa_stack_queue.bai_tap.reverse_element;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int array[] = {1, 2, 3, 4, 5, 6};
        System.out.println("Array before change: " + Arrays.toString(array));
        reverse(array);
        System.out.println("Array after reverse: " + Arrays.toString(array));

    }

    public static void reverse(int arr[]) {
        int size = arr.length;
        Stack stack = new Stack(size);

        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }

        for (int i = 0; i < size; i++) {
            arr[i] = stack.pop();
        }

    }
}
