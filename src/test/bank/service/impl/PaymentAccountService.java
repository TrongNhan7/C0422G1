package test.bank.service.impl;

import test.bank.common.DateCheckingException;
import test.bank.common.NotFoundBankAccountException;
import test.bank.models.Bank;
import test.bank.models.PaymentAccount;
import test.bank.models.SavingAccount;
import test.bank.util.ReadAndWriteBank;
import test.bank.util.Regex;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class PaymentAccountService implements IBank {
    static Scanner scanner = new Scanner(System.in);

    private static final String PATH_FILE_BankAcount = "src/test/bank/data/bank_accounts.csv";

    @Override
    public void add() {
        List<Bank> bankList;
        bankList = ReadAndWriteBank.readFileList(PATH_FILE_BankAcount);
        System.out.println("Nhập thông tin theo yêu cầu");
        int idBankAccount = 0;
        int max = 0;
        if (bankList == null) {
            idBankAccount = 1;
        } else {
            for (Bank bank : bankList) {
                if (bank.getIdAccount() > max) {
                    max = bank.getIdAccount();
                }
            }
        }
        idBankAccount = max + 1;
        System.out.println("Nhập mã tài khoản");
        String codeAccount = Regex.inputCodeAccount();
        System.out.println("Nhập tên chủ tài khoản");
        String nameAccount = Regex.inputName();
        LocalDate creationDateAccount;
        while (true) {
            try {
                System.out.println("Nhập ngày tạo tài khoản");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                creationDateAccount = LocalDate.parse(scanner.nextLine(), formatter);
                DateCheckingException.checkDateStart(creationDateAccount);
                break;
            } catch (DateTimeParseException e) {
                System.err.println("Nhập ngày theo định dạng dd/MM/yyyy");
            } catch (DateCheckingException e) {
                System.err.println(e.getMessage());
            }
        }
        int cardNumber = 0;
        while (true) {
            try {
                System.out.println("Nhập số thẻ");
                cardNumber = Integer.parseInt(Regex.inputCardNumber());
                if (cardNumber < 0) {
                    System.err.println("Nhập số nguyên dương");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.err.println("Nhập sai định dạng");
            }
        }
        double amountAccount = 0;
        while (true) {
            try {
                System.out.println("Nhập số tiền trong tài khoản");
                amountAccount = Double.parseDouble(scanner.nextLine());
                if (amountAccount < 0) {
                    System.err.println("Nhập số nguyên dương");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.err.println("Nhập sai định dạng");
            }
        }

        PaymentAccount paymentAccount = new PaymentAccount(idBankAccount, codeAccount, nameAccount, creationDateAccount,
                cardNumber, amountAccount);
        bankList.add(paymentAccount);
        ReadAndWriteBank.writeList(bankList, PATH_FILE_BankAcount, false);
    }

    @Override
    public void delete() {
        List<Bank> banklist;
        banklist = ReadAndWriteBank.readFileList(PATH_FILE_BankAcount);
        for (Bank item : banklist) {
            if (item instanceof PaymentAccount) {
                System.out.println(item);
            }
        }
        boolean flag = true;
        String codeAccount = null;
        do {
            System.out.println("Nhập mã tài khoản muốn xóa");
            codeAccount = scanner.nextLine();
            int count = 0;
            String inputChoose = null;
            for (int i = 0; i < banklist.size(); i++) {
                if (banklist.get(i) instanceof PaymentAccount && banklist.get(i).getCodeAccount().equals(codeAccount)) {
                    System.out.println("Bạn có chắc chắn muốn xóa hay không?");
                    System.out.println("1. có");
                    System.out.println("2. không");

                    inputChoose = scanner.nextLine();

                    switch (inputChoose) {
                        case "1":
                            banklist.remove(i);
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
                    throw new NotFoundBankAccountException("Mã sản tài khoản không tồn tại,vui lòng nhập lại");
                }
            } catch (NotFoundBankAccountException e) {
                System.err.println(e.getMessage());
            }
        } while (flag);
        ReadAndWriteBank.writeList(banklist, PATH_FILE_BankAcount, false);
    }

    @Override
    public void display() {
        List<Bank> bankList;
        bankList = ReadAndWriteBank.readFileList(PATH_FILE_BankAcount);
        for (Bank item : bankList) {
            if (item instanceof PaymentAccount) {
                System.out.println(item);
            }
        }
    }

    @Override
    public void search() {
        List<Bank> bankList;
        bankList = ReadAndWriteBank.readFileList(PATH_FILE_BankAcount);
        System.out.println("Bạn muốn tìm kiếm theo: ");
        System.out.println("1. Mã tài khoản");
        System.out.println("2. Tên chủ tài khoản");
        int choose = 0;
        try {
            choose = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại");
        }
        if (choose == 1) {
            System.out.println("Nhập mã tài khoản");
            String codeAccount = scanner.nextLine();
            boolean flag = true;
            for (Bank item : bankList) {
                if (item instanceof PaymentAccount && item.getCodeAccount().contains(codeAccount)) {
                    System.out.println(item);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("Không tìm thấy mã tài khoản");
            }
        } else if (choose == 2) {
            System.out.println("Nhập tên chủ tài khoản muốn tìm kiếm: ");
            String name = scanner.nextLine();
            boolean flag = true;
            for (Bank item : bankList) {
                if (item instanceof PaymentAccount && item.getNameAccount().contains(name)) {
                    System.out.println(item);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("Không tìm thấy tên tài khoản");
            }
        }
    }
}
