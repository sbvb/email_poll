/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sbVB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sbvb
 */
public class Group {

    public String name;
    public String description;
    public String hash;
    public String creation_dt;
    public int owner_id;
    public String owner_name;

    static Group[] getAllGroups() {
        LinkedList<Group> groupContainer = new LinkedList<Group>();

        try {

            Class.forName(DAO.driver);

            Connection con = DriverManager.getConnection(
                    "jdbc:" + DAO.driverStr + ":" + DAO.database + "?"
                    + "user=" + DAO.user + "&password=" + DAO.pwd);

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tb_group");
            int rowCount = 1;

            Group debugGroup = new Group();
            debugGroup.name = "debug name";
            groupContainer.add(debugGroup);

            System.out.println("sbVB debug");

            // for each line of ResultSet
            while (rs.next()) {
                Group currGroup = new Group();
                currGroup.name = rs.getString("name");
                currGroup.description = rs.getString("description");
                currGroup.hash = rs.getString("hash");
                currGroup.creation_dt = rs.getTimestamp("creation_dt").toString();
                currGroup.owner_id = rs.getInt("tb_person_id");

                // get group owner name
                Statement stmt2 = con.createStatement();
                ResultSet rs2 = stmt2.executeQuery("select name from tb_person where id=" + currGroup.owner_id);
                rs2.next();
                currGroup.owner_name = rs2.getString("name");

                groupContainer.add(currGroup);
                rowCount++;
            }

            rs.next();

        } catch (SQLException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }

        Group ret[] = new Group[groupContainer.size()];
        groupContainer.toArray(ret);
        return ret;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getCreation_dt() {
        return creation_dt;
    }

    public void setCreation_dt(String creation_dt) {
        this.creation_dt = creation_dt;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

}
