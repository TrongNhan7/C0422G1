package test.hospital.util;

import java.util.Scanner;

public class Regex {
    static Scanner scanner = new Scanner(System.in);
    private static final String REGEX_MEDICAL_PATIENT = "^(BA)-\\d{3}$";
    private static final String REGEX_MEDICAL_PEOPLE = "^(BN)-\\d{3}$";

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
    public static String inputPatient() {
        System.out.println("Nhập mã bệnh án: ");
        return case_study.util.Regex.regexStr(scanner.nextLine(), REGEX_MEDICAL_PATIENT, "Bạn đã nhập sai mã bệnh án, BA là BA-XXXX!");
    }
    public static String inputPeople() {
        System.out.println("Nhập mã bệnh nhân: ");
        return case_study.util.Regex.regexStr(scanner.nextLine(), REGEX_MEDICAL_PEOPLE, "Bạn đã nhập sai mã bệnh nhân, BN là BN-XXXX!");
    }
}
