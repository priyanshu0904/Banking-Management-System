package app;

import exceptions.ValidationException;
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
                case "2" -> deposit(sc, bankService);
                case "3" -> withdraw(sc, bankService);
                case "4" -> transfer(sc, bankService);
                case "5" -> statement(sc, bankService);
                case "6" -> listAccounts(sc, bankService);
                case "7" -> searchAccounts(sc, bankService);
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
        if(amountStr.isBlank())
            amountStr = "0";
        Double initial = Double.valueOf(amountStr);
        String accountNumber = bankService.openAccount(name, email, type);
        if(initial < 0){
            throw new ValidationException("Amount should be valid");
        }else {
            bankService.deposit(accountNumber, initial, "First Deposit");
        }
        System.out.println("Account opened with account number: " + accountNumber);
    }

    private static void deposit(Scanner sc, BankService bankService) {
        System.out.print("Account Number: ");
        String accountNumber = sc.nextLine().trim();
        System.out.print("Deposit Amount: ");
        Double amount = Double.valueOf(sc.nextLine().trim());
        bankService.deposit(accountNumber, amount, "Deposit");
        System.out.println("Amount Deposited");
    }

    private static void withdraw(Scanner sc, BankService bankService) {
        System.out.print("Account Number: ");
        String accountNumber = sc.nextLine().trim();
        System.out.print("Withdraw Amount: ");
        Double amount = Double.valueOf(sc.nextLine().trim());
        bankService.withdraw(accountNumber, amount, "Withdrawal");
        System.out.println("Amount Withdrawn");
    }

    private static void transfer(Scanner sc, BankService bankService) {
        System.out.print("From Account Number: ");
        String from = sc.nextLine().trim();
        System.out.print("To Account Number: ");
        String to = sc.nextLine().trim();
        System.out.print("Amount: ");
        Double amount = Double.valueOf(sc.nextLine().trim());
        bankService.transfer(from, to, amount, "Transfer");
    }

    private static void statement(Scanner sc, BankService bankService) {
        System.out.print("Account Number: ");
        String accountNumber = sc.nextLine().trim();
        bankService.getStatement(accountNumber).forEach(t -> {
            System.out.println(t.getTimestamp() + " | " + t.getType() +
                    " | " + t.getAmount() + " | " +
                    t.getNote());
        });
    }

    private static void listAccounts(Scanner sc, BankService bankService) {
        bankService.listAccounts().forEach(a -> {
            System.out.println(a.getAccountNumber() + " | " + a.getAccountType() + " | " + a.getBalance());
        });
    }

    private static void searchAccounts(Scanner sc, BankService bankService) {
        System.out.print("Customer name contains: ");
        String q = sc.nextLine().trim();
        bankService.searchAccountByCustomerName(q).forEach(
                account -> System.out.println(account.getAccountNumber() + " | " +
                        account.getAccountType() + " | " + account.getBalance())
        );
    }

}
