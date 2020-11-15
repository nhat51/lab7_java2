package lab7.view;

import lab7.Controller.NewController;
import lab7.Models.books;
import lab7.Models.customer;
import lab7.Models.user;

import java.util.Scanner;

public class newView {
    Scanner input = new Scanner(System.in);
    NewController objControl = new NewController();
    //Menu
   public static void Home(){
        System.out.println("1.Manager book");
        System.out.println("2.Manager customer");
       System.out.println("3.Sign In");
       System.out.println("4.Sign Up");
    }
   public void customerMenu(){
        System.out.println("=======================");
        System.out.println("1.Add customer");
        System.out.println("2.Delete customer");
        System.out.println("3.Update customer");
        System.out.println("4View customer");
        System.out.println("5.Return");
        System.out.println("=======================");
    }
   public void bookMenu(){
        System.out.println("=======================");
        System.out.println("1.Add book");
        System.out.println("2.Update book");
        System.out.println("3.Delete book");
        System.out.println("4.View book");
        System.out.println("5.Return");
        System.out.println("=======================");
    }
    //Add book, customer and user
    public void addBook(){
        System.out.println("Enter book information");
        books objBook = new books();

        System.out.println("Enter book id: ");
        int id = Integer.parseInt(input.nextLine());
        objBook.setId(id);

        System.out.println("Enter book name: ");
        String name = input.nextLine();
        objBook.setName(name);

        System.out.println("Enter author: ");
        String author = input.nextLine();
        objBook.setAuthor(author);

        System.out.println("Price of book: ");
        double price = input.nextFloat();
        objBook.setPrice(price);

        System.out.println("The quantity of book is: ");
        int qty = input.nextInt();
        objBook.setQty(qty);

        NewController objControl = new NewController();
        objControl.insertBook(objBook);
   }
    public void addCustomer(){
        System.out.println("Enter customer information");
        customer objCus = new customer();

        System.out.println("Enter customer id:");
        int id = Integer.parseInt(input.nextLine());
        objCus.setCus_ID(id);

        System.out.println("Enter customer name: ");
        String name = input.nextLine();
        objCus.setName(name);

        System.out.println("Enter phone number:");
        String phone = input.nextLine();
        objCus.setPhone(phone);

        System.out.println("Enter email:");
        String email = input.nextLine();
        objCus.setEmail(email);

        System.out.println("Enter customer address: ");
        String address = input.nextLine();
        objCus.setAddress(address);

        NewController objControl = new NewController();
        objControl.insertCustomer(objCus);
    }
    public void SignUp(){
        user objUser = new user();

        System.out.println("Enter user name: ");
        String userName = input.nextLine();
        objUser.setUserName(userName);

        System.out.println("Enter pass word: ");
        String password = input.nextLine();
        objUser.setPassword(password);
        System.out.println("Retype password");
        String password1 = input.nextLine();
        if (password1 != password){
            System.out.println("password don't match try agian");
            do {
                System.out.println("Enter pass word: ");
                password = input.nextLine();
                objUser.setPassword(password);
                System.out.println("Retype password");
                password1 = input.nextLine();
            }while (password == password1);
        }

        System.out.println("Enter email: ");
        String email = input.nextLine();
        objUser.setEmail(email);

        System.out.println("Enter role: ");
        int role = input.nextInt();
        objUser.setRole(role);

        NewController objControl = new NewController();
        objControl.insertUser(objUser);
    }
    //Delete book and customer
    public void deleteBook(){
       System.out.println("Enter book ID you want delete: ");
        int id = input.nextInt();
        books objBook = new books();
        objBook.setId(id);
        objControl.deleteBook(objBook);
    }
    public void deleteCustomer(){
        System.out.println("Enter customer ID you want delete: ");
        int id = input.nextInt();
        customer objCus = new customer();
        objCus.setCus_ID(id);
        objControl.deleteCustomer(objCus);
    }
    //Update book and customer
    public void updateBook(){
        books obj = new books();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the book id you want to update:");
        int id = Integer.parseInt(input.nextLine());
        System.out.println("Enter new qty: ");
        int qty = Integer.parseInt(input.nextLine());
        System.out.println("Enter new price: ");
        double price = input.nextDouble();
        System.out.println();
        obj.setId(id);
        obj.setPrice(price);
        obj.setQty(qty);
        NewController ctr = new NewController();
        if(ctr.updateBook(obj)==0){
            System.out.println("Wrong book's information");
        }else if(ctr.updateBook(obj)==1){
            System.out.println("Book has been updated");
        };
    }
    public void updateCustomer(){
        customer obj = new customer();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the customer id you want to update:");
        int id = Integer.parseInt(input.nextLine());
        System.out.println("Enter new address: ");
        String address = input.nextLine();
        System.out.println("Enter new email: ");
        String email = input.nextLine();
        System.out.println("Enter new phone: ");
        String phone = input.nextLine();
        obj.setAddress(address);
        obj.setCus_ID(id);
        obj.setEmail(email);
        obj.setPhone(phone);
        NewController objControl = new NewController();
        if(objControl.updateCustomer(obj) == 0){
            System.out.println("No customer found");
        }else if(objControl.updateCustomer(obj) == 1){
            System.out.println("Customer has been updated");
        }
    }

    //book management and customer management
    public void customerManagement(){
    int choice;
    Scanner input = new Scanner(System.in);
    do {
        customerMenu();
        System.out.println("Your choice: ");
        choice = input.nextInt();
        switch (choice){
            case 1:
                addCustomer();
                break;
            case 2:
                deleteCustomer();
                break;
            case 3:
              updateCustomer();
              break;
            case 4:
                objControl.displayCustomer();
        }
    }while (choice != 5);
    }
    public void BookManagement(){
        int choice;
        Scanner input = new Scanner(System.in);
        do {
            bookMenu();
            System.out.println("Your choice: ");
            choice = input.nextInt();
            switch (choice){
                case 1:
                    addBook();
                    break;
                case 2:
                    updateBook();
                    break;
                case 3:
                    deleteBook();
                    break;
                case 4:
                    objControl.displayBook();
                    break;
            }
        }while (choice != 5);
    }

    public static void main(String[] args) {
        System.out.println("!!!---Welcome to ebookStore---!!!");
        System.out.println("==============================");
        newView objNew = new newView();
        int choice;
        do {
            Home();
            System.out.println("Your choice: ");
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            switch (choice){
                case 1:
                    objNew.BookManagement();
                    break;
                case 2:
                    objNew.customerManagement();
                    break;
                case 4:
                    objNew.SignUp();
            }
        }while (choice != 3);
    }
}
