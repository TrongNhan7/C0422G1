package case_study.service.control;

import case_study.common.DateCheckingException;
import case_study.common.TypeInformation;
import case_study.models.Person.Customer;
import case_study.models.booking.Booking;
import case_study.models.facility.Facility;
import case_study.service.IService.IBookingService;
import case_study.util.ReadAndWrite;
import case_study.util.Regex;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class BookingServiceImpl implements IBookingService {
    private static final String PATH_FILE_CUSTOMER = "src/case_study/data/Customer.csv";
    private static final String PATH_FILE_FACILITY = "src/case_study/data/Facility";
    private static final String PATH_FILE_BOOKING = "src/case_study/data/Booking.csv";
    private static Scanner scanner = new Scanner(System.in);


    @Override
    public void display() {
        Set<Booking> bookings;
        bookings = ReadAndWrite.readFileBooking(PATH_FILE_BOOKING);
        for (Booking booking : bookings) {
            System.out.printf(booking.toString() + "\n");
        }
    }

    @Override
    public void add() {
        Map<Facility, Integer> facilityMap = ReadAndWrite.readFile(PATH_FILE_FACILITY);
        Set<Booking> bookings;
        bookings = ReadAndWrite.readFileBooking(PATH_FILE_BOOKING);
        int id = 0;
        int max = 0;
        if (bookings == null) {
            id = 1;
        } else {
            for (Booking booking1 : bookings) {
                if (booking1.getIdBooking() > max) {
                    max = booking1.getIdBooking();
                }
            }
        }
        id = max + 1;
        Customer customer = choosesCustomer();
        Facility facility = choosesFacility();
        LocalDate startDay = null;
        LocalDate endDay = null;

        while (true) {
            try {
                System.out.println("Nhập ngày bắt đầu");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                startDay = LocalDate.parse(scanner.nextLine(), formatter);
                DateCheckingException.checkDateStart(startDay);
                break;
            } catch (DateTimeParseException e) {
                System.err.println("Nhập ngày theo định dạng dd/MM/yyyy");
            } catch (DateCheckingException e) {
                System.err.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Nhập ngày kết thúc");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                endDay = LocalDate.parse(scanner.nextLine(), formatter);
                DateCheckingException.checkDateEnd(startDay, endDay);
                break;
            } catch (DateTimeParseException e) {
                System.err.println("Nhập ngày theo định dạng dd/MM/yyyy");
            } catch (DateCheckingException e) {
                System.err.println(e.getMessage());
            }
        }

        System.out.println("Nhập kiểu dịch vụ");
        String serviceType = TypeInformation.getServiceType();
        bookings.add(new Booking(id, startDay, endDay, customer, facility, serviceType));
        ReadAndWrite.writeFileBooking(bookings, PATH_FILE_BOOKING, false);
        for (Map.Entry<Facility, Integer> entry : facilityMap.entrySet()) {
            if (facility.getIdFacility().equals(entry.getKey().getIdFacility())) {
                facilityMap.replace(entry.getKey(), entry.getValue() + 1);
            }
        }
        ReadAndWrite.writeFile(facilityMap, PATH_FILE_FACILITY, false);
    }


    public static Customer choosesCustomer() {
        List<Customer> customerList = ReadAndWrite.readFileList(PATH_FILE_CUSTOMER);
        System.out.println("Danh sách Customer");
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
        System.out.println("Nhập Id khách hàng muốn Booking:");
        int id = Integer.parseInt(Regex.inputNumber());
        boolean flag = true;
        while (flag) {
            for (Customer customer : customerList) {
                if (customer.getId() == id) {
                    flag = false;
                    System.out.println("Nhập mã khách hàng thành công");
                    return customer;
                }
            }
            if (flag) {
                System.out.println("Không tìm thấy khách hàng, vui lòng nhập lại");
                id = Integer.parseInt(Regex.inputNumber());
            }
        }
        return null;
    }

    public static Facility choosesFacility() {
        Map<Facility, Integer> facilityMap = ReadAndWrite.readFile(PATH_FILE_FACILITY);
        System.out.println("Danh sách Facility");
        for (Map.Entry<Facility, Integer> entry : facilityMap.entrySet()) {
            if (entry.getValue() < 5) {
                System.out.println(entry);
            }
        }

        System.out.println("Nhập Id mã dịch vụ Facility:");
        String id = scanner.nextLine();
        boolean flag = true;
        while (flag) {
            for (Map.Entry<Facility, Integer> entry : facilityMap.entrySet()) {
                if (entry.getKey().getIdFacility().equals(id) && entry.getValue() < 5) {
                    flag = false;
                    System.out.println("Nhập mã dịch vụ thành công");
                    return entry.getKey();
                }
            }
            if (flag) {
                System.out.println("Không tìm thấy mã dịch vụ, vui lòng nhập lại");
                id = scanner.nextLine();
            }
        }
        return null;
    }


}
