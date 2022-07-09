package test.electric_bill.controller;

import test.electric_bill.service.FCustomerService;
import test.electric_bill.service.VNCustomerService;

import java.util.Scanner;

public class Controller {
    private static Scanner scanner = new Scanner(System.in);
    private static VNCustomerService vnCustomerService = new VNCustomerService();
    private static FCustomerService fCustomerService = new FCustomerService();

    public static void displayMainMenu() {
        String choose = null;
        do {
            System.out.println("\n------CHƯƠNG TRÌNH QUẢN LÝ HÓA ĐƠN TIỀN ĐIỆN------ " +
                    "\n Chọn chức năng theo số để tiếp tục" +
                    "\n 1. Thêm mới" +
                    "\n 2. Hiện thị thông tin khách hàng " +
                    "\n 3. Tìm kiếm khách hàng " +
                    "\n 4. Thêm mới hóa đơn " +
                    "\n 5. Chỉnh sửa hóa đơn" +
                    "\n 6. Hiện thị thông  tin chi tiết hóa đơn " +
                    "\n 7. Thoát");
            System.out.println("Chọn chức năng");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    addCustomer();
                    break;
                case "2":
                    displayCustomer();
                    break;
                case "3":
                    searchCustomer();
                    break;
                case "4":

                    break;
                case "5":

                    break;
                case "6":

                    break;
                case "7":
                    System.exit(0);
                    break;
                default:
                    System.out.printf("Bạn cần chọn lại");
            }
        } while (true);
    }

    public static void addCustomer() {
        String choose = null;
        do {
            System.out.println("\n------CUSTOMER----- " +
                    "\n Chọn chức năng theo số để tiếp tục" +
                    "\n 1. Thêm mới khách VN" +
                    "\n 2. Thêm mới khách nước ngoài  " +
                    "\n 3. Thoát");
            System.out.println("Chọn chức năng");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    vnCustomerService.add();
                    break;
                case "2":
                    fCustomerService.add();
                    break;
                case "3":
                    return;
                default:
                    System.out.printf("Bạn cần chọn lại");
            }
        } while (true);
    }

    public static void displayCustomer() {
        String choose = null;
        do {
            System.out.println("\n------CUSTOMER------ " +
                    "\n Chọn chức năng theo số để tiếp tục" +
                    "\n 1. Hiển thị khách hàng VN" +
                    "\n 2. Hiển thị khách hàng nước ngoài  " +
                    "\n 3. Thoát");
            System.out.println("Chọn chức năng");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    vnCustomerService.display();
                    break;
                case "2":
                    fCustomerService.display();
                    break;
                case "3":
                    return;
                default:
                    System.out.printf("Bạn cần chọn lại");
            }
        } while (true);
    }

    public static void searchCustomer() {
        String choose = null;
        do {
            System.out.println("\n------CUSTOMER------ " +
                    "\n Chọn chức năng theo số để tiếp tục" +
                    "\n 1. Tìm khách hàng VN" +
                    "\n 2. Tìm khách hàng nước ngoài" +
                    "\n 3. Thoát");
            System.out.println("Chọn chức năng");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    vnCustomerService.search();
                    break;
                case "2":
                    fCustomerService.search();
                    break;
                case "3":
                    return;
                default:
                    System.out.printf("Bạn cần chọn lại");
            }
        } while (true);
    }
}
