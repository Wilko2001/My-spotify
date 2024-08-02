package com.emma.spotify_app;

public class Song {
    String title;
    String artist;
    String album;
    String spotifyUrl;

    public Song(String title, String artist, String album, String spotifyUrl) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.spotifyUrl = spotifyUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public String getSpotifyUrl() {
        return spotifyUrl;
    }

    @Override
    public String toString() {
        return title + " by " + artist + " from the album " + album + " ( " + spotifyUrl + " ) ";
    }
}