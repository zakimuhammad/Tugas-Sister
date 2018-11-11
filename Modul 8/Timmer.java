/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadeprogramming;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
/**
 *
 * @author zaki
 */
public class Timmer extends TickerBehaviour{
    private int waktu;
    public Timmer(Agent a, long period, int waktu) {
        super(a, period);
        this.waktu = waktu;
    }

    @Override
    protected void onTick() {
        if (waktu == 0 ) {
            System.out.println("Waktu Habis!!");
            myAgent.doDelete();
        }else{
            System.out.println(waktu);
            waktu--;
        }
    }

    
}
