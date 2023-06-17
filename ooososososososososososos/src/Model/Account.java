/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author WAFAco
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Account {
    private int id;
    private int userId;
    private String accountNumber;
    private String username;
    private String currency;
    private double balance;
    private String creationDate;

    // Constructor
    public Account(int id, int userId, String accountNumber, String username, String currency, double balance, String creationDate) {
        this.id = id;
        this.userId = userId;
        this.accountNumber = accountNumber;
        this.username = username;
        this.currency = currency;
        this.balance = balance;
        this.creationDate = creationDate;
    }

    private Account(String aInt, String string, String string0, String string1, double aDouble, String string2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Account() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
    
    public int save() throws SQLException, ClassNotFoundException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter =0;
         String insertQuery = "INSERT INTO accounts (id, user_id, account_number, username, currency, balance, creation_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
    ps.setInt(1, this.getId());
            ps.setInt(2, this.getUserId());
            ps.setString(3, this.getAccountNumber());
            ps.setString(4, this.getUsername());
            ps.setString(5, this.getCurrency());
            ps.setDouble(6, this.getBalance());
            ps.setString(7, this.getCreationDate());
            ps.executeUpdate();
    if (recordCounter > 0) {
            System.out.println(this.getUsername()
                    +" User was added successfully!");
        }
        if (ps != null){
            ps.close();
        }
        c.close();
        return recordCounter;  
    }
    public static  ArrayList<Account> getAllAccount()throws SQLException, ClassNotFoundException {
    
     Connection c = DB.getInstance().getConnection();
    
    PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Account> accounts = new ArrayList<>();
            String sql = "SELECT * FROM accounts ";
            ps = c.prepareStatement(sql);
        rs = ps.executeQuery();

    while (rs.next()){
            Account account = new Account(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getString(7));
            account.setId(rs.getInt(1));
           
            accounts.add(account);
        }
     if (ps != null){
            ps.close();
        }
        c.close();
        return accounts;
    }
    public int update() throws SQLException, ClassNotFoundException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter =0;
        String sql = /*"UPDATE USERS SET USERNAME=?, PASSWORD=?, EMAIL=? , GENDER=?,ROLE=? WHERE ID=?"*/
                "UPDATE accounts SET user_id = ?, account_number = ?, username = ?, currency = ?, balance = ?, creation_date = ? WHERE id = ?";;
        ps = c.prepareStatement(sql);
        ps.setInt(1, this.getUserId());
            ps.setString(2, this.getAccountNumber());
            ps.setString(3, this.getUsername());
            ps.setString(4, this.getCurrency());
            ps.setDouble(5, this.getBalance());
            ps.setString(6, this.getCreationDate());
            ps.setInt(7, this.getId());
            ps.executeUpdate();
        
        if (recordCounter > 0) {
            System.out.println("Account with id : "+this.getId()+" was updated successfully!");
        }
        if (ps != null){
            ps.close();
        }
        c.close();
        return recordCounter;  
    }
    public int delete() throws SQLException, ClassNotFoundException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter =0;
        String sql = "DELETE FROM Account WHERE ID=? ";
        ps = c.prepareStatement(sql);
        ps.setInt(1, this.getId());
        recordCounter = ps.executeUpdate();
        if (recordCounter > 0) {
            System.out.println("The Account with id : "+this.getId()+" was deleted successfully!");
        }
        if (ps != null){
            ps.close();
        }
        c.close();
        return recordCounter;  
    }

    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
}