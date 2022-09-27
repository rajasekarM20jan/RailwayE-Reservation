import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.management.OperationsException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Registration extends Operations {


    public Registration() throws Exception{
        Object regularObject=new JSONParser().parse(new FileReader("C:\\Users\\Temp-user4\\IdeaProjects\\RailwayE-Reservation\\src\\UserData.json"));
        JSONArray arrayOfUserData=(JSONArray) regularObject;
        JSONObject objectOfInitialization= new JSONObject();
        Scanner regInput = new Scanner(System.in);
        System.out.println("------Credits To Jeeva Prakash------");
        System.out.println("Enter Your Name :");
        String name=regInput.nextLine();
        System.out.println("Create a User Name:");
        String userName=regInput.nextLine();
        System.out.println("Create Password:");
        String password=regInput.nextLine();
        System.out.println("Confirm Password");
        String confirmPassword=regInput.nextLine();
        boolean val=false;
        for(int i=0;i<arrayOfUserData.size();i++){
            JSONObject j= (JSONObject) arrayOfUserData.get(i);
            if(userName.equals(j.get("userName"))){
                System.out.println("User Name Exists");
                val=true;
            }
        }if(val){
            new Registration();
        }else{
            if(password.equals(confirmPassword)){
                objectOfInitialization.put("userName",userName);
                objectOfInitialization.put("password",password);
                arrayOfUserData.add(objectOfInitialization);
                FileWriter w=new FileWriter("C:\\Users\\Temp-user4\\IdeaProjects\\RailwayE-Reservation\\src\\UserData.json");
                w.write(String.valueOf(arrayOfUserData));
                w.flush();
                w.close();

            }else{
                System.out.println("Passwords doesn't match");
                new Registration();
            }
        }
    }
}