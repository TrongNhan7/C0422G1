package test.hospital.common;


import java.time.LocalDate;
import java.time.Period;

public class InvalidDateCheckException extends Exception {
    public InvalidDateCheckException(String message) {
        super(message);
    }

    public static void checkDateStart(LocalDate startDay) throws InvalidDateCheckException {
        LocalDate now = LocalDate.now();
        int current = Period.between(now, startDay).getDays();
        if (current < 0) {
            throw new InvalidDateCheckException("Ko nhập ngày quá khứ");
        }
    }

    public static void checkDateEnd(LocalDate startDay, LocalDate endDay) throws InvalidDateCheckException {
        int current = Period.between(startDay, endDay).getYears();
        if (current < 0) {
            throw new InvalidDateCheckException("Ngày kết thúc phải lớn hơn ngày bắt đầu");
        }
    }
}
