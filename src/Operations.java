//import Statements..
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.regex.Pattern;

//---Business Logic----
public class Operations {
    //global color declarations
    public static final String ANSI_RED= "\u001B[31m"; //for red colored text
    public static final String ANSI_GREEN= "\u001B[32m"; //for green colored text
    public static final String ANSI_RESET= "\u001B[0m"; //for resetting the color of text
    // global variable declarations
    String from;
    String to;
    String train;
    String departureTime;
    List<String> Cost;
    String travellerName;
    Calendar cal=Calendar.getInstance(); //getting instance of date and time through java.util.calendar
    Scanner input = new Scanner(System.in); //global scanner for getting inputs
    ArrayList<RailwayDatabase> railData=new ArrayList<>(); //Arraylist for railway database
    ArrayList<UserDatabase> userData=new ArrayList<>(); //Arraylist for user database
    String travellingDate;

    //Constructor
    Operations() throws Exception{
        //acquiring data from railData.json for railway database
        Object railDataObject=  new JSONParser().parse(new FileReader("C:\\Users\\raj\\IdeaProjects\\RailwayE-Reservation\\src\\RailData.json"));
        JSONArray objectConvert= (JSONArray) railDataObject;
        for (Object dexter:objectConvert) {
            String From = (String) ((JSONObject) dexter).get("From");
            String To = (String) ((JSONObject) dexter).get("To");
            List<String> Timings= (List)((JSONObject)dexter).get("Timings");
            List<String> Cost=(List)((JSONObject)dexter).get("cost");
            railData.add(new RailwayDatabase(From,To,Timings,Cost));
        }
    }
    void ticketBooking() throws Exception {
        //getting instance values from railway database
        System.out.println("\n\t\t----------- Java's 1 Rupee Train -------------");
        System.out.println("From : ");
        String from = input.nextLine();
        System.out.println("To : ");
        String to = input.nextLine();
        String train = from + "to" + to;
        System.out.println("\t"+from+" to "+to);
        boolean gettingOut=false;
        for (int i = 0; i < railData.size(); i++) {
            if (train.equals(railData.get(i).getTrain())) {
                int count=1;
                gettingOut=true;
                System.out.println("Available Train Timings Are:");
                for (int j = 0; j < railData.get(i).getTimings().size(); j++){
                    System.out.println("\t"+count+"--->" + railData.get(i).getTimings().get(j));
                    count+=1;
                }
                List<String> Cost=railData.get(i).getCost();
                this.Cost=Cost;
                System.out.println("Select any of the above Options for initiating the Booking Process:");
                String Options= input.nextLine();
                switch(Options){
                    case "1": case"2": case "3": case "4": case "5":
                    {
                        int opt=Integer.parseInt(Options);
                        String departureTime = railData.get(i).getTimings().get((opt - 1));
                        this.from=from;
                        this.to=to;
                        this.train=train;
                        this.departureTime=departureTime;
                        userAccess(); //Calling method userAccess
                        break;
                    }
                    default:{
                        System.out.println("Invalid input");
                        break;
                    }
                }
            }
        }if(!gettingOut){
            System.out.println("OOPS! No Trains for your Search!");
        }
    }
    void dummy(String choice,int opt){
        //Confirmation and booking process
        System.out.println("The provided details are:\tName : " + travellerName + ", From: " + from + ", TO: " + to + ", Train: " + train + ", Departure Time: " + departureTime);
        System.out.println("Class Of Travelling: " + choice);
        System.out.println((ANSI_RED+"Cost : "+Cost.get(opt))+ANSI_RESET);
        System.out.println(ANSI_GREEN+"Cost : Re. 1/-"+ANSI_RESET);
        System.out.println("Confirm Your Details before booking!");
        int ct=3;
        while(ct>0) {
            System.out.println("Select\n1----> Book your Ticket \n2---->Exit");
            String book = input.nextLine();
            switch (book) {
                case "1": {
                    ct=0;
                    System.out.println("Your ticket is Booked. \tDetails are:\nName : " + travellerName + "\nDepart At : " + from + "\tArrive At : " + to + "\nClass : " + choice + ANSI_GREEN + "\t@Cost : Re.1/-" + ANSI_RESET);
                    System.out.println("Travelling Date : "+travellingDate);
                    System.out.println("Booked On: " + cal.getTime() + "\n\t\tThank You!");
                    break;
                }
                case "2": {
                    ct=0;
                    System.out.println("\tBooking Cancelled \n\tThank you!");
                    break;
                }
                default: {
                    System.out.println("Invalid Input");
                    ct-=1;
                    if(ct==0){
                        System.out.println("Maximum Attempts Reached.. \n\tThank You!");
                        break;
                    }
                }
            }
        }
    }
    void userAccess() throws Exception{
        //accessing user data and verifying them
        Object temp= new JSONParser().parse(new FileReader("C:\\Users\\raj\\IdeaProjects\\RailwayE-Reservation\\src\\UserData.json"));
        JSONArray tempA= (JSONArray) temp;
        System.out.println("Departure time selected is :"+departureTime);
        for (Object getTheData:tempA) {
            String userName=(String)((JSONObject)getTheData).get("userName");
            String password=(String)((JSONObject)getTheData).get("password");
            userData.add(new UserDatabase(userName,password));
        }
        System.out.println("Enter Your Login Credentials for Booking Process");
        System.out.println("User Name :");
        String name=input.nextLine();
        boolean userNotFound=false;
        for(int i=0;i<userData.size();i++){
            if(name.equals(userData.get(i).getUserName())){
                int count=3;
                userNotFound=true;
                while(count>0){
                    System.out.println("Password :");
                    String password = input.nextLine();
                    if(password.equals(userData.get(i).getPassword())){
                        count=0;
                        System.out.println("Provide Name of the Traveller");
                        String travellerName=input.nextLine();
                        System.out.println("Provide Date for travelling in (DD/MM/YYYY) Format");
                        int calc=3;
                        int cal=3;
                        while(calc>0){
                            String travellingDate=input.nextLine();
                            Pattern p= Pattern.compile("^(0[0-9]|1[0-9]|2[0-9]|3[0-1])\\/(0[0-9]|1[0-2])\\/(19|20)\\d\\d$");
                            Date s;
                            if(p.matcher(travellingDate).matches()) {
                                SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
                                Date tdate = new Date();
                                d.format(tdate);
                                s = d.parse(travellingDate);
                                if (s.compareTo(tdate) > 0) {
                                    calc=0;
                                    this.travellingDate=travellingDate;
                                } else {
                                    System.out.println("Choose dates of future");
                                    calc-=1;
                                    if(calc==0){
                                        cal=0;
                                        System.out.println("Maximum attempts reached \n Thank You!");
                                    }
                                }
                            }else{
                                System.out.println("Enter in valid date format (DD/MM/YYYY)");
                                calc-=1;
                                if(calc==0){
                                    cal=0;
                                    System.out.println("Maximum attempts reached \n Thank You!");
                                }
                            }
                        }

                        while(cal>0) {
                            System.out.println("Select Class of Travelling..\n1---> AC (1ST CLASS)\n2---> AC (2 TIER)\n3---> AC (3 TIER)\n4---> NON-AC (SLEEPER)\n5---> SECOND (SITTING)");
                            String choose = input.nextLine();
                            this.travellerName = travellerName;
                            switch (choose) {
                                //Calling dummy method for cases(1-5)
                                case "1": {
                                    dummy("AC (1ST CLASS)", 0);
                                    cal=0;
                                    break;
                                }
                                case "2": {
                                    dummy("AC (2 TIER)", 1);
                                    cal=0;
                                    break;
                                }
                                case "3": {
                                    dummy("AC (3 TIER)", 2);
                                    cal=0;
                                    break;
                                }
                                case "4": {
                                    dummy("NON-AC (SLEEPER)", 3);
                                    cal=0;
                                    break;
                                }
                                case "5": {
                                    dummy("SECOND (SITTING)", 4);
                                    cal=0;
                                    break;
                                }
                                default: {
                                    System.out.println("Invalid Input provided..!\n Try Again! \n"+(cal-1)+" attempt/attempts left");
                                    cal-=1;
                                    if(cal==0){
                                        System.out.println("Maximum attempts Reached..\n Thank You!");
                                        break;
                                    }
                                }
                            }
                            if(cal==0)
                                break;
                        }
                    }else{
                        System.out.println("Please provide your valid password!");
                        System.out.println((count-1)+" attempts left");
                        if(count==1){
                            System.out.println("Maximum Attempts reached!\n\t Thank You!");
                        }
                        count-=1;
                    }
                }
            }
        }if(!userNotFound){
            System.out.println("User Invalid!! / User Name not found!! \n\tThank You!!");
        }
    }
}