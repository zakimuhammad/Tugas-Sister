/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas6;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author Asus
 */
public class ClientThread extends Thread{

    public static final int SERVICE_PORT = 2048;
    String hostname = "localhost";
    InputStream in;
    BufferedReader bf;

    public void run() {
        try {
            Socket client = new Socket(hostname, SERVICE_PORT);
            bf = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println(bf.readLine());
            Thread.sleep(500);
            Socket client2 = new Socket(hostname, SERVICE_PORT);
            bf = new BufferedReader(new InputStreamReader(client2.getInputStream()));
            System.out.println(bf.readLine());
            Thread.sleep(500);
            Socket client3 = new Socket(hostname, SERVICE_PORT);
            bf = new BufferedReader(new InputStreamReader(client3.getInputStream()));
            System.out.println(bf.readLine());
            Thread.sleep(500);
            Socket client4 = new Socket(hostname, SERVICE_PORT);
            bf = new BufferedReader(new InputStreamReader(client4.getInputStream()));
            System.out.println(bf.readLine());
            Thread.sleep(500);
            Socket client5 = new Socket(hostname, SERVICE_PORT);
            bf = new BufferedReader(new InputStreamReader(client5.getInputStream()));
            System.out.println(bf.readLine());
            Thread.sleep(500);
            client.close();
            client2.close();
            client3.close();
            client4.close();
            client5.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Thread t1 = new ClientThread();
        t1.start();
    }
}
