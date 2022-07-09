package test.electric_bill.service;

import test.electric_bill.models.Receipt;
import test.electric_bill.util.ReadAndWriteCustomer;

import java.util.List;
import java.util.Scanner;

public class ReceiptService {
    static Scanner scanner = new Scanner(System.in);
    private static final String PATH_FILE_RECEIPT = "src/test/electric_bill/data/hoadon.csv";

    public void addReceipt() {
        List<Receipt> receipts;
        receipts = ReadAndWriteCustomer.readFileListReceipt(PATH_FILE_RECEIPT);
        System.out.println("Nhập thông tin theo yêu cầu");
        String idReceipt = null;
        int max = 0;
        if (receipts == null) {
            idReceipt = 1;
        } else {
            for (Receipt receipt : receipts) {
                if (receipt.getIdReceipt() > max) {
                    max = receipt.getIdReceipt();
                }
            }
        }
        idReceipt = max + 1;


    }
}
