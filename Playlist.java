package com.javacourse;

import java.util.*;

public class Playlist {

    private String playlistName;
    private ArrayList<Album> albumArrayList;
    private LinkedList<Song> songList;
    private Scanner scanner = new Scanner(System.in);

    public Playlist(String playlistName) {
        this.playlistName = playlistName;
        this.albumArrayList = new ArrayList<Album>();
        this.songList = new LinkedList<Song>();
    }

    private void createAlbum() {
        Album album01 = new Album("JLo (AKA)");
        album01.addSongsToAlbum(new Song("AKA ft TI", 1.0));
        album01.addSongsToAlbum(new Song("First Love", 2.0));
        album01.addSongsToAlbum(new Song("Never Satisfied", 3.0));
        album01.addSongsToAlbum(new Song("Emotions", 4.0));
        album01.addSongsToAlbum(new Song("So Good", 5.0));


        Album album02 = new Album("Enrique Inglesia");
        album02.addSongsToAlbum(new Song("I'm a freak", 1.0));
        album02.addSongsToAlbum(new Song("Bailando", 2.0));
        album02.addSongsToAlbum(new Song("El Perdedor", 3.0));
        album02.addSongsToAlbum(new Song("Hero", 4.0));
        album02.addSongsToAlbum(new Song("Loco", 5.0));

        this.albumArrayList.add(album01);
        this.albumArrayList.add(album02);
    }


    public void printListOfAlbums() {
        createAlbum();

        for (int i = 0; i < this.albumArrayList.size(); i++) {
            System.out.println("\t" + (i + 1) + " " + this.albumArrayList.get(i).getName());
        }
    }

    public void printListOfSongs(Album albums) {

        System.out.println("You have selected : " + albums.getName());

        System.out.println("TRACK NO \t TITLE \t DURATION");
        System.out.println("------------------------------------------");
        for (int i = 0; i < albums.getArrayOfSongs().size(); i++) {
            System.out.printf("%-5d %-20s %-5.2f\n", (i + 1), albums.getArrayOfSongs().get(i).getTitle(), albums.getArrayOfSongs().get(i).getDuration());
        }
    }

    public void addSongsToPlayList(Song theSong) {

        ListIterator<Song> songListIterator = songList.listIterator();

        while(songListIterator.hasNext())
        {
            int comparison = songListIterator.next().getTitle().compareTo(theSong.getTitle());
            if(comparison == 0)
            {
                System.out.println("The song " + theSong.getTitle() + " is already added!");

            }else if(comparison > 0)
            {
                songListIterator.previous();
                songListIterator.add(theSong);
                System.out.println("Song Added!");
            }else if(comparison < 0)
            {
                // let it run
            }
        }
        songListIterator.add(theSong);
    }

    public void printPlayList()
    {
        printMenu();

        ListIterator<Song> j = songList.listIterator();
        int i = 0;
        System.out.println("Playlist Track");

        while(j.hasNext())
        {
            System.out.println("\tSong : (" +j.next().getTitle()+")");
        }
        System.out.println(" ");
    }

    public void runPlaylist(LinkedList<Song> theSongList) {

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        
        ListIterator<Song> listIterator = theSongList.listIterator();

        if (theSongList.isEmpty()) {
            System.out.println("Error: Empty Lists.");
        } else {
            System.out.println("Now Playing " + listIterator.next().getTitle());
           // printPlayList();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Playlist over");
                    quit = true;
                    break;
                case 1:
                    if(!goingForward)
                    {
                        if(listIterator.hasNext())
                        {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now Playing " + listIterator.next().getTitle());
                    } else {
                        System.out.println("End of the list.");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if(goingForward)
                    {
                        if(listIterator.hasPrevious())
                        {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now Playing " +
                                listIterator.previous().getTitle());
                    } else {
                        System.out.println("Start of the list.");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }

    }
    private static void printMenu()
    {
        System.out.println("OPTIONS: \n"+
                "0 - Exit\n" +
                "1 - Next Song.\n" +
                "2 - Previous Song\n" +
                "3 - Print menu");
    }

    public ArrayList<Album> getAlbumArrayList() {
        return albumArrayList;
    }

    public LinkedList<Song> getSongList() {
        return songList;
    }
}
