/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas6;

/**
 *
 * @author zaki
 */
public class Array extends Thread {

    static int i = 0;
    private int A, B, C;
    private String thread;

    public Array(String thread) {
        this.thread = thread;
    }

    public void setIndeks(int a, int b, int c) {
        A = a;
        B = b;
        C = c;
    }

    @Override
    public void run() {
        int jumlah = A + B + C;
        System.out.print(thread + "\t");
        System.out.println(A + " + " + B + " + " + C + " = " + jumlah);
    }

    public static void main(String[] args) {
        int[] array1 = {6, 9, 1, 2, 3, 5};
        int[] array2 = {7, 11, 6, 4, 3, 1};
        int[] array3 = {5, 4, 3, 2, 1, 12};

        for (i = 0; i < 3; i++) {
            System.out.print("Array 1 \t");
            for (i = 0; i < 6; i++) {
                System.out.print(array1[i] + " ");
            }
            System.out.print("\nArray 2 \t");
            for (i = 0; i < 6; i++) {
                System.out.print(array2[i] + " ");
            }
            System.out.print("\nArray 3 \t");
            for (i = 0; i < 6; i++) {
                System.out.print(array3[i] + " ");
            }
            System.out.println("");
        }
        
        for (i = 0; i < 1; i++) {
            for (i = 0; i < 2; i++) {
                System.out.print("\t");
            }
            for (i = 0; i < 12; i++) {
                System.out.print("-");
            }
            System.out.println(" +");
        }
        
        System.out.println("Jumlah \t\t");
        for (int j = 0; j < 6; j++) {
            Array arr = new Array("Thread "+j);
            arr.setIndeks(array1[j],array2[j],array3[j]);
            arr.start();
        }
    }
}

