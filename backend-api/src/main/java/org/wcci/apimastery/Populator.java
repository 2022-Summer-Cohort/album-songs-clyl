package org.wcci.apimastery;
import org.wcci.apimastery.Model.Rating;
import org.wcci.apimastery.Model.Song;
import org.springframework.boot.CommandLineRunner;
import org.wcci.apimastery.Model.Album;
import org.wcci.apimastery.Repository.AlbumRepository;
import org.wcci.apimastery.Repository.RatingRepository;
import org.wcci.apimastery.Repository.SongRepository;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

@Component
public class Populator implements CommandLineRunner{
    private AlbumRepository albumRepo;
    private SongRepository songRepo;
    private RatingRepository ratingRepo;

    public Populator(AlbumRepository albumRepo, SongRepository songRepo, RatingRepository ratingRepo) {
        this.albumRepo = albumRepo;
        this.songRepo = songRepo;
        this.ratingRepo = ratingRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        Song goodMorning = new Song("Good Morning", 195);
        Song barryBonds = new Song("Barry Bonds", 243);
        Song champion = new Song("Champion", 168);
        Song goodLife = new Song("Good Life", 207);

        Song blackBird = new Song("Black Bird", 138);
        Song rockyRacoon = new Song("Rocky Raccoon", 201);
        Song ObLaDi = new Song("Ob-La-Di, Ob-La-Da", 189);
        Song ussr = new Song("Back in the U.S.S.R.", 163);

        Song fadeAway = new Song("Fade Away", 288);
        Song runIt = new Song("Run It", 201);
        Song likeWoah = new Song("Like Woah", 233);
        Song stainless = new Song("Stainless", 200);

        Song mathematics = new Song("Mathematics", 246);
        Song got = new Song("Got", 208);
        Song habitat = new Song("Habitat", 280);
        Song love = new Song("Love", 283);

        songRepo.save(goodMorning);
        songRepo.save(barryBonds);
        songRepo.save(champion);
        songRepo.save(goodLife);

        Song[] graduationSongs = {goodLife, goodMorning, barryBonds, champion};

//        Collection<Song> graduationSongs = new ArrayList<>(4);
//        graduationSongs.add(goodMorning);
//        graduationSongs.add(barryBonds);
//        graduationSongs.add(champion);
//        graduationSongs.add(goodLife);


        songRepo.save(blackBird);
        songRepo.save(rockyRacoon);
        songRepo.save(ObLaDi);
        songRepo.save(ussr);

        songRepo.save(fadeAway);
        songRepo.save(runIt);
        songRepo.save(likeWoah);
        songRepo.save(stainless);

        songRepo.save(mathematics);
        songRepo.save(got);
        songRepo.save(habitat);
        songRepo.save(love);

        Album graduation = new Album("Graduation", "/images/albumCover.jpg", "Def Jam Roc-A-Fella", graduationSongs);
        Album whiteAlbum = new Album("The White Album", "/images/albumCover.jpg", "Apple", graduationSongs);
        Album incredible = new Album("The Incredible True Story", "/images/albumCover.jpg", "Def Jam", graduationSongs);
        Album blackOnBothSides = new Album("Black on Both Sides", "/images/albumCover.jpg", "Rawkus", graduationSongs);

        albumRepo.save(graduation);
        albumRepo.save(whiteAlbum);
        albumRepo.save(incredible);
        albumRepo.save(blackOnBothSides);

        Rating goodMorningRating = new Rating("Best song on the album by far", 5, goodMorning);
        Rating goodLifeRating = new Rating("Best song on the album by far", 5, goodLife);
        Rating barryBondsRating = new Rating("Best song on the album by far", 5, barryBonds);
        Rating championRating = new Rating("Best song on the album by far", 5, champion);

        Rating blackBirdRating = new Rating("Best song on the album by far", 5, blackBird);
        Rating rockyRacoonRating = new Rating("Best song on the album by far", 5, rockyRacoon);
        Rating obLaDiRating = new Rating("Best song on the album by far", 5, ObLaDi);
        Rating ussrRating = new Rating("Best song on the album by far", 5, ussr);

        Rating fadeAwayRating = new Rating("Best song on the album by far", 5, fadeAway);
        Rating runItRating = new Rating("Best song on the album by far", 5, runIt);
        Rating likeWoahRating = new Rating("Best song on the album by far", 5, likeWoah);
        Rating stainlessRating = new Rating("Best song on the album by far", 5, stainless);

        Rating mathematicsRating = new Rating("Best song on the album by far", 5, mathematics);
        Rating gotRating = new Rating("Best song on the album by far", 5, got);
        Rating habitatRating = new Rating("Best song on the album by far", 5, habitat);
        Rating loveRating = new Rating("Best song on the album by far", 5, love);

        ratingRepo.save(goodMorningRating);
        ratingRepo.save(goodLifeRating);
        ratingRepo.save(barryBondsRating);
        ratingRepo.save(championRating);

        ratingRepo.save(blackBirdRating);
        ratingRepo.save(rockyRacoonRating);
        ratingRepo.save(obLaDiRating);
        ratingRepo.save(ussrRating);

        ratingRepo.save(fadeAwayRating);
        ratingRepo.save(runItRating);
        ratingRepo.save(likeWoahRating);
        ratingRepo.save(stainlessRating);

        ratingRepo.save(mathematicsRating);
        ratingRepo.save(gotRating);
        ratingRepo.save(habitatRating);
        ratingRepo.save(loveRating);





    }
}


