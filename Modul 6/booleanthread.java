/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas6;

import java.io.IOException;

/**
 *
 * @author zaki
 */
public class booleanthread extends Thread {

    int count = 1, last;
    boolean boolthread;

    public void setBoolthread(boolean boolthread) {
        this.boolthread = boolthread;
    }

    @Override
    public void run() {
        for (;;) {
            try {
                if (boolthread == true) {
                    count++;
                    this.last = count;
                    
                    if (count % 2 == 0) {
                        System.out.print(count + " ");
                    }
                } else if (boolthread == false) {
                    last--;
                    if (last % 2 == 1) {
                        System.out.print(last + " ");
                    }
                }
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) throws IOException {
        booleanthread counter = new booleanthread();
        counter.setBoolthread(true);
        counter.start();
        System.out.println("Bilangan Genap");
        System.in.read();

        counter.setBoolthread(false);
        counter.resume();
        System.out.println("Bilangan Ganjil");
        System.in.read();

        counter.stop();
    }
}
