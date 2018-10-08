/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas5;

import java.io.Serializable;

/**
 *
 * @author Zaki
 */
public class mahasiswa implements Serializable{

    private final String NIM;
    private final String Nama;
    private final String Asal;
    private final String Kelas;

    public mahasiswa(String NIM, String Nama, String Asal, String Kelas) {
        this.NIM = NIM;
        this.Nama = Nama;
        this.Asal = Asal;
        this.Kelas = Kelas;
    }

    public String getNIM() {
        return NIM;
    }

    public String getNama() {
        return Nama;
    }

    public String getAsal() {
        return Asal;
    }

    public String getKelas() {
        return Kelas;
    }

    @Override
    public String toString() {
        return "mahasiswa{" + "NIM=" + NIM + ", Nama=" + Nama + ", Asal=" + Asal + ", Kelas=" + Kelas + '}';
    }
    
    
}
