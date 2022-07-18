package Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Artist {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany (mappedBy = "artist")
    private Collection <Album> albums;

    @OneToMany (mappedBy = "artist")
    private Collection <Song> songs;

    public Artist(){}

    public Artist(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Collection<Album> getAlbums() {
        return albums;
    }

    public Collection<Song> getSongs() {
        return songs;
    }

    public Long getId() {
        return id;
    }
}
