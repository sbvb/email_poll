/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sbVB;

/**
 *
 * @author sbvb
 */
public class CypherMain {

    /**
     * @param args the command line arguments
     */
    
    // java -jar Cypher.jar e "secret sentence" mykey   => eRJdsxwh7mICGXuubLdjUQ==
    // java -jar Cypher.jar d "eRJdsxwh7mICGXuubLdjUQ==" mykey   => "secret sentence"
    public static void splash() {
        System.out.println("Cypher encrypt/deceypt, by sbVB");
        System.out.println("usage: java -jar Cypher e \"secret sentence\" \"key\" (to encrypt)");
        System.out.println("usage: java -jar Cypher d \"encrypted sentence\" \"key\" (to dectypt)");
        System.out.println("usage: java -jar Cypher t (to run tests)");

    }

    // java -jar Cypher.jar 111 222
    // 111 222
    public static void main(String[] args) {
//        System.out.println(args[0] + " " + args[1]);
        
//        System.out.println("args.length=" + args.length);
        
        if (args.length < 1) {
            splash();
            return;
        }

        if (!args[0].equals("e") 
                && !args[0].equals("d")
                && !args[0].equals("t")
                ) {
            splash();
            return;
        }

        if (args[0].equals("t")) {
            System.out.println("Cypher tests");
            Cypher.testMe();
        }

        if (args[0].equals("e")) {
            System.out.println(Cypher.encrypt2(args[1], args[2]));
        }

        if (args[0].equals("d")) {
            System.out.println(Cypher.decrypt2(args[1], args[2]));
        }
    }

}
