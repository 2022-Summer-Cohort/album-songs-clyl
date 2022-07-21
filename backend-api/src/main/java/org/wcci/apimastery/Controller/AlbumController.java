package org.wcci.apimastery.Controller;


import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.Model.Album;
import org.wcci.apimastery.Model.Song;
import org.wcci.apimastery.Repository.AlbumRepository;
import org.wcci.apimastery.Repository.RatingRepository;
import org.wcci.apimastery.Repository.SongRepository;

import java.nio.file.Path;

@RestController
public class AlbumController {

    private SongRepository songRepo;
    private AlbumRepository albumRepo;
    private RatingRepository ratingRepo;

    public AlbumController(SongRepository songRepo, AlbumRepository albumRepo, RatingRepository ratingRepo) {
        this.songRepo = songRepo;
        this.albumRepo = albumRepo;
        this.ratingRepo = ratingRepo;
    }

    @GetMapping("/api/albums")
    public Iterable<Album> retrieveAllAlbums(){
        return albumRepo.findAll();
    }

    @GetMapping("/api/albums/{id}")
    public Album retrieveAlbumById(@PathVariable Long id){
        return albumRepo.findById(id).get();
    }

    @PostMapping("/api/albums")
    public Album addAlbum(@RequestBody Album albumToAdd){
        albumRepo.save(albumToAdd);
        return albumToAdd;
    }
    @PostMapping("/api/albums/{id}/addAlbum")
    public Album addToAlbum(@RequestBody Album newAlbum, @PathVariable Long id){
        Song song1 = songRepo.findById(id).get();
        song1.addAlbum(newAlbum);
        return newAlbum;

    }
    @PatchMapping("/api/albums/{id}/title")
    public Album albumToChangeName(@RequestBody String newName, @PathVariable Long id){
        Album albumToChange = albumRepo.findById(id).get();
        albumToChange.changeTitle(newName);
        albumRepo.save(albumToChange);
        return albumToChange;
    }

    @PostMapping("/api/albums/{id}/addSong")
    public Album addSong(@RequestBody Song songToAdd, @PathVariable Long id){
        Album newAlbum = albumRepo.findById(id).get();
        songToAdd.addAlbum(newAlbum);
        songRepo.save(songToAdd);
        return newAlbum;
    }
}
