package org.wcci.apimastery.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

@Entity
public class Album {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @OneToMany(mappedBy = "album")
    private Collection<Song> songs;
    private String recordLabel;

    private String imgUrl;

    public Album(String title, String imgUrl, String recordLabel) {
        this.title = title;
        this.imgUrl = imgUrl;
        this.recordLabel = recordLabel;

    }

    public Album() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Collection<Song> getSongs() {
        return songs;
    }

    public String getRecordLabel() {
        return recordLabel;
    }

    public String getImgUrl() {
        return imgUrl;
    }

//    public void addSongToAlbum(Song songToAdd){
//        songs.add(songToAdd);
//    }
    public void changeTitle(String newTitle){
        title = newTitle;
    }
}



