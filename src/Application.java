import javax.swing.*;
import java.util.Calendar;

public class Application extends Operations{
    Application() throws Exception {
    }
    public static void main(String[] args) throws Exception {
        Application o=new Application();
        new Operations();
        o.ticketBooking();
    }
}