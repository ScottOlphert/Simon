package Simon;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import javax.swing.*;

public class Binary 
{
	public static String currentPlayer = "";
	public static Player [] score; //upon an attempt to use a ArrayList and a Comparator for sorting purposes, I felt this would be easier and cause me less stress.
	
public static void main(String[] args) throws IOException {
		
		printPlayer();
		//sort();
		
		//read();

	}
	
	public static void createUser() throws IOException 
	{
		Player p;
				
		try
		{
			File out = new File("Players.dat");
			RandomAccessFile rd = new RandomAccessFile(out, "rw");

			if (out.exists())
				rd.seek(rd.length()); // Move to End of File

				p = new Player();
				
				p.setUsername(Simon.name2.getText());
				
				do {
					p.setForename( Simon.fore.getText());
				} while (p.getForename().length() == 0);

				if (p.getForename().length() > 10)
					p.setForename(p.getForename().substring(0, 10));
				else
					for (int x = p.getForename().length(); x < 10; x++)
						p.setForename(p.getForename() + " ");

				do {
					p.setSurname( Simon.sur.getText());
				} while (p.getSurname().length() == 0);

				if (p.getSurname().length() > 10)
					p.setSurname(p.getSurname().substring(0, 10));
				else
					for (int x = p.getSurname().length(); x < 10; x++)
						p.setSurname(p.getSurname() + " ");


				rd.writeUTF(p.getUsername());
				rd.writeUTF(p.getForename());
				rd.writeUTF(p.getSurname());
				rd.writeInt(p.getLevel());
				rd.writeInt(p.getHighest());
				rd.writeInt(p.getWin());
				rd.writeInt(p.getLose());
				currentPlayer = p.getUsername();
				

			rd.close();
			
			printPlayer();
			Simon_Game.player = new PlayerDetail();
			Simon_Game.player.setTitle("Player");
			Simon_Game.player.setSize(700,270);
			Simon_Game.player.setVisible(false);
			
			sort();
			Simon_Game.score = new LeaderBoard();
			Simon_Game.score.setTitle("Score");
			Simon_Game.score.setSize(700,450);
			Simon_Game.score.setVisible(false);
		} 
		catch (IOException ex) 
		{
			System.out.print("\n\n\t  Unable to save data");
		}
	}
	
	public static void sort() throws IOException // reads in player data to an array and sorts it
	{
		int size = 0;
		boolean eof = false;
		score = new Player[20];
		
		File in = new File("Players.dat");

		Player p;
		
		RandomAccessFile rd = new RandomAccessFile(in, "rw");

		try 
		{
			
			do 
			{	
				score[size] = new Player();
				
				score[size].setUsername(rd.readUTF().trim());
				score[size].setForename(rd.readUTF().trim());
				score[size].setSurname(rd.readUTF().trim());
				score[size].setLevel(rd.readInt());
				score[size].setHighest(rd.readInt());
				score[size].setWin(rd.readInt());
				score[size].setLose(rd.readInt());
				size++;

			} while (!eof);

		} 
		catch (IOException ex) 
		{
			score[size]= null;
			rd.close();
		}

		     boolean swapped = true;  
		     Player temp;   

		     while ( swapped ) //sorts the array based on player Wins
		     {
		            swapped= false;    
		            for(int i=0;  i < size-1;  i++ )
		            {
		                   if ( score[i].getWin() < score[i+1].getWin() )   
		                   {
		                           temp = score[i];               
		                           score[i] = score[i+1];
		                           score[i+1] = temp;
		                          swapped = true;               
		                  } 
		            } 
		      } 
		     
		     swapped = true;
		     
		     while ( swapped )// Sorts the array based on highest lvl achieved
		     {
		            swapped= false;   
		            for(int i=0;  i < size-1;  i++ )
		            {
		                   if ( score[i].getHighest() < score[i+1].getHighest())  
		                   {
		                           temp = score[i];                
		                           score[i] = score[i+1];
		                           score[i+1] = temp;
		                          swapped = true;                
		                  } 
		            } 
		      } 
		     
		     printLeader(score);
	}
	
	
	
	public static void updatePlayer(int lvl, boolean win) throws IOException //updates players information
	{
		boolean eof, found;
		Player p;

		File file = new File("Players.dat");
		RandomAccessFile rd = new RandomAccessFile(file,"rw");
		
		found=false;
	
		long posLevel, posHigh, posWin, posLose;
		try
		{
			eof = false;
		
			while (!eof)
			{
				p = new Player();
				
				p.setUsername(rd.readUTF());
				p.setForename(rd.readUTF());
				p.setSurname(rd.readUTF());
				posLevel = rd.getFilePointer();
				p.setLevel(rd.readInt());
				posHigh = rd.getFilePointer();
				p.setHighest(rd.readInt());
				posWin = rd.getFilePointer();
				p.setWin(rd.readInt());
				posLose = rd.getFilePointer();
				p.setLose(rd.readInt());
				
				
				
				if (currentPlayer.equals(p.getUsername()))
				{
					eof = true; 
					found = true;
					
					p.setLevel(lvl);
					rd.seek(posLevel);
					rd.writeInt(p.getLevel());
					
					p.compareTo(p.getLevel());
					rd.seek(posHigh);
					rd.writeInt(p.getHighest());
					
					if(!win)
					{
						p.setLose(p.getLose()+1);
						rd.seek(posLose);
						rd.writeInt(p.getLose());
					}
					
					else
					{
						p.setWin(p.getWin()+1);
						rd.seek(posWin);
						rd.writeInt(p.getWin());
					}
						
					
					rd.seek(rd.length());
					rd.close();
					
					printPlayer();
					Simon_Game.player = new PlayerDetail();
					Simon_Game.player.setTitle("Player");
					Simon_Game.player.setSize(700,270);
					Simon_Game.player.setVisible(false);
					
					sort();
					Simon_Game.score = new LeaderBoard();
					Simon_Game.score.setTitle("Score");
					Simon_Game.score.setSize(700,450);
					Simon_Game.score.setVisible(false);					
				}
			}	
		}
		catch( IOException e)
		{
			eof= true;
			if (!found)
				JOptionPane.showMessageDialog(null, "Error Saving game user not found");
			rd.close();
		}
}
		
