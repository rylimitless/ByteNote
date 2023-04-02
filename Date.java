import java.time.LocalDate;
import java.time.LocalTime;

public class Date {
    
    private LocalDate date;
    private LocalTime time;

    public Date(){
        date = LocalDate.now();
        time = LocalTime.now();
    }

    public LocalDate getDate(){
        return date;
    }

    public LocalTime getTime(){
        return time;
    }
}
