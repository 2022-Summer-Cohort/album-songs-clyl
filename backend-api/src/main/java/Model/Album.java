package Model;


import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
public class Album{
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @OneToMany(mappedBy = "albums")
    private Collection<Song> songs;
    @ManyToOne
    private Artist artist;
    private String recordLabel;

    private String imgUrl;

    public Album(String title, Artist artist,String imgUrl, String recordLabel, Song...songs) {
        this.title = title;
        this.artist = artist;
        this.imgUrl = imgUrl;
        this.recordLabel = recordLabel;
        this.songs = Set.of(songs);

    }

    public Album(){}

    public String getTitle() {
        return title;
    }

    public Collection<Song> getSongs() {
        return songs;
    }

    public Artist getArtist() {
        return artist;
    }

    public String getRecordLabel() {
        return recordLabel;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(title, album.title) && Objects.equals(artist, album.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, artist);
    }
}
