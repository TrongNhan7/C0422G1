package ss17_i0_binaryfile_serialization.bai_tap;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Product> productList = new ArrayList<>();

    public static void writeFile(String path, List<Product> products) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> readFile(String path) {
        List<Product> products = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            products = (List<Product>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return products;
    }

    public static void main(String[] args) {
        do {
            System.out.println("------MENU------");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị sản phẩm");
            System.out.println("3. Tìm kiếm sản phẩm");
            System.out.println("4. Thoát");
            System.out.println("Chọn yêu cầu:");
            int chosen = Integer.parseInt(scanner.nextLine());
            switch (chosen) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    displayProduct();
                    break;
                case 3:
                    findProduct();
                    break;
                default:
                    System.exit(4);
            }
        } while (true);
    }

    public static void addProduct() {
        System.out.println("Nhập tên sản phẩm:");
        String nameProduct = scanner.nextLine();
        System.out.println("Nhập tên hãng sản xuất:");
        String production = scanner.nextLine();
        System.out.println("Nhập giá");
        Double price = Double.parseDouble(scanner.nextLine());

        productList.add(new Product(productList.size() + 1, nameProduct, production, price));
        writeFile("src/ss17_i0_binaryfile_serialization/bai_tap/products.txt", productList);
        System.out.println("Thêm thành công");
    }

    public static void displayProduct() {
        if (productList.size() > 0) {
            productList = readFile("src/ss17_i0_binaryfile_serialization/bai_tap/products.txt");
            for (Product item : productList) {
                System.out.println(item);
            }
        } else {
            System.out.printf("List trống\n");
        }
    }

    public static void findProduct() {
        if (productList.size() > 0) {
            productList = readFile("src/ss17_i0_binaryfile_serialization/bai_tap/products.txt");
            System.out.println("Nhập tên sản phẩm hoặc tên nhà sản xuất cần tìm:");
            String nameFind = scanner.nextLine();
            int count = 0;
            for (Product item : productList) {
                if (item.getProductName().contains(nameFind) || item.getProduction().contains(nameFind)) {
                    System.out.println(item);
                    count++;
                }
            }
            System.out.println("Tìm được " + count + " sản phẩm.");
        } else {
            System.out.printf("List trống\n");
        }
    }
}