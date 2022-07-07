package case_study.service.control;

import case_study.common.TypeInformation;
import case_study.models.Person.Customer;
import case_study.models.Person.Employee;
import case_study.service.IService.ICustomerService;
import case_study.util.ReadAndWrite;
import case_study.util.Regex;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements ICustomerService {
    private static Scanner scanner = new Scanner(System.in);

    private static final String PATH_FILE_CUSTOMER = "src/case_study/data/Customer.csv";


    @Override
    public void display() {
        List<Customer> customerList;
        customerList = ReadAndWrite.readFileList(PATH_FILE_CUSTOMER);
        for (Customer customer : customerList) {
            System.out.printf(customer.toString() + "\n");
        }
    }

    @Override
    public void add() {
        List<Customer> customerList;
        customerList = ReadAndWrite.readFileList(PATH_FILE_CUSTOMER);
        System.out.printf("Nhập thông tin theo yêu cầu");
        int id = 0;
        int max = 0;
        if (customerList == null) {
            id = 1;
        } else {
            for (Customer customer : customerList) {
                if (customer.getId() > max) {
                    max = customer.getId();
                }
            }
        }
        id = max + 1;
        System.out.println("\nNhập tên");
        String name = Regex.inputName();
        String birthday = Regex.inputBirthday();
        String sex = TypeInformation.getTypeSex();
        String idCard = null;
        boolean flag = true;
        do {
            idCard = Regex.inputIdCard();
            for (Customer customer : customerList) {
                flag = false;
                if (customer.getIdCard().equals(idCard)) {
                    System.out.println("Bạn đã nhập trùng IdCard");
                    flag = true;
                    break;
                }
            }
        } while (flag);
        String phone = Regex.inputPhone();
        String email = Regex.inputMail();
        String customerType = TypeInformation.getTypeCustomer();
        System.out.println("Nhập địa chỉ khách hàng");
        String address = scanner.nextLine();
        Customer customer = new Customer(id, name, birthday, sex, idCard, phone, email, customerType, address);
        customerList.add(customer);
        ReadAndWrite.writeList(customerList, PATH_FILE_CUSTOMER, false);
        System.out.println("Đã thêm thành công");

    }

    @Override
    public void edit() {
        List<Customer> customerList;
        customerList = ReadAndWrite.readFileList(PATH_FILE_CUSTOMER);
        int checkId = 0;
        System.out.println("Nhập id muốn sửa: ");
        int inputId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId() == inputId) {
                System.out.println("\nNhập tên");
                String name = Regex.inputName();
                String birthday = Regex.inputBirthday();
                String sex = TypeInformation.getTypeSex();
                String idCard = null;
                boolean flag = true;
                do {
                    idCard = Regex.inputIdCard();
                    for (Customer customer : customerList) {
                        flag = false;
                        if (customer.getIdCard().equals(idCard)) {
                            System.out.println("Bạn đã nhập trùng IdCard");
                            flag = true;
                            break;
                        }
                    }
                } while (flag);
                String phone = Regex.inputPhone();
                String email = Regex.inputMail();
                String customerType = TypeInformation.getTypeCustomer();
                System.out.println("Nhập địa chỉ khách hàng");
                String address = scanner.nextLine();


                customerList.get(i).setName(name);
                customerList.get(i).setBirthday(birthday);
                customerList.get(i).setSex(sex);
                customerList.get(i).setIdCard(idCard);
                customerList.get(i).setPhone(phone);
                customerList.get(i).setEmail(email);
                customerList.get(i).setCustomerType(customerType);
                customerList.get(i).setAddress(address);

                System.out.println("Cập nhập thành công");
                checkId++;

            }
        }
        ReadAndWrite.writeList(customerList, PATH_FILE_CUSTOMER, false);
        if (checkId == 0) {
            System.out.println("Không tìm thấy id");
        }
    }

    public void deleteCustomer() {
        List<Customer> customerList;
        customerList = ReadAndWrite.readFileList(PATH_FILE_CUSTOMER);
        for (Customer customer : customerList) {
            System.out.printf(customer.toString() + "\n");
        }
        System.out.println("Nhap ten Customer muon xoa: ");
        String name = scanner.nextLine();
        boolean flag = false;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getName().equals(name)) {
                customerList.remove(i);
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Khong tim thay ten can xoa");
        }
        ReadAndWrite.writeList(customerList, PATH_FILE_CUSTOMER, false);
    }

}
