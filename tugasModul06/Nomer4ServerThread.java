/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasModul06;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author ASUS
 */
public class Nomer4ServerThread extends Thread{
    public static final int SERVICE_PORT = 13;
    OutputStream out;
    InputStream in;
    PrintStream pout;
    @Override
    public void run(){
        try{
            ServerSocket server = new ServerSocket(SERVICE_PORT);
            System.out.println("Server is getting started");
                for(int i=0;;i++){
                    Socket client = server.accept();
                    System.out.println("Received Request from "+client.getInetAddress()+" : "+ client.getPort());
                    out = client.getOutputStream();
                    pout = new PrintStream(out);
                    pout.print("ahlan wa sahlan, You're the visitor number "+i);
                    out.flush();
                    pout.close();
                    client.close();
                }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        Thread t1 = new Nomer4ServerThread();
        t1.start();
    }
}
