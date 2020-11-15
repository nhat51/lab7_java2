package lab7.Models;

public class user {
    String userName;
    String password;
    String email;
    int role;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public user(){
        this.userName = "";
        this.password = "";
        this.email = "";
        this.role =0;
    }
    public user(String userName,String password,String email,int role){
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.role = role;
    }
    public String toString() {
        return String.format("%-30s%-30s%-30d",userName,password,role);
    }
}
