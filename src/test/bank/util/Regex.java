package test.bank.util;

import java.util.Scanner;

public class Regex {
    static Scanner scanner = new Scanner(System.in);
    public static final String REGEX_CODEACCOUNT = "^\\d{9}$";
    private static final String REGEX_NAME = "^[A-Z][a-z]{0,10}(\\s[A-Z][a-z]{0,10}){0,5}$";
    public static final String REGEX_CARDNUMBER = "^\\d{8}$";

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
    public static String inputCodeAccount() {
        return Regex.regexStr(scanner.nextLine(), REGEX_CODEACCOUNT, "Bạn đã nhập sai định dạng");
    }
    public static String inputName() {
        return Regex.regexStr(scanner.nextLine(), REGEX_NAME, "Bạn đã nhập sai định dạng");
    }
    public static String inputCardNumber() {
        return Regex.regexStr(scanner.nextLine(), REGEX_CARDNUMBER, "Bạn đã nhập sai định dạng");
    }
}
