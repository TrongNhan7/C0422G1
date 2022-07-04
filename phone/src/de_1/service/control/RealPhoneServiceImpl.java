package de_1.service.control;

import de_1.models.CellPhone;
import de_1.models.RealPhone;
import de_1.service.IService.IService;
import de_1.util.NotFoundProductException;
import de_1.util.ReadAndWrite;
import de_1.util.Regex;

import java.util.List;
import java.util.Scanner;

public class RealPhoneServiceImpl implements IService {
    static Scanner scanner = new Scanner(System.in);
    private static final String PATH_FILE_REALMOBILES = "src/de_1/data/realMobile";

    @Override
    public void addNew() {
        List<RealPhone> realPhones;
        realPhones = ReadAndWrite.readRealPhoneToCSV(PATH_FILE_REALMOBILES);
        int idPhone = 0;
        int max = 0;
        if (realPhones == null) {
            idPhone = 1;
        } else {
            for (int i = 0; i < realPhones.size(); i++) {
                if (realPhones.get(i).getIdPhone() > max) {
                    max = realPhones.get(i).getIdPhone();
                }
            }
        }
        idPhone = max + 1;
        System.out.println("Nhập tên Phone");
        String name = scanner.nextLine();
        System.out.println("Nhập giá bán");
        double pricePhone = Double.parseDouble(Regex.inputNumberDouble());
        System.out.println("Nhập số lượng");
        int amountPhone = Integer.parseInt(Regex.inputNumber());
        System.out.println("Nhập nhà sản xuất");
        String manufacture = scanner.nextLine();
        int time = getTerm();
        String cover = getCover();
        RealPhone realPhone = new RealPhone(idPhone, name, pricePhone, amountPhone, manufacture, time, cover);
        realPhones.add(realPhone);
        ReadAndWrite.writeList(realPhones, PATH_FILE_REALMOBILES, false);
    }

    @Override
    public void delete() {
        List<RealPhone> realPhones;
        realPhones = ReadAndWrite.readRealPhoneToCSV(PATH_FILE_REALMOBILES);
        for (RealPhone realPhone : realPhones) {
            System.out.printf(realPhone.toString() + "\n");
        }
        System.out.println("Nhập id muốn xóa: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());

            int count = 0;
            for (int i = 0; i < realPhones.size(); i++) {
                if (id == realPhones.get(i).getIdPhone()) {
                    System.out.println("Bạn có chắc chắn muốn xóa hay không?");
                    System.out.println("1. có");
                    System.out.println("2. không");

                    int inputChoose = Integer.parseInt(scanner.nextLine());

                    switch (inputChoose) {
                        case 1:
                            realPhones.remove(i);
                            System.out.println("đã xóa thành công");
                            ReadAndWrite.writeList(realPhones, PATH_FILE_REALMOBILES, false);
                            realPhones = ReadAndWrite.readRealPhoneToCSV(PATH_FILE_REALMOBILES);
                            for (RealPhone realPhone : realPhones) {
                                System.out.printf(realPhone.toString() + "\n");
                            }
                            count++;
                            break;
                        case 2:
                            count++;
                            break;
                    }
                }
            }
            if (count == 0) {
                throw new NotFoundProductException("Id không tồn tại");
            }
        } catch (NumberFormatException e) {
            System.out.println("Nhập sai định dạng");

        } catch (NotFoundProductException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void display() {
        List<RealPhone> realPhones;
        realPhones = ReadAndWrite.readRealPhoneToCSV(PATH_FILE_REALMOBILES);
        for (RealPhone realPhone : realPhones) {
            System.out.printf(realPhone.toString() + "\n");
        }
    }

    @Override
    public void search() {
        List<RealPhone> realPhones;
        realPhones = ReadAndWrite.readRealPhoneToCSV(PATH_FILE_REALMOBILES);
        System.out.println("Bạn muốn tìm kiếm theo: ");
        System.out.println("1. Id điện thoại");
        System.out.println("2. Tên điện thoại");
        int choose = 0;
        try {
            choose = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại");
        }
        if (choose == 1) {
            System.out.println("Nhập id điện thoại cần kiếm ");
            int id = Integer.parseInt(Regex.inputNumber());
            boolean flag = false;
            for (RealPhone item : realPhones) {
                if (id == item.getIdPhone()) {
                    System.out.println(item);
                } else {
                    flag = true;
                }
            }
            if (flag) {
                System.out.println("Không tìm thấy id điện thoại");
            }
        } else if (choose == 2) {
            System.out.println("Nhập tên điện thoại muốn tìm kiếm: ");
            String name = scanner.nextLine();
            boolean flag = false;
            for (RealPhone item : realPhones) {
                if (name.contains(item.getNamePhone())) {
                    System.out.println(item);
                } else {
                    flag = true;
                }
            }
            if (flag) {
                System.out.println("Không tìm thấy tên điện thoại");
            }
        }
    }

    public static int getTerm() {
        int value;
        while (true) {
            try {
                System.out.println("Nhập thời gian bảo hành");
                value = Integer.parseInt(scanner.nextLine());

                if (value < 0) {
                    System.out.println("Thời gian bảo hành phải là số dương");
                    continue;
                }

                if (value > 720) {
                    System.out.println(" Thời gian bảo hành phải bé hơn 720");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai định dạng");
            }
        }
        return value;
    }

    private static String getCover() {
        String temp;
        boolean check = true;
        int choose = 0;
        do {
            System.out.println("Chọn trạng thái");
            System.out.println("1.Toàn Quốc");
            System.out.println("2.Quốc tế");
            try {
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại");
            }
            switch (choose) {
                case 1:
                    temp = "Toàn Quốc";
                    check = false;
                    break;
                case 2:
                    temp = "Quốc tế";
                    check = false;
                    break;
                default:
                    System.out.printf("You need to choose again");
                    throw new IllegalStateException("Unexpected value: " + choose);
            }
        } while (check);

        return temp;
    }

}
