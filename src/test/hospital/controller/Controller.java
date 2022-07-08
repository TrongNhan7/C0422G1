package test.hospital.controller;


import test.hospital.service.Impl.MedicalRecordNormalService;
import test.hospital.service.Impl.MedicalRecordVIpService;

import java.util.Scanner;

public class Controller {
    private static Scanner scanner = new Scanner(System.in);
    static MedicalRecordNormalService medicalRecordNormalService = new MedicalRecordNormalService();
    static MedicalRecordVIpService medicalRecordVIpService = new MedicalRecordVIpService();


    public static void displayMainMenu() {
        String choose = null;
        do {
            System.out.println("\n------CHƯƠNG TRÌNH QUẢN LÝ BỆNH ÁN ------ " +
                    "\n Chọn chức năng theo số để tiếp tục" +
                    "\n 1. Thêm mới" +
                    "\n 2. Xóa  " +
                    "\n 3. Xem danh sách các bệnh án " +
                    "\n 4. Thoát");
            System.out.println("Chọn chức năng");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    addMedicalRecord();
                    break;
                case "2":
                    deleteMedicalRecord();
                    break;
                case "3":
                    displayMedicalRecord();
                    break;
                case "4":
                    System.exit(0);
                    break;
                default:
                    System.out.printf("Bạn cần chọn lại");
            }
        } while (true);
    }

    public static void addMedicalRecord() {
        String choose = null;
        do {
            System.out.println("\n------BỆNH ÁN BỆNH NHÂN------ " +
                    "\n Chọn chức năng theo số để tiếp tục" +
                    "\n 1. Thêm mới bệnh án thường" +
                    "\n 2. Thêm mới bệnh án Vip  " +
                    "\n 3. Thoát");
            System.out.println("Chọn chức năng");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    medicalRecordNormalService.add();
                    break;
                case "2":
                    medicalRecordVIpService.add();
                    break;
                case "3":
                    return;
                default:
                    System.out.printf("Bạn cần chọn lại");
            }
        } while (true);
    }

    public static void deleteMedicalRecord() {
        String choose = null;
        do {
            System.out.println("\n------BỆNH ÁN BỆNH NHÂN------ " +
                    "\n Chọn chức năng theo số để tiếp tục" +
                    "\n 1. Xóa bệnh án thường" +
                    "\n 2. Xóa bệnh án Vip  " +
                    "\n 3. Thoát");
            System.out.println("Chọn chức năng");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    medicalRecordNormalService.delete();
                    break;
                case "2":
                    medicalRecordVIpService.delete();
                    break;
                case "3":
                    return;
                default:
                    System.out.printf("Bạn cần chọn lại");
            }
        } while (true);
    }

    public static void displayMedicalRecord() {
        String choose = null;
        do {
            System.out.println("\n------BỆNH ÁN BỆNH NHÂN------ " +
                    "\n Chọn chức năng theo số để tiếp tục" +
                    "\n 1. Hiển thị bệnh án thường" +
                    "\n 2. Hiển thị  bệnh án Vip  " +
                    "\n 3. Thoát");
            System.out.println("Chọn chức năng");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    medicalRecordNormalService.display();
                    break;
                case "2":
                    medicalRecordVIpService.display();
                    break;
                case "3":
                    return;
                default:
                    System.out.printf("Bạn cần chọn lại");
            }
        } while (true);
    }
}
