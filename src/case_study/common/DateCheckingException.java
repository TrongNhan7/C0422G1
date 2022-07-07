package case_study.common;

import java.time.LocalDate;
import java.time.Period;

public class DateCheckingException extends Exception{
    public DateCheckingException(String message) {
        super(message);
    }
    public static void checkDateStart(LocalDate startDay) throws DateCheckingException{
        LocalDate now=LocalDate.now();
        int current = Period.between(now, startDay).getYears();
        if(current<0){
            throw new DateCheckingException("Ko nhập ngày quá khứ");
        }
    }
    public static void checkDateEnd(LocalDate startDay,LocalDate endDay) throws DateCheckingException{
        int current = Period.between(startDay, endDay).getYears();
        if(current<0){
            throw new DateCheckingException("Ngày kết thúc phải lớn hơn ngày booking");
        }
    }
}
