/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadeprogramming;
import jade.core.Agent;
import javax.swing.JOptionPane;
/**
 *
 * @author zaki
 */
public class timmerticker extends Agent{

    int waktu = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Jumlah Detik"));
    int period = 1000;
    @Override
    protected void setup() {
        addBehaviour(new Timmer(this, period, waktu));
    }
    
}
