package test.electric_bill.service;

import test.electric_bill.models.TypeCustomer;

import java.util.List;
import java.util.Scanner;

public class TypeCustomerService {
    static Scanner scanner = new Scanner(System.in);
    private static final String PATH_FILE_TYPECUSTOMER = "src/test/electric_bill/data/loaiKhach.csv";

    public void add() {
        List<TypeCustomer> typeCustomerList = ReadAndWriteCustomer.readFileListTypeCustomer(PATH_FILE_TYPECUSTOMER);
        ,

    }
}
