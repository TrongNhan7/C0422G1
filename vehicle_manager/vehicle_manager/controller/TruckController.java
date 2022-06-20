package vehicle_manager.controller;

import vehicle_manager.models.vehicle.Truck;

import java.util.ArrayList;
import java.util.List;

public class TruckController {
    static List<Truck> trucks;

    static {
        trucks = new ArrayList<>();
    }

    public static void addNewVehicle(Truck vehicle) {
        if (isNotExistVehicle(vehicle.getNumberPlate())) {
            trucks.add(vehicle);
        }
    }

    public static void displayVehicle() {
        trucks.forEach(x -> System.out.println(x.toString()));
    }

    public static void deleteVehicle(String numberPlate) {
        trucks.remove(searchVehicle(numberPlate));

    }

    public static Truck searchVehicle(String numberPlate) {
        return trucks.stream().filter(x -> x.getNumberPlate().equalsIgnoreCase(numberPlate))
                .findFirst().orElse(null);
    }

    public static boolean isNotExistVehicle(String numberPlate) {
        return trucks.stream().noneMatch(x -> x.getNumberPlate().equalsIgnoreCase(numberPlate));
    }

    public static boolean isExistVehicle(String numberPlate) {
        return trucks.stream().anyMatch(x -> x.getNumberPlate().equalsIgnoreCase(numberPlate));
    }
}
