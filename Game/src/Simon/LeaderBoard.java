package Simon;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class LeaderBoard extends JFrame implements ActionListener
{
	private JTextArea txtArea;
	private JLabel lbl;
	private JButton  btnExit;
	private JScrollPane jsp;
	private Container cn;
	
	private FileInputStream in;
	
	private String s = "";
	private char ch;
	private int no;
	
	LeaderBoard()
	{
		cn = getContentPane();
		
		lbl = new JLabel("Leader Board", SwingConstants.CENTER);
		lbl.setFont(new Font("Dialog", Font.BOLD, 30));
		lbl.setBackground(Color.BLUE);
		cn.add(lbl, BorderLayout.NORTH);
		
		btnExit = new JButton ("  Close ");
		btnExit.setFont(new Font("Dialog", Font.BOLD, 18));
		btnExit.addActionListener(this);
		cn.add(btnExit, BorderLayout.SOUTH);
		
		txtArea = new JTextArea (20,70);
		txtArea.setFont(new Font("Dialog", Font.PLAIN, 16));
		
		jsp = new JScrollPane(txtArea);
		cn.add(jsp, BorderLayout.CENTER);
		
		try
		{
			in = new FileInputStream ("LeaderBoard.txt");
			
			while((no=in.read())!= -1)
			{
				ch = (char)no;
				s += ch;
			}
			txtArea.setText(s);
		}
		catch(FileNotFoundException e) 
		{
			JOptionPane.showMessageDialog(null, "file not found - LeaderBoard.txt");
		}
		catch(IOException e) 
		{
			JOptionPane.showMessageDialog(null, "unable to read character from file" +s);
		}
	}

public void actionPerformed(ActionEvent e)
{
	this.dispose();
}

}