package lab3pa;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author João Vitor Marques
 */
public class Lab3PA {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        //armazenando as informções dos usuários
        FileReader file = new FileReader(new File("users.dat"));
        BufferedReader br = new BufferedReader(file);
        String[] atributos;
        Map<Integer, User> usuarios = new HashMap<>();

        User auxUser;

        String temp = br.readLine();
        while (temp != null) {
            //System.out.println(temp);//depois tira
            atributos = temp.split("::");
            auxUser = new User(Integer.parseInt(atributos[0]), atributos[1].charAt(0), Integer.parseInt(atributos[2]), Integer.parseInt(atributos[3]));
            usuarios.put(Integer.parseInt(atributos[0]), auxUser);
            temp = br.readLine();
        }
        file.close();
        System.out.println(usuarios.get(4953).occupation);

        //armazenando as informações dos filmes
        FileReader file2 = new FileReader(new File("movies.dat"));
        BufferedReader br2 = new BufferedReader(file2);
        String[] atributos2;
        Map<Integer, Movie> filmes = new HashMap<>();
        Movie auxMovie;

        String temp2 = br2.readLine();
        while (temp2 != null) {
            //System.out.println(temp);//depois tira
            atributos2 = temp2.split("::");
            auxMovie = new Movie(Integer.parseInt(atributos2[0]), atributos2[1], atributos2[2]);
            filmes.put(Integer.parseInt(atributos2[0]), auxMovie);
            temp2 = br2.readLine();
        }
        file2.close();
        System.out.println(filmes.get(1212).title);

        //armazenando as informações das avaliações
        FileReader file3 = new FileReader(new File("ratings.dat"));
        BufferedReader br3 = new BufferedReader(file3);
        String[] atributos3;
        Map<Integer, Rating> avaliacoes = new HashMap<>();
        Rating auxRating;

        String temp3 = br3.readLine();
        while (temp3 != null) {
            //System.out.println(temp);//depois tira
            atributos3 = temp3.split("::");
            auxRating = new Rating(Integer.parseInt(atributos3[0]), Integer.parseInt(atributos3[1]), Integer.parseInt(atributos3[2]), Integer.parseInt(atributos3[3]));
            avaliacoes.put(Integer.parseInt(atributos3[0])*10000 + Integer.parseInt(atributos3[1]), auxRating);
            temp3 = br3.readLine();
        }
        file3.close();
        System.out.println(avaliacoes.get(40581792).timeStamp);
    }

}
