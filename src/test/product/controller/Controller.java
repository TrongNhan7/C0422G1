package test.product.controller;


import test.product.service.impl.ExportProductService;
import test.product.service.impl.ImportProductService;

import java.util.Scanner;

public class Controller {
    private static Scanner scanner = new Scanner(System.in);
    static ImportProductService importProductService = new ImportProductService();
    static ExportProductService exportProductService = new ExportProductService();


    public static void displayMainMenu() {
        String choose = null;
        do {
            System.out.println("\n------CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM------ " +
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
                    addProduct();
                    break;
                case "2":
                    deleteProduct();
                    break;
                case "3":
                    displayProduct();
                    break;
                case "4":
                    searchProduct();
                    break;
                case "5":
                    System.exit(0);
                    break;
                default:
                    System.out.printf("Bạn cần chọn lại");
            }
        } while (true);
    }

    public static void addProduct() {
        String choose = null;
        do {
            System.out.println("\n------PRODUCT------ " +
                    "\n Chọn chức năng theo số để tiếp tục" +
                    "\n 1. Thêm mới sản phẩm nhập khẩu" +
                    "\n 2. Thêm mới xuất khẩu  " +
                    "\n 3. Thoát");
            System.out.println("Chọn chức năng");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    importProductService.add();
                    break;
                case "2":
                    exportProductService.add();
                    break;
                case "3":
                    return;
                default:
                    System.out.printf("Bạn cần chọn lại");
            }
        } while (true);
    }

    public static void deleteProduct() {
        String choose = null;
        do {
            System.out.println("\n------PRODUCT------ " +
                    "\n Chọn chức năng theo số để tiếp tục" +
                    "\n 1. Xóa sản phẩm xuất khẩu" +
                    "\n 2. Xóa sản phẩm nhập khẩu  " +
                    "\n 3. Thoát");
            System.out.println("Chọn chức năng");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    importProductService.delete();
                    break;
                case "2":
                    exportProductService.delete();
                    break;
                case "3":
                    return;
                default:
                    System.out.printf("Bạn cần chọn lại");
            }
        } while (true);
    }

    public static void displayProduct() {
        String choose = null;
        do {
            System.out.println("\n------PRODUCT------ " +
                    "\n Chọn chức năng theo số để tiếp tục" +
                    "\n 1. Hiển thị sản phẩm xuất khẩu" +
                    "\n 2. Hiển thị sản phẩm nhập khẩu  " +
                    "\n 3. Thoát");
            System.out.println("Chọn chức năng");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    importProductService.display();
                    break;
                case "2":
                    exportProductService.display();
                    break;
                case "3":
                    return;
                default:
                    System.out.printf("Bạn cần chọn lại");
            }
        } while (true);
    }

    public static void searchProduct() {
        String choose = null;
        do {
            System.out.println("\n------PRODUCT------ " +
                    "\n Chọn chức năng theo số để tiếp tục" +
                    "\n 1. Tìm sản phẩm nhập khẩu" +
                    "\n 2. Tìm sản phẩm xuất khẩu  " +
                    "\n 3. Thoát");
            System.out.println("Chọn chức năng");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    importProductService.search();
                    break;
                case "2":
                    exportProductService.search();
                    break;
                case "3":
                    return;
                default:
                    System.out.printf("Bạn cần chọn lại");
            }
        } while (true);
    }
}
