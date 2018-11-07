/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jade;
import jade.core.Agent;
/**
 *
 * @author Husnus
 */
public class TimerAgent extends Agent{
        int timer =10;
        int waktu = 1000;
        
        public void setup(){
            addBehaviour(new TimerBehaviur(this,timer,waktu));
        }
    
}
