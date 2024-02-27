package com.company.controllers;

import com.company.db.interfaces.IDB;
import com.company.repos.BankAccountRepo;
import com.company.repos.interfaces.IBankAccountRepo;

public class BankAccountController {
    private IDB db;
    private static BankAccountController bac;

    private static IBankAccountRepo bankAccountRepo;
    public BankAccountController(IDB db) {
        this.db=db;
        bankAccountRepo=new BankAccountRepo(db);
    }

    public static BankAccountController getBankAccountRepoInstance(IDB db){
        if(bac==null){
            bac=new BankAccountController(db);
        }
        return bac;
    }

    public static void addAccount(String accountName, String accountNumber, String password, String account_type, double balance){
        bankAccountRepo.addAccount(accountName,accountNumber,password,account_type,balance);
    }

    public static void deleteAccount(String accountNumber, String password){
        bankAccountRepo.deleteAccount(accountNumber, password);
    }

    public static double getAccountBalance(String accountNumber, String password){
        return bankAccountRepo.getBalance(accountNumber, password);
    }

    public static double replenishAccountBalance(String accountNumber, String password, double newBalance){
        return bankAccountRepo.replenishBalance(accountNumber, password, newBalance);
    }
    public static void transfer(String fromAccountNumber, String toAccountNumber, double amount){
        bankAccountRepo.transfer(fromAccountNumber,toAccountNumber,amount);
    }

    public static String getAccountType(String accountNumber, String password){
        return bankAccountRepo.getAccountType(accountNumber,password);
    }

    public static String getAccountInformation(String accountNumber, String password){
        return bankAccountRepo.getAccountInformation(accountNumber,password);
    }
    


}
