package ss12_java_collection_framework.bai_tap.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager implements IProduct {
    static Scanner scanner = new Scanner(System.in);
    static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Nokia", 200));
        productList.add(new Product(7, "Samsung", 100));
        productList.add(new Product(5, "Motorola", 700));

    }

    @Override
    public void add() {
        System.out.println("Nhập id: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i=0; i<productList.size(); i++){
            if((productList.get(i).getIdProduct()==)
        }
        System.out.println("Nhập tên sản phẩm: ");
        String namePro = scanner.nextLine();
        System.out.println("Nhập giá: ");
        double price = Double.parseDouble(scanner.nextLine());
        productList.add(new Product(id, namePro, price));
    }

    @Override
    public void edit() {

    }

    @Override
    public void remove() {

    }

    @Override
    public void display() {
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    @Override
    public void search() {

    }

    @Override
    public void sort() {

    }
}
