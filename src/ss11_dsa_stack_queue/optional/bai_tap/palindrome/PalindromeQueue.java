package ss11_dsa_stack_queue.optional.bai_tap.palindrome;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PalindromeQueue {
    public static void main(String[] args) {
        Queue queue = new LinkedList();
        System.out.println("Enter String: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        for (int i = str.length() - 1; i >= 0; i--) {
            queue.add(str.charAt(i));
        }

        String reverseStr = "";
        while (!queue.isEmpty()) {
            reverseStr += queue.remove();
        }
        if (str.equals(reverseStr)) {
            System.out.println(str + " is Palindrome");
        } else {
            System.out.println(str + " is not Palindrome");
        }
    }


}
