package org.wcci.apimastery.Controller;


import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.Model.Album;
import org.wcci.apimastery.Model.Song;
import org.wcci.apimastery.Repository.AlbumRepository;
import org.wcci.apimastery.Repository.SongRepository;

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

    @PostMapping("/api/albums/{id}")
    public Iterable<Album> addSong(@RequestBody Album albumToAdd){
        albumRepo.save(albumToAdd);
        return albumRepo.findAll();
    }
}
