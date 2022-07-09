package test.electric_bill.service;

import test.electric_bill.models.Customer;
import test.electric_bill.models.TypeCustomer;
import test.electric_bill.models.VNCustomer;
import test.electric_bill.util.ReadAndWriteCustomer;
import test.electric_bill.util.RegexCustomer;

import java.util.List;
import java.util.Scanner;

public class VNCustomerService implements ICustomer {
    static Scanner scanner = new Scanner(System.in);

    private static final String PATH_FILE_CUSTOMER = "src/test/electric_bill/data/khanhHang.csv";
    private static final String PATH_FILE_TYPECUSTOMER = "src/test/electric_bill/data/loaiKhach.csv";

    @Override
    public void add() {
        List<Customer> customerList;
        List<TypeCustomer> typeCustomerList;
        customerList = ReadAndWriteCustomer.readFileList(PATH_FILE_CUSTOMER);
        typeCustomerList = ReadAndWriteCustomer.readFileListTypeCustomer(PATH_FILE_TYPECUSTOMER);
        System.out.println("Nhập thông tin theo yêu cầu");
        String idCustomer = RegexCustomer.inputIdVN();
        System.out.println("Nhập tên khách hàng");
        String nameCustomer = scanner.nextLine();
        System.out.println("Danh sách loại khách hàng");
        TypeCustomer typeCustomer = getTypeCus();
        int quota = 0;
        while (true) {
            try {
                System.out.println("Nhập định mức tiêu thụ");
                quota = Integer.parseInt(scanner.nextLine());
                if (quota < 0) {
                    System.err.println("Nhập số nguyên dương");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.err.println("Nhập sai định dạng");
            }
        }
        VNCustomer customer = new VNCustomer(idCustomer, nameCustomer, typeCustomer, quota);
        customerList.add(customer);
        ReadAndWriteCustomer.writeList(customerList, PATH_FILE_CUSTOMER, false);
    }

    @Override
    public void display() {
        List<Customer> customerList;
        customerList = ReadAndWriteCustomer.readFileList(PATH_FILE_CUSTOMER);
        for (Customer item : customerList) {
            if (item instanceof VNCustomer) {
                System.out.println(item);
            }
        }
    }

    @Override
    public void search() {
        List<Customer> customerList;
        customerList = ReadAndWriteCustomer.readFileList(PATH_FILE_CUSTOMER);
        System.out.println("Bạn tên khách hàng muốn tìm: ");
        String name = scanner.nextLine();
        boolean flag = true;
        for (Customer item : customerList) {
            if (item instanceof VNCustomer && item.getNameCustomer().contains(name)) {
                System.out.println(item);
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Không tìm thấy khách hàng");
        }
    }

    public static TypeCustomer getTypeCus() {
        List<TypeCustomer> typeCustomerList;
        typeCustomerList = ReadAndWriteCustomer.readFileListTypeCustomer(PATH_FILE_TYPECUSTOMER);
        TypeCustomer type = null;
        boolean flag = true;
        String choose = null;
        do {
            System.out.println("Chọn kiểu khách hàng\n" +
                    "1. LKH-001,Sinh hoạt\n" +
                    "2. LKH-002,Kinh doanh\n" +
                    "3. LKH-003,Sản xuất\n");
            System.out.print("Mời bạn chọn: ");
            choose = scanner.nextLine();
            for (int i = 0; i < typeCustomerList.size(); i++) {
                if (choose.equals("1")) {
                    type = typeCustomerList.get(0);
                    flag = false;
                    break;
                }
                if (choose.equals("2")) {
                    type = typeCustomerList.get(1);
                    flag = false;
                    break;
                }
                if (choose.equals("3")) {
                    type = typeCustomerList.get(2);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("Không tìm thấy loại khách hàng!");
            }
        } while (flag);
        return type;
    }

}
