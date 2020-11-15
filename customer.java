package lab7.Models;

public class customer {
    String name;
    int Cus_ID;
    String phone;
    String address;
    String email;
    int level;
    public customer(int Cus_ID,String name,String email ,String phone, String address, int level){
        this.Cus_ID = Cus_ID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.level = level;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public customer(){
    this.name = "";
    this.Cus_ID = 0;
    this.email = "";
    this.phone = "";
    this.address = "";
    this.level = 0;
}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCus_ID() {
        return Cus_ID;
    }

    public void setCus_ID(int cus_ID) {
        Cus_ID = cus_ID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }



}
