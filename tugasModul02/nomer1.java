/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasModul02;

import java.io.IOException;
//Write
import java.io.FileWriter;
import java.io.BufferedWriter;
//Read
//import java.io.FileReader;
//import java.io.BufferedReader;

/**
 *
 * @author MNW
 */
public class nomer1 {

    public static void main(String[] args) throws IOException {
        //bikin file baru
        try {
            FileWriter fw = new FileWriter("E:\\fileAwal.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Ini Teks Awal");
            bw.close();
            System.out.println("berhasil membuat");
        } catch (Exception e) {
            System.out.println("gagal");
        }
        //Mengcopy isi file
//        FileReader fr = new FileReader("E:/fileCopy.txt");
//        BufferedReader br = new BufferedReader(fr);
//        FileWriter fw = new FileWriter("E:\\fileBaru.txt");
//        BufferedWriter bw = new BufferedWriter(fw);
//        String line;
//        line = br.readLine();
//        while (line != null) {
//            try {
//                bw.write(line, 0, line.length());
//                bw.newLine();
//                line = br.readLine();
//                System.out.println("Sukses Dicopy");
//            } catch (Exception e) {
//                System.out.println("Gagal Dicopy");
//            }
//        }
    }
}
