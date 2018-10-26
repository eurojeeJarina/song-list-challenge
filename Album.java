package com.javacourse;

import java.util.ArrayList;

public class Album {

    private String name;
    private ArrayList<Song> arrayOfSongs;

    public Album(String name) {
        this.name = name;
        this.arrayOfSongs = new ArrayList<Song>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Song> getArrayOfSongs() {
        return arrayOfSongs;
    }

    public void addSongsToAlbum(Song theSong) {
        this.arrayOfSongs.add(theSong);
    }

    public void displaySongs(){
        for(int i=0; i<this.arrayOfSongs.size(); i++)
        {
            System.out.println("Song #" + (i+1) + " Title :[" + this.arrayOfSongs.get(i).getTitle() +
                    "] Duration : [" + this.arrayOfSongs.get(i).getDuration() + "]");
        }
    }
}
