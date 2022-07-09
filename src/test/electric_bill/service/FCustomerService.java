package test.electric_bill.service;

import test.electric_bill.models.Customer;
import test.electric_bill.models.ForeignCustomer;
import test.electric_bill.models.TypeCustomer;
import test.electric_bill.models.VNCustomer;
import test.electric_bill.util.ReadAndWriteCustomer;
import test.electric_bill.util.RegexCustomer;

import java.util.List;
import java.util.Scanner;

public class FCustomerService implements ICustomer {
    static Scanner scanner = new Scanner(System.in);

    private static final String PATH_FILE_CUSTOMER = "src/test/electric_bill/data/khanhHang.csv";

    @Override
    public void add() {
        List<Customer> customerList;
        customerList = ReadAndWriteCustomer.readFileList(PATH_FILE_CUSTOMER);
        System.out.println("Nhập thông tin theo yêu cầu");
        String idCustomer = RegexCustomer.inputIdF();
        System.out.println("Nhập tên khách hàng");
        String nameCustomer = scanner.nextLine();
        System.out.println("Nhập quốc gia");
        String nationality = scanner.nextLine();
        ForeignCustomer foreignCustomer = new ForeignCustomer(idCustomer, nameCustomer, nationality);
        customerList.add(foreignCustomer);
        ReadAndWriteCustomer.writeList(customerList, PATH_FILE_CUSTOMER, false);
    }

    @Override
    public void display() {
        List<Customer> customerList;
        customerList = ReadAndWriteCustomer.readFileList(PATH_FILE_CUSTOMER);
        for (Customer item : customerList) {
            if (item instanceof ForeignCustomer) {
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
            if (item instanceof ForeignCustomer && item.getNameCustomer().contains(name)) {
                System.out.println(item);
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Không tìm thấy khách hàng");
        }
    }
}
