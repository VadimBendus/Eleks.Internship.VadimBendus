package com.example.atm.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.example.atm.domain.ATM;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ATMRepository {


    public List<ATM> getAllKupuru() {
try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e);
        }
        System.out.println("JDBC Class found");
        int no_of_rows = 0;
        List<ATM> kupuru = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/kupuru?useSSL=false", "root", "123321");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM kupuru where status = 'true'");
            while (rs.next()) {
                int id =rs.getInt(1);
                int kname = rs.getInt(2);
                String dated = rs.getString(3);
                String description = rs.getString(4);
                String status = rs.getString(5);
                ATM at = new ATM();
                at.setId(id);
                at.setKname(kname);
                at.setDated(dated);
                at.setDescription(description);
                at.setStatus(status);
                kupuru.add(at);
                no_of_rows++;
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3) +"  " + rs.getString(4));
            }
            System.out.println("В таблиці міститься " + no_of_rows + " записів!");
        } catch (SQLException e) {
            System.out.println("SQL exception occured " + e);
        }
        return kupuru ;
    }

    public List<ATM> getKupuru() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e);
        }
        System.out.println("JDBC Class found");
        List<ATM> kupuru = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/kupuru?useSSL=false", "root", "123321");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM kupuru where status = 'true' ORDER BY kname DESC");
            while (rs.next()) {
                int kname = rs.getInt(2);
                ATM at = new ATM();
                at.setKname(kname);
                kupuru.add(at);
            }
            System.out.println("Successfully!");
        } catch (SQLException e) {
            System.out.println("SQL exception occured " + e);
        }
        return kupuru ;
    }

    public  List<ATM> getKupuruByKname(int kupura){
        int no_of_rows = 0;
        List<ATM> kupuru = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/kupuru?useSSL=false", "root", "123321");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM kupuru where status ='true' AND kname ="+ kupura);
            while (rs.next()) {
                int id =rs.getInt(1);
                int kname = rs.getInt(2);
                String dated = rs.getString(3);
                String description = rs.getString(4);
                String status = rs.getString(5);
                ATM atm = new ATM();
                atm.setId(id);
                atm.setKname(kname);
                atm.setDated(dated);
                atm.setDescription(description);
                atm.setStatus(status);
                kupuru.add(atm);
                no_of_rows++;
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4));
            }
            System.out.println("В таблиці міститься " + no_of_rows + " купюри з цим номіналом!");
        } catch (SQLException e) {
            System.out.println("SQL exception occured " + e);
        }

        return kupuru ;
    }

    public  String deleteKupuruByKname(String kname){
        String rezult = null;
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/kupuru?useSSL=false", "root", "123321");
            Statement stmt = con.createStatement();
            Integer rs = stmt.executeUpdate("UPDATE kupuru SET status='false' where status='true' AND kname = "+kname+" ORDER BY dated DESC LIMIT 1");
//           // DELETE FROM kupuru where kname =" + kname +" ORDER BY dated DESC LIMIT 1
            if(rs!=null){
rezult = "Операцію успішно здійснено!";}
        } catch (Exception e) {
            System.out.println("SQL exception occured" + e);
           rezult = "Нема купюри";
        }
        return rezult;
    }

    public  boolean insertKupuru(ATM atm){
        PreparedStatement ps = null;
        String insertTableSQL = "INSERT INTO kupuru"
                + "(id, kname, dated, description, status) VALUES"
                + "(?,?,?,?,?)";
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/kupuru?useSSL=false", "root", "123321");
            ps = con.prepareStatement(insertTableSQL);

            ps.setInt(1, atm.getId());
            ps.setInt(2, atm.getKname());
            ps.setString(3, atm.getDated());
            ps.setString(4,atm.getDescription());
            ps.setString(5,atm.getStatus());

            ps.executeUpdate();
            if(ps!=null){
                System.out.println("Додавання успішно здійснено!");
                return true;}
        } catch (SQLException e) {
            System.out.println("SQL exception occured" + e);
            System.out.println("Виникла помилка при додаванні записів!");
            return false;
        }
        return true;
    }

    public int getCount(int kname){
int count = 0;
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/kupuru?useSSL=false", "root", "123321");
            Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT COUNT(*) as kupuru_count FROM kupuru where status='true' AND kname = " + kname);
         while(rs.next()){
     count = rs.getInt("kupuru_count");}
                System.out.println("Кількість купюр з цим номіналом : " + count);

        } catch (SQLException e) {
            System.out.println("SQL exception occured" + e);
        }
        return count;
    }

    public int getAccount(){
        int sum = 0;
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/kupuru?useSSL=false", "root", "123321");
            Statement stmt = con.createStatement();
           ResultSet rs = stmt.executeQuery("SELECT SUM(kname) AS account FROM kupuru WHERE status='true'");
           while(rs.next()){
               sum = rs.getInt("account");
           }
            System.out.println("В банкоматі знаходиться " + sum + " гривень");

        } catch (SQLException e) {
            System.out.println("SQL exception occured" + e);
        }
        return sum;
    }

    public List<ATM> getKupuruWithCount() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e);
        }
        System.out.println("JDBC Class found");
        int count=0;
        List<ATM> kupuru = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/kupuru?useSSL=false", "root", "123321");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT kname ,COUNT(*) as kupuru_count FROM kupuru where status = 'true' GROUP BY kname");
            while (rs.next()) {
                int kname = rs.getInt("kname");
                count = rs.getInt("kupuru_count");
                ATM at = new ATM();
                at.setKilk(count);
                at.setKname(kname);
                kupuru.add(at);
                kupuru.toString();
                System.out.println(rs.getInt("kname")+"  "+rs.getInt("kupuru_count"));
            }
            System.out.println("Successfully!");
        } catch (SQLException e) {
            System.out.println("SQL exception occured " + e);
        }
        return kupuru;
    }
}