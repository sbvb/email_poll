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

/**
 *
 * @author sbvb
 */
public class Main {

    String OK = "OK";

    public String getVersion() {
        return "Email_poll for cloud, by sbVB, version of 2015_06_20__17_37";
    }

    public Group [] getAllGroups() {
        return Group.getAllGroups();
    }

    public Person getPerson(int id) {
        return Person.getPerson(id);
    }

    public String createPerson(
            String name,
            String email,
            String tel,
            String comment,
            String image,
            String password,
            int timezone) {

        return Person.createPerson(name, email, tel, comment, image, password, timezone);
    }

    public static String[] test() {
        LinkedList<String> stringList = new LinkedList<String>();

        stringList.add("====== Email poll.test");

        Helper.testMe(stringList);
        Cypher.testMeWeb(stringList);

//        stringList.add("str 1");
//        stringList.add("str 2");
//        stringList.add("str 3");
//        stringList.add("str 4");
//        stringList.add("str 5");

        String ret[] = new String[stringList.size()];
        stringList.toArray(ret);

        return ret;
    }

}
