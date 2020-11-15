package lab7.Controller;


import lab7.Models.books;
import lab7.Models.customer;
import lab7.Models.user;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewController {
    List<books> listBook = new ArrayList<>();
    List<customer> listCustomer = new ArrayList<>();
    List<user> ListUser = new ArrayList<>();
    String url = "jdbc:mysql://localhost:3306/ebookstore";
    String use = "root";
    String pass = "";
    //Book
    public List<books> loadBook() {
     try (Connection conn = DriverManager.getConnection(url,use,pass);
          Statement stmt = conn.createStatement()) {
         String strSelect = "Select * from books";
         ResultSet rSet = stmt.executeQuery(strSelect);
         while (rSet.next()){
             int id = rSet.getInt("bookID");
             String name = rSet.getString("bookName");
             String author = rSet.getString("author");
             double price = rSet.getDouble("price");
             int qty = rSet.getInt("qty");
             books objBook = new books(id,name,author,price,qty);
             listBook.add(objBook);
         }
     } catch (SQLException throwables) {
         throwables.printStackTrace();
     }
     return listBook;
    }
    public void displayBook(){
        try(Connection conn = DriverManager.getConnection(url,use,pass);
            Statement stmt = conn.createStatement()){
            String stt = "Select * from books";
            ResultSet rset = stmt.executeQuery(stt);
            ResultSetMetaData rsetMD = rset.getMetaData();
            int numColums = rsetMD.getColumnCount();
            for (int i = 1; i <= numColums; i++) {
                System.out.printf("%-30s", rsetMD.getColumnName(i));
            }
            loadBook();
            System.out.println();
            while(rset.next()){
                for(int i=1;i<=numColums;i++){
                    System.out.printf("%-30s",rset.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    public boolean insertBook(books book){
        try (Connection conn = DriverManager.getConnection(url,use,pass);
             Statement stmt = conn.createStatement()){
            String sqlInsert = "Insert into books values ("
                    + book.getId() + ", '"
                    + book.getName() + "','"
                    + book.getAuthor() +"',"
                    + book.getPrice() +", " + book.getQty() + ")";
             stmt.executeUpdate(sqlInsert);
            loadBook();
            System.out.println("Inserted");
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
    public int updateBook(books book){
        try (Connection conn = DriverManager.getConnection(url,use,pass);
             Statement stmt = conn.createStatement()){
            String sqlUpdate =  "update books set qty="+book.getQty()+",price="+book.getPrice()+" where bookID ="+book.getId();
            int count = stmt.executeUpdate(sqlUpdate);
            if (count == 0){
                return 0;
            }else {
                return 1;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
    }
    public void deleteBook(books book){
        try (Connection conn = DriverManager.getConnection(url,use,pass);
             Statement stmt = conn.createStatement()){
            String sqlDelete = "select * from orders where bookID ="+ book.getId();
            ResultSet rSet = stmt.executeQuery(sqlDelete);
            if (!rSet.next()){
                String deleteBook = "Delete from book where bookID =" + book.getId();
                stmt.executeQuery(deleteBook);
                System.out.println("Delete successful");
            }else {
                System.out.println("Can't delete this book");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //Customer
    public List<customer> loadCustomer(){
        try(Connection conn = DriverManager.getConnection(url,use,pass);
        Statement stmt = conn.createStatement()) {
            String select = "Select * from customers";
            ResultSet rSet = stmt.executeQuery(select);
            while (rSet.next()){
                int id = rSet.getInt("CustomerID");
                String name = rSet.getString("CustomerName");
                String phone = rSet.getString("phone");
                String email = rSet.getString("email");
                String address = rSet.getString("address");
                int level = rSet.getInt("levels");
                customer objCustomer = new customer(id,name,email,phone,address,level);
                listCustomer.add(objCustomer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  listCustomer;
    }
    public void insertCustomer(customer customers){
        try(
                Connection conn = DriverManager.getConnection(url,use,pass);
                Statement stmt = conn.createStatement()
                ) {
            String sqlInsert = "Insert into customers values (" + customers.getCus_ID() + ", '"
                    + customers.getName() +"','"
                    + customers.getEmail() + "','"
                    + customers.getPhone() +"','"
                    + customers.getAddress() + "',"
                    + customers.getLevel() + ")";
            stmt.executeQuery(sqlInsert);
            loadCustomer();
            System.out.println("Inserted");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void displayCustomer(){
        try(Connection conn = DriverManager.getConnection(url,use,pass);
            Statement stmt = conn.createStatement()){
            String stt = "Select * from customers";
            ResultSet rset = stmt.executeQuery(stt);
            ResultSetMetaData rsetMD = rset.getMetaData();
            int numColums = rsetMD.getColumnCount();
            for (int i = 1; i <= numColums; i++) {
                System.out.printf("%-30s", rsetMD.getColumnName(i));
            }
            loadBook();
            System.out.println();
            while(rset.next()){
                for(int i=1;i<=numColums;i++){
                    System.out.printf("%-30s",rset.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    public int updateCustomer(customer customers){
        try(
                Connection conn = DriverManager.getConnection(url,use,pass);
                Statement stmt = conn.createStatement()
                ){
            String update = "Update customers set CustomerID = " + customers.getCus_ID()
                    + ",CustomerName ='" + customers.getName()
                    + "',phone = '" + customers.getPhone()
                    + "', address = '" + customers.getAddress()
                    +"',levles = " + customers.getLevel();stmt.executeUpdate(update);
            int count = stmt.executeUpdate(update);
            loadCustomer();
            if(count == 0){
                return 0;
            }else{
                return 1;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
    }
    public void deleteCustomer(customer customers){
        try (
                Connection conn = DriverManager.getConnection(url,use,pass);
                Statement stmt = conn.createStatement();
        ) {
            String sqlDelete = "select * from orders where bookID ="+ customers.getCus_ID();
            ResultSet rSet = stmt.executeQuery(sqlDelete);
            if (!rSet.next()){
                String deleteBook = "Delete from customers where customerID =" + customers.getCus_ID();
                stmt.executeQuery(deleteBook);
                System.out.println("Delete successful");
            }else {
                System.out.println("Can't delete because customer ordered");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    //User
    public List<user> loadUSer() {
        try (
                Connection conn = DriverManager.getConnection(url,use,pass);
                Statement stmt = conn.createStatement()
                ) {
            String sqlSelect = "Select * from users";
            ResultSet rSet = stmt.executeQuery(sqlSelect);
            while (rSet.next()){
                String name = rSet.getString("userName");
                String pass = rSet.getString("password");
                String email = rSet.getString("email");
                int role = rSet.getInt("role");
                user objUser = new user(name,pass,email,role);
                ListUser.add(objUser);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  ListUser;
    }
    public  void insertUser(user users){
        try(
                Connection conn = DriverManager.getConnection(url,use,pass);
                Statement stmt = conn.createStatement();
                ) {
            String selectUser = "Select userName from users where userName = '" + users.getUserName() + "';";
            ResultSet rSet = stmt.executeQuery(selectUser);
            if (!rSet.next()){
                String insertUser = "Insert into users values ( '"
                        + users.getUserName() + "', '"
                        + users.getPassword() + "', '"
                        + users.getEmail() + "', "
                        + users.getRole() + ")";
                stmt.executeQuery(insertUser);
                System.out.println("Inserted");
            }else {
                System.out.println("User name already exist");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
