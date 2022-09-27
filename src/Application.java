import javax.swing.*;
import java.util.Calendar;
//---------Execution Logic----------
public class Application extends Operations{
    Application() throws Exception {
    }
    public static void main(String[] args) throws Exception {
        Application o=new Application();
        new Operations(); //calling constructor from operations class
        o.ticketBooking(); //calling method of operations class
    }
}