package com.jspiders.musicplayer.operations;

import java.util.Iterator;
import java.util.Scanner;

import com.jspiders.musicplayer.main.MusicPlayer;
import com.jspiders.musicplayer.song.Song;

public class SongOperation implements OperationInterface {

	MusicPlayer m = new MusicPlayer();
	Scanner sc = new Scanner(System.in);

	@Override
	public void playAll() {
		System.out.println("\n----- Your PlayList -----\n ");
		System.out.println("~ " + MusicPlayer.playList.get(0).getSongName() + "~ is now playing...");
		for (int i = 1; i < MusicPlayer.playList.size(); i++) {
			System.out.println("~ " + MusicPlayer.playList.get(i).getSongName() + " ~ in queue,");
		}
		MusicPlayer.songChoice();
	}

	@Override
	public void playRandom() {
		int ri = (int) (Math.random() * MusicPlayer.playList.size());
		System.out.println("Random song is playing.. " + MusicPlayer.playList.get(ri));
		MusicPlayer.songChoice();
	}

	@Override
	public void chooseSong() {
		for (int i = 0; i < MusicPlayer.playList.size(); i++) {

			System.out.println(MusicPlayer.playList.get(i).allSongs());
		}
		System.out.println("Enter Song ID: ");
		int uid = sc.nextInt();
		for (int i = 0; i < MusicPlayer.playList.size(); i++) {
			if (uid == MusicPlayer.playList.get(i).getId()) {
				System.out.println("\n~" + MusicPlayer.playList.get(i).getSongName() + "~ by"
						+ MusicPlayer.playList.get(i).getArtist() + "is now playing...!!\n");
				break;
			}

		}
		MusicPlayer.songChoice();
	}

	@Override
	public void addSong() {
		System.out.println("Enter Id");
		int id = sc.nextInt();

		System.out.println("Enter Song Name: ");
		String songName = sc.nextLine();

		System.out.println("Enter Song Duration: ");
		String duration = sc.nextLine();

		System.out.println("Enter Artist Name: ");
		String artist = sc.nextLine();

		MusicPlayer.playList.add(new Song(id, songName, duration, artist));
		System.out.println("\nNew Song is Added\n");
		Iterator<Song> z = MusicPlayer.playList.iterator();
		while (z.hasNext()) {
//			
			System.out.println(z.next());
//		     
		}
		MusicPlayer.songChoice();
	}

	@Override
	public void removeSong(int uid) {
		for (int i = 0; i < MusicPlayer.playList.size(); i++) {
			if (uid == MusicPlayer.playList.get(i).getId()) {
				System.out
						.println("\n" + MusicPlayer.playList.get(i).getSongName() + " is removed from the Playlist\n");
				MusicPlayer.playList.remove(i);
			}
		}
		System.out.println("\n----- Your PlayList -----\n ");
		for (int i = 0; i < MusicPlayer.playList.size(); i++) {

			System.out.println(MusicPlayer.playList.get(i).allSongs());
		}

		MusicPlayer.songChoice();
	}

	@Override
	public void viewAllSongs() {
		System.out.println("\n----- Your PlayList -----\n ");
		for (int i = 0; i < MusicPlayer.playList.size(); i++) {
			System.out.println(MusicPlayer.playList.get(i).allSongs());
		}
		MusicPlayer.songChoice();
	}
//	@Override
//	public void editSong() {
//		
//		System.out.println(MusicPlayer.playList);
//		System.out.println("Select Song to Edit");
//		System.out.println("Enter ID : ");
//		int uid=sc.nextInt();
//		for (int i = 0; i < MusicPlayer.playList.size(); i++) {
//			if(uid==MusicPlayer.playList.get(i).getId()) {
//				System.out.println("\n1. Edit ID \n2. Edit Song Name \n3. Edit Artist Name");
//				
//				int choice=sc.nextInt();
//				switch (choice) {
//				case 1:
//					System.out.println("Enter New ID");
//					int id=sc.nextInt();
//					MusicPlayer.playList.get(i).setId(id);
//					break;
//				   
//				case 2:
//					System.out.println("Enter New Song Name");
//					String songName=sc.next();
//					MusicPlayer.playList.get(i).setSongName(songName);
////					MusicPlayer.playList.get(i).getSongName();
//					
//					break;
//					
//				case 3:
//					System.out.println("Enter New Artist Name");
//					String artist=sc.next();
//					MusicPlayer.playList.get(i).setArtist(artist);
////					MusicPlayer.playList.get(i).getArtist();
//					
//					break;
//					
//				default:
//					System.out.println("Invalid Choice");
//					MusicPlayer.songChoice();
//				}
//			}
//		}
//		
//		
//	}

	@Override
	public void editSong() {
		System.out.println("Select Options");
		System.out.println("1.Edit Song Name \n2.Edit Artist Name \n3.Go Back");
		int n = sc.nextInt();
		switch (n) {
		case 1:
			for (Song i : MusicPlayer.playList) {
				System.out.println(i);
			}
			System.out.print("Enter Song Name: ");
			String s = sc.next();
			for (int x = 0; x < MusicPlayer.playList.size(); x++) {
				if (MusicPlayer.playList.get(x).getSongName().equals(s)) {
					System.out.print("Enter Edited Song Name: ");
					String sr = sc.nextLine();
					MusicPlayer.playList.get(x).setSongName(sr);
					System.out.println(MusicPlayer.playList.get(x));
				}
			}
			break;
		case 2:
			for (Song i : MusicPlayer.playList) {
				System.out.println(i);
			}
			System.out.print("Enter Artist Name: ");
			String s1 = sc.next();
			for (int x = 0; x < MusicPlayer.playList.size(); x++) {
				if (MusicPlayer.playList.get(x).getArtist().equals(s1)) {
					System.out.print("Enter Edited Artist Name: ");
					String sr = sc.nextLine();
					MusicPlayer.playList.get(x).setArtist(sr);
					System.out.println(MusicPlayer.playList.get(x));
				}
			}
		case 3:
			MusicPlayer.songChoice();
		}

	}

}
