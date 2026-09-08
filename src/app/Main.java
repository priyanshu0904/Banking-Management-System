package app;

import javax.xml.transform.Source;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        System.out.println("Welcome to Console Bank....");
        while (running){
            System.out.println("""
                1. Open Account
                2. Deposit Money
                3. Withdraw Money
                4. Transfer Money
                5. Check your Account Statement
                6. List Accounts
                7. Search Account by Customer Name
                0. Exit
                """);

            System.out.print("Choose any operation: ");
            String choice = sc.nextLine().trim();
            System.out.println("Your choice is: " + choice);

            switch (choice){
                case "0" -> running = false;
            }
        }
    }
}
