package Simon;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AutoCreate {

	public static void main(String[] args) throws IOException {
		
		//createUser();
		printPlayer ();
	}
	
	
	public static void createUser() throws IOException 
	{
		
		Player[] p;
				
		try
		{
			File out = new File("Players.dat");
			RandomAccessFile rd = new RandomAccessFile(out, "rw");

			if (out.exists())
				rd.seek(rd.length()); // Move to End of File

				p = new Player[5];
				
				p[0]= new Player("Xander","Alexander","Olphert", 0, 0, 0, 0);
				p[1]= new Player("Scotto","Scott","Olphert", 0, 0, 0, 0);
				p[2]= new Player("BFG","Ricky","Stewart", 0, 0, 0, 0);
				p[3]= new Player("Superman","Clark","Kent", 0, 0, 0, 0);
				p[4]= new Player("Batman","Bruce","Wayne", 0, 0, 0, 0);
				
				for(int i = 0; i < 5; i++){

				if (p[i].getForename().length() > 10)
					p[i].setForename(p[i].getForename().substring(0, 10));
				else
					for (int x = p[i].getForename().length(); x < 10; x++)
						p[i].setForename(p[i].getForename() + " ");


				if (p[i].getSurname().length() > 10)
					p[i].setSurname(p[i].getSurname().substring(0, 10));
				else
					for (int x = p[i].getSurname().length(); x < 10; x++)
						p[i].setSurname(p[i].getSurname() + " ");


				rd.writeUTF(p[i].getUsername());
				rd.writeUTF(p[i].getForename());
				rd.writeUTF(p[i].getSurname());
				rd.writeInt(p[i].getLevel());
				rd.writeInt(p[i].getHighest());
				rd.writeInt(p[i].getWin());
				rd.writeInt(p[i].getLose());
				
				}

			rd.close();
			
		} 
		catch (IOException ex) 
		{
			System.out.print("\n\n\t  Unable to save data");
		}
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
				
				System.out.print("\n" + p.toString());
			}
		}
				
				catch( IOException e)
				{
					eof= true;
					rd.close();
				}
	}
}
		
