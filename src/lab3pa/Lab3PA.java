
package lab3pa;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author João Vitor Marques
 */
public class Lab3PA {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileReader file = new FileReader(new File("users.dat"));
        BufferedReader br = new BufferedReader(file);
        String temp = br.readLine();
        while (temp != null) {
            System.out.println(temp);
            temp = br.readLine();
        }
    }
}
