package org.wcci.apimastery.Controller;


import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.Model.Album;
import org.wcci.apimastery.Model.Song;
import org.wcci.apimastery.Repository.AlbumRepository;
import org.wcci.apimastery.Repository.SongRepository;

import java.nio.file.Path;

@RestController
public class AlbumController {

    private SongRepository songRepo;
    private AlbumRepository albumRepo;

    public AlbumController(SongRepository songRepo, AlbumRepository albumRepo) {
        this.songRepo = songRepo;
        this.albumRepo = albumRepo;
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
}
