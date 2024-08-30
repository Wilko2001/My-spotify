package com.emma.spotify_app;

import io.github.cdimascio.dotenv.Dotenv;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.model_objects.specification.Track;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;

public class SpotifyController {
    private final Dotenv dotenv = Dotenv.load();
    private final String clientId = dotenv.get("SPOTIFY_CLIENT_ID");
    private final String clientSecret = dotenv.get("SPOTIFY_CLIENT_SECRET");

    private String clientToken;
    private SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setClientId(clientId)
            .setClientSecret(clientSecret)
            .build();

    private final ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials()
            .build();
    public SpotifyController() {
        clientCredentials_Sync();
    }

    public Track getSong(String trackId) throws IOException, ParseException, SpotifyWebApiException {
        return spotifyApi.getTrack(trackId).build().execute();
    }
    public Float getMood(String track) throws IOException, ParseException, SpotifyWebApiException {
        return spotifyApi.getAudioFeaturesForTrack(track).build().execute().getEnergy();
    }

    public Float getValence(String track) throws IOException, ParseException, SpotifyWebApiException {
        return spotifyApi.getAudioFeaturesForTrack(track).build().execute().getValence();
    }
    // Handles the client credentials authentication with the spotify api, it requests the access token. sets it in spotifyApi instance,
    //and prints the token.
    private void clientCredentials_Sync() {
        System.out.println("Starting client credentials sync...");
        try {
            final ClientCredentials clientCredentials = clientCredentialsRequest.execute();

            spotifyApi.setAccessToken(clientCredentials.getAccessToken());
            System.out.println("Access token: " + clientCredentials.getAccessToken());
            clientToken = clientCredentials.getAccessToken();
            spotifyApi.setAccessToken(clientCredentials.getAccessToken());
        } catch (

                IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
