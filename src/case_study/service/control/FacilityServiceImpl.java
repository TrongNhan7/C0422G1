package case_study.service.control;

import case_study.controller.FuramaController;
import case_study.models.facility.Facility;
import case_study.models.facility.House;
import case_study.models.facility.Room;
import case_study.models.facility.Villa;
import case_study.service.IService.IFacilityService;
import case_study.util.ReadandWrite;
import case_study.util.Regex;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements IFacilityService {
    static Scanner scanner = new Scanner(System.in);
    public static final String PATH_FILE_FACILITY = "src/case_study/data/Facility";
    static private Map<Facility, Integer> facilityMap;


    static {
        facilityMap = new LinkedHashMap<>();
    }

    @Override
    public void addNew() {
        do {
            System.out.println("------Facility------" +
                    "\n 1. Add New Villa" +
                    "\n 2. Add New House" +
                    "\n 3. Add New Room " +
                    "\n 4. Back to menu");
            System.out.println("Choose function");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    addVilla();
                    break;
                case 2:
                    addHouse();
                    break;
                case 3:
                    addRoom();
                    break;
                case 4:
                    FuramaController.displayMainMenu();
                    break;
                default:
                    System.out.printf("You need to choose again\n");
            }
        } while (true);
    }

    @Override
    public void displayFacilityCanUse() {
        Map<Facility, Integer> facilityMap = ReadandWrite.readFile(PATH_FILE_FACILITY);
        for (Map.Entry<Facility, Integer> entry : facilityMap.entrySet()) {
            if (entry.getValue() < 5) {
                System.out.println(entry.getKey().toString() + "\ncó số lần đã thuê là " + entry.getValue() + " lần.");
            }
        }
    }

    @Override
    public void displayFacilityMaintenance() {
        Map<Facility, Integer> facilityMap = ReadandWrite.readFile(PATH_FILE_FACILITY);
        for (Map.Entry<Facility, Integer> entry : facilityMap.entrySet()) {
            if (entry.getValue() >= 5) {
                System.out.println(entry.getKey().toString() + "\ncó số" + entry.getValue() + " lần thuê.Đang bảo trì hệ thống!");
            }
        }
    }

    private void addVilla() {
        String id = Regex.inputIdVilla();
        String name = Regex.inputNameService();
        double area = Double.parseDouble(Regex.inputArea());
        double rentalCosts = Double.parseDouble(Regex.inputRentalCosts());
        int people = Integer.parseInt(Regex.inputPepple());
        String rentalType = Regex.inputRentalType();
        String standard = Regex.inputStandard();
        double areaPool = Double.parseDouble(Regex.inputPool());
        int floor = Integer.parseInt(Regex.inputFloors());
        facilityMap.put(new Villa(id, name, area, rentalCosts, people, rentalType, standard, areaPool, floor), 0);
        ReadandWrite.writeFile(facilityMap, PATH_FILE_FACILITY, true);
        System.out.println("Đã thêm mới house thành công");
    }

    private void addHouse() {
        String id = Regex.inputIdHouse();
        String name = Regex.inputNameService();
        double area = Double.parseDouble(Regex.inputArea());
        double rentalCosts = Double.parseDouble(Regex.inputRentalCosts());
        int people = Integer.parseInt(Regex.inputPepple());
        String rentalType = Regex.inputRentalType();
        String standard = Regex.inputStandard();
        int floor = Integer.parseInt(Regex.inputFloors());
        facilityMap.put(new House(id, name, area, rentalCosts, people, rentalType, standard, floor), 0);
        ReadandWrite.writeFile(facilityMap, PATH_FILE_FACILITY, false);
        System.out.println("Đã thêm mới house thành công");
    }

    private void addRoom() {
        String id = Regex.inputIdRoom();
        String name = Regex.inputNameService();
        double area = Double.parseDouble(Regex.inputArea());
        double rentalCosts = Double.parseDouble(Regex.inputRentalCosts());
        int people = Integer.parseInt(Regex.inputPepple());
        String rentalType = Regex.inputRentalType();
        String serviceFree = Regex.inputServiceFree();
        facilityMap.put(new Room(id, name, area, rentalCosts, people, rentalType, serviceFree), 0);
        ReadandWrite.writeFile(facilityMap, PATH_FILE_FACILITY, false);
        System.out.println("Đã thêm mới house thành công");
    }
}