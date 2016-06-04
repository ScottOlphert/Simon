package Simon;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Simon_Game extends JFrame implements ActionListener, MouseListener
{
	private Container cPane;
	private static JLabel lblTitle, lvl, curPlayer;
	private static ImageIcon rOff;
	private static ImageIcon gOff;
	private static ImageIcon yOff;
	private static ImageIcon bOff;
	private static ImageIcon rOn;
	private static ImageIcon gOn;
	private static ImageIcon yOn;
	private static ImageIcon bOn;
	private static JButton red;
	private static JButton green;
	private static JButton yellow;
	private static JButton blue;
	private static JButton start;
	private JPanel pNorth, pSouth, pStart, pPlayer, PCenter;
	private ImageIcon title;
	
	private JMenuBar mb;
	private JMenu mSystem;
	private JMenuItem mIRules, mIExit, mIPlayer, mIScore;
	private Menu rules;
	public static PlayerDetail player;
	public static LeaderBoard score;
	
	Simon_Game()
	{
	
		cPane = getContentPane ();
		cPane.setBackground(new Color (0,0,0));
		
		
		pNorth = new JPanel();
		pNorth.setBackground(new Color (0,0,0));
		
		pSouth = new JPanel();
		pSouth.setLayout(new BorderLayout());
		pSouth.setBackground(new Color (0,0,0));
		
		pStart = new JPanel();
		pStart.setLayout(new GridLayout(1,1,0,0));
		pStart.setBackground(new Color (0,0,0));
		
		pPlayer = new JPanel();
		pPlayer.setLayout(new GridLayout(1,2,0,0));
		pPlayer.setBackground(new Color (0,0,0));
		
		PCenter = new JPanel();
		PCenter.setLayout(new GridLayout(2,2,-1,-1));
		
		title = new ImageIcon(getClass().getResource("SIMON_Title.png"));
		rOff = new ImageIcon(getClass().getResource("Red_Off.png"));
		bOff = new ImageIcon(getClass().getResource("Blue_Off.png"));
		yOff = new ImageIcon(getClass().getResource("Yellow_Off.png"));
		gOff = new ImageIcon(getClass().getResource("Green_Off.png"));
		rOn = new ImageIcon(getClass().getResource("Red_On.png"));
		bOn = new ImageIcon(getClass().getResource("Blue_On.png"));
		yOn = new ImageIcon(getClass().getResource("Yellow_On.png"));
		gOn = new ImageIcon(getClass().getResource("Green_On.png"));
		
		lblTitle = new JLabel(title);
		
		lvl = new JLabel("Level \n  0", SwingConstants.CENTER);
		lvl.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lvl.setBackground(Color.black);
		lvl.setForeground(Color.yellow);
		
		curPlayer = new JLabel(Binary.currentPlayer, SwingConstants.CENTER);
		curPlayer.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		curPlayer.setBackground(Color.black);
		curPlayer.setForeground(Color.yellow);
		
		green = new JButton(gOff);
		green.setText("0");
		green.addActionListener(this);
		green.setBackground (Color.black);
		
		red = new JButton(rOff);
		red.setText("1");
		red.addActionListener(this);
		red.setBackground (Color.black);
		
		yellow = new JButton(yOff);
		yellow.setText("2");
		yellow.addActionListener(this);
		yellow.setBackground (Color.black);
		
		blue = new JButton(bOff);
		blue.setText("3");
		blue.addActionListener(this);
		blue.setBackground (Color.black);
		
		start = new JButton ("Start");
		start.addActionListener(this);
		start.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		start.setBackground(Color.yellow);
		start.setForeground(Color.black);
		start.setBorder(BorderFactory.createRaisedBevelBorder());
		
		pNorth.add(lblTitle);
		PCenter.add(green);
		PCenter.add(red);
		PCenter.add(yellow);
		PCenter.add(blue);
		pStart.add(start);
		pPlayer.add(curPlayer);
		pPlayer.add(lvl);
		pSouth.add(pStart);
		pSouth.add(pPlayer, BorderLayout.SOUTH);
		

		cPane.add(pNorth, BorderLayout.NORTH);
		cPane.add(pSouth, BorderLayout.SOUTH);
		cPane.add(PCenter, BorderLayout.CENTER);
		
		rules = new Menu();
		rules.setTitle("Rules");
		rules.setSize(700,450);
		rules.setVisible(false);
		
		player = new PlayerDetail();
		player.setTitle("Player");
		player.setSize(700,270);
		player.setVisible(false);
		
		score = new LeaderBoard();
		score.setTitle("Score");
		score.setSize(700,450);
		score.setVisible(false);
		
		mb = new JMenuBar();
		mb.setBackground(Color.YELLOW);
		mSystem = new JMenu("Rules / Scores");
		mIRules = new JMenuItem ("Rules");
		mIRules.setBackground(Color.YELLOW);
		mIExit = new JMenuItem ("Exit");
		mIExit.setBackground(Color.YELLOW);
		mIPlayer = new JMenuItem ("Player Score");
		mIPlayer.setBackground(Color.YELLOW);
		mIScore = new JMenuItem ("Leader Board");
		mIScore.setBackground(Color.YELLOW);
		
		mIRules.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				rules.setVisible(true);
			}
		});
		
		mIPlayer.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				player.setVisible(true);
			}
		});
		
		mIScore.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				score.setVisible(true);
			}
		});
		
		mIExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		
		mSystem.add(mIRules);
		mSystem.add(mIPlayer);
		mSystem.add(mIScore);
		mSystem.add(mIExit);
		mb.add(mSystem);
		setJMenuBar(mb);
		
		green.addMouseListener(this);
		blue.addMouseListener(this);
		red.addMouseListener(this);
		yellow.addMouseListener(this);
		addMouseListener(this);
	}
	
	public static void toggleLight(int light) {
		try
		{
			switch (light)
			{
			case 0:
				green.setIcon(gOn);
				Thread.sleep(500);
				green.setIcon(gOff);
				Thread.sleep(500);
				break;
			case 1:
				red.setIcon(rOn);
				Thread.sleep(500);
				red.setIcon(rOff);
				Thread.sleep(500);
				break;
			case 2:
				yellow.setIcon(yOn);
				Thread.sleep(500);
				yellow.setIcon(yOff);
				Thread.sleep(500);
				break;
			case 3:
				blue.setIcon(bOn);
				Thread.sleep(500);
				blue.setIcon(bOff);
				Thread.sleep(500);
				break;
			}
		}
		catch(Exception e)
		{
			
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		JButton btn = (JButton)e.getSource();
		
		if(btn == start)
		{
		Player.clear();
		correct = true;
		startG = true;
		}
		
		else
		{
		Player.add(Integer.parseInt(btn.getText()));
		//System.out.print("\n" + Player); for testing purposes
		
		int current = Player.size() - 1;
		if(Computer.get(current) != Player.get(current)) {
			Simon_Game.correct = false;
		}
		}
		
	}


@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==green)
	{
		green.setIcon(gOn);
	}
	else
		if (e.getSource()==red)
		{
			red.setIcon(rOn);
		}
		else
			if (e.getSource()==blue)
			{
				blue.setIcon(bOn);
			}
			else
				if (e.getSource()==yellow)
				{
					yellow.setIcon(yOn);
				}
	
	
}





