package test.phone.src.de_1.util;

import java.util.Scanner;

public class Regex {
    static Scanner scanner = new Scanner(System.in);
    public static final String REGEX_STR = "^[A-Z][a-z]+";
    public static final String REGEX_NUMBERDOUBLE = "^\\d+\\.*\\d*$";
    public static final String REGEX_NUMBER = "^\\d+$";

    public static String regexStr(String temp, String regex, String error) {
        boolean flag = true;
        do {
            if (temp.matches(regex)) {
                flag = false;
            } else {
                System.out.println(error);
                temp = scanner.nextLine();
            }
        } while (flag);
        return temp;
    }

    public static String inputNumber() {
        return Regex.regexStr(scanner.nextLine(), REGEX_NUMBER, "Bạn đã nhập sai, xin hãy nhập số lớn hơn 0!");
    }

    public static String inputNumberDouble() {
        return Regex.regexStr(scanner.nextLine(), REGEX_NUMBERDOUBLE, "Bạn đã nhập sai, xin hãy nhập số lớn hơn 0!");
    }


}
