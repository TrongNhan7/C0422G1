package vehicle_manager.controller;

import vehicle_manager.models.vehicle.Car;
import vehicle_manager.models.vehicle.Motor;
import vehicle_manager.models.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class MotorController{
    static List<Motor> motors;

    static {
        motors = new ArrayList<>();
    }

    public static void addNewVehicle(Motor vehicle) {
        if (isNotExistVehicle(vehicle.getNumberPlate())) {
            motors.add( vehicle);
        }
    }

    public static void displayVehicle() {
        motors.forEach(x-> System.out.println(x.toString()));
    }

    public static void deleteVehicle(String numberPlate) {
        motors.remove(searchVehicle(numberPlate));
    }

    public static Motor searchVehicle(String numberPlate) {
        return motors.stream().filter(x -> x.getNumberPlate().equalsIgnoreCase(numberPlate))
                .findFirst().orElse(null);
    }

    public static boolean isNotExistVehicle(String numberPlate) {
        return motors.stream().noneMatch(x -> x.getNumberPlate().equalsIgnoreCase(numberPlate));
    }

    public static boolean isExistVehicle(String numberPlate) {
        return motors.stream().anyMatch(x -> x.getNumberPlate().equalsIgnoreCase(numberPlate));
    }
}