@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==green)
	{
		green.setIcon(gOff);
	}
	else
		if (e.getSource()==red)
		{
			red.setIcon(rOff);
		}
		else
			if (e.getSource()==blue)
			{
				blue.setIcon(bOff);
			}
			else
				if (e.getSource()==yellow)
				{
					yellow.setIcon(yOff);
				}
	
}

@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

public static ArrayList<Integer> Computer;
public static ArrayList<Integer> Player;
public static boolean correct = true, startG = false;

public static void main(String[] args) throws InterruptedException, IOException 
{
	int plvl = 1;
	boolean win;
	Random gen = new Random();
	Computer = new ArrayList<Integer>();
	while(Computer.size() <= 29) {
		Computer.add(gen.nextInt(4));
		
	}
	Player = new ArrayList<Integer>();
	
	Simon Login = new Simon();		
	Login.setTitle("Login");
	Login.setSize(450, 550);
	Login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	Login.setVisible(true);
	
	while (Simon.Load == false)
	{
	Thread.sleep(100);
	}

	Login.setVisible(false);
	
	Simon_Game Game = new Simon_Game();		
	Game.setTitle("Simon Says");
	Game.setSize(450, 740);
	Game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Game.setVisible(true);
	do
	{
		
	
		while (startG == false)
		{
		Thread.sleep(100);
		}
		
		do
		{
		Player.clear();
		lvl.setText("Level\n  " + plvl);
		int count = 1;
		for(int i : Computer) 
		{
			toggleLight(i);
			
			if(count >= plvl) 
			{
				break;
			}
			count++;
		}
		
		while(Player.size() < plvl) 
		{
			if(!correct) 
			{
				break;
			}
			Thread.sleep(100);
		}
		
		if(correct) 
		{
				if(plvl == 5) // Change  Lvl here
				{
					win = true;
					JOptionPane.showMessageDialog(null, "You Win\n Congratulations!!!");
					Binary.updatePlayer(plvl, win);
					startG = false;
					correct = true;
					plvl = 1;
					count = 1;
					Computer.clear();
					while(Computer.size() <= 29) 
					{
						Computer.add(gen.nextInt(4));
					}
					break;
				}
				else
					plvl++;
		}
		
		Thread.sleep(500);
		
		if(!correct) 
		{
			win = false;
			JOptionPane.showMessageDialog(null, "You Lose");
			Binary.updatePlayer(plvl-1, win);
			startG = false;
			correct = true;
			plvl = 1;
			count = 1;
			Computer.clear();
			while(Computer.size() <= 29) 
			{
				Computer.add(gen.nextInt(4));
			}
			
			break;
		}
		
	}while (plvl <= 30);

	}while (startG == false);

}


}
	
