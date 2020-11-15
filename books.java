package lab7.Models;

public class books {
   int id;
   String name;
   String author;
   double price;
   int qty;
    public books(int id,String name,String author,double price,int qty){
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }
    public books(){
        this.id = 0;
        this.name ="";
        this.author = "";
        this.price = 0;
        this.qty = 0;

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
