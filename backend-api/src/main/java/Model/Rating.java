package Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Rating {
    @Id
    @GeneratedValue

    private Long id;
    private String review;
    private int rating;
    @ManyToOne
    private Song song;

    public Rating(String review, int rating, Song song) {
        this.review = review;
        this.rating = rating;
        this.song = song;
    }

    public Rating(){}

    public String getReview() {
        return review;
    }

    public int getRating() {
        return rating;
    }

    public Song getSong() {
        return song;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating1 = (Rating) o;
        return rating == rating1.rating && Objects.equals(review, rating1.review) && Objects.equals(song, rating1.song);
    }

    @Override
    public int hashCode() {
        return Objects.hash(review, rating, song);
    }
}
