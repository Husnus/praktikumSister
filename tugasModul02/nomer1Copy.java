/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasModul02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author MNW
 */
public class nomer1Copy {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        //Mengcopy isi file
        FileReader fr = new FileReader("e:/fileCopy.txt");
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter("e:/fileAwal.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        String line;
        line = br.readLine();
        try {
            bw.write(line, 0, line.length());
            bw.newLine();
            System.out.println("data berhasil di copy");
        } catch (Exception e) {
            System.out.println("data gagal di copy");
        }

        br.close();
        bw.close();
    }
}
