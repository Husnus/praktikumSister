/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import UDP.taskHomeParticipant;
import UDP.taskHomeSerialization;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class TaskClient {

    public static final int SERVICE_PORT = 7;
    public static final int BUFSIZE = 256;

    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
        String hostname = ("localhost");
        InetAddress addr = null;
        addr = InetAddress.getByName(hostname);
        String fileName = "E:/dataMahasiswa.txt";

        ArrayList<taskHomeParticipant> datamu = new ArrayList<taskHomeParticipant>();
        taskHomeSerialization task = new taskHomeSerialization();
        ArrayList<taskHomeParticipant> newList = null;
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket socket = new DatagramSocket();
        while (true) {
            System.out.println("Menu :");
            System.out.println("1. Insert Data");
            System.out.println("2. Update Data");
            System.out.println("3. Delete Data");
            System.out.println("4. Save Data to Server");
            System.out.println("5. Show Data");
            System.out.println("6. Exit");
            System.out.print("Choice : ");
            int choice = Integer.parseInt(buf.readLine());

            switch (choice) {
                //Insert
                case 1:
                    System.out.print("Enter NIM : ");
                    int a = Integer.parseInt(buf.readLine());
                    System.out.print("Enter Nama : ");
                    String b = buf.readLine();
                    System.out.print("Enter Asal : ");
                    String c = buf.readLine();
                    System.out.print("Enter Kelas : ");
                    String d = buf.readLine();
                    datamu.add(new taskHomeParticipant(a, b, c, d));
                    task.Serialize(datamu, fileName);

                    break;
                case 2:
                    //Update
                    System.out.print("Menampilkan data : ");
                    newList = (ArrayList<taskHomeParticipant>) task.print(fileName);
                    System.out.println("List Data : " + newList);
                    System.out.print("Pilih index data yang akan diubah : ");
                    int pilihIndex = Integer.parseInt(buf.readLine());
                    System.out.println("Pilih item dari index data ke " + pilihIndex);
                    int pilihItem = Integer.parseInt(buf.readLine());
                    if (pilihItem == 0) {
                        System.out.print("Inputkan NIM : ");
                        a = Integer.parseInt(buf.readLine());
                        datamu.get(pilihIndex).setNim(a);
                    } else if (pilihItem == 1) {
                        System.out.print("Inputkan Nama : ");
                        b = buf.readLine();
                        datamu.get(pilihIndex).setNama(buf.readLine());
                    } else if (pilihItem == 2) {
                        System.out.print("Inputkan Asal : ");
                        c = buf.readLine();
                        datamu.get(pilihIndex).setAsal(c);
                    } else if (pilihItem == 3) {
                        System.out.print("Inputkan Kelas : ");
                        d = buf.readLine();
                        datamu.get(pilihIndex).setKelas(d);
                    }
                    task.Serialize(datamu, fileName);
                    break;
                case 3:
                    //Delete
                    System.out.print("Menampilkan data : ");
                    newList = (ArrayList<taskHomeParticipant>) task.print(fileName);
                    System.out.println("List Data : " + newList);
                    System.out.print("Tekan 0 Untuk Menghapus : ");
                    pilihIndex = Integer.parseInt(buf.readLine());
                    datamu.remove(pilihIndex);
                    task.Serialize(datamu, fileName);
                    break;
                case 4:
                    //Save
                    String data = String.valueOf(datamu);
                    DatagramPacket packet = new DatagramPacket(data.getBytes(), data.length(), addr, SERVICE_PORT);
                    socket.send(packet);
                    socket.close();
                    break;
                case 5:
                    //Show
                    newList = task.print(fileName);
                    System.out.println("List Data : " + newList);
                    break;
                case 6:
                    //Exit
                    System.exit(0);
            }

        }
    }
}
