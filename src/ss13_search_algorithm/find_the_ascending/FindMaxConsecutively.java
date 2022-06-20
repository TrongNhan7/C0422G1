package ss13_search_algorithm.find_the_ascending;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindMaxConsecutively {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String str = sc.nextLine();
        LinkedList<Character> list = new LinkedList<>();
        LinkedList<Character> listMax = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            if (list.size() > 1 && list.getLast() >= str.charAt(i) && list.contains(str.charAt(i))) {
                list.clear();
            }
            list.add(str.charAt(i));
            if (list.size() > listMax.size()) {
                listMax.clear();
                listMax.addAll(list);
            }
        }
        for (Character ch : listMax) {
            System.out.print(ch);
        }
        System.out.println();
    }
}
