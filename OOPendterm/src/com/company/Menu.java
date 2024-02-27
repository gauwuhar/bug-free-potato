package com.company;

import com.company.controllers.BankAccountController;
import com.company.moduls.BankAccount;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private ArrayList<BankAccount> bankAccounts = new ArrayList<>();
    private static Menu menu;
    private final BankAccountController bankAccountController;

    public Menu(BankAccountController bankAccountController) {
        this.bankAccountController = bankAccountController;
    }

    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Add account");
        System.out.println("2. Delete account");
        System.out.println("3. View balance");
        System.out.println("4. Replenish balance");
        System.out.println("5. Transfer money");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        processChoice(choice);
    }

    public static Menu createMenuAsSingletone(BankAccountController bankAccountController){
        if(menu==null){
            menu=new Menu(bankAccountController);
        }
        return menu;
    }
    public void processChoice(int choice) {
        Scanner sc = new Scanner(System.in);
        String name;
        String number;
        String password;
        String email;
        String type;
        double balance;
        double amount;

        switch (choice) {
            case 1:
                System.out.println("Please enter the account name");
                name = sc.nextLine();
                System.out.println("Please enter the account number");
                number = sc.nextLine();
                System.out.println("Please enter the account password");
                password = sc.nextLine();
                System.out.println("Please enter the account type (checking or savings)");
                type = sc.nextLine();
                System.out.println("Please enter the account balance");
                balance = sc.nextDouble();
                BankAccountController.addAccount(name, number, password, type, balance);
                break;
            case 2:
                System.out.println("Please enter the account number");
                number = sc.nextLine();
                System.out.println("Please enter the account password");
                password = sc.nextLine();
                BankAccountController.deleteAccount(number, password);
                break;
            case 3:
                System.out.println("Please enter the account number");
                number = sc.nextLine();
                System.out.println("Please enter the account password");
                password = sc.nextLine();
                BankAccountController.getAccountBalance(number, password);
                break;
            case 4:
                System.out.println("Please enter the account number");
                number = sc.nextLine();
                System.out.println("Please enter the account password");
                password = sc.nextLine();
                System.out.println("Please enter the account amount");
                amount = sc.nextDouble();
                BankAccountController.replenishAccountBalance(number, password, amount);
                break;
            case 5:
                System.out.println("Please enter the account number");
                number = sc.nextLine();
                System.out.println("Please enter the account password");
                password = sc.nextLine();
                System.out.println("Please enter another the account number");
                String numberToTransfer = sc.nextLine();
                System.out.println("Please enter the account amount");
                amount = sc.nextDouble();
                BankAccountController.transfer(number, numberToTransfer, amount);
                break;
            case 0:
                System.out.println("Thank you for using Bank Account Manager");
                System.exit(0);
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}

/*
    public void populateData(){
        students=libraryController.readStudentRecords();
        subjects=libraryController.readSubjectRecords();
        for (Student s:students) {
            libraryController.getTakenSubjectRecords(s);
        }
        System.out.println("ALL DATA ADDED!");
    }
*/
