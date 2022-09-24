import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.*;

public class Operations {
    String from;
    String to;
    String train;
    String departureTime;
    String travellerName;
    Calendar cal=Calendar.getInstance();


    Scanner input = new Scanner(System.in);
    ArrayList<RailwayDatabase> railData=new ArrayList<>();
    ArrayList<UserDatabase> userData=new ArrayList<>();
    Operations() throws Exception{
        Object railDataObject=  new JSONParser().parse(new FileReader("C:\\Users\\Temp-user4\\IdeaProjects\\RailwayE-Reservation\\src\\RailData.json"));
        JSONArray objectConvert= (JSONArray) railDataObject;
        for (Object dexter:objectConvert) {
            String From = (String) ((JSONObject) dexter).get("From");
            String To = (String) ((JSONObject) dexter).get("To");
            List<String> Timings= (List)((JSONObject)dexter).get("Timings");
            railData.add(new RailwayDatabase(From,To,Timings));
        }
    }
    void ticketBooking() {
        System.out.println("\n\t\tEnter The Details For Ticket Booking");
        System.out.println("From : ");
        String from = input.nextLine();
        System.out.println("To : ");
        String to = input.nextLine();
        String train = from + "to" + to;
        System.out.println("\t"+from+" to "+to);
        for (int i = 0; i < railData.size(); i++) {
            if (train.equals(railData.get(i).getTrain())) {
                int count=1;
                System.out.println("Available Train Timings Are:");
                for (int j = 0; j < railData.get(i).getTimings().size(); j++){
                    System.out.println("\t"+count+"--->" + railData.get(i).getTimings().get(j));
                    count+=1;
                }
                System.out.println("Select any of the above Options for initiating the Booking Process:");
                String Options= input.nextLine();
                int opt=Integer.parseInt(Options);
                String departureTime= railData.get(i).getTimings().get(( opt-1));
                this.from=from;
                this.to=to;
                this.train=train;
                this.departureTime=departureTime;

            }
        }
    }
    void userAccess() throws Exception{
        Object temp= new JSONParser().parse(new FileReader("C:\\Users\\Temp-user4\\IdeaProjects\\RailwayE-Reservation\\src\\UserData.json"));
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
        for(int i=0;i<userData.size();i++){
            if(name.equals(userData.get(i).getUserName())){
                int count=3;
                while(count>0){
                    System.out.println("Password :");
                    String password = input.nextLine();
                    if(password.equals(userData.get(i).getPassword())){
                        count=0;
                        System.out.println("Provide Name of the Traveller");
                        String travellerName=input.nextLine();
                        System.out.println("Select Class of Travelling..\n1---> AC (1ST CLASS)\n2---> AC (2 TIER)\n3---> AC (3 TIER)\n4---> NON-AC (SLEEPER)\n5---> SECOND (SITTING)");
                        String choose=input.nextLine();
                        this.travellerName=travellerName;
                        switch (choose){
                            case "1": {
                                System.out.println("The provided details are:\tName : " + travellerName + ", From: " + from + ", TO: " + to + ", Train: " + train + ", Departure Time: " + departureTime);
                                String choice = "AC (1ST CLASS)";
                                System.out.println("Class Of Travelling: " + choice);
                                System.out.println("Confirm Your Details before booking!");
                                System.out.println("Select\n1----> Book your Ticket \n2---->Exit");
                                String book = input.nextLine();
                                switch (book) {
                                    case "1": {
                                        System.out.println("Your ticket is Booked. \tDetails are:\nName : " + travellerName + "\nDepart At : " + from + "\tArrive At : " + to + "\nClass : " + choice);
                                        System.out.println("Booked On: "+cal.getTime());
                                        break;
                                    }
                                    case "2": {
                                        System.out.println("Booking Cancelled");
                                        break;
                                    }
                                    default: {
                                        System.out.println("Invalid Input");
                                        break;
                                    }
                                }break;
                            }
                            case "2": {
                                System.out.println("The provided details are:\tName : " + travellerName + ", From: " + from + ", TO: " + to + ", Train: " + train + ", Departure Time: " + departureTime);
                                String choice = "AC (2 TIER)";
                                System.out.println("Class Of Travelling: " + choice);
                                System.out.println("Confirm Your Details before booking!");
                                System.out.println("Select\n1----> Book your Ticket \n2---->Exit");
                                String book = input.nextLine();
                                switch (book) {
                                    case "1": {
                                        System.out.println("Your ticket is Booked. \tDetails are:\nName : " + travellerName + "\nDepart At : " + from + "\tArrive At : " + to + "\nClass : " + choice);
                                        System.out.println("Booked On: "+cal.getTime());
                                        break;
                                    }
                                    case "2": {
                                        System.out.println("Booking Cancelled");
                                        break;
                                    }
                                    default: {
                                        System.out.println("Invalid Input");
                                        break;
                                    }
                                }break;
                            }
                            case "3": {
                                System.out.println("The provided details are:\tName : " + travellerName + ", From: " + from + ", TO: " + to + ", Train: " + train + ", Departure Time: " + departureTime);
                                String choice = "AC (3 TIER)";
                                System.out.println("Class Of Travelling: " + choice);
                                System.out.println("Confirm Your Details before booking!");
                                System.out.println("Select\n1----> Book your Ticket \n2---->Exit");
                                String book = input.nextLine();
                                switch (book) {
                                    case "1": {
                                        System.out.println("Your ticket is Booked. \tDetails are:\nName : " + travellerName + "\nDepart At : " + from + "\tArrive At : " + to + "\nClass : " + choice);
                                        System.out.println("Booked On: "+cal.getTime());
                                        break;
                                    }
                                    case "2": {
                                        System.out.println("Booking Cancelled");
                                        break;
                                    }
                                    default: {
                                        System.out.println("Invalid Input");
                                        break;
                                    }
                                }break;
                            }
                            case "4": {
                                System.out.println("The provided details are:\tName : " + travellerName + ", From: " + from + ", TO: " + to + ", Train: " + train + ", Departure Time: " + departureTime);
                                String choice = "NON-AC (SLEEPER)";
                                System.out.println("Class Of Travelling: " + choice);
                                System.out.println("Confirm Your Details before booking!");
                                System.out.println("Select\n1----> Book your Ticket \n2---->Exit");
                                String book = input.nextLine();
                                switch (book) {
                                    case "1": {
                                        System.out.println("Your ticket is Booked. \tDetails are:\nName : " + travellerName + "\nDepart At : " + from + "\tArrive At : " + to + "\nClass : " + choice);
                                        System.out.println("Booked On: "+cal.getTime());
                                        break;
                                    }
                                    case "2": {
                                        System.out.println("Booking Cancelled");
                                        break;
                                    }
                                    default: {
                                        System.out.println("Invalid Input");
                                        break;
                                    }
                                }break;
                            }
                            case "5": {
                                System.out.println("The provided details are:\tName : " + travellerName + ", From: " + from + ", TO: " + to + ", Train: " + train + ", Departure Time: " + departureTime);
                                String choice = "SECOND (SITTING)";
                                System.out.println("Class Of Travelling: " + choice);
                                System.out.println("Confirm Your Details before booking!");
                                System.out.println("Select\n1----> Book your Ticket \n2---->Exit");
                                String book = input.nextLine();
                                switch (book) {
                                    case "1": {
                                        System.out.println("Your ticket is Booked. \tDetails are:\nName : " + travellerName + "\nDepart At : " + from + "\tArrive At : " + to + "\nClass : " + choice);
                                        System.out.println("Booked On: "+cal.getTime());
                                        break;
                                    }
                                    case "2": {
                                        System.out.println("Booking Cancelled");
                                        break;
                                    }
                                    default: {
                                        System.out.println("Invalid Input");
                                        break;
                                    }
                                }break;
                            }
                            default:{
                                System.out.println("Invalid Input provided..!");
                                break;
                            }
                        }break;
                    }else{
                        System.out.println("Please provide your valid password!");
                        System.out.println((count-1)+" attempts left");
                        count-=1;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        new Operations();
        Operations o=new Operations();
        o.ticketBooking();
        o.userAccess();
    }
}