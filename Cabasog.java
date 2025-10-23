/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cabasog;

/**
 *
 * @author KevinCabasog <kevincabasog>
 */
import java.util.Scanner;

public class Cabasog {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean menu = true;
        final int MAX_USERS = 10;
        String[][] users = new String[MAX_USERS][2];
        int userCount = 0;
        
        while(menu) {
            System.out.println("==== LOGIN SYSTEM ====");
            System.out.println("[1] Login");
            System.out.println("[2] Register");
            System.out.println("[3] Exit");
            System.out.print("Choose an option: ");
            
            if (input.hasNextInt()) {
                int option = input.nextInt();
                input.nextLine();
                
                switch (option) {
                    case 1:
                        if (userCount == 0) {
                            System.out.println("No registered users yet. Please register an account first.");
                            break;
                        }
        
                        System.out.println("\n==== LOGIN ====");
                        System.out.print("Enter username: ");
                        String loginUsername = input.nextLine().trim();
                        System.out.print("Enter password: ");
                        String loginPassword = input.nextLine();
        
                        boolean loginConfirm = false;
        
                        for (int i = 0; i < userCount; i++) {
                            String storedUsername = users[i][0];
                            String storedPassword = users[i][1];
            
                            if (loginUsername.equals(storedUsername) && loginPassword.equals(storedPassword)) {
                                System.out.println("Hello, " + loginUsername + "!");
                                loginConfirm = true;
                                break;
                            }
                        }
        
                        if (!loginConfirm) {
                            System.out.println("Invalid username or password!");
                        }
                        break;
                        
                    case 2:
                        if (userCount >= MAX_USERS) {
                            System.out.println("Registration failed. Maximum number of users reached.");
                            return;
                        }
        
                        System.out.println("\n==== REGISTRATION ====");
                        System.out.print("Enter your username: ");
                        String registeredUsername = input.nextLine().trim();
                        
                        boolean accountTaken = false;
                        for (int i = 0; i < userCount; i ++) {
                            if (users[i][0].equals(registeredUsername)) {
                                accountTaken = true;
                                break;
                            }
                        }
                        
                        if (accountTaken) {
                            System.out.println("Registration failed. Username: " + registeredUsername + " is already taken.");
                            break;
                        }
        
                        System.out.print("Enter password: ");
                        String password = input.nextLine();
                        System.out.print("Confirm password: ");
                        String confirmPassword = input.nextLine();
        
                        if (!password.equals(confirmPassword)) {
                            System.out.println("Registration failed. Password and confirmation password didn't match.");
                            break;
                        }
        
                        users[userCount][0] = registeredUsername;
                        users[userCount][1] = password;
                        userCount++;
        
                        System.out.println("Registration succesful! User '" + registeredUsername + "' created.");
                        
                        break;
                    case 3:
                        System.out.println("Goodbye!");
                        menu = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please enter a number between 1, 2, or 3.");
                        
                        break;
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine();
            }
            
            System.out.println();
        }
        input.close();
    }
}