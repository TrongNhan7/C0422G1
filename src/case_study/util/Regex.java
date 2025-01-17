package case_study.util;

import case_study.common.AgeCheckingExeption;


import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Regex {
    static Scanner scanner = new Scanner(System.in);
    private static final String REGEX_STR = "^[A-Z][a-z]+";
    private static final String REGEX_VILLA = "^(SVVL)-\\d{4}$";
    private static final String REGEX_HOUSE = "^(SVHO)-\\d{4}$";
    private static final String REGEX_ROOM = "^(SVRO)-\\d{4}$";
    private static final String REGEX_AREA = "^([3-9][0-9]\\.*\\d*|\\d{3,}\\.*\\d*)$";
    private static final String REGEX_RENTALCOSTS = "^\\d+\\.*\\d*$";
    private static final String REGEX_MAXPEOPLE = "^([1-9]|1[0-9])$";
    private static final String REGEX_FLOORS = "^\\d+$";
    private static final String REGEX_NUMBER = "^\\d+$";
    private static final String REGEX_BIRTHDAY = "^([0-2][0-9]|3[0|1])\\/(0[1-9]|1[0-2])\\/\\d{4}$";
    private static final String REGEX_GMAIL = "^\\w+@(\\w+\\.)+\\w+$";

    public static final String REGEX_PHONE = "^\\d{10}$";
    public static final String REGEX_IDCARD = "^([A-Z0-9]{9}|[A-Z0-9]{12})$";
    private static final String REGEX_NAME = "^[A-Z][a-z]{0,10}(\\s[A-Z][a-z]{0,10}){0,5}$";

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


    public static String regexBirthday(String temp, String regex) {
        boolean check = true;
        while (check) {
            try {
                if (Pattern.matches(regex, temp)) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate age = LocalDate.parse(temp, formatter);
                    LocalDate now = LocalDate.now();
                    int current = Period.between(age, now).getYears();
                    if (current < 100 && current > 18) {
                        check = false;
                        break;
                    } else {
                        throw new AgeCheckingExeption("Tuổi phải lớn hơn 18 và bé hơn 100");
                    }
                } else {
                    throw new AgeCheckingExeption("Định dạng nhập vào không đúng");
                }
            } catch (AgeCheckingExeption e) {
                System.out.println(e.getMessage());
                temp = scanner.nextLine();
            }
        }
        return temp;
    }


    public static String inputNameService() {
        System.out.println("Nhập tên dịch vụ: ");
        return Regex.regexStr(scanner.nextLine(), REGEX_NAME, "Bạn đã nhập sai tên dịch vụ, tên ko vượt quá 20 ký tự!");
    }
    public static String inputName() {
        System.out.println("Nhập tên dịch vụ: ");
        return Regex.regexStr(scanner.nextLine(), REGEX_NAME, "Bạn đã nhập sai tên định dạng, tên ko vượt quá 20 ký tự!");
    }
    public static String inputIdVilla() {
        System.out.println("Nhập mã dịch vụ: ");
        return Regex.regexStr(scanner.nextLine(), REGEX_VILLA, "Bạn đã nhập sai mã dịch vụ, Villa là SVVL-XXXX!");
    }

    public static String inputIdHouse() {
        System.out.println("Nhập mã dịch vụ: ");
        return Regex.regexStr(scanner.nextLine(), REGEX_HOUSE, "Bạn đã nhập sai mã dịch vụ!,House là SVHO-XXXX!");
    }

    public static String inputIdRoom() {
        System.out.println("Nhập mã dịch vụ: ");
        return Regex.regexStr(scanner.nextLine(), REGEX_ROOM, "Bạn đã nhập sai mã dịch vụ!,Room là SVRO-XXXX!");
    }

    public static String inputArea() {
        System.out.println("Nhập diện tích dịch vụ: ");
        return Regex.regexStr(scanner.nextLine(), REGEX_AREA, "Bạn đã nhập sai diện tích dịch vụ!, diện tích lớn hơn 30m2");
    }

    public static String inputRentalCosts() {
        System.out.println("Nhập mã giá thuê: ");
        return Regex.regexStr(scanner.nextLine(), REGEX_RENTALCOSTS, "Bạn đã nhập sai giá thuê!, phải là số dương");
    }

    public static String inputPepple() {
        System.out.println("Nhập số người thuê: ");
        return Regex.regexStr(scanner.nextLine(), REGEX_MAXPEOPLE, "Bạn đã vượt quá số người dc thuê!, số người dc thuê < 20");
    }

    public static String inputRentalType() {
        System.out.println("Nhập kiểu thuê");
        return Regex.regexStr(scanner.nextLine(), REGEX_STR, "Bạn đã nhập sai định dạng, kiểu thuê phải viết hoa chữ cái đầu");
    }

    public static String inputStandard() {
        System.out.println("Nhập tiêu chuẩn");
        return Regex.regexStr(scanner.nextLine(), REGEX_STR, "Bạn đã nhập sai định dạng, tiêu chuẩn phải viết hoa chữ cái đầu");
    }

    public static String inputPool() {
        System.out.println("Nhập diện tích hồ bơi: ");
        return Regex.regexStr(scanner.nextLine(), REGEX_AREA, "Bạn đã nhập sai diện tích hồ bơi!,diện tích lớn hơn 30m2");
    }

    public static String inputFloors() {
        System.out.println("Nhập số tầng: ");
        return Regex.regexStr(scanner.nextLine(), REGEX_FLOORS, "Bạn đã nhập sai số tầng!");
    }

    public static String inputServiceFree() {
        System.out.println("Nhập dịch vụ miễn phí:");
        return Regex.regexStr(scanner.nextLine(), REGEX_STR, "Bạn đã nhập sai định dạng, tiêu chuẩn phải viết hoa chữ cái đầu");
    }

    public static String inputNumber() {
        return Regex.regexStr(scanner.nextLine(), REGEX_NUMBER, "Bạn đã nhập sai, xin hãy nhập số!");
    }

    public static String inputNumberDouble() {
        return Regex.regexStr(scanner.nextLine(), REGEX_RENTALCOSTS, "Bạn đã nhập sai, xin hãy nhập số!");
    }

    public static String inputBirthday() {
        System.out.println("Nhập ngày tháng năm sinh:");
        return Regex.regexBirthday(scanner.nextLine(), REGEX_BIRTHDAY);
    }

    public static String inputServiceType() {
        return Regex.regexStr(scanner.nextLine(), REGEX_STR, "Bạn đã nhập sai định dạng, kiểu dịch vụ phải viết hoa chữ cái đầu");
    }

    public static String inputMail() {
        System.out.println("Nhập mail:");
        return Regex.regexStr(scanner.nextLine(), REGEX_GMAIL, "Bạn đã nhập sai định dạng");
    }

    public static String inputPhone() {
        System.out.println("Nhập so Phone:");
        return Regex.regexStr(scanner.nextLine(), REGEX_PHONE, "Bạn đã nhập sai định dạng");
    }

    public static String inputIdCard() {
        System.out.println("Nhập chứng minh:");
        return Regex.regexStr(scanner.nextLine(), REGEX_IDCARD, "Bạn đã nhập sai định dạng");
    }

}
