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

    @Override
    public int hashCode() {
        return title.hashCode() + album.hashCode() + artist.hashCode() + album.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}