/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Zaki
 */
public class DaytimeClient {

    public static final int SERVICE_PORT = 2048;

    public static void main(String[] args) throws ClassNotFoundException, ClassNotFoundException {
        List<mahasiswa> participants = new ArrayList<mahasiswa>();
        String NIM, Nama, Asal, Kelas;
        int index;
        boolean run = true;
        int pilihan;
        Scanner input = new Scanner(System.in);
        SerializationDemo demo = new SerializationDemo();
        String direktori = "/home/zaki/NetBeansProjects/Sister/src/tugas5/data.ser";

        String hostname = "localhost";
        try {
            Socket daytime = new Socket(hostname, SERVICE_PORT);
            System.out.println("Connection Estabilished");

            daytime.setSoTimeout(2000);

            while (run) {
                System.out.println("Pilih menu : ");
                System.out.println("1. Insert\n"
                        + "2. Update\n"
                        + "3. Delete\n"
                        + "4. Print\n"
                        + "5. Save\n"
                        + "6. Exit\n");
                pilihan = input.nextInt();
                if (pilihan == 1) {
                    System.out.print("NIM : ");
                    NIM = input.next();
                    System.out.print("Nama : ");
                    Nama = input.next();
                    System.out.print("Asal : ");
                    Asal = input.next();
                    System.out.print("Kelas Praktikum : ");
                    Kelas = input.next();

                    participants.add(new mahasiswa(NIM, Nama, Asal, Kelas));

                    //String kata = br.readLine();
                    System.out.println("\n" + participants);

                    demo.serialize(participants, direktori);
                    //proses nulis
                    OutputStream os = daytime.getOutputStream();
                    PrintStream ps = new PrintStream(os);
                    //nulis ke server
                    ps.println(participants);//Perlu Println biar datanya kebanya jangan print
                    System.out.println("");

                    try {
                        BufferedReader br1 = new BufferedReader(new InputStreamReader(daytime.getInputStream()));
                        System.out.println("Pesan  dari Server \t : " + br1.readLine());
                        System.out.println("");
                    } catch (IOException ioe) {
                        System.out.println("Error " + ioe);
                    }
                    
                    os.flush();
                } else if (pilihan == 2) {
                    System.out.print("Update data Index: ");
                    index = input.nextInt();
                    if (index > participants.size()) {
                        System.out.println("Index Not Found!");
                        break;
                    }
                    System.out.print("Data: " + participants.get(index)+"\n");
                    System.out.print("Masukkan NIM: ");
                    NIM = input.next();
                    System.out.print("Masukkan Nama: ");
                    Nama = input.next();
                    System.out.print("Masukkan Asal: ");
                    Asal = input.next();
                    System.out.print("Masukkan Kelas: ");
                    Kelas = input.next();
                    mahasiswa m = new mahasiswa(NIM, Nama, Asal, Kelas);

                    participants.remove(index);
                    participants.add(index, m);
                    System.out.println("\n" + participants);

                    demo.serialize(participants, direktori);

                    //proses nulis
                    OutputStream os = daytime.getOutputStream();
                    PrintStream ps = new PrintStream(os);
                    //nulis ke server
                    ps.println(participants);
                    System.out.println("");

                    try {
                        BufferedReader br1 = new BufferedReader(new InputStreamReader(daytime.getInputStream()));
                        System.out.println("Pesan  dari Server \t : " + br1.readLine());
                        System.out.println("");
                    } catch (IOException ioe) {
                        System.out.println("Error " + ioe);
                    }

                    os.flush();
                } else if (pilihan == 3) {
                    System.out.print("Delete data Index: ");
                    index = input.nextInt();
                    if (index > participants.size() - 1) {
                        System.out.println("Not Found!");
                        break;
                    }

                    mahasiswa m = participants.get(index);
                    participants.remove(index);

                    demo.serialize(participants, direktori);
                    System.out.println("Delete Successful");

                    OutputStream os = daytime.getOutputStream();
                    PrintStream ps = new PrintStream(os);
                    //nulis ke server
                    ps.println(participants);//Perlu Println biar datanya kebanya jangan print
                    System.out.println("");

                    try {
                        BufferedReader br1 = new BufferedReader(new InputStreamReader(daytime.getInputStream()));
                        System.out.println("Pesan  dari Server \t : " + br1.readLine());
                        System.out.println("");
                    } catch (IOException ioe) {
                        System.out.println("Error " + ioe);
                    }
                    
                    os.flush();
                } else if (pilihan == 4) {
                    System.out.println("DATA MAHASISWA...");
                    int i = 0;
                    for (mahasiswa mhs : demo.deserialize(direktori)) {
                        System.out.printf("%d. %s", i++, mhs);
                        System.out.println("");
                    }
                    System.out.println("");
                } else if (pilihan == 5) {
                    demo.serialize(participants, direktori);
                    System.out.println("Save Successful\n");
                } else if (pilihan == 6) {
                    System.out.println("Anda Keluar");
                    run = false;
                    System.exit(0);
                }
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(daytime.getInputStream()));
            System.out.println("Reader : " + reader.readLine());

            daytime.close();
        } catch (IOException e) {
            System.err.println("Error WOY" + e);
        }

    }
}
