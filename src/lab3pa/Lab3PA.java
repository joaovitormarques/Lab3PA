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

    //função que retorna o número truncado
    public static double trunca(double y) {
        if (y - Math.floor(y) >= 0.5) {
            return Math.ceil(y);
        }
        return Math.floor(y);
    }

    //classificador de arvore de decisão com base nas informações dos usuários
    public static double classificacaoGeral(Map<Integer, Rating> avaliacoes, Map<Integer, User> usuarios, Movie filme, double minhaNota) {
        double nota = 0;
        int n = 0;
        double relevancia = 1, totalRelevancia = 0;
        for (Rating avaliacao : avaliacoes.values()) {
            if (avaliacao.movieId == filme.id) {
                relevancia = 1;

                //calcula a relevancia de acordo com o perfil do usuario
                if (usuarios.get(avaliacao.userId).gender == usuarios.get(6041).gender) {
                    relevancia += Math.abs(minhaNota - avaliacoes.get(avaliacao.userId * 10000 + avaliacao.movieId).rating)/10;
                }
                else relevancia -= Math.abs(minhaNota - avaliacoes.get(avaliacao.userId * 10000 + avaliacao.movieId).rating)/10;
                
                
                if (usuarios.get(avaliacao.userId).age == 1) {
                    relevancia += Math.abs(minhaNota - avaliacoes.get(avaliacao.userId * 10000 + avaliacao.movieId).rating)/10;
                }
                if (usuarios.get(avaliacao.userId).age == 18) {
                    relevancia += Math.abs(minhaNota - avaliacoes.get(avaliacao.userId * 10000 + avaliacao.movieId).rating)/7;
                }
                if (usuarios.get(avaliacao.userId).age == 25) {
                    relevancia += Math.abs(minhaNota - avaliacoes.get(avaliacao.userId * 10000 + avaliacao.movieId).rating)/10;
                }
                if (usuarios.get(avaliacao.userId).age == 35) {
                    relevancia -= Math.abs(minhaNota - avaliacoes.get(avaliacao.userId * 10000 + avaliacao.movieId).rating)/10;
                }
                if (usuarios.get(avaliacao.userId).age == 45) {
                    relevancia -= Math.abs(minhaNota - avaliacoes.get(avaliacao.userId * 10000 + avaliacao.movieId).rating)/10;
                }
                if (usuarios.get(avaliacao.userId).age == 50) {
                    relevancia -= Math.abs(minhaNota - avaliacoes.get(avaliacao.userId * 10000 + avaliacao.movieId).rating)/7;
                }
                if (usuarios.get(avaliacao.userId).age == 56) {
                    relevancia -= Math.abs(minhaNota - avaliacoes.get(avaliacao.userId * 10000 + avaliacao.movieId).rating)/7;
                }
                
                
                if (usuarios.get(avaliacao.userId).occupation == 0) {
                    relevancia -= 0;
                }
                if (usuarios.get(avaliacao.userId).occupation == 1) {
                    relevancia += Math.abs(minhaNota - avaliacoes.get(avaliacao.userId * 10000 + avaliacao.movieId).rating)/10;
                }
                if (usuarios.get(avaliacao.userId).occupation == 2) {
                    relevancia -= Math.abs(minhaNota - avaliacoes.get(avaliacao.userId * 10000 + avaliacao.movieId).rating)/8;
                }
                if (usuarios.get(avaliacao.userId).occupation == 3) {
                    relevancia -= Math.abs(minhaNota - avaliacoes.get(avaliacao.userId * 10000 + avaliacao.movieId).rating)/10;
                }
                if (usuarios.get(avaliacao.userId).occupation == 4) {
                    relevancia += Math.abs(minhaNota - avaliacoes.get(avaliacao.userId * 10000 + avaliacao.movieId).rating)/7;
                }
                if (usuarios.get(avaliacao.userId).occupation == 5) {
                    relevancia += Math.abs(minhaNota - avaliacoes.get(avaliacao.userId * 10000 + avaliacao.movieId).rating)/10;
                }
                if (usuarios.get(avaliacao.userId).occupation == 6) {
                    relevancia += Math.abs(minhaNota - avaliacoes.get(avaliacao.userId * 10000 + avaliacao.movieId).rating)/8;
                }
                if (usuarios.get(avaliacao.userId).occupation == 7) {
                    relevancia += Math.abs(minhaNota - avaliacoes.get(avaliacao.userId * 10000 + avaliacao.movieId).rating)/8;
                }
                if (usuarios.get(avaliacao.userId).occupation == 8) {
                    relevancia -= Math.abs(minhaNota - avaliacoes.get(avaliacao.userId * 10000 + avaliacao.movieId).rating)/7;
                }
                if (usuarios.get(avaliacao.userId).occupation == 9) {
                    relevancia -= Math.abs(minhaNota - avaliacoes.get(avaliacao.userId * 10000 + avaliacao.movieId).rating)/8;
                }
                if (usuarios.get(avaliacao.userId).occupation == 10) {
                    relevancia += Math.abs(minhaNota - avaliacoes.get(avaliacao.userId * 10000 + avaliacao.movieId).rating)/10;
                }
                if (usuarios.get(avaliacao.userId).occupation == 11) {
                    relevancia += Math.abs(minhaNota - avaliacoes.get(avaliacao.userId * 10000 + avaliacao.movieId).rating)/10;
                }
                if (usuarios.get(avaliacao.userId).occupation == 12) {
                    relevancia += Math.abs(minhaNota - avaliacoes.get(avaliacao.userId * 10000 + avaliacao.movieId).rating)/7;
                }
                if (usuarios.get(avaliacao.userId).occupation == 13) {
                    relevancia -= Math.abs(minhaNota - avaliacoes.get(avaliacao.userId * 10000 + avaliacao.movieId).rating)/10;
                }
                if (usuarios.get(avaliacao.userId).occupation == 14) {
                    relevancia -= Math.abs(minhaNota - avaliacoes.get(avaliacao.userId * 10000 + avaliacao.movieId).rating)/10;
                }
                if (usuarios.get(avaliacao.userId).occupation == 15) {
                    relevancia -= Math.abs(minhaNota - avaliacoes.get(avaliacao.userId * 10000 + avaliacao.movieId).rating)/8;
                }
                if (usuarios.get(avaliacao.userId).occupation == 16) {
                    relevancia += Math.abs(minhaNota - avaliacoes.get(avaliacao.userId * 10000 + avaliacao.movieId).rating)/10;
                }
                if (usuarios.get(avaliacao.userId).occupation == 17) {
                    relevancia += Math.abs(minhaNota - avaliacoes.get(avaliacao.userId * 10000 + avaliacao.movieId).rating)/7;
                }
                if (usuarios.get(avaliacao.userId).occupation == 18) {
                    relevancia += Math.abs(minhaNota - avaliacoes.get(avaliacao.userId * 10000 + avaliacao.movieId).rating)/10;
                }
                if (usuarios.get(avaliacao.userId).occupation == 19) {
                    relevancia -= Math.abs(minhaNota - avaliacoes.get(avaliacao.userId * 10000 + avaliacao.movieId).rating)/8;
                }
                if (usuarios.get(avaliacao.userId).occupation == 20) {
                    relevancia -= Math.abs(minhaNota - avaliacoes.get(avaliacao.userId * 10000 + avaliacao.movieId).rating)/10;
                }

                totalRelevancia += relevancia;
                nota += avaliacao.rating * relevancia;
                n++;
            }
        }
        if (n > 0) {
            nota = nota / totalRelevancia; //é a média ponderada das avaliações que os usuários deram praquele filme
        } else {
            return 0;
        }
        if (nota > 5) {
            nota = 5;
        }
        if (nota < 0) {
            nota = 0;
        }
        return trunca(nota);
    }

    //classificador a priori(só classifica pelos gêneros do filme)
    public static double classificacaoPriori(Movie filme) {
        double nota = 2.5;
        String[] generos;
        generos = filme.genre.split("[|]");
        for (String palavra : generos) {
            if ("Action".equals(palavra)) {
                nota += 1.2;
            }
            if ("Adventure".equals(palavra)) {
                nota += 0.9;
            }
            if ("Animation".equals(palavra)) {
                nota += 0;
            }
            if ("Children's".equals(palavra)) {
                nota -= 0.5;
            }
            if ("Comedy".equals(palavra)) {
                nota += 0.9;
            }
            if ("Crime".equals(palavra)) {
                nota += 1.5;
            }
            if ("Documentary".equals(palavra)) {
                nota += 0.3;
            }
            if ("Drama".equals(palavra)) {
                nota += 0.6;
            }
            if ("Fantasy".equals(palavra)) {
                nota += 0;
            }
            if ("Film-Noir".equals(palavra)) {
                nota += 0.3;
            }
            if ("Horror".equals(palavra)) {
                nota -= 1.5;
            }
            if ("Musical".equals(palavra)) {
                nota -= 0.7;
            }
            if ("Mystery".equals(palavra)) {
                nota -= 0.9;
            }
            if ("Romance".equals(palavra)) {
                nota -= 0.7;
            }
            if ("Sci-Fi".equals(palavra)) {
                nota += 0.6;
            }
            if ("Thriller".equals(palavra)) {
                nota -= 1;
            }
            if ("War".equals(palavra)) {
                nota += 0.7;
            }
            if ("Western".equals(palavra)) {
                nota -= 0.7;
            }
        }
        if (nota > 5) {
            nota = 5;
        }
        if (nota < 0) {
            nota = 0;
        }
        return trunca(nota);
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {

        //armazenando as informções dos usuários
        FileReader file = new FileReader(new File("users.dat"));
        BufferedReader br = new BufferedReader(file);
        String[] atributos;
        Map<Integer, User> usuarios = new HashMap<>();

        User auxUser;

        String temp = br.readLine();
        while (temp != null) {
            atributos = temp.split("::");
            auxUser = new User(Integer.parseInt(atributos[0]), atributos[1].charAt(0), Integer.parseInt(atributos[2]), Integer.parseInt(atributos[3]));
            usuarios.put(Integer.parseInt(atributos[0]), auxUser);
            temp = br.readLine();
        }
        file.close();

        //me colocando no banco de usuarios para posterior aprendizagem
        auxUser = new User(6041, 'M', 18, 4);
        usuarios.put(6041, auxUser);

        //armazenando as informações dos filmes
        FileReader file2 = new FileReader(new File("movies.dat"));
        BufferedReader br2 = new BufferedReader(file2);
        String[] atributos2;
        Map<Integer, Movie> filmes = new HashMap<>();
        Movie auxMovie;

        String temp2 = br2.readLine();
        while (temp2 != null) {
            atributos2 = temp2.split("::");
            auxMovie = new Movie(Integer.parseInt(atributos2[0]), atributos2[1], atributos2[2]);
            filmes.put(Integer.parseInt(atributos2[0]), auxMovie);
            temp2 = br2.readLine();
        }
        file2.close();

        //armazenando as informações das avaliações
        FileReader file3 = new FileReader(new File("ratings.dat"));
        BufferedReader br3 = new BufferedReader(file3);
        String[] atributos3;
        Map<Integer, Rating> avaliacoes = new HashMap<>();
        Rating auxRating;

        String temp3 = br3.readLine();
        while (temp3 != null) {
            atributos3 = temp3.split("::");
            auxRating = new Rating(Integer.parseInt(atributos3[0]), Integer.parseInt(atributos3[1]), Integer.parseInt(atributos3[2]), Integer.parseInt(atributos3[3]));
            avaliacoes.put(Integer.parseInt(atributos3[0]) * 10000 + Integer.parseInt(atributos3[1]), auxRating);
            temp3 = br3.readLine();
        }
        file3.close();

        //classificação a priori dos meus 10 filmes:
        /*
         System.out.println(filmes.get(2).title + " " + classificacaoPriori(filmes.get(2)));
         System.out.println(filmes.get(44).title + " " + classificacaoPriori(filmes.get(44)));
         System.out.println(filmes.get(296).title + " " + classificacaoPriori(filmes.get(296)));
         System.out.println(filmes.get(480).title + " " + classificacaoPriori(filmes.get(480)));
         System.out.println(filmes.get(858).title + " " + classificacaoPriori(filmes.get(858)));
         System.out.println(filmes.get(1101).title + " " + classificacaoPriori(filmes.get(1101)));
         System.out.println(filmes.get(1205).title + " " + classificacaoPriori(filmes.get(1205)));
         System.out.println(filmes.get(1580).title + " " + classificacaoPriori(filmes.get(1580)));
         System.out.println(filmes.get(2571).title + " " + classificacaoPriori(filmes.get(2571)));
         System.out.println(filmes.get(3404).title + " " + classificacaoPriori(filmes.get(3404)));
         */
        //classificação baseado em árvore decisão dos meus 10 filmes
        System.out.println(filmes.get(2).title + " " + classificacaoGeral(avaliacoes, usuarios, filmes.get(2), 4));
        System.out.println(filmes.get(44).title + " " + classificacaoGeral(avaliacoes, usuarios, filmes.get(44), 2));
        System.out.println(filmes.get(296).title + " " + classificacaoGeral(avaliacoes, usuarios, filmes.get(296), 4));
        System.out.println(filmes.get(480).title + " " + classificacaoGeral(avaliacoes, usuarios, filmes.get(480), 3));
        System.out.println(filmes.get(858).title + " " + classificacaoGeral(avaliacoes, usuarios, filmes.get(858), 4));
        System.out.println(filmes.get(1101).title + " " + classificacaoGeral(avaliacoes, usuarios, filmes.get(1101), 4));
        System.out.println(filmes.get(1205).title + " " + classificacaoGeral(avaliacoes, usuarios, filmes.get(1205), 2));
        System.out.println(filmes.get(1580).title + " " + classificacaoGeral(avaliacoes, usuarios, filmes.get(1580), 3));
        System.out.println(filmes.get(2571).title + " " + classificacaoGeral(avaliacoes, usuarios, filmes.get(2571), 4));
        System.out.println(filmes.get(3404).title + " " + classificacaoGeral(avaliacoes, usuarios, filmes.get(3404), 3));
    }

}
