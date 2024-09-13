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

//            System.out.println(happyPlaylist);

            System.out.println("How are you feeling today? Please pick a mood that best suits you: ");
            System.out.println("Happy " +
                    "\nSad " +
                    "\nAngry " +
                    "\nConfused " +
                    "\nCalm");

            String userMood = scan.nextLine();

            List<Track> happyPlaylist = new ArrayList<>();
            List<Track> sadPlaylist = new Arraylist<>();
            List<Track> angryPlaylist = new Arraylist<>();
            List<Track> confusedPlaylist = new ArrayList<>();
            List<Track> calmPlaylist = new ArrayList<>();

            if (mood > 0.5 && valence > 0.5) {
                happyPlaylist.add(song);
            }

            switch (userMood) {
                case "Happy": System.out.println(happyPlaylist);
                break;
                case "Sad": System.out.println(sadPlaylist);
                break;
                case "Angry": System.out.println(angryPlaylist);
                break;
                case "Confused": System.out.println(confusedPlaylist);
                break;
                case "Calm": System.out.println(calmPlaylist);
                default:
                    System.out.println("Please choose a mood from the list above.")
            }
//            System.out.println("Here is a playlist I think you might like: " + userMood)

        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}