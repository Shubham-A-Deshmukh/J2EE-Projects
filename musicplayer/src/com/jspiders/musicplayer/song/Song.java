package com.jspiders.musicplayer.song;

import java.util.Objects;

public class Song {
	private int id;
	private String songName;
	private String duration;
	private String artist;
	
//	Song Constructor
	public Song(int id, String songName, String duration, String artist) {
		super();
		this.id = id;
		this.songName = songName;
		this.duration = duration;
		this.artist = artist;
	}

	
//	to fetch song ID
	public int getId() {
		return id;
	}
	
//	to Set Song ID
	public void setId(int id) {
		this.id = id;
	}
	
//	to Fetch Song name
	public String getSongName() {
		return songName;
	}
	
//	to Set Song Name
	public void setSongName(String songName) {
		this.songName = songName;
	}
	
//	to fetch Duration
	public String getDuration() {
		return duration;
	}
	
//	to Set Duration
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
//	to fetch Artist name
	public String getArtist() {
		return artist;
	}
	
//	to Set artist name
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
   public String allSongs() {
		return   id + ".Song: " + songName + "\n Duration: " + duration + "\n Artist: " + artist+"\n";
   }
	
//	Override toString method
	@Override
	public String toString() {
		return   id + ".Song: " + songName + "\n Duration: " + duration + "\n Artist: " + artist+"\n";
	}
	
//	Override hashCode() method
	@Override
	public int hashCode() {
		return Objects.hash(artist, duration, id, songName);
	}
	
//	Override equals() method
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Song other = (Song) obj;
		return Objects.equals(artist, other.artist) && Objects.equals(duration, other.duration) && id == other.id
				&& Objects.equals(songName, other.songName);
	}
	

}
