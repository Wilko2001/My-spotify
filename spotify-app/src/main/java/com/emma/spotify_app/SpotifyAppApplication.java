// declares the package name for the class

// Convert the track to a list of ids
// Use the ids to get the audio features for the tracks using getAudioFeaturesForSeveralTracks, this will return you a list of AudioFeatures objects
// Pass in AudioFeature object to a processor class to return a mood
// Use mood to sort out each song to its own playlist and print to user

package com.emma.spotify_app;

import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import org.apache.hc.core5.http.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.michaelthelin.spotify.model_objects.specification.Track;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


import java.io.IOException;

import static com.emma.spotify_app.Mood.*;

@SpringBootApplication
public class SpotifyAppApplication {
    public static void main(String[] args) throws IOException, ParseException, SpotifyWebApiException {
        SpringApplication.run(SpotifyAppApplication.class, args);

        SpotifyController controller = new SpotifyController();
        Scanner scan = new Scanner(System.in);

        try {
            Track song = controller.getSong("5QpjkwvagLUbiqbhD71UCh");
            System.out.println(controller.getAlbumTracks("4aawyAB9vmqN3uQ7FjRGTy"));
//            SongProcessor proc = new SongProcessor();
//            var mood = proc.process(song);

            float mood = controller.getMood(song.getId());
            float valence = controller.getValence(song.getId());

//            System.out.println(happyPlaylist);

//            System.out.println("How are you feeling today? Please pick a mood that best suits you: ");
//            System.out.println("Happy " +
//                    "\nSad " +
//                    "\nAngry " +
//                    "\nConfused " +
//                    "\nCalm");
//
//            String userMood = scan.nextLine();
//            HashMap<Mood, List<Track>> mapOfMoodToPlaylist = new HashMap<>();

//            mapOfMoodToPlaylist.get(mood).add(song);



            List<Track> happyPlaylist = new ArrayList<>();
            List<Track> sadPlaylist = new ArrayList<>();
            List<Track> angryPlaylist = new ArrayList<>();
            List<Track> confusedPlaylist = new ArrayList<>();
            List<Track> calmPlaylist = new ArrayList<>();

//            switch (Mood.valueOfIgnoreCase(userMood)) {
//                case HAPPY: System.out.println(happyPlaylist);
//                break;
//                case SAD: System.out.println(sadPlaylist);
//                break;
//                case ANGRY: System.out.println(angryPlaylist);
//                break;
//                case CONFUSED: System.out.println(confusedPlaylist);
//                break;
//                case CALM: System.out.println(calmPlaylist);
//                default:
//                    System.out.println("Please choose a mood from the list above.");
//            }
//            System.out.println("Here is a playlist I think you might like: " + userMood)

        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}