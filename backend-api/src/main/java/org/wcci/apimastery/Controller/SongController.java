package org.wcci.apimastery.Controller;

import org.wcci.apimastery.Model.Album;
import org.wcci.apimastery.Model.Song;
import org.wcci.apimastery.Repository.AlbumRepository;
import org.wcci.apimastery.Repository.SongRepository;
import org.springframework.web.bind.annotation.*;


@RestController
public class SongController {

    private SongRepository songRepo;
    private AlbumRepository albumRepo;

    public SongController(SongRepository songRepo, AlbumRepository albumRepo ){
        this.songRepo = songRepo;
        this.albumRepo = albumRepo;
    }

    @GetMapping("/api/songs")
    public Iterable<Song> retrieveAllSongs(){
        return songRepo.findAll();
    }

    @GetMapping("/api/songs/{id}")
    public Song retrieveSongById(@PathVariable Long id){
        return songRepo.findById(id).get();
    }


    @PostMapping("/api/songs")
    public Song addSong(@RequestBody Song songToAdd){
        songRepo.save(songToAdd);
        return songToAdd;
    }

    @PatchMapping("/api/songs/{id}/name")
    public Song songToChangeName(@RequestBody String newName, @PathVariable Long id){
        Song songToChange = songRepo.findById(id).get();
        songToChange.changeName(newName);
        songRepo.save(songToChange);
        return songToChange;
    }



}
