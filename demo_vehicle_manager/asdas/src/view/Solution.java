package view;

import Controller.CarController;
import Controller.MotoBikeController;
import Controller.TruckController;

import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMain();
    }

    public static void displayMain() {
        CarController carController = new CarController();
        TruckController truckController = new TruckController();
        MotoBikeController motoBikeController = new MotoBikeController();
        boolean flag = true;
        do {
            System.out.println(" CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG " +
                    "\n 1. Thêm mới phương tiện" +
                    "\n 2. Hiển thị phương tiện" +
                    "\n 3. Xóa phương tiện" +
                    "\n 4. Tìm kiếm theo biển kiểm soát" +
                    "\n 5. Exit");
            System.out.println("Chọn chức năng");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("Chọn loại phương tiện thêm vào: " +
                            "\n 1. Thêm mới phương tiện xe Oto" +
                            "\n 2. Thêm thị phương tiện xe Tải" +
                            "\n 3. Thêm phương tiện xe máy");
                    int choose1 = Integer.parseInt(scanner.nextLine());
                    switch (choose1) {
                        case 1:
                            carController.addNewVehicle();
                            break;
                        case 2:
                            truckController.addNewVehicle();
                            break;
                        case 3:
                            motoBikeController.addNewVehicle();
                            break;
                    }

                    break;
                case 2:
                    System.out.println("Chức năng hiển thị");
                    System.out.println("Chọn loại phương tiện hiển thị vào: " +
                            "\n 1. Hiển thị phương tiện xe Oto" +
                            "\n 2. Hiển thị phương tiện xe Tải" +
                            "\n 3. Hiển thị  phương tiện xe máy");
                    int choose2 = Integer.parseInt(scanner.nextLine());
                    switch (choose2) {
                        case 1:
                            carController.displayVehicle();
                            break;
                        case 2:
                            truckController.displayVehicle();
                            break;
                        case 3:
                            motoBikeController.displayVehicle();
                            break;
                    }

                    break;
                case 3:
                    System.out.println("chức năng xóa");
                    System.out.println("Nhập biển số cần xóa: ");
                    String numberPlateNeedDelete = scanner.nextLine();
                    carController.deleteVehicle(numberPlateNeedDelete);
                    truckController.deleteVehicle(numberPlateNeedDelete);
                    motoBikeController.deleteVehicle(numberPlateNeedDelete);
                    break;
                case 4:
                    System.out.println("chức năng tìm kiếm");
                    System.out.println("Nhập biển số cần tìm: ");
                    String numberPlateNeedFind = scanner.nextLine();
                    carController.findNumberPlate(numberPlateNeedFind);
                    truckController.findNumberPlate(numberPlateNeedFind);
                    motoBikeController.findNumberPlate(numberPlateNeedFind);
                    break;
                default:
                    flag = false;
            }
        } while (flag);
    }
}
