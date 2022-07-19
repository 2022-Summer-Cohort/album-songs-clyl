package org.wcci.apimastery.Model;


import javax.persistence.*;
import java.util.Collection;

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

    public Long getId() {
        return id;
    }

    public void changeTitle(String newTitle){
        title = newTitle;
    }

}



