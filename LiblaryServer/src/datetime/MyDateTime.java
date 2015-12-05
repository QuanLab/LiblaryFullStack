package datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class MyDateTime {
    
    LocalDateTime localDate;

            
    public static String getDateTime() {      
        LocalDateTime localDate = LocalDateTime.now();
        return localDate.format(DateTimeFormatter.ISO_DATE);
    }
}
