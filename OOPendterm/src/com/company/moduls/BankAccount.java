package com.company.moduls;

public class BankAccount {

    private String name;
    private String number;
    private String email;
    private String password;
    private int balance;

    public BankAccount(BankAccountBuilder bankAccountBuilder) {
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public static class BankAccountBuilder{

        private String name;
        private String number;
        private String email;
        private String password;
        private int balance;

        public BankAccountBuilder(String name, String number){
            this.name = name;
            this.number = number;
        }
        public BankAccountBuilder withEmail(String email){
            this.email = email;
            return this;
        }
        public BankAccountBuilder withPassword(String password){
            this.password = password;
            return this;
        }
        public BankAccountBuilder withBalance(int balance){
            this.balance = balance;
            return this;
        }
        public BankAccount build(){
            return new BankAccount(this);
        }

    }

}
