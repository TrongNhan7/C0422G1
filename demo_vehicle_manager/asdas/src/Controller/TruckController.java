package Controller;

import model.Manufacture.Manufacture;
import model.vehicle.Truck;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TruckController implements IVehicle {

    static Scanner scanner = new Scanner(System.in);
    static List<Truck> trucks;

    static {
        trucks = new ArrayList<>();
    }


    @Override
    public void addNewVehicle() {
        System.out.println("Nhập biển số xe: ");
        String numPlate = scanner.nextLine();
        for (int i = 0; i < trucks.size(); i++) {
            if (trucks.get(i).getNumberPlate().equals(numPlate)) {
                System.out.println("Biển số đã tồn tại, xin vui lòng nhập lại: ");
                System.out.println("Nhập biển số: ");
                numPlate = scanner.nextLine();
            }
        }
        System.out.println("Nhập tên nhà sản xuất: ");
        String nameManufacture = scanner.nextLine();
        System.out.println("Nhập mã nhà sản xuất: ");
        String idManufacture = scanner.nextLine();
        System.out.println("Nhập quốc gia nhà sản xuất: ");
        String nationManufacture = scanner.nextLine();
        Manufacture manufacture = new Manufacture(nameManufacture, idManufacture, nationManufacture);
        ManufactureController.add(nameManufacture, idManufacture, nationManufacture);
        System.out.println("Nhập năm sản phẩm: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập chủ sở hữu: ");
        String owner = scanner.nextLine();
        System.out.println("Nhập tải trọng cho phép: ");
        double load = Double.parseDouble(scanner.nextLine());
        trucks.add(new Truck(numPlate, manufacture, year, owner, load));
    }


    public void displayVehicle() {
        for (Truck car : trucks) {
            System.out.println(car);
        }
    }

    @Override
    public void deleteVehicle(String numberPlate) {
        for (int i = 0; i < trucks.size(); i++) {
            if (trucks.get(i).getNumberPlate().equals(numberPlate)) {
                System.out.println("Bạn có chắc chắn muốn xóa " +
                        "\n 1. Yes" +
                        "\n 2. No");
                int choose = scanner.nextInt();
                if (choose == 1) {
                    trucks.remove(i);
                    System.out.println("Đã xóa thành công");
                }
            }
        }
    }

    @Override
    public void findNumberPlate(String numberPlate) {
        for (int i = 0; i < trucks.size(); i++) {
            if (trucks.get(i).getNumberPlate().equals(numberPlate)) {
                System.out.println(trucks.get(i).toString());
            }
        }
    }
}
