package case_study.service.control;

import case_study.models.booking.Booking;
import case_study.service.IService.IBookingService;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BookingServiceImpl implements IBookingService {
    Scanner scanner = new Scanner(System.in);
    static Set<Booking> bookings = new TreeSet<>();

    @Override
    public void display() {

    }

    @Override
    public void add() {

    }

    @Override
    public void edit() {

    }
}
