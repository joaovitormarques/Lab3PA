
package lab3pa;

/**
 *
 * @author João Vitor Marques
 */
public class Rating {
    int userId, movieId, rating, timeStamp;
    public Rating(int user, int movie, int rate, int ts){
        this.movieId = movie;
        this.rating = rate;
        this.timeStamp = ts;
        this.userId = user;
    }
}
