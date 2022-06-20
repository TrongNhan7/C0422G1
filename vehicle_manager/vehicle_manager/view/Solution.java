package vehicle_manager.view;

import vehicle_manager.controller.CarController;
import vehicle_manager.controller.MainController;
import vehicle_manager.controller.MotorController;
import vehicle_manager.controller.TruckController;
import vehicle_manager.models.vehicle.Car;
import vehicle_manager.models.vehicle.Motor;
import vehicle_manager.models.vehicle.Truck;
import vehicle_manager.utils.menu_enum.MainMenu;
import vehicle_manager.utils.menu_enum.VehicleMenu;
import vehicle_manager.utils.support.DisplayEnum;
import vehicle_manager.utils.support.DisplayScanner;

import java.util.List;
import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMain();
    }

    public static void displayMain() {
        loop:
        while (true) {
            MainMenu option = selectMain();
            switch (option) {
                case ADD_NEW:
                    displayAddNewVehicle();
                    break;
                case DISPLAY:
                    displayVehicleSelect();
                    break;
                case DELETE:
                    displayDeleteOption();
                    break;
                case SEARCH_BY_LICENSE_PLATES:
                    displaySearch();
                    break;
                case QUIT:
                    System.out.println("Bye");
                    break loop;
            }
        }
    }

    private static void displaySearch() {
        String numberPlate = DisplayScanner.getChooseTarget("Number Plate search");

        if (MainController.isNotExistNumberPlate(numberPlate)) {
            System.out.println("Not Found All Vehicle!");
            return;
        }

        System.out.println(MainController.searchByNumberPlate(numberPlate));
    }

    private static void displayDeleteOption() {
        String numberPlate = DisplayScanner.getChooseTarget("Number Plate search");

        if (MainController.isNotExistNumberPlate(numberPlate)) {
            System.out.println("Not Found All Vehicle!");
            return;
        }

        String choose = DisplayScanner.getChooseTarget(String.format("%s.\nYour Want Delete???? ",
                MainController.searchByNumberPlate(numberPlate)));

        if (choose.equalsIgnoreCase("yes")) {
            MainController.deleteByNumberPlate(numberPlate);
            System.out.println("Complete");
        }
    }


    private static void displayVehicleSelect() {
        VehicleMenu option = selectVehicle();
        switch (option) {
            case CAR:
                CarController.displayVehicle();
                break;
            case MOTOR:
                MotorController.displayVehicle();
                break;
            case TRUCK:
                TruckController.displayVehicle();
        break;
        case BACK_MAIN_MENU:
        break;
    }
}

    public static void displayAddNewVehicle() {
        VehicleMenu option = selectVehicle();
        switch (option) {
            case CAR:
                List<String> propsCar = DisplayScanner.collectDataFromUserInput(Car.getPropertiesCar());
                CarController.addNewVehicle(new Car(propsCar));
                break;
            case MOTOR:
                List<String> propsMotor = DisplayScanner.collectDataFromUserInput(Motor.getPropertiesMotor());
                MotorController.addNewVehicle(new Motor(propsMotor));
                break;
            case TRUCK:
                List<String> propsTruck = DisplayScanner.collectDataFromUserInput(Truck.getPropertiesTruck());
                TruckController.addNewVehicle(new Truck(propsTruck));
                break;
            case BACK_MAIN_MENU:
                break;
        }
    }

    public static VehicleMenu selectVehicle() {
        return DisplayEnum.selectMenuOption(scanner, VehicleMenu.class);
    }

    public static MainMenu selectMain() {
        return DisplayEnum.selectMenuOption(scanner, MainMenu.class);
    }
}
