public class UserDatabase {
    String userName;
    String password;

    UserDatabase(){

    }
    public UserDatabase(String userName,String password){
        this.userName=userName;
        this.password=password;
    }
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}