package com.emma.spotify_app;

public class Node {
    Song song;
    Node next;

    public Node(Song song) {
        this.song = song;
        this.next = null;
    }
}
