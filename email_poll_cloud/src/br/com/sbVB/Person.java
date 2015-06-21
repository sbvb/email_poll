/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sbVB;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sbvb
 */
public class Person {

    static String OK = "OK";

    public String name;
    public String email;
    public String tel;
    public String comment;
    public String password;
    public String timezone;
    public String hash;
    public String creation_dt;

    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreation_dt() {
        return creation_dt;
    }

    public void setCreation_dt(String creation_dt) {
        this.creation_dt = creation_dt;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        name = value;
    }

    public static Person getPerson(int id) {
        Person ret = new Person();
        ret.name = "(empty)";
        try {

            Class.forName(DAO.driver);

            Connection con = DriverManager.getConnection(
                    "jdbc:" + DAO.driverStr + ":" + DAO.database + "?"
                    + "user=" + DAO.user + "&password=" + DAO.pwd);

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tb_person where id = " + id);

            rs.next();

            ret.name = rs.getString("name");
            ret.email = rs.getString("email");
            ret.tel = rs.getString("tel");
            ret.comment = rs.getString("comment");
            ret.password = rs.getString("password");
            ret.timezone = rs.getString("timezone");
            ret.hash = rs.getString("hash");
            ret.creation_dt = rs.getTimestamp("creation_dt").toString();

        } catch (SQLException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;

    }

// CREATE USER 'user_email_poll'@'localhost' IDENTIFIED BY 'emailpwd';
// GRANT ALL ON db_email_poll.* TO 'user_email_poll'@'localhost';
//INSERT INTO tb_person (name,email,tel,comment,image,hash,password,timezone,creation_dt) 
//VALUES ("sbVB Name of test","sbvillasboas@gmail.com","sbVB tel test","sbVB comment","/folder/image.png","sbVB hash","testpwd","-3",now());
    public static String createPerson(
            String name,
            String email,
            String tel,
            String comment,
            String image,
            String password,
            int timezone) {

        String ret = OK;

        timezone = -3;

        String miliseconds = new Integer(Calendar.getInstance().get(Calendar.MILLISECOND)).toString();

        String hash = Helper.hash(name + email + miliseconds);

        try {

            String sql
                    = "INSERT INTO tb_person (name,email,tel,comment,image,hash,password,timezone,creation_dt) "
                    + "VALUES("
                    + "'" + name + "'"
                    + ",'" + email + "'"
                    + ",'" + tel + "'"
                    + ",'" + comment + "'"
                    + ",'" + image + "'"
                    + ",'" + hash + "'"
                    + ",'" + password + "'"
                    + ",'" + (new Integer(timezone)).toString() + "'"
                    + ",now())";

//            ret = sql;
            Class.forName(DAO.driver);

            Connection con = DriverManager.getConnection(
                    "jdbc:" + DAO.driverStr + ":" + DAO.database + "?"
                    + "user=" + DAO.user + "&password=" + DAO.pwd);

            Statement stmt = con.createStatement();
            stmt.execute(sql);

//            Statement stmt = con.createStatement();
//            stmt.execute("insert into tb_book(title, author, editor, year) values" + 
//                    "('New Title', 'New author', 'New editor',2001)"); 
//            System.out.print("query  executed");
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery("select * from tb_book");
//            int rowCount = 1;
//
//            // System.out.println("japanese = æ—¥æœ¬èªžã‚’å‹‰å¼·ã—ã¾ã™");
//            // for each line of ResultSet
//            while (rs.next()) {
//                System.out.print("Row[" + rowCount++ + "] = ");
//                System.out.print("title=" + rs.getString("title") + ";");
//                System.out.print("author=" + rs.getString("author") + ";");
//                System.out.print("editor=" + rs.getString("editor") + ";");
//                System.out.println("year=" + rs.getInt("year"));
//            }

            /*
             String st = "delete from tb_book where bookid=3;";
             System.out.println("DEBUG " + st);
             Statement stmt2 = con.createStatement();
             stmt2.execute(st);
             */
        } catch (SQLException e) {
            ret = "SQLException";
        } catch (ClassNotFoundException e) {
            ret = "ClassNotFoundException";
        } catch (Exception e) {
            ret = "Unhandled Exception";
        }
        return ret;
    }
}
