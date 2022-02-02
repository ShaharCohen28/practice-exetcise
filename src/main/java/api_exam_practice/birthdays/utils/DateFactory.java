package api_exam_practice.birthdays.utils;

import java.time.LocalDate;

public class DateFactory {

    public static LocalDate getLocalDate(){
        return LocalDate.of(
                (int)(Math.random()*50+1960),
                (int)(Math.random()*12+1),
                (int)(Math.random()*28+1));
    }
}
