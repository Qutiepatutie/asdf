package libraryproject;

import java.util.*;
import java.io.*;

public class LibraryProject {

        static String userId;
        static String password;
        static Scanner input = new Scanner(System.in);
        
        static HashMap<String, User> userDatabase = new HashMap<>();
        
    public static void main(String[] args) throws IOException {
        
        userDatabase.put("Admin", new User("admin123", "Admin"));
        //userDatabase.put("Student1", new User("student123", "Student"));
        
        int choice;
        
        while(true){
            System.out.println("[1] Login");
            System.out.println("[2] Register");
            System.out.println("[3] Exit");
            System.out.print("Choose: ");
            choice = input.nextInt();
            input.nextLine();
            
            switch(choice){

                case 1 -> {
                    System.out.print("Enter ID: ");
                    userId = input.nextLine();

                    System.out.print("Enter Password: ");
                    password = input.nextLine();
                    
                    logIn(userId,password);
                    //add choice to add books or exit program
                    //add user class
                }

                case 2 -> {
                    System.out.print("Enter new ID: ");
                    String newUserId = input.nextLine();

                    if(userDatabase.containsKey(newUserId)){
                        System.out.println("User Id already exists");

                    }else {
                        System.out.print("Enter New Password: ");
                        String newPassword = input.nextLine();

                        userDatabase.put(newUserId, new User(newPassword, "Student"));
                        System.out.println("User Registered Succesfully!");
                    }
                    
                    //ask for info/name on registration
                    //use notepad to save accounts
                }
                
                case 3 ->{
                    System.out.println("Exiting the Program...");
                    return;
                }
                
                default ->{
                    System.out.println("Invalid Choice");
                }
            }
        
        }
    }
    
    public static void logIn(String userId, String password)throws IOException{
        if(userDatabase.containsKey(userId)){
            if(User.getPassword().equals(password)){
                if(User.getRole().equals("Admin")){
                    System.out.println("Welcome, Admin");
                    Admin.welcome();

                }else if(User.getRole().equals("Student")){
                    System.out.println("Welcome, Student");
                }

            }else{
                System.out.println("Invalid Password");
            }

        }else{
            System.out.println("Invalid Username");
        }
    
    }
    
}
