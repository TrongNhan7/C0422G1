package test.electric_bill.util;

import case_study.util.Regex;

import java.util.Scanner;

public class RegexCustomer {
    static Scanner scanner = new Scanner(System.in);

    private static final String REGEX_VNCUSTOMER = "^(KHVN)-\\d{5}$";
    private static final String REGEX_FCUSTOMER = "^(KHNN)-\\d{5}$";

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
    public static String inputIdVN() {
        System.out.println("Nhập mã khách hàng VN: ");
        return Regex.regexStr(scanner.nextLine(), REGEX_VNCUSTOMER, "Bạn đã nhập sai mã KH, mã là KHVN-XXXXX!");
    }
    public static String inputIdF() {
        System.out.println("Nhập mã khách hàng NN: ");
        return Regex.regexStr(scanner.nextLine(), REGEX_FCUSTOMER, "Bạn đã nhập sai mã KH, mã là KHNN-XXXXX!");
    }
}
