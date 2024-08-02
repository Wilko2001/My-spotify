// declares the package name for the class
package com.emma.spotify_app;

import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import org.apache.hc.core5.http.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.IOException;

@SpringBootApplication
public class SpotifyAppApplication {
    public static void main(String[] args) throws IOException, ParseException, SpotifyWebApiException {
        SpringApplication.run(SpotifyAppApplication.class, args);
        try {
            System.out.println(new SpotifyController().getSong("5QpjkwvagLUbiqbhD71UCh"));
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
        System.out.println(new SpotifyController().getMood("5QpjkwvagLUbiqbhD71UCh"));

        PlaylistLinkedList playlist = new PlaylistLinkedList();

        playlist.addSong(new Song("High Hopes", "Gentlemens Dub Club", "High Hopes", "https://open.spotify.com/playlist/44szbwVTGjGOMZVsan77Dx?si=a9aad07d33f742cf"));
        playlist.addSong(new Song("Rat-at-at", "Skints", "Part & Parcel", "https://open.spotify.com/playlist/44szbwVTGjGOMZVsan77Dx?si=a9aad07d33f742cf"));
        playlist.addSong(new Song("Nowhere else to go", "Too Many Zooz", "Retail Therapy", "https://open.spotify.com/playlist/44szbwVTGjGOMZVsan77Dx?si=a9aad07d33f742cf"));


        playlist.displayPlaylist();
    }
}