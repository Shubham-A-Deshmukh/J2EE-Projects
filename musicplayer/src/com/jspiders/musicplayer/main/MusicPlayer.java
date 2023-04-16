package com.jspiders.musicplayer.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.jspiders.musicplayer.operations.*;
import com.jspiders.musicplayer.song.*;

public class MusicPlayer {

	public static ArrayList<Song> playList = new ArrayList<Song>();
	private static Scanner sc = new Scanner(System.in);

	public static void songChoice() {
		OperationInterface m = new SongOperation();
		System.out.println("===== Menu =====");
		System.out.println("1. Play Song  \n2. Add/Remove Song  \n3. Edit Song \n4. View All Songs \n5. Exit \n");
		int ch = sc.nextInt();

//	 	Main Switch Case starts
		switch (ch) {
		case 1:
			System.out.println("====Play Songs===== \n");
			System.out.println(" 1.Play All Song \n 2.Play Random Song \n 3.Choose Song To Play \n 4.Go Back");

//		       1st inner switch case
			int ch1 = sc.nextInt();
			switch (ch1) {

			// Play All Song
			case 1:
				m.playAll();
				break;
				
			// Play Random Song
			case 2:
				m.playRandom();
				break;
				
			// Chose Song to play	
			case 3:
				m.chooseSong();
				break;
				
//				Exit
			case 4:
				songChoice();
				break;
			case 5:
				System.out.println("Enter Valid Option");
			}
			break;
//			1st inner switch case ends
			
		case 2:
			System.out.println("====Add/Remove Song=====\n");
			System.out.println("1.Add Song \n2.Remove Song \n3.Go Back\n");
			int ch2 = sc.nextInt();

//			2nd inner switch case
			switch (ch2) {
			case 1:
				m.addSong();
				break;
			case 2:
				Iterator<Song> it = playList.iterator();
				if (it.hasNext() == false) {
					System.out.println("Playlist is empty!!");
					songChoice();
				}
				while (it.hasNext()) {
					System.out.println(it.next());
				}
				
				System.out.println("Enter Song ID: ");
				int uid=sc.nextInt();
				m.removeSong(uid);
				break;
			case 3:
				songChoice();
				break;
			case 4:
				System.out.println("Enter Valid Option");
			}
			break;
		case 3:
			m.editSong();
			break;
		case 4:
			m.viewAllSongs();
			break;
		case 5:
			break;
		default:
			System.out.println("Enter valid choice");
			songChoice();
		}
	}

//		Main Method Starts
	public static void main(String[] args) {
//		ArrayList<Song> playList = new ArrayList();
		playList.add(new Song(1, "Hypnotize ", " 5 min", " Biggie Smalls"));
		playList.add(new Song(2, "MockingBird", " 3 min", " Eminem"));
		playList.add(new Song(3, "Hot Stuff", "3.15 min", " Donna Summer"));
		playList.add(new Song(4, "Bones", "2 min", " Low Roar"));
		playList.add(new Song(5, "Hit im up", "3.5 min", "2PAC"));
		songChoice();

	}
}
