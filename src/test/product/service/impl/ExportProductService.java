package test.product.service.impl;

import case_study.util.ReadAndWrite;
import test.product.common.NotFoundProductException;
import test.product.models.ExportProduct;
import test.product.models.ImportProduct;
import test.product.models.Product;
import test.product.util.ReadAndWriteProduct;

import java.util.List;
import java.util.Scanner;

public class ExportProductService implements IProduct {
    static Scanner scanner = new Scanner(System.in);

    private static final String PATH_FILE_PRODUCT = "src/test/product/data/products.csv";

    @Override
    public void add() {
        List<Product> productList;
        productList = ReadAndWriteProduct.readFileList(PATH_FILE_PRODUCT);
        System.out.println("Nhập thông tin theo yêu cầu");
        int idProduct = 0;
        int max = 0;
        if (productList == null) {
            idProduct = 1;
        } else {
            for (Product product : productList) {
                if (product.getIdProduct() > max) {
                    max = product.getIdProduct();
                }
            }
        }
        idProduct = max + 1;
        System.out.println("Nhập mã sản phẩm");
        String codeProduct = scanner.nextLine();
        System.out.println("Nhập tên sản phẩm");
        String nameProduct = scanner.nextLine();
        double costProduct = 0;
        while (true) {
            try {
                System.out.println("Nhập giá sản phẩm");
                costProduct = Double.parseDouble(scanner.nextLine());
                if (costProduct < 0) {
                    System.err.println("Nhập số nguyên dương");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.err.println("Nhập sai định dạng");
            }
        }
        int quanlityProduct = 0;
        while (true) {
            try {
                System.out.println("Nhập số lượng sản phẩm");
                quanlityProduct = Integer.parseInt(scanner.nextLine());
                if (quanlityProduct < 0) {
                    System.err.println("Nhập số nguyên dương");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.err.println("Nhập sai định dạng");
            }
        }
        System.out.println("Nhập nhà sản xuất");
        String manufacture = scanner.nextLine();

        double exportCostProduct = 0;
        while (true) {
            try {
                System.out.println("Nhập giá xuất khẩu");
                exportCostProduct = Double.parseDouble(scanner.nextLine());
                if (exportCostProduct < 0) {
                    System.err.println("Nhập số nguyên dương");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.err.println("Nhập sai định dạng");
            }
        }
        System.out.println("Nhập quốc gia xuất khẩu");
        String exportCountry = scanner.nextLine();
        ExportProduct exportProduct = new ExportProduct(idProduct, codeProduct, nameProduct, costProduct, quanlityProduct,
                manufacture, exportCostProduct, exportCountry);
        productList.add(exportProduct);
        ReadAndWriteProduct.writeList(productList, PATH_FILE_PRODUCT, false);

    }

    @Override
    public void delete() {
        List<Product> productList;
        productList = ReadAndWriteProduct.readFileList(PATH_FILE_PRODUCT);
        for (Product item : productList) {
            if (item instanceof ImportProduct) {
                System.out.println(item);
            }
        }
        boolean flag = true;
        String codeProduct = null;
        do {
            codeProduct = scanner.nextLine();
            int count = 0;
            String inputChoose = null;
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i) instanceof ExportProduct && productList.get(i).getCodeProduct().equals(codeProduct)) {
                    System.out.println("Bạn có chắc chắn muốn xóa hay không?");
                    System.out.println("1. có");
                    System.out.println("2. không");

                    inputChoose = scanner.nextLine();

                    switch (inputChoose) {
                        case "1":
                            productList.remove(i);
                            System.out.println("đã xóa thành công");
                            count++;
                            flag = false;
                            break;
                        case "2":
                            count++;
                            flag = false;
                            break;
                    }
                }
            }
            try {
                if (count == 0) {
                    throw new NotFoundProductException("Mã sản phẩm không tồn tại,vui lòng nhập lại");
                }
            } catch (NotFoundProductException e) {
                System.out.println(e.getMessage());
            }
        } while (flag);
        ReadAndWriteProduct.writeList(productList, PATH_FILE_PRODUCT, false);
    }

    @Override
    public void display() {
        List<Product> productList;
        productList = ReadAndWriteProduct.readFileList(PATH_FILE_PRODUCT);
        for (Product item : productList) {
            if (item instanceof ExportProduct) {
                System.out.println(item);
            }
        }
    }

    @Override
    public void search() {
        List<Product> productList;
        productList = ReadAndWriteProduct.readFileList(PATH_FILE_PRODUCT);
        for (Product item : productList) {
            if (item instanceof ExportProduct) {
                System.out.println(item);
            }
        }
        System.out.println("Bạn muốn tìm kiếm theo: ");
        System.out.println("1. Mã sản phẩm");
        System.out.println("2. Tên sản phẩm");
        int choose = 0;
        try {
            choose = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại");
        }
        if (choose == 1) {
            System.out.println("Nhập mã sản phẩm");
            String codeProduct = scanner.nextLine();
            boolean flag = true;
            for (Product item : productList) {
                if (item instanceof ExportProduct && item.getCodeProduct().contains(codeProduct)) {
                    System.out.println(item);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("Không tìm thấy mã sản phẩm");
            }
        } else if (choose == 2) {
            System.out.println("Nhập tên sản phẩm muốn tìm kiếm: ");
            String name = scanner.nextLine();
            boolean flag = true;
            for (Product item : productList) {
                if (item instanceof ExportProduct && item.getNameProduct().contains(name)) {
                    System.out.println(item);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("Không tìm thấy tên sản phẩm");
            }
        }
    }
}
