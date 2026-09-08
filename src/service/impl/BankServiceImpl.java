package service.impl;

import domain.Account;
import repository.AccountRepository;
import service.BankService;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class BankServiceImpl implements BankService {
    private final AccountRepository accountRepository = new AccountRepository();
    @Override
    public String openAccount(String name, String email, String accountType) {
        String customerId = UUID.randomUUID().toString();
        String accountNumber = getAccountNumber();
        Account account = new Account(accountNumber, accountType,(double) 0, customerId);
        accountRepository.save(account);
        return accountNumber;
    }

    @Override
    public List<Account> listAccounts() {
        return accountRepository.findAll().stream()
                .sorted(Comparator.comparing(Account::getAccountNumber))
                .collect(Collectors.toList());
    }

    private String getAccountNumber() {
        //Account Number ---> 10 + 1 = AC000011
        int size = accountRepository.findAll().size() + 1;
        return String.format("AC%06d", size);
    }
}
