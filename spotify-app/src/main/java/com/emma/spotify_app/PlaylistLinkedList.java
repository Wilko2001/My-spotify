package com.emma.spotify_app;

public class PlaylistLinkedList {
    // the head is the first node in the list, it is null by default
    private Node head;

    public void addSong(Song song) {
        Node newNode = new Node(song);
        if (head == null){
            head = newNode;
        } else {
            // this goes through the list and finds the last node (current.next) then adds the new node at the end.
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void displayPlaylist() {
        Node current = head;
        while (current != null) {
            System.out.println(current.song);
            current = current.next;
        }
    }

    public void middlePlayList() {
        Node slowPtr = head;
        Node fastPtr = head;

        if (head != null) {
            while (fastPtr != null && fastPtr.next != null) {
                fastPtr = fastPtr.next.next;
                slowPtr = slowPtr.next;
            }
            System.out.println("The middle element is: " + slowPtr.song);
        }
    }
}
