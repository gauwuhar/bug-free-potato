package com.company.repos;
import com.company.db.interfaces.IDB;
import com.company.repos.interfaces.IBankAccountRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankAccountRepo implements IBankAccountRepo {
    private final IDB db;

    public BankAccountRepo(IDB db) {
        this.db = db;
    }

    @Override
    public void addAccount(String accountName, String accountNumber, String password,String accountType, double balance) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO bank_accounts(account_name,account_number, account_password, account_type, balance) VALUES (?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, accountName);
            st.setString(2, accountNumber);
            st.setString(3, password);
            st.setString(4, accountType);
            st.setDouble(5, balance);

            st.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
    @Override
    public void deleteAccount(String accountNumber, String password) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM bank_accounts WHERE account_number =? AND account_password =?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, accountNumber);
            st.setString(2, password);

            st.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    //viewing balance
    @Override
    public double getBalance(String accountNumber, String password) {
        Connection con = null;
        double balance = 0;
        try {
            con = db.getConnection();
            String sql = "SELECT balance FROM bank_accounts WHERE account_number =? AND account_password =?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, accountNumber);
            st.setString(2, password);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                balance = rs.getDouble("balance");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return balance;
    }

    //adding more balance to balance
    @Override
    public double replenishBalance(String accountNumber, String password, double addingBalance) {
        Connection con = null;
        double balance = 0.0;
        try {
            con = db.getConnection();
            String sql = "SELECT balance FROM bank_accounts WHERE account_number =? AND account_password =?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, accountNumber);
            st.setString(2, password);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                balance = rs.getDouble("balance");
            }
            balance = balance + addingBalance;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return balance;
    }
    @Override
    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE bank_accounts SET balance = balance -? WHERE account_number =? AND account_number =?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setDouble(1, amount);
            st.setString(2, fromAccountNumber);
            st.setString(3, toAccountNumber);

            st.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    @Override
    public String getAccountType(String accountNumber, String password) {
        Connection con = null;
        String accountType = "";
        try {
            con = db.getConnection();
            String sql = "SELECT account_type FROM bank_accounts WHERE account_number =?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, accountNumber);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                accountType = rs.getString("account_type");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return accountType;
    }

    @Override
    public String getAccountInformation(String accountNumber, String password) {
        Connection con = null;
        String accountInformation = "";
        try {
            con = db.getConnection();
            String sql = "SELECT account_name, account_number, account_password, account_type, balance FROM bank_accounts WHERE account_number =? AND account_password =?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, accountNumber);
            st.setString(2, password);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                accountInformation = rs.getString("account_name") + " " + rs.getString("account_number") + " " + rs.getString("account_password") + " " + rs.getString("account_type") + " " + rs.getDouble("balance");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return accountInformation;
    }
}
