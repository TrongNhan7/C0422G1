package ss11_dsa_stack_queue.optional.bai_tap.check_bracket;

import java.util.Stack;

public class CheckBracket {
    public static void main(String[] args) {
        String str = "s * ((s – a) * (s – b) * (s – c)";
        if (isBlanced(str)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    private static boolean isBlanced(String str) {
        Stack<Character> stack = new Stack<>();
        boolean flag = true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
                continue;
            } else if (str.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    flag = false;
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        if (flag && stack.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }
}
