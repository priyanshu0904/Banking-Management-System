package app;

import service.BankService;
import service.impl.BankServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankService bankService = new BankServiceImpl();
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
                case "1" -> openAccount(sc, bankService);
                case "2" -> deposit(sc);
                case "3" -> withdraw(sc);
                case "4" -> transfer(sc);
                case "5" -> statement(sc);
                case "6" -> listAccounts(sc, bankService);
                case "" -> searchAccounts(sc);
                case "0" -> running = false;
            }
        }
    }

    private static void openAccount(Scanner sc, BankService bankService) {
        System.out.print("Customer Name: ");
        String name = sc.nextLine().trim();
        System.out.print("Customer Email: ");
        String email = sc.nextLine().trim();
        System.out.print("Account Type (SAVINGS/CURRENT): ");
        String type = sc.nextLine().trim();
        System.out.print("Initial Deposit (optional, blank for 0): ");
        String amountStr = sc.nextLine().trim();
        Double initial = Double.valueOf(amountStr);
        bankService.openAccount(name, email, type);
    }

    private static void deposit(Scanner sc) {
    }

    private static void withdraw(Scanner sc) {
    }

    private static void transfer(Scanner sc) {
    }

    private static void statement(Scanner sc) {
    }

    private static void listAccounts(Scanner sc, BankService bankService) {
        bankService.listAccounts().forEach(a -> {
            System.out.println(a.getAccountNumber() + " | " + a.getAccountType() + " | " + a.getBalance());
        });
    }

    private static void searchAccounts(Scanner sc) {
    }

}
