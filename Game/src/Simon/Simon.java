package Simon;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class Simon extends JFrame implements ActionListener 
{
	
	private Container cPane;
	private ImageIcon title;
	private JLabel lblTitle, lblName, lblName2, lblFore, lblSur, reg, log;
	private JButton login, register;
	private JPanel pTop, pMain, pDiv, pDiv2, btn1, btn2, plog, pLogin, pRegister, pReg, lable, text, tBox1, tBox2, tBox3, tBox4;
	public static JTextField name, name2, fore, sur;
	
	private JMenuBar mb;
	private JMenu mSystem;
	private JMenuItem mIRules, mIExit, mIScore;
	private Menu rules;
	private LeaderBoard score;
	
	public static boolean Load = false;

	
	Simon() {
		
		cPane = getContentPane ();  // container for login page
		cPane.setBackground(Color.black);
		cPane.setLayout (new BorderLayout ());
		
		pTop = new JPanel();  //panel to hold title
		pTop.setBackground(Color.black);
		
		pMain = new JPanel(); // main will hold login and register fields
		pMain.setLayout(new BorderLayout());
		pMain.setBackground(Color.black);
		
		pLogin = new JPanel(); //panel for login field
		pLogin.setLayout(new BorderLayout ());
		pLogin.setBackground(Color.black);
		
		lable = new JPanel();
		lable.setLayout(new GridLayout (3, 1, 0, 0));
		lable.setBackground(Color.black);
		
		text = new JPanel();
		text.setLayout(new GridLayout (3, 1, 0, 0));
		text.setBackground(Color.black);
		
		btn1 = new JPanel();
		btn1.setLayout(new FlowLayout());
		btn1.setBackground(Color.black);
		
		btn2 = new JPanel();
		btn2.setLayout(new FlowLayout());
		btn2.setBackground(Color.black);
		
		pDiv = new JPanel();
		pDiv.setLayout(new GridLayout (1,2,0,0));
		pDiv.setBackground(Color.black);
		
		pDiv2 = new JPanel();
		pDiv2.setLayout(new GridLayout (1,2,0,0));
		pDiv2.setBackground(Color.black);
		
		tBox1 = new JPanel();  
		tBox1.setBackground(Color.black);
		
		tBox2 = new JPanel();  
		tBox2.setBackground(Color.black);
		
		tBox3 = new JPanel();  
		tBox3.setBackground(Color.black);
		
		tBox4 = new JPanel();  
		tBox4.setBackground(Color.black);
		
		plog = new JPanel();
		plog.setBackground(Color.black);
		
		log = new JLabel("Login", SwingConstants.CENTER);
		log.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		log.setBackground(Color.black);
		log.setForeground(Color.yellow);
		
		pRegister = new JPanel();
		pRegister.setLayout(new BorderLayout ());
		pRegister.setBackground(Color.black);
				
		pReg = new JPanel();
		pReg.setLayout(new BorderLayout ());
		pReg.setBackground(Color.black);
		
		reg = new JLabel("Register", SwingConstants.CENTER);
		reg.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		reg.setBackground(Color.black);
		reg.setForeground(Color.yellow);

		title = new ImageIcon(getClass().getResource("SIMON_Title.png"));
		
		lblTitle = new JLabel(title);
		
		lblName = new JLabel("Username", SwingConstants.CENTER);
		lblName.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblName.setBackground(Color.black);
		lblName.setForeground(Color.yellow);
		
		lblName2 = new JLabel("Username", SwingConstants.CENTER);
		lblName2.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblName2.setBackground(Color.black);
		lblName2.setForeground(Color.yellow);
		
		lblFore = new JLabel("Forename", SwingConstants.CENTER);
		lblFore.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblFore.setBackground(Color.black);
		lblFore.setForeground(Color.yellow);
		
		lblSur = new JLabel("Surename", SwingConstants.CENTER);
		lblSur.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblSur.setBackground(Color.black);
		lblSur.setForeground(Color.yellow);
		
		name = new JTextField(10);
		name.setFont(new Font("Ariel", Font.BOLD, 12));
		name.setForeground(Color.black);
		
		name2 = new JTextField(10);
		name2.setFont(new Font("Ariel", Font.BOLD, 12));
		name2.setForeground(Color.black);
		
		fore = new JTextField(10);
		fore.setFont(new Font("Ariel", Font.BOLD, 12));
		fore.setForeground(Color.black);
		
		sur = new JTextField(10);
		sur.setFont(new Font("Ariel", Font.BOLD, 12));
		sur.setForeground(Color.black);
		
		login = new JButton (" Login ");
		login.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		login.setBackground(Color.yellow);
		login.setForeground(Color.black);
		login.setBorder(BorderFactory.createRaisedBevelBorder());
		
		register = new JButton (" Register ");
		register.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		register.setBackground(Color.yellow);
		register.setForeground(Color.black);
		register.setBorder(BorderFactory.createRaisedBevelBorder());
		
		pTop.add(lblTitle);
		
		pMain.add(pLogin, BorderLayout.NORTH);
		pMain.add(pRegister, BorderLayout.SOUTH);
		
		pLogin.add(plog, BorderLayout.NORTH);
		plog.add(log);
		
		pRegister.add(pReg, BorderLayout.NORTH);
		pReg.add(reg);
		
		pLogin.add(pDiv, BorderLayout.CENTER);
		
		pDiv.add(lblName,BorderLayout.EAST);
		pDiv.add(tBox1, BorderLayout.WEST);
		tBox1.add(name, BorderLayout.WEST);
		
		pLogin.add(btn1, BorderLayout.SOUTH);
		btn1.add(login);
		
		
		
		pRegister.add(pDiv2, BorderLayout.CENTER);
		pDiv2.add(lable);
		pDiv2.add(text);
		
		lable.add(lblName2);
		lable.add(lblFore);
		lable.add(lblSur);
		
		text.add(tBox2);
		text.add(tBox3);
		text.add(tBox4);
		
		tBox2.add(name2,BorderLayout.WEST);
		tBox3.add(fore, BorderLayout.WEST);
		tBox4.add(sur, BorderLayout.WEST);
		
		pRegister.add(btn2, BorderLayout.SOUTH);
		btn2.add(register);
		
		
		cPane.add(pTop, BorderLayout.NORTH);
		cPane.add(pMain);

		login.addActionListener(this);
		register.addActionListener(this);
		
		rules = new Menu();
		rules.setTitle("Rules");
		rules.setSize(700,450);
		rules.setVisible(false);
		
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
		mIScore = new JMenuItem ("Leader Board");
		mIScore.setBackground(Color.YELLOW);
		
		mIRules.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				rules.setVisible(true);
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
		mSystem.add(mIScore);
		mSystem.add(mIExit);
		mb.add(mSystem);
		setJMenuBar(mb);
	}
	
//public void stateChange(ChangeEvent e)
//{


//}
	
	/*public boolean isString(String input) // This Method would not work even with == null and .matches("[a-zA-Z]"). I have decided to remove it.
	{
		try
		{
			String test = "";
	        if(input == test)
	        {
	            return false;
	        }
			else
				return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}*/
	
public void actionPerformed(ActionEvent e)
	{
	
		if(e.getSource() == login)
		{
			
			try {
				Load = Binary.find();
			} 
			catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if(!Load)
			{
				JOptionPane.showMessageDialog(null, "User not found, try again or register");
			}
		}
		if(e.getSource()==register)
		{
			/*	if (!isString(name2.getText()))
					name2.setText("???");
				else
					if (!isString(fore.getText()))
						fore.setText("???");
					else
						if (!isString(sur.getText()))
							sur.setText("???");
						else
						{*/
							try {
								Binary.createUser();
							} 
							catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							Load = true;
						//}
							
		}
	}

}

