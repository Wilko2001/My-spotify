package com.emma.spotify_app;

import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.Track;

import java.io.IOException;

public class SongProcessor {

    private SpotifyController controller;

    public SongProcessor(SpotifyController controller) {
        this.controller = controller;
    }

    public Mood process(Track song) throws IOException, ParseException, SpotifyWebApiException {
        float mood = controller.getMood(song.getId());
        float valence = controller.getValence(song.getId());

        if (mood > 0.5 && valence > 0.5) {
            return Mood.HAPPY;
        } else if (mood < 0.5 && valence < 0.5) {
           return Mood.SAD;
        } else if ()
    }
}
