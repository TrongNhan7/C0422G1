package case_study.controller;

import case_study.service.control.*;

import java.util.Scanner;

public class FuramaController {
    static Scanner scanner = new Scanner(System.in);
    static EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    static CustomerServiceImpl customerService = new CustomerServiceImpl();
    static FacilityServiceImpl facilityService = new FacilityServiceImpl();
    static BookingServiceImpl bookingService = new BookingServiceImpl();
    static ContractServiceImpl contractService = new ContractServiceImpl();

    public static void displayMainMenu() {
        String choose = null;
        do {
            System.out.println("\n------MENU FURAMA------ " +
                    "\n 1. Employee Management" +
                    "\n 2. Customer Management" +
                    "\n 3. Facility Management " +
                    "\n 4. Booking Management" +
                    "\n 5. Management" +
                    "\n 6. Exit");
            System.out.println("Choose function");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    displayEmployeeManagement();
                    break;
                case "2":
                    displayCustomerManagement();
                    break;
                case "3":
                    displayFacilityManagement();
                    break;
                case "4":
                    displayBookingManagement();
                    break;
                case "5":
                    displayPromotionManagement();
                    break;
                case "6":
                    System.exit(0);
                    break;
                default:
                    System.out.printf("You need to choose again");
            }
        } while (true);
    }

    public static void displayEmployeeManagement() {
        String choose = null;
        do {
            System.out.println("\n------EMPLOYEE MANAGEMENT------" +
                    "\n 1. Display list employees" +
                    "\n 2. Add new employee" +
                    "\n 3. Edit employee " +
                    "\n 4. Return main menu");
            System.out.println("Choose function");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    employeeService.display();
                    break;
                case "2":
                    employeeService.add();
                    break;
                case "3":
                    employeeService.edit();
                    break;
                case "4":
                    return;
                default:
                    System.out.printf("You need to choose again\n");
            }
        } while (true);
    }

    public static void displayCustomerManagement() {
        String choose = null;
        do {
            System.out.println("\n------CUSTOMERS MANAGEMENT------" +
                    "\n 1. Display list customers" +
                    "\n 2. Add new customer" +
                    "\n 3. Edit customer " +
                    "\n 4. Return main menu" +
                    "\n 5. Delete Customer");
            System.out.println("Choose function");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    customerService.display();
                    break;
                case "2":
                    customerService.add();
                    break;
                case "3":
                    customerService.edit();
                    break;
                case "4":
                    return;
                case "5":
                    customerService.deleteCustomer();
                    break;
                default:
                    System.out.printf("You need to choose again\n");
            }
        } while (true);
    }

    public static void displayFacilityManagement() {
        String choose = null;
        do {
            System.out.println("\n------FACILITY MANAGEMENT------" +
                    "\n 1. Display list facility" +
                    "\n 2. Add new facility" +
                    "\n 3. Display list facility maintenance " +
                    "\n 4. Reset facility " +
                    "\n 5. Return main menu");
            System.out.println("Choose function");
            choose = scanner.nextLine();

            switch (choose) {
                case "1":
                    facilityService.displayFacilityCanUse();
                    break;
                case "2":
                    facilityService.addNew();
                    break;
                case "3":
                    facilityService.displayFacilityMaintenance();
                    break;
                case "4":
                    facilityService.resetService();
                    break;
                case "5":
                    return;
                default:
                    System.out.printf("You need to choose again\n");
            }
        } while (true);
    }

    public static void displayBookingManagement() {
        String choose = null;
        do {
            System.out.println("\n------BOOKING MANAGEMENT------" +
                    "\n 1. Add new booking" +
                    "\n 2. Display list booking" +
                    "\n 3. Create new constracts " +
                    "\n 4. Display list contracts" +
                    "\n 5. Edit contracts" +
                    "\n 6. Return main menu");
            System.out.println("Choose function");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    bookingService.add();
                    break;
                case "2":
                    bookingService.display();
                    break;
                case "3":
                    contractService.add();
                    break;
                case "4":
                    contractService.display();
                    break;
                case "5":
                    contractService.edit();
                    break;
                case "6":
                    return;
                default:
                    System.out.printf("You need to choose again\n");
            }
        } while (true);
    }

    public static void displayPromotionManagement() {
        String choose = null;
        do {
            System.out.println("\n------PROMOTION MANAGEMENT------" +
                    "\n 1. Display list customers use service" +
                    "\n 2. Display list customers get voucher" +
                    "\n 3. Return main menu");
            System.out.println("Choose function");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":

                    break;
                case "2":

                    break;
                case "3":
                    return;
                default:
                    System.out.printf("You need to choose again\n");
            }
        } while (true);
    }
}
