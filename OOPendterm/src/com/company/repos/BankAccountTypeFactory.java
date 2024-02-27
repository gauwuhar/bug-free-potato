package com.company.repos;

import com.company.repos.interfaces.BankAccountType;

public class BankAccountTypeFactory {
    public BankAccountType getAccountType(String type) {
        switch (type) {
            case "checking":
                return new CheckingBankAccount();
            case "savings":
                return new SavingsBankAccount();
            default:
                return null;
        }
    }

    private class CheckingBankAccount implements BankAccountType {
        @Override
        public String getType() {
            return "checking";
        }

        @Override
        public String getAccountType() {
            return null;
        }
    }

    private class SavingsBankAccount implements BankAccountType {
        @Override
        public String getType() {
            return "savings";
        }

        @Override
        public String getAccountType() {
            return null;
        }
    }

    private class UnknownBankAccount implements BankAccountType {
        @Override
        public String getType() {
            return "unknown";
        }

        @Override
        public String getAccountType() {
            return null;
        }
    }

}
