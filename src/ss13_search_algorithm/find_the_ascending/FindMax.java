package ss13_search_algorithm.find_the_ascending;

import java.util.LinkedList;
import java.util.Scanner;

public class FindMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String str = sc.nextLine();
        LinkedList<Character> listMax = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            LinkedList<Character> list = new LinkedList<>();
            list.add(str.charAt(i));

            for (int j = i + 1; j < str.length(); j++) {
                if (list.getLast() < str.charAt(j)) {
                    list.add(str.charAt(j));
                }
            }
            if (list.size() > listMax.size()) {
                listMax.clear();
                listMax.addAll(list);
            }
            list.clear();
        }
        for (Character ch : listMax) {
            System.out.print(ch);
        }
        System.out.println();

    }
}
