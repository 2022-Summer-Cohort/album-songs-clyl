package org.wcci.apimastery.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.wcci.apimastery.Repository.SongRepository;

import javax.persistence.*;
import java.util.ArrayList;
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
    @OneToMany (mappedBy = "song")
    private Collection<Rating> ratings;

    public Song(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public Song(){}

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public Collection<Rating> getRatings() {
        return ratings;
    }

    public Long getId() {
        return id;
    }

    public Album getAlbum() {
        return album;
    }

    public void changeName(String newName){
        name = newName;
    }

}

