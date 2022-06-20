package vehicle_manager.controller;

public class MainController {
    public static String searchByNumberPlate(String numberPlate) {
        if (CarController.isExistVehicle(numberPlate)) {
            return CarController.searchVehicle(numberPlate).toString();
        }
        if (TruckController.isExistVehicle(numberPlate)) {
            return TruckController.searchVehicle(numberPlate).toString();
        }
        return MotorController.searchVehicle(numberPlate).toString();
    }

    public static void deleteByNumberPlate(String numberPlate) {
        CarController.deleteVehicle(numberPlate);
        TruckController.deleteVehicle(numberPlate);
        MotorController.deleteVehicle(numberPlate);
    }

    public static boolean isNotExistNumberPlate(String numberPlate) {
        return CarController.isNotExistVehicle(numberPlate) &&
                MotorController.isNotExistVehicle(numberPlate) &&
                TruckController.isNotExistVehicle(numberPlate);
    }

}
