/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas6;

/**
 *`
 * @author zaki
 */
public class Cerita extends Thread {

    static int suster, pasien;

    @Override
    public void run() {
        for (pasien = 0; pasien < 10; pasien++) {
            System.out.println("Pasien ke " + (pasien + 1) + " datang dan di periksa oleh Dokter");
        }

        System.out.println("");
        for (suster = 1; suster <= 2; suster++) {
            System.out.println("Suster " + suster + " merawat 5 pasien");
        }
        
        for (pasien = 0; pasien < 10; pasien++) {
            if ((pasien + 1) % 5 == 0) {
                System.out.println("");

                for (int j = (pasien + 1); j > pasien - 4; j--) {
                    System.out.println("Pasien " + j + " membayar ke kasir");
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Cerita();
        t1.start();
    }
}