	public static boolean find()throws IOException // searches .Dat file for existing user returns boolean
	{
		boolean eof, found = false;
		String username;
		Player p;

		File file = new File("Players.dat");
		RandomAccessFile rd = new RandomAccessFile(file,"rw");
		
		username = Simon.name.getText();
		
		try
		{
			eof = false;
		
			while (!eof)
			{
				p = new Player();
				
				p.setUsername(rd.readUTF());
				//p.setUsername(rd.readUTF());
				p.setForename(rd.readUTF());
				p.setSurname(rd.readUTF());
				p.setLevel(rd.readInt());
				p.setHighest(rd.readInt());
				p.setWin(rd.readInt());
				p.setLose(rd.readInt());
				
				if (username.equals(p.getUsername()))
					{
						eof = true; 
						found = true;
						currentPlayer = p.getUsername();
					
						printPlayer();
						Simon_Game.player = new PlayerDetail();
						Simon_Game.player.setTitle("Player");
						Simon_Game.player.setSize(700,270);
						Simon_Game.player.setVisible(false);

						sort();
						Simon_Game.score = new LeaderBoard();
						Simon_Game.score.setTitle("Score");
						Simon_Game.score.setSize(700,450);
						Simon_Game.score.setVisible(false);
					}
			}
		}
			catch( IOException e)
			{
				//e.printStackTrace();
				eof= true;
				
				rd.close();
				
			}
		
		
		return found;
	}
	
	
	
	
	public static void printPlayer () throws IOException // finds current player in the .dat file and prints their information to .txt file
	{
		boolean eof;
		Player p;

		File file = new File("Players.dat");
		RandomAccessFile rd = new RandomAccessFile(file,"rw");

		try
		{
			eof = false;
		
			while (!eof)
			{
				p = new Player();
				
				p.setUsername(rd.readUTF());
				p.setForename(rd.readUTF());
				p.setSurname(rd.readUTF());
				p.setLevel(rd.readInt());
				p.setHighest(rd.readInt());
				p.setWin(rd.readInt());
				p.setLose(rd.readInt());
				
				
				
				if (currentPlayer.equals(p.getUsername()))
				{
					eof = true; 
					print(p);
				}
			}
		}
				
				catch( IOException e)
				{
					eof= true;
					rd.close();
				}
	}
			
	
	
	public static void print(Player p) // prints to .txt file
	{
		String heading;
	
			try
			{
				// write to file
				FileWriter outFile = new FileWriter("Player.txt");
					PrintWriter out = new PrintWriter(outFile);

						heading="\n\t\tPLAYER SCORE";
						out.println(heading);
						heading="\t\t-------------------------\n";
						out.println(heading);
						//out.println (" ");
						out.println (String.format("%-20s %-50s %-15s %-15s %-5s %-5s", "Username", "Name", "Highest Level", "Recent Level", "Wins", "Lost" ));
						out.println (p.toString());
					

						//JOptionPane.showMessageDialog(null, "Printed");

						out.close();
			}
		
		catch(IOException ex2)
		{
			JOptionPane.showMessageDialog(null, "Cannot Open File");
		}
	}
	
	
	public static void printLeader (Player [] score)
	{
		String heading, ordinal;
		
	try
	{
		// write to file
		FileWriter outFile = new FileWriter("LeaderBoard.txt");
		PrintWriter out = new PrintWriter(outFile);
				
		heading="\n\t\tLeader Board";
		out.println(heading);
		heading="\t\t--------------------\n";
		out.println(heading);
				
		out.println (String.format("%-20s %-37s %-15s %-15s", "Rank", "Username", "Highest Level", "Wins"));
		for(int i = 1; i<6; i++)
		{
			if(i == 1)
				ordinal = "st";
			else if (i == 2)
				ordinal = "nd";
			else if (i == 3)
				ordinal = "rd";
			else 
				ordinal = "th";
		
		out.println (i + ordinal + "\t" + score[i-1].LeaderBoard());
		}
				
		out.close();
	}
	catch(IOException ex2)
	{
		JOptionPane.showMessageDialog(null, "Cannot Open File");
	}
	}
}


	
