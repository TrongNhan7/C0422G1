package test.bank.common;

import java.time.LocalDate;
import java.time.Period;

public class DateCheckingException extends Exception {
    public DateCheckingException(String message) {
        super(message);
    }

    public static void checkDateStart(LocalDate startDay) throws DateCheckingException {
        LocalDate now = LocalDate.now();
        int current = Period.between(now, startDay).getDays();
        if (current < 0) {
            throw new DateCheckingException("Ngày tạo tài khoản phải hơn hôm nay");
        }
        if (current == 0) {
            current = Period.between(now, startDay).getYears();
            if (current < 0) {
                throw new DateCheckingException("Ngày gửi tiền tiết kiệm phải sau ngày lập tài khoản");
            }
        }
    }

    public static void checkDateEnd(LocalDate startDay, LocalDate endDay) throws DateCheckingException {
        int current = Period.between(startDay, endDay).getDays();

        if (current < 0) {
            throw new DateCheckingException("Ngày gửi tiền tiết kiệm phải sau ngày lập tài khoản");
        }
        if (current == 0) {
            current = Period.between(startDay, endDay).getYears();
            if (current < 0) {
                throw new DateCheckingException("Ngày gửi tiền tiết kiệm phải sau ngày lập tài khoản");
            }
        }
    }
}
