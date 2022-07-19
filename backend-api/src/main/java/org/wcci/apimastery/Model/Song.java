package org.wcci.apimastery.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @JsonIgnore
    private Album album;
    @OneToMany (mappedBy = "song")
    private Collection<Rating> ratings;

    public Song(String name, int duration, Album album) {
        this.name = name;
        this.duration = duration;
        this.album = album;
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

    public Collection<Rating> getRatings() {
        return ratings;
    }

    public Long getId() {
        return id;
    }


    public void changeName(String newName){
        name = newName;
    }
    public void addAlbum(Album newAlbum){
        album = newAlbum;
    }

}

