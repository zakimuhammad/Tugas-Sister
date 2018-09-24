/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author Zaki
 */
public class Serialization implements Serializable{

    private String nama, kelas, asal;
    private int nim;

    public Serialization(int nim, String nama, String asal, String kelas) {
        this.nama = nama;
        this.kelas = kelas;
        this.asal = asal;
        this.nim = nim;
    }

     public int getNim() {
        return nim;
    }

    public void setNim(int nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

     public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }
    
    public void printData() throws ClassNotFoundException{
        JOptionPane.showMessageDialog(null, "NIM : " + nim + "\nNama : " + nama + "\nAsal : " + asal + "\nKelas : " + kelas);
    }

    public void saveObject(Serialization obj) throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream("f:data.txt");
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(obj);
            out.flush();
            fos.close();
        } catch (IOException e) {
            System.out.println("Error di " + e.getMessage());
        }
    }

    public void readObject(Serialization ser) {
        try {
            FileInputStream fis = new FileInputStream("f:data.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ser = (Serialization) ois.readObject();
            ser.printData();
            fis.close();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Terjadi kesalahan di " + ex.getMessage());
            System.exit(1);
        }
    }

    public void remove(int nim) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream("F:data.txt");
        ObjectOutputStream out = new ObjectOutputStream(fos);
        out.reset();
    }
}
