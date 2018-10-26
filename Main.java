package com.javacourse;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Playlist playlist = new Playlist("My PlayList");
        playlist.printListOfAlbums();

        playlist.addSongsToPlayList(playlist.getAlbumArrayList().get(0).getArrayOfSongs().get(0));
        playlist.addSongsToPlayList(playlist.getAlbumArrayList().get(0).getArrayOfSongs().get(1));
        playlist.addSongsToPlayList(playlist.getAlbumArrayList().get(0).getArrayOfSongs().get(2));

        playlist.printPlayList();

        playlist.runPlaylist(playlist.getSongList());
    }
}
