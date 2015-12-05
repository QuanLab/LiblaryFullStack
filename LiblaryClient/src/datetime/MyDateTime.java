package datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyDateTime {
    
    public MyDateTime(){
        
    }

    LocalDateTime localDate;

    public static String getDateTime() {
        LocalDateTime localDate = LocalDateTime.now();
        return localDate.format(DateTimeFormatter.ISO_DATE);
    }

    public static String setDateTime(int date, int month, int year) {
        return (date + "-"+ month+ "-"+ year);
    }
}
