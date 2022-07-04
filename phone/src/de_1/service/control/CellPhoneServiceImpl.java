package de_1.service.control;

import de_1.models.CellPhone;
import de_1.service.IService.IService;
import de_1.util.NotFoundProductException;
import de_1.util.ReadAndWrite;
import de_1.util.Regex;


import java.util.List;
import java.util.Scanner;


public class CellPhoneServiceImpl implements IService {
    static Scanner scanner = new Scanner(System.in);
    private static final String PATH_FILE_MOBILES = "src/de_1/data/cellMobile.csv";

    @Override
    public void addNew() {
        List<CellPhone> cellPhones;
        cellPhones = ReadAndWrite.readCellPhoneToCSV(PATH_FILE_MOBILES);
        int idPhone = 0;
        int max = 0;
        if (cellPhones == null) {
            idPhone = 1;
        } else {
            for (int i = 0; i < cellPhones.size(); i++) {
                if (cellPhones.get(i).getIdPhone() > max) {
                    max = cellPhones.get(i).getIdPhone();
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
        String countryCell = getNation();
        String status = getArea();
        CellPhone cellPhone = new CellPhone(idPhone, name, pricePhone, amountPhone, manufacture, countryCell, status);
        cellPhones.add(cellPhone);
        ReadAndWrite.writeList(cellPhones, PATH_FILE_MOBILES, false);
    }

    @Override
    public void delete() {
        List<CellPhone> cellPhones;
        cellPhones = ReadAndWrite.readCellPhoneToCSV(PATH_FILE_MOBILES);
        for (CellPhone cellPhone : cellPhones) {
            System.out.printf(cellPhone.toString() + "\n");
        }
        System.out.println("Nhập id muốn xóa: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());

            int count = 0;
            for (int i = 0; i < cellPhones.size(); i++) {
                if (id == cellPhones.get(i).getIdPhone()) {
                    System.out.println("Bạn có chắc chắn muốn xóa hay không?");
                    System.out.println("1. có");
                    System.out.println("2. không");

                    int inputChoose = Integer.parseInt(scanner.nextLine());

                    switch (inputChoose) {
                        case 1:
                            cellPhones.remove(i);
                            System.out.println("đã xóa thành công");
                            ReadAndWrite.writeList(cellPhones, PATH_FILE_MOBILES, false);
                            cellPhones = ReadAndWrite.readCellPhoneToCSV(PATH_FILE_MOBILES);
                            for (CellPhone cellPhone : cellPhones) {
                                System.out.printf(cellPhone.toString() + "\n");
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
        List<CellPhone> cellPhones;
        cellPhones = ReadAndWrite.readCellPhoneToCSV(PATH_FILE_MOBILES);
        for (CellPhone cellPhone : cellPhones) {
            System.out.printf(cellPhone.toString() + "\n");
        }
    }

    @Override
    public void search() {
        List<CellPhone> cellPhones;
        cellPhones = ReadAndWrite.readCellPhoneToCSV(PATH_FILE_MOBILES);
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
            for (CellPhone item : cellPhones) {
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
            for (CellPhone item : cellPhones) {
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

    private static String getNation() {
        String value;
        while (true) {
            System.out.println("Nhập thành phố nhập về");
            value = scanner.nextLine();
            if (!value.equalsIgnoreCase("VietNam") && !value.equalsIgnoreCase("Viet Nam")) {
                break;
            }
            System.out.println("Not IN VIET NAM");
        }
        return value;
    }

    private static String getArea() {
        String temp;
        boolean check = true;
        int choose = 0;
        do {
            System.out.println("Chọn trạng thái");
            System.out.println("1.Da sua chua");
            System.out.println("2.Chua sua chua");
            try {
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại");
            }
            switch (choose) {
                case 1:
                    temp = "Da sua chua";
                    check = false;
                    break;
                case 2:
                    temp = "Chua sua chua";
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
