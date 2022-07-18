package Model;


import javax.persistence.*;
import java.util.Collection;

@Entity
public class Song {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int duration;
    @ManyToOne
    private Album album;
    @ManyToOne
    private Artist artist;
    @OneToMany (mappedBy = "song")
    private Collection<Rating> ratings;

    public Song(String name, int duration, Album album, Artist artist) {
        this.name = name;
        this.duration = duration;
        this.album = album;
        this.artist = artist;
    }

    public Song(){}

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public Album getAlbum() {
        return album;
    }

    public Artist getArtist() {
        return artist;
    }

    public Collection<Rating> getRatings() {
        return ratings;
    }

    public Long getId() {
        return id;
    }
}

