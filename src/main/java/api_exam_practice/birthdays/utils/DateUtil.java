package api_exam_practice.birthdays.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class DateUtil {
    public static String BeautifyDate(LocalDate date){
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(dateTimeFormatter);
    }
}
