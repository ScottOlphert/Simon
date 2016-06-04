package Simon;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class PlayerDetail extends JFrame implements ActionListener
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
	
	PlayerDetail()
	{
		cn = getContentPane();
		
		lbl = new JLabel(" Player Score ", SwingConstants.CENTER);
		lbl.setFont(new Font("Dialog", Font.BOLD, 30));
		lbl.setBackground(Color.BLUE);
		cn.add(lbl, BorderLayout.NORTH);
		
		btnExit = new JButton ("  Close ");
		btnExit.setFont(new Font("Dialog", Font.BOLD, 18));
		btnExit.addActionListener(this);
		cn.add(btnExit, BorderLayout.SOUTH);
		
		txtArea = new JTextArea (10,30);
		txtArea.setFont(new Font("Dialog", Font.PLAIN, 16));
		
		jsp = new JScrollPane(txtArea);
		cn.add(jsp, BorderLayout.CENTER);
		
		try
		{
			in = new FileInputStream ("Player.txt");
			
			while((no=in.read())!= -1)
			{
				ch = (char)no;
				s += ch;
			}
			txtArea.setText(s);
		}
		catch(FileNotFoundException e) 
		{
			JOptionPane.showMessageDialog(null, "file not found - Player.txt");
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