package test.bank.controller;

import test.bank.service.impl.PaymentAccountService;
import test.bank.service.impl.SavingAccountService;

import java.util.Scanner;

public class Controller {
    private static Scanner scanner = new Scanner(System.in);
    static SavingAccountService savingAccountService = new SavingAccountService();
    static PaymentAccountService paymentAccountService = new PaymentAccountService();

    public static void displayMainMenu() {
        String choose = null;
        do {
            System.out.println("\n------CHƯƠNG TRÌNH QUẢN LÝ TÀI KHOẢN NGÂN HÀNG------ " +
                    "\n Chọn chức năng theo số để tiếp tục" +
                    "\n 1. Thêm mới" +
                    "\n 2. Xóa  " +
                    "\n 3. Xem danh sách sản phẩm " +
                    "\n 4. Tìm kiếm " +
                    "\n 5. Thoát");
            System.out.println("Chọn chức năng");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    addAccount();
                    break;
                case "2":
                    deleteAccount();
                    break;
                case "3":
                    displayAccount();
                    break;
                case "4":
                    searchAccount();
                    break;
                case "5":
                    System.exit(0);
                    break;
                default:
                    System.out.printf("Bạn cần chọn lại");
            }
        } while (true);
    }

    public static void addAccount() {
        String choose = null;
        do {
            System.out.println("\n------ACCOUNT BANK----- " +
                    "\n Chọn chức năng theo số để tiếp tục" +
                    "\n 1. Thêm mới tài khoản tiết kiệm" +
                    "\n 2. Thêm mới tài khoản thanh toán  " +
                    "\n 3. Thoát");
            System.out.println("Chọn chức năng");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    savingAccountService.add();
                    break;
                case "2":
                    paymentAccountService.add();
                    break;
                case "3":
                    return;
                default:
                    System.out.printf("Bạn cần chọn lại");
            }
        } while (true);
    }

    public static void deleteAccount() {
        String choose = null;
        do {
            System.out.println("\n------ACCOUNT BANK------ " +
                    "\n Chọn chức năng theo số để tiếp tục" +
                    "\n 1. Xóa tài khoản tiết kiệm" +
                    "\n 2. Xóa tài khoản thanh toán  " +
                    "\n 3. Thoát");
            System.out.println("Chọn chức năng");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    savingAccountService.delete();
                    break;
                case "2":
                    paymentAccountService.delete();
                    break;
                case "3":
                    return;
                default:
                    System.out.printf("Bạn cần chọn lại");
            }
        } while (true);
    }

    public static void displayAccount() {
        String choose = null;
        do {
            System.out.println("\n------ACCOUNT BANK------ " +
                    "\n Chọn chức năng theo số để tiếp tục" +
                    "\n 1. Hiển thị tài khoản tiết kiệm" +
                    "\n 2. Hiển thị tài khoản thanh toán " +
                    "\n 3. Thoát");
            System.out.println("Chọn chức năng");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    savingAccountService.display();
                    break;
                case "2":
                    paymentAccountService.display();
                    break;
                case "3":
                    return;
                default:
                    System.out.printf("Bạn cần chọn lại");
            }
        } while (true);
    }

    public static void searchAccount() {
        String choose = null;
        do {
            System.out.println("\n------ACCOUNT BANK------ " +
                    "\n Chọn chức năng theo số để tiếp tục" +
                    "\n 1. Tìm tài khoản tiết kiệm" +
                    "\n 2. Tìm tài khoản thanh toán  " +
                    "\n 3. Thoát");
            System.out.println("Chọn chức năng");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    savingAccountService.search();
                    break;
                case "2":
                    paymentAccountService.search();
                    break;
                case "3":
                    return;
                default:
                    System.out.printf("Bạn cần chọn lại");
            }
        } while (true);
    }
}
