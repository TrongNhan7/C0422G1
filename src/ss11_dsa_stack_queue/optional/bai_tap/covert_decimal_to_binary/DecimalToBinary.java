package ss11_dsa_stack_queue.optional.bai_tap.covert_decimal_to_binary;

import java.util.Stack;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter decimal number: ");
        int num = scanner.nextInt();
        while (num != 0) {
            int a = num % 2;
            stack.push(a);
            num /= 2;
        }
        System.out.println("Binary number : ");
        while (!(stack.isEmpty())) {
            System.out.print(stack.pop() + " ");
        }
    }
}
