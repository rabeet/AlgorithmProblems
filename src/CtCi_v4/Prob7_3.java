package CtCi_v4;

import java.util.List;
import java.util.Random;

public class Prob7_3 {
	
	/*
	 * 7.3:	Design a musical juke box using OOPs.
	 * Methods: play, pause, getNextSong, getPrevSong, addSong, turnOn, turnOff, readSongsFromSource
	 * Variables: 
	 * 	MODE: repeat_current, repeat_all, shuffle_all, none
	 * 	SongList: List of Songs
	 * 	Int songsPlayed: # of songs played
	 * 	currentSong: being played
	 * 
	 * Song class:
	 * 	Song name, artist info, album, etc.
	 * 
	 */
	
	static class JukeBox {
		enum MODE {
			REPEAT_CURRENT, REPEAT_ALL, SHUFFLE_ALL, NONE;
		}
		
		// Variables
		private MODE mode = MODE.NONE;
		private List<Song> songList;
		private List<Song> songsPlayed;
		private int numOfSongsPlayed;
		private Song currentSong;
		
		// Methods
		void play() {
			// play the song
		}
		
		void pause() {
			// pause the song
		}
		
		void changeMode(MODE mode) {
			this.mode = mode;
		}
		
		Song getNextSong() {
			switch (mode) {
			case REPEAT_CURRENT:
				return currentSong;
			case REPEAT_ALL:
				if (numOfSongsPlayed == songList.size()-1) {
					return songList.get(0);
				} else {
					return songList.get(++numOfSongsPlayed);
				}
			case SHUFFLE_ALL:
				// randomly select a song from the list
				// have to check which songs have been already played
				// using the songsPlayed variable
				Random random = new Random();
				int songnum = random.nextInt(songList.size());
				return songList.get(songnum);
			case NONE:
			default:
				return numOfSongsPlayed < songList.size() ? songList.get(++numOfSongsPlayed) : null;
			}
		}
		
		Song getPrevSong() {
			return songsPlayed.isEmpty() ? null : songsPlayed.get(songsPlayed.size()-1);
		}
		
		void addSong(Song song) {
			// add new song to list
		}
		
		void readSongsFromSource(){
			// read from source
		}
		
		// Constructors
	}
	
	class Song {
		String name;
		String artist;
		String album;
		String runtime;
		
		// constructors and getters/setters
	}
}
