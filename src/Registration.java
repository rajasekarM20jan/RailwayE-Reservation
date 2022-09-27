import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Registration extends Operations {
    String userName;
    String name;
    Scanner regInput = new Scanner(System.in);
    Object regularObject=new JSONParser().parse(new FileReader("src/UserData.json"));
    JSONArray arrayOfUserData=(JSONArray) regularObject;
    JSONObject objectOfInitialization= new JSONObject();
    public Registration() throws Exception{
        //------Credits To Jeeva Prakash------
        System.out.println("Enter Your Name :");
        name=regInput.nextLine();
        System.out.println("Create a User Name:");
        userName=regInput.nextLine();
        validationOfUserName();
    }
    void validationOfUserName() throws Exception {
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
                FileWriter w=new FileWriter("src/UserData.json");
                w.write(String.valueOf(arrayOfUserData));
                w.flush();
                w.close();

            }else{
                System.out.println("Passwords doesn't match");
                validationOfUserName();
            }
        }
    }
}