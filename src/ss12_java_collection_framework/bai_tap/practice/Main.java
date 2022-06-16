package ss12_java_collection_framework.bai_tap.practice;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        displayMenu();
    }

    public static void displayMenu() {
        ss12_java_collection_framework.bai_tap.practice.ProductManager productManager = new ss12_java_collection_framework.bai_tap.practice.ProductManager();
        boolean flag = true;
        do {
            System.out.println("Chức năng của hệ thống " +
                    "\n 1.Display" +
                    "\n 2. Add" +
                    "\n 3.Delete" +
                    "\n 4. Edit" +
                    "\n 5. Search" +
                    "\n 6. Sort" +
                    "\n 7. Exit");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Chọn chức năng");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    // code display
                    System.out.println("chức năng hiện thị");
                    productManager.display();
                    break;
                case 2:
                    // code thêm mới
                    System.out.println("Chức năng thêm ới");
                    productManager.add();
                    break;
                case 3:
                    // code xóa
                    System.out.println("chức năng xóa");
                    productManager.remove();

                    break;
                case 4:
                    // code sửa
                    System.out.println("chức năng sửa");
                    productManager.edit();

                    break;
                case 5:
                    // code tìm kiếm
                    System.out.println("chức năng tìm kiếm");
                    productManager.search();
                    break;
                case 6:
                    // code tìm kiếm
                    System.out.println("chức năng sắp xếp");
                    System.out.println("Chon 1 sort tang, con lai la giam: ");
                    int a = Integer.parseInt(scanner.nextLine());
                    if (a == 1) {
                        productManager.sort(true);
                    } else {
                        productManager.sort(false);
                    }
                    break;
                default:
                    flag = false;
            }
        } while (flag);
    }
}
