package ss11_dsa_stack_queue.bai_tap.reverse_element;

public class MainChar {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("abcdef");
        System.out.println("String before change: " + str);
        reverse(str);
        System.out.println("String after reverse: " + str);
    }

    public static void reverse(StringBuffer str) {
        int size = str.length();
        StackString stack = new StackString(size);

        for (int i = 0; i < size; i++) {
            stack.push(str.charAt(i));
        }

        for (int i = 0; i < size; i++) {
            str.setCharAt(i, stack.pop());
        }

    }
}
