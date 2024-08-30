// declares the package name for the class
package com.emma.spotify_app;

import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import org.apache.hc.core5.http.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.michaelthelin.spotify.model_objects.specification.Track;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


import java.io.IOException;

@SpringBootApplication
public class SpotifyAppApplication {
    public static void main(String[] args) throws IOException, ParseException, SpotifyWebApiException {
        SpringApplication.run(SpotifyAppApplication.class, args);

        SpotifyController controller = new SpotifyController();
        Scanner scan = new Scanner(System.in);

        try {
            Track song = controller.getSong("5QpjkwvagLUbiqbhD71UCh");

            float mood = controller.getMood(song.getId());
            float valence = controller.getValence(song.getId());

            List<Track> happyPlaylist = new ArrayList<>();
            if (mood > 0.5 && valence > 0.5) {
                happyPlaylist.add(song);
            }
//            System.out.println(happyPlaylist);

            System.out.println("How are you feeling today? Please pick a mood that best suits you: ");
            System.out.println("Happy " +
                    "\nSad " +
                    "\nAngry " +
                    "\nConfused " +
                    "\nCalm");

            String userMood = scan.nextLine();

            switch (userMood) {
                case "Happy": System.out.println(happyPlaylist);
            }
//            System.out.println("Here are some songs I think you might like: " + )

        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}