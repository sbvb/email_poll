/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sbVB;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author sbvb
 */
public class Helper {

    public static String hash(String in) {
        String ret;
        try {
            MessageDigest mdEnc = MessageDigest.getInstance("MD5");
            mdEnc.update(in.getBytes(), 0, in.length());
            ret = new BigInteger(1, mdEnc.digest()).toString(16); // Hash value
        } catch (NoSuchAlgorithmException ex) {
            ret = "NoSuchAlgorithmException";
//            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;

    }



    public static void testMe(LinkedList<String> stringList) {

        stringList.add("=== Helper.testMe");

//        stringList.add("== encrypt(\"abc\",\"def\")="+encrypt("abc","def"));

//        String plainData = "some data to encrypt";
//        String keyStr = "";
//        String encriptedStr = encrypt(plainData, keyStr);
//
//        stringList.add("== encrypt(\"abc\",\"def\")="+encrypt("abc","def"));
//        
//        stringList.add("== encryptOK");

        stringList.add("== hash(\"abc\")="+hash("abc"));

        String miliseconds = new Integer(Calendar.getInstance().get(Calendar.MILLISECOND)).toString();

        stringList.add("== miliseconds="+miliseconds);
        
    }

}
