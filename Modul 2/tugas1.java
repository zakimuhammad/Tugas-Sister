/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikum02;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author Zaki
 */
public class tugas1 {
    public static void main(String[] args) {
        File filenya = new File("F:sister.txt");
        try {
            if (filenya.createNewFile()) {
                System.out.println("file telah dibuat");
            } else {
                System.out.println("file belum dibuat");
            }
            
            FileReader fr = new FileReader("F:java.txt");
            FileWriter fw = new FileWriter("F:sister.txt");
            int c = fr.read();
            while (c != -1) {                
                fw.write(c);
                c = fr.read();
            }
            fr.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
