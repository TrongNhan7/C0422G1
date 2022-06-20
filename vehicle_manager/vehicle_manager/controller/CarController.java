package vehicle_manager.controller;

import vehicle_manager.models.vehicle.Car;

import java.util.ArrayList;
import java.util.List;

public class CarController {
    static List<Car> cars;

    static {
        cars = new ArrayList<>();
    }

    public static void addNewVehicle(Car car) {
        if (isNotExistVehicle(car.getNumberPlate())) {
            cars.add(car);
        }
    }

    public static void displayVehicle() {
        cars.forEach(x -> System.out.println(x.toString()));
    }

    public static void deleteVehicle(String numberPlate) {
        cars.remove(searchVehicle(numberPlate));
    }

    public static Car searchVehicle(String numberPlate) {
        return cars.stream().filter(x -> x.getNumberPlate().equalsIgnoreCase(numberPlate))
                .findFirst().orElse(null);
    }

    public static boolean isNotExistVehicle(String numberPlate) {
        return cars.stream().noneMatch(x -> x.getNumberPlate().equalsIgnoreCase(numberPlate));
    }

    public static boolean isExistVehicle(String numberPlate) {
        return cars.stream().anyMatch(x -> x.getNumberPlate().equalsIgnoreCase(numberPlate));
    }

}
