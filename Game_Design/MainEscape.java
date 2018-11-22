import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author angelorey
 *
 */

@SuppressWarnings("serial")
public class MainEscape extends JApplet {
	PuzzleDesign puzzles;
	int current;
	JTextArea textArea;
	String printScript;
	JTextField textFieldUserInput;
	JPanel mainPanel = new JPanel();
	String scr;			// THIS IS THE ONE YOU HAVE TO UPDATE EVERYTIME YOU WANT TO PRINT A LINE ON THE TEXT AREA

	int line = 0;
	int puzzleDesIndex = 0;

	public MainEscape() {

		this.puzzles = new PuzzleDesign();
		this.current = 1;

		getContentPane().setLayout(null);

		JPanel panelBorderBlack = new JPanel();
		panelBorderBlack.setBackground(Color.BLACK);
		panelBorderBlack.setBounds(0, 0, 1000, 700);	// DIMENSIONS OF THE APPLET
		getContentPane().add(panelBorderBlack);
		panelBorderBlack.setLayout(null);

		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(10, 11, 980, 678);
		panelBorderBlack.add(mainPanel);
		mainPanel.setLayout(null);

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Open Sans", Font.PLAIN, 14));
		textArea.setBounds(10, 11, 960, 656);
		textArea.setWrapStyleWord(true);
		textArea.setMargin(new Insets(10, 10, 10, 10));

		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(10, 11, 960, 600);
		mainPanel.add(scroll);

		textFieldUserInput = new JTextField();
		textFieldUserInput.setBounds(10, 622, 809, 45);
		mainPanel.add(textFieldUserInput);
		textFieldUserInput.setColumns(10);

		JButton btnNewButton = new JButton("START");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if((puzzles.numOfPuzz) > line) {
					btnNewButton.setText("ENTER");
					startThread(line);
					textArea.append(printScript); // PRINTING TO THE TEXT AREA FROM DISPLAY
					line++; // update index line to be printed
					
					System.out.println(puzzles.puzzDes[1].textSc.length);
					System.out.println(puzzles.puzzDes.length);
					System.out.println(puzzles.numOfPuzz);
				}
				else {
					options(current);
					textArea.append(printScript);
				}
//				if(puzzles.puzzDes[0].textSc.length)
				
			}
		});
		btnNewButton.setFont(new Font("Open Sans Semibold", Font.BOLD, 11));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(829, 622, 141, 45);
		mainPanel.add(btnNewButton);

	}

	private int startThread(int indexOfLine) {
		display(1, indexOfLine);
		int i = line;
		return i;
	}

	private void display(int scriptNum, int index) {
		scr = "";
		scr = puzzles.puzzDes[0].textSc[scriptNum - 1][index].read() + "\n";
		printScript = scr;
		System.out.println("Progress: " + puzzles.puzzDes[0].counter);
	}
	
	private void options(int i) {
		scr = "~\nP - go near the portrait \nB - go near the bookshelf \nC - check the plants \nT - go to coffee table \nD - come closer to the door)\n~";
		printScript = scr;
		System.out.println("(P - go near the portrait) (B - go near the bookshelf) (C - check the plants) (T - go to coffee table) (D - come closer to the door)");
//		switch (com.toUpperCase()) {
//		case "P":
//			portrait();
//			break;
//		case "B":
//			bookshelf();
//			break;
//		case "C":
//			plants();
//			break;
//		case "T":
//			coffee();
//			break;
//		case "D":
//			door2();
//			break;
//		default:
//			System.out.println("That's not a command I recognize.");
//			options(i);
//			break;		
//		}
	} 
	
}
