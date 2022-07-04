package case_study.util;

import java.util.Scanner;

public class TypeInformation {
    static Scanner scanner = new Scanner(System.in);

    public static String getTypeSex() {
        String sex = "";
        boolean flag = true;
        do {
            System.out.println("Chọn giới tính\n" +
                    "1. Nam\n" +
                    "2. Nữ\n");
            System.out.print("Mời bạn chọn: ");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    sex = "nam";
                    flag = false;
                    break;
                case "2":
                    sex = "nữ";
                    flag = false;
                    break;
                default:
                    System.out.println("Vui lòng chọn lại");
            }
        } while (flag);
        return sex;
    }

    public static String getTypeLevel() {
        String level = "";
        boolean flag = true;
        do {
            System.out.println("Nhập trình độ\n" +
                    "1. Trung cấp.\n" +
                    "2. Cao đẳng.\n" +
                    "3. Đại học.\n" +
                    "4. Sau đại học.");
            System.out.print("Mời bạn chọn: ");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    level = "Trung cấp";
                    flag = false;
                    break;
                case "2":
                    level = "Cao đẳng";
                    flag = false;
                    break;
                case "3":
                    level = "Đại học";
                    flag = false;
                    break;
                case "4":
                    level = "Sau đại học";
                    flag = false;
                    break;
                default:
                    System.out.println("Bạn chọn không đúng thông tin, mời bạn chọn lại");
            }
        } while (flag);
        return level;
    }

    public static String getTypeCustomer() {
        String typeCustomer = "";
        String choose;
        boolean flag = true;
        do {
            System.out.println("Chọn loại khách\n" +
                    "1. Diamond.\n" +
                    "2. Platinum.\n" +
                    "3. Gold.\n" +
                    "4. Silver.\n" +
                    "5. Member.");
            System.out.print("Mời bạn chọn: ");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    typeCustomer = "Diamond";
                    flag = false;
                    break;
                case "2":
                    typeCustomer = "Platinum";
                    flag = false;
                    break;
                case "3":
                    typeCustomer = "Gold";
                    flag = false;
                    break;
                case "4":
                    typeCustomer = "Silver";
                    flag = false;
                    break;
                case "5":
                    typeCustomer = "Member";
                    flag = false;
                    break;
                default:
                    System.out.println("Bạn chọn không đúng thông tin, mời bạn chọn lại");
            }
        } while (flag);
        return typeCustomer;
    }
}
