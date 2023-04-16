package com.jspiders.musicplayer.operations;
import java.util.ArrayList;
import com.jspiders.musicplayer.song.*;
public interface OperationInterface {
	public void playAll();
	public void playRandom();
	public void chooseSong();
	public void addSong();
	public void removeSong(int uid); 
	public void viewAllSongs();
	public void editSong();
}
