public class UserDatabase {
    String userName;
    String password;

    boolean login;

    UserDatabase(){

    }
    public UserDatabase(String userName,String password,boolean login){
        this.userName=userName;
        this.password=password;
        this.login=login;
    }
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
    public boolean isLogin() {
        return login;
    }
}