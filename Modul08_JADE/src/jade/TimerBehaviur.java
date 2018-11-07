/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jade;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

/**
 *
 * @author Husnus
 */
public class TimerBehaviur extends TickerBehaviour{
    int timer;
    
    public TimerBehaviur(Agent a, int timer,int waktu) {
        super(a, waktu);
        this.timer=timer;
    }

    protected void onTick() {
        if (timer==0) {
            System.out.println("Waktu Habis");
            myAgent.doDelete();            
        }else{
            System.out.println(timer);
            timer--;
        }
    }
   
        
    }

