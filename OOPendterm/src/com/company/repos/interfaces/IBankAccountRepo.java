package com.company.repos.interfaces;

public interface IBankAccountRepo {
    void addAccount(String accountName, String accountNumber, String password, String accountType, double balance);

    void deleteAccount(String accountNumber, String password);
    //viewing balance
    double getBalance(String accountNumber, String password);
    //adding more balance to balance
    double replenishBalance(String accountNumber, String password, double addingBalance);

    void transfer(String fromAccountNumber, String toAccountNumber, double amount);

    String getAccountType(String accountNumber, String password);

    String getAccountInformation(String accountNumber, String password);
}
