import javax.swing.*;
import java.util.Calendar;

public class Application {
    String travellerName="raj";
    String from="abc";
    String to="xyz";
    String choice="ac-1";
    Application(){
        m();
    }
    void m(){
        c();
    }
    void c(){
        dummy();
    }
    void dummy()
    {

        String title="JAVA's 1 Rupee Train";
        JFrame j=null;
        int me=0;
        String Message="Your ticket is Booked. \tDetails are:\nName : " + travellerName + "\nDepart At : " + from + "\tArrive At : " + to + "\nClass : " + choice + "\t@Cost : Re.1/-";
        JOptionPane.showMessageDialog(j,Message,title,JOptionPane.ERROR_MESSAGE);
    }    public static void main(String[] args) {
        new Application();
    }
}