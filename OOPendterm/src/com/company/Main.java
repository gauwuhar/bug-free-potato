package com.company;

import com.company.controllers.BankAccountController;
import com.company.db.PostgresDB;
import com.company.db.interfaces.IDB;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        IDB db=PostgresDB.getInstance();
        BankAccountController bankAccountController=BankAccountController.getBankAccountRepoInstance(db);
        Menu menu= Menu.createMenuAsSingletone(bankAccountController);
        //System.out.println(menu.showMenu());
        while (true) {
            menu.showMenu();
            int choice=sc.nextInt();
            if (choice == 0) {
                break;
            }
            menu.processChoice(choice);
        }

    }
}