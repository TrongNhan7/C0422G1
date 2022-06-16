package ss12_java_collection_framework.bai_tap.practice;

import bai_tap.practice.PriceCompartor2;

import java.util.*;

public class ProductManager implements ss12_java_collection_framework.bai_tap.practice.IProduct {
    static Scanner scanner = new Scanner(System.in);
    static List<ss12_java_collection_framework.bai_tap.practice.Product> productList = new ArrayList<>();

    static {
        productList.add(new ss12_java_collection_framework.bai_tap.practice.Product(1, "Nokia", 200));
        productList.add(new ss12_java_collection_framework.bai_tap.practice.Product(7, "Samsung", 100));
        productList.add(new ss12_java_collection_framework.bai_tap.practice.Product(5, "Motorola", 700));

    }

    @Override
    public void add() {
        System.out.println("Nhập id: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getIdProduct() == id) {
                System.out.println("Id đã tồn tại, xin vui lòng nhập lại: ");
                System.out.println("Nhập Id: ");
                id = Integer.parseInt(scanner.nextLine());
            }
        }
        System.out.println("Nhập tên sản phẩm: ");
        String namePro = scanner.nextLine();
        System.out.println("Nhập giá: ");
        double price = Double.parseDouble(scanner.nextLine());
        productList.add(new ss12_java_collection_framework.bai_tap.practice.Product(id, namePro, price));
    }

    @Override
    public void edit() {
        System.out.println("Nhập Id sản phẩm cần edit: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean flag = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getIdProduct() == id) {
                System.out.println("nhập lại Id sản phẩm: ");
                productList.get(i).setIdProduct(Integer.parseInt(scanner.nextLine()));
                System.out.println("nhập lại tên sản phẩm: ");
                productList.get(i).setNameProduct(scanner.nextLine());
                System.out.println("nhập lại giá sản phẩm");
                productList.get(i).setPriceProduct(Integer.parseInt(scanner.nextLine()));
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("Không tìm thấy sản phẩm cần edit");
        }
    }

    @Override
    public void remove() {
        System.out.println("Nhập id sản phẩm muốn xóa");
        int id = Integer.parseInt(scanner.nextLine());
        boolean flag = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getIdProduct() == id) {
                productList.remove(i);
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Không tìm thấy sản phẩm cần xóa");
        }
    }

    @Override
    public void display() {
        for (ss12_java_collection_framework.bai_tap.practice.Product product : productList) {
            System.out.println(product);
        }
    }

    @Override
    public void search() {
        System.out.println("Nhập tên sản phẩm muốn tìm");
        String name = scanner.nextLine();
        boolean flag = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getNameProduct().equals(name)) {
                System.out.println(productList.get(i).toString());
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Không tìm thấy sản phẩm");
        }
    }



    @Override
    public void sort(boolean sort) {
        if (sort == true) {
            ss12_java_collection_framework.bai_tap.practice.PriceCompartor priceCompartor = new ss12_java_collection_framework.bai_tap.practice.PriceCompartor();
            Collections.sort(productList, priceCompartor);
        }else {
           PriceCompartor2 priceCompartor2 = new PriceCompartor2();
           Collections.sort(productList,priceCompartor2);
        }
    }

}
