package com.emma.spotify_app;

public enum Mood {
    HAPPY,
    SAD,
    ANGRY,
    CONFUSED,
    CALM

    public static Mood valueOfIgnoreCase(String name) {
        return valueOf(name.toUpperCase());
    }

}
