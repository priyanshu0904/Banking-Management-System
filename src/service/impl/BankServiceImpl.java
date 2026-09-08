package service.impl;

import domain.Account;
import service.BankService;

import java.util.UUID;

public class BankServiceImpl implements BankService {
    @Override
    public String openAccount(String name, String email, String accountType) {
        String customerId = UUID.randomUUID().toString();
        //will change later ---> 10 + 1 = AC11
        String accountNumber = UUID.randomUUID().toString();
        Account account = new Account(accountNumber, accountType,(double) 0, customerId);

        //Save Data

        return "";
    }
}
