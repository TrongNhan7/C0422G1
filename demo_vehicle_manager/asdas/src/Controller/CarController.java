package Controller;

import model.Manufacture.Manufacture;
import model.vehicle.Car;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class CarController implements IVehicle {
    static Scanner scanner = new Scanner(System.in);
    static List<Car> cars;

    static {
        cars = new ArrayList<>();
    }


    @Override
    public void addNewVehicle() {
        System.out.println("Nhập biển số xe: ");
        String numPlate = scanner.nextLine();
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getNumberPlate().equals(numPlate)) {
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
        System.out.println("Nhập số chỗ ngồi: ");
        int numberSeat = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập kiểu xe: ");
        String typeCar = scanner.nextLine();
        cars.add(new Car(numPlate, manufacture, year, owner, numberSeat, typeCar));
    }


    public void displayVehicle() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    @Override
    public void deleteVehicle(String numberPlate) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getNumberPlate().equals(numberPlate)) {
                System.out.println("Bạn có chắc chắn muốn xóa " +
                        "\n 1. Yes" +
                        "\n 2. No");
                int choose = scanner.nextInt();
                if (choose == 1) {
                    cars.remove(i);
                    System.out.println("Đã xóa thành công");
                }
            }
        }
    }

    @Override
    public void findNumberPlate(String numberPlate) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getNumberPlate().equals(numberPlate)) {
                System.out.println(cars.get(i).toString());
            }
        }
    }
}
