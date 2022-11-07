

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;



public class TicTacToc implements ActionListener{
	
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean player1_turn;
	

	TicTacToc() {
		
		//create frame layout button layout textfield layout.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setVisible(true);
		
		textfield.setBackground(new Color(92,76,111));
		textfield.setForeground(new Color(215,230,42));
		textfield.setFont(new Font("TimesRoman",Font.BOLD,75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true);
		//need to create title panel
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,100);
		// button panel
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(150,150,150));
		//for panel button we use for loop method....
		
		for(int i=0;i<9;i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("Monospaced",Font.BOLD,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		title_panel.add(textfield);
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		
		firstTurn();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<9;i++) {
			if(e.getSource()==buttons[i]) {
				if(player1_turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(255,165,0));
						buttons[i].setText("X");
						player1_turn=false;
						textfield.setText("Jerry Turn");
						check();
					}
				}
				else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(0,0,255));
						buttons[i].setText("O");
						player1_turn=true;
						textfield.setText("Tom Turn");
						check();
					}
				}
			}
				
			}			
	}
	
		public void firstTurn() {
			//we use try catch mathod
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
			if(random.nextInt(2)==0) {
				player1_turn=true;
				textfield.setText("X turn");
			}//must be player two turn so we use lese statement
			else {
				player1_turn=false;
				textfield.setText("O turn");
			}
		}
		
		public void check() {
			//check X win conditions
			//we have 8 condition to win as a x player as well as o player
			if(
					(buttons[0].getText()=="X") &&
					(buttons[1].getText()=="X") &&
					(buttons[2].getText()=="X")
					) {
				xWins(0,1,2);
			}
			if(
					(buttons[3].getText()=="X") &&
					(buttons[4].getText()=="X") &&
					(buttons[5].getText()=="X")
					) {
				xWins(3,4,5);
			}
			if(
					(buttons[6].getText()=="X") &&
					(buttons[7].getText()=="X") &&
					(buttons[8].getText()=="X")
					) {
				xWins(6,7,8);
			}
			if(
					(buttons[0].getText()=="X") &&
					(buttons[3].getText()=="X") &&
					(buttons[6].getText()=="X")
					) {
				xWins(0,3,6);
			}
			if(
					(buttons[1].getText()=="X") &&
					(buttons[4].getText()=="X") &&
					(buttons[7].getText()=="X")
					) {
				xWins(1,4,7);
			}
			if(
					(buttons[2].getText()=="X") &&
					(buttons[5].getText()=="X") &&
					(buttons[8].getText()=="X")
					) {
				xWins(2,5,8);
			}
			if(
					(buttons[0].getText()=="X") &&
					(buttons[4].getText()=="X") &&
					(buttons[8].getText()=="X")
					) {
				xWins(0,4,8);
			}
			if(
					(buttons[2].getText()=="X") &&
					(buttons[4].getText()=="X") &&
					(buttons[6].getText()=="X")
					) {
				xWins(2,4,6);
			}
			//check O win conditions
			if(
					(buttons[0].getText()=="O") &&
					(buttons[1].getText()=="O") &&
					(buttons[2].getText()=="O")
					) {
				oWins(0,1,2);
			}
			if(
					(buttons[3].getText()=="O") &&
					(buttons[4].getText()=="O") &&
					(buttons[5].getText()=="O")
					) {
				oWins(3,4,5);
			}
			if(
					(buttons[6].getText()=="O") &&
					(buttons[7].getText()=="O") &&
					(buttons[8].getText()=="O")
					) {
				oWins(6,7,8);
			}
			if(
					(buttons[0].getText()=="O") &&
					(buttons[3].getText()=="O") &&
					(buttons[6].getText()=="O")
					) {
				oWins(0,3,6);
			}
			if(
					(buttons[1].getText()=="O") &&
					(buttons[4].getText()=="O") &&
					(buttons[7].getText()=="O")
					) {
				oWins(1,4,7);
			}
			if(
					(buttons[2].getText()=="O") &&
					(buttons[5].getText()=="O") &&
					(buttons[8].getText()=="O")
					) {
				oWins(2,5,8);
			}
			if(
					(buttons[0].getText()=="O") &&
					(buttons[4].getText()=="O") &&
					(buttons[8].getText()=="O")
					) {
				oWins(0,4,8);
			}
			if(
					(buttons[2].getText()=="O") &&
					(buttons[4].getText()=="O") &&
					(buttons[6].getText()=="O")
					) {
				oWins(2,4,6);
			}
			
		}
		public void xWins(int a,int b,int c) {
			buttons[a].setBackground(Color.GRAY);
			buttons[b].setBackground(Color.GRAY);
			buttons[c].setBackground(Color.GRAY);
			
			for(int i=0;i<9;i++) {
				buttons[i].setEnabled(false);
			}
			textfield.setText("Tom wins");
		}
		public void oWins(int a,int b,int c) {
			buttons[a].setBackground(Color.PINK);
			buttons[b].setBackground(Color.PINK);
			buttons[c].setBackground(Color.PINK);
			
			for(int i=0;i<9;i++) {
				buttons[i].setEnabled(false);
			}
			textfield.setText("Jerry wins");
		}

		}
	


