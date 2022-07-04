package de_1.controller;

import de_1.models.CellPhone;
import de_1.models.RealPhone;
import de_1.service.control.CellPhoneServiceImpl;
import de_1.service.control.RealPhoneServiceImpl;

import java.util.Scanner;

public class PhoneController {
    static CellPhoneServiceImpl cellPhoneService = new CellPhoneServiceImpl();
    static RealPhoneServiceImpl realPhoneService = new RealPhoneServiceImpl();
    static Scanner scanner = new Scanner(System.in);

    public static void displayMainMenu() {
        do {
            System.out.println("\n------MENU PHONE------ " +
                    "\n 1. Add new phone" +
                    "\n 2. Delete phone" +
                    "\n 3. Display phone " +
                    "\n 4. Search phone" +
                    "\n 5. Exit");
            System.out.println("Choose function");
            int choose = 0;
            try {
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại");
            }

            switch (choose) {
                case 1:
                    addNewStaff();
                    break;
                case 2:
                    deleteStaff();
                    break;
                case 3:
                    displayStaff();
                    break;
                case 4:
                    searchStaff();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.printf("You need to choose again");
            }
        } while (true);
    }

    public static void addNewStaff() {
        do {
            System.out.println("--------Thêm mới----------");
            System.out.println("1. Thêm mới realphone");
            System.out.println("2. Thêm mới cellphone");
            System.out.println("3. quay lại menu chính");
            System.out.println("Choose function");
            int choose = 0;
            try {
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại");
            }
            switch (choose) {
                case 1:
                    System.out.println("Thêm mới realphone");
                    realPhoneService.addNew();
                    break;
                case 2:
                    System.out.println("Thêm mới cellphone");
                    cellPhoneService.addNew();
                    break;
                case 3:
                    displayMainMenu();
                    break;
                default:
                    System.out.println("Không có option này, xin hãy nhập lại");
                    break;
            }
        } while (true);
    }

    public static void deleteStaff() {
        do {
            System.out.println("--------Xóa----------");
            System.out.println("1. Xóa realphone");
            System.out.println("2. Xóa cellphone");
            System.out.println("3. quay lại menu chính");
            System.out.println("Choose function");
            int choose = 0;
            try {
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại");
            }
            switch (choose) {
                case 1:
                    System.out.println("Xóa realphone");
                    realPhoneService.delete();
                    break;
                case 2:
                    System.out.println("Xóa cellphone");
                    cellPhoneService.delete();
                    break;
                case 3:
                    displayMainMenu();
                    break;
                default:
                    System.out.println("Không có option này, xin hãy nhập lại");
                    break;
            }
        } while (true);
    }

    public static void displayStaff() {
        do {
            System.out.println("--------Danh sách----------");
            System.out.println("1. Danh sách realphone");
            System.out.println("2. Danh sách cellphone");
            System.out.println("3. quay lại menu chính");
            System.out.println("Choose function");
            int choose = 0;
            try {
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại");
            }
            switch (choose) {
                case 1:
                    System.out.println("Danh sách realphone");
                    realPhoneService.display();
                    break;
                case 2:
                    System.out.println("Danh sách cellphone");
                    cellPhoneService.display();
                    break;
                case 3:
                    displayMainMenu();
                    break;
                default:
                    System.out.println("Không có option này, xin hãy nhập lại");
                    break;
            }
        } while (true);
    }

    public static void searchStaff() {
        do {
            System.out.println("--------Danh sách----------");
            System.out.println("1. Tìm kiếm realphone");
            System.out.println("2. Tìm kiếm cellphone");
            System.out.println("3. quay lại menu chính");
            System.out.println("Choose function");
            int choose = 0;
            try {
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại");
            }
            switch (choose) {
                case 1:
                    System.out.println("Tìm kiếm realphone");
                    realPhoneService.search();
                    break;
                case 2:
                    System.out.println("Tìm kiếm cellphone");
                    cellPhoneService.search();
                    break;
                case 3:
                    displayMainMenu();
                    break;
                default:
                    System.out.println("Không có option này, xin hãy nhập lại");
                    break;
            }
        } while (true);
    }
}
