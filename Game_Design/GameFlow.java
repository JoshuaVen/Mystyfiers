

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;

/**
 * @author angelorey
 *
 */
public class GameFlow {

	private JFrame frame;
	private JTextField textField;
	static String strLine;
	
	PuzzleDesign puzzles;
	int current;
	
	String printScr;
	String scr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameFlow window = new GameFlow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public GameFlow() {
		initialize();
		this.puzzles = new PuzzleDesign();
		this.current = 1;
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);	// TO MAKE WINDOW START IN THE MIDDLE
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1274, 691);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 1254, 669);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Open Sans", Font.PLAIN, 15));
		textArea.setBounds(10, 11, 1234, 583);
		textArea.setWrapStyleWord(true);
		textArea.setMargin(new Insets(10, 10, 10, 10));
		
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(10, 11, 1234, 583);
		panel_1.add(scroll);
		
		textField = new JTextField();
		textField.setForeground(new Color(0, 0, 128));
		textField.setFont(new Font("Open Sans", Font.PLAIN, 14));
		textField.setBounds(10, 605, 916, 53);
		panel_1.add(textField);
		textField.setColumns(10);
//		textField.setEditable(false);
		
		
		JButton startbutton = new JButton("START");
		startbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				startbutton.setText("ENTER");
				scr = "";
				printToTextArea();	// TODO make a function for strings to just be prepared to be printed
				textArea.append(scr);
				getTextFieldInput();
			}
		});
		startbutton.setBackground(Color.BLACK);
		startbutton.setForeground(Color.WHITE);
		startbutton.setFont(new Font("Open Sans", Font.PLAIN, 12));
		startbutton.setBounds(936, 605, 149, 53);
		panel_1.add(startbutton);
		
		JButton exitbutton = new JButton("MAIN MENU");
		exitbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitbutton.setText("Really?");
				exitbutton.setBackground(Color.red);
			}
		});
		exitbutton.setBackground(Color.BLACK);
		exitbutton.setForeground(Color.WHITE);
		exitbutton.setFont(new Font("Open Sans", Font.PLAIN, 12));
		exitbutton.setBounds(1095, 605, 149, 53);
		panel_1.add(exitbutton);
		
	}
	
	public void printToTextArea() {
		display(1);
		options(1);
	}
	
	public String getTextFieldInput() {
		String updateField = textField.getText();
		textField.setText("");
		return updateField;
	}
	
	// 
	public String display(int scriptNum) {
		String text = "";
		int toMatchTheArray = 1; // removed the magic number
		for (int i = 0; i < puzzles.puzzDes[0].actualSizeOfSc(scriptNum); i++) {
			text = text + puzzles.puzzDes[0].textSc[scriptNum - toMatchTheArray][i].read()  + "\n" ;
		}
		return text;
	}
	
	// CAN YOU EXPLAIN THIS??
	//Since script is stored in an array, and the script numbering start at 1, we have to subtract 1 from the script numbering so that it will match
	//to what is stored in the array
	//Another puzzDes[0] input zero since from the start, we thought that there would be many puzzles in this game, unfortunately, we only have one or two, which is stored in
	//an array hence, we placed it immediately instead of having some variable
	public  String branchDisplay(int ifScript, int elseScript) {
		int toMatchTheArray = 1; // removed the magic number
		int firstLineOfTheScript = 0;
		if (puzzles.puzzDes[0].textSc[ifScript - toMatchTheArray][firstLineOfTheScript].isRead == false) {
			return display(ifScript);
		} else {
			return display(elseScript);
		}
	}
	
	
	//not sure if this needs fixing 
	public void options(int i) {
		if (puzzles.puzzDes[0].checkProblemIfSolved("isHoundChecked") && puzzles.puzzDes[0].checkProblemIfSolved("isPlantsChecked")
				&& puzzles.puzzDes[0].checkProblemIfSolved("isCoffeeChecked") && puzzles.puzzDes[0].checkProblemIfSolved("isPortraitChecked")) {
			scr += "(P - go near the portrait) (B - go near the bookshelf) (C - check the plants) (T - go to coffee table) (D - come closer to the door)"  + "\n";
		} else {
			scr += "(B - go near the bookshelf) (C - check the plants) (T - go to coffee table) (P - go near the portrait)"  + "\n";
		}
		printScr = scr;
		
//		Scanner in = new Scanner(System.in);
		
		String com = getTextFieldInput(); // get the textField input from this function
		switch (com.toUpperCase()) {
		case "P":
			portrait();
			break;
		case "B":
			scr = ""; // do not forget to set this string to empty otherwise it will print everything from the start till the latest output
			bookshelf();
			
			break;
		case "C":
			plants();
			break;
		case "T":
			coffee();
			break;
		case "D":
			door2();
			break;
		default:
			if(!com.equals("")) {
			scr += "That's not a command I recognize." + "\n"; // changed
			} else {
				scr += "\n";
			}
//			options(i);
			break;		
		}
		printScr += scr;
		
	} 
	
	//following examine2 format for the succeeding methods
	private void bookshelf() {
		String text = ""; 
		branchDisplay(2, 40);
		text = text + "(S - check 'A Study in Scarlet') (B- check 'The Hound of Baskervilles') (H - check 'Hamlet') (G - go back to table)" + "\n";
//		System.out.print("> ");
		Scanner in = new Scanner(System.in);
		String command = getTextFieldInput();
		switch (command.toUpperCase()) {
		case "S":
			scarlet();
			break;
		case "B":
			basker();
			break;
		case "H":
			hamlet();
			break;
		case "G":
			goBack();
			break;
		default:
//			System.out.println("That's not a command I recognize.");
//			bookshelf();
			/*if(!command.equals("")) {
				scr += "That's not a command I recognize." + "\n"; // changed
				} else {
					scr += "\n";
				}*/
			text = text + "That's not a command I recognize." + "\n";
			//slick.display(text);
			bookshelf();
		}
	}
	
	
	// TODO: DO THE SAME AS BOOKSHELF:
	private void scarlet() {
		String text = "";
		display(6);
		text = text + "(C - continue searching bookshelf) (G - go back to table)" + "\n";
		Scanner in = new Scanner(System.in);
//		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toUpperCase()) {
		case "C":
			bookshelf();
			break;
		case "G":
			goBack();
			break;
		default:
			//System.out.println("That's not a command I recognize.");
			text = text + "That's not a command I recognize." + "\n";
			//slick.display(text);
			scarlet();	
		}
	}
	
	private void basker() {
		String text = "";
		if (puzzles.puzzDes[0].checkProblemIfSolved("isHoundChecked") == false) {
			branchDisplay(3, 34);
		} else {
			display(14);
			goBack();
		}
		Scanner in = new Scanner(System.in);
		text = text + "(C - continue searching bookshelf) (E - enter solution) (G - go back to table)" + "\n";
//		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toUpperCase()) {
		case "C":
			bookshelf();
			break;
		case "E":
			pass1();
			break;
		case "G":
			goBack();
			break;
		default:
			text = text + "That's not a command I recognize." + "\n";
			//slick.display(text);
			basker();		
		}
	}
	
	private void pass1() {
		String text = "";
		text = text + "Enter text message: " + "\n";
		Scanner in = new Scanner(System.in);
//		System.out.print("> ");
		String command = in.nextLine();
		String pass = new String("man");
		command = command.toLowerCase();
		if (!command.matches(pass) ) {
			display(5);
			basker();
		} else if (command.matches(pass)) {
			display(4);
			puzzles.puzzDes[0].changeToSolved("isHoundChecked");
			goBack();
		} else {
			basker();
		}
	}
	
	private void hamlet() {
		String text = "";
		Scanner in = new Scanner(System.in);
		display(7);
		text = text + "(C - continue searching bookshelf) (G - go back to table)" + "\n";
//		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toUpperCase()) {
		case "C":
			bookshelf();
			break;
		case "G":
			goBack();
			break;
		default:
			text = text + "That's not a command I recognize." + "\n";
			//slick.display(text);
			hamlet();	
		}
	}
	
	private void plants() {
		String text = "";
		if (puzzles.puzzDes[0].checkProblemIfSolved("isPlantsChecked") == false) {
			branchDisplay(8, 9);
		} else {
			display(15);
			goBack();
		}
		Scanner in = new Scanner(System.in);
		text = text + "(C - check bottom of pots) (G - go back to table)" + "\n";
//		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toUpperCase()) {
		case "C":
			bottom();
			break;
		case "G":
			goBack();
			break;
		default:
			text = text + "That's not a command I recognize." + "\n";
			//slick.display(text);
			plants();	
		}
	}
	
	private void bottom() {
		String text = "";
		branchDisplay(10, 35);
		Scanner in = new Scanner(System.in);
		text = text + "(E - enter solution) (G - go back to table)" + "\n";
//		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toUpperCase()) {
		case "E":
			pass2();
			break;
		case "G":
			goBack();
			break;
		default:
			text = text + "That's not a command I recognize." + "\n";
			//slick.display(text);
			bottom();		
		}
	}

	//should this be in string?
	//needs converting if yes
	//also needs error handling if user inputs string instead of int
	private void pass2() {
		String text = "";
		text = text + "Enter code: " + "\n";
		Scanner in = new Scanner(System.in);
//		System.out.print("> ");
		int code = in.nextInt();
		if (code == 10) {
			display(11);
			key();
		} else if (code != 10) {
			display(12);
			bottom();
		} else {      //expected for no input, not yet working
			goBack();
		}
	}
	
	private void key() {
		String text = "";
		if (puzzles.puzzDes[0].checkProblemIfSolved("isHoundChecked")) {
			text = text + "(U - use key) (G - go back to table)" + "\n";
		} else {
			text = text + "(G - go back to table)" + "\n";
		}
		Scanner in = new Scanner(System.in);
//		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toUpperCase()) {
		case "U":
			display(13);
			puzzles.puzzDes[0].changeToSolved("isPlantsChecked");
			goBack();
			break;
		case "G":
			goBack();
			break;
		default:
			text = text + "That's not a command I recognize." + "\n";
			//slick.display(text);
			key();	
		}
	}
	
	private void coffee() {
		String text = "";
		if (puzzles.puzzDes[0].checkProblemIfSolved("isCoffeeChecked") == false) {
			branchDisplay(16, 17);
		} else {
			display(21);
			goBack();
		}
		Scanner in = new Scanner(System.in);
		text = text + "(R - recline the chair)(G - go back to table)"+ "\n";
//		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toUpperCase()) {
		case "R":
			recline();
			break;
		case "G":
			goBack();
			break;
		default:
			text = text + "That's not a command I recognize." + "\n";
			//slick.display(text);
			coffee();	
		}
	}
	
	private void recline() {
		String text = "";
		branchDisplay(18, 36);
		Scanner in = new Scanner(System.in);
		text = text + "(T - type password) (G - go back to table)" + "\n";
//		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toUpperCase()) {
		case "T":
			pass4();
			break;
		case "G":
			goBack();
			break;
		default:
			text = text + "That's not a command I recognize." + "\n";
			//slick.display(text);
			recline();	
		}
	}
	
	private void pass4() {
		String text = "";
		text = text + "Enter the answer: " + "\n";
		Scanner in = new Scanner(System.in);
//		System.out.print("> ");
		String command = in.nextLine();
		String pass = new String("chicago");
		command = command.toLowerCase();
		if (!command.matches(pass) ) {
			display(19);
			recline();
		} else if (command.matches(pass)) {
			display(20);
			puzzles.puzzDes[0].changeToSolved("isCoffeeChecked");
			goBack();
		} else {
			coffee();
		}
	}
	
	private void portrait() {
		String text = "";
		if (puzzles.puzzDes[0].checkProblemIfSolved("isPortraitChecked") == false) {
			branchDisplay(22, 23);
		} else {
			display(29);
			goBack();
		}
		Scanner in = new Scanner(System.in);
		text = text + "(T - try to take it off)(G - go back to table)(C - Check broken tile)" + "\n";
//		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toUpperCase()) {
		case "T":
			take();
			break;
		case "G":
			goBack();
			break;
		case "C":
			brokenTile();
			break;
		default:
			text = text + "That's not a command I recognize." + "\n";
			//slick.display(text);
			portrait();		
		}
	}
	
	private void take() {
		String text = "";
		branchDisplay(25, 26);
		Scanner in = new Scanner(System.in);
		text = text + "(E - enter code) (G - go back to table)" + "\n";
//		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toUpperCase()) {
		case "E":
			pass5();
			break;
		case "G":
			goBack();
			break;
		default:
			text = text + "That's not a command I recognize." + "\n";
			//slick.display(text);
			take();		
		}
	}
	
	//might need fixing since input should be int
	//also needs error handling if user inputs string instead of int
	private void pass5() {
		String text = "";
		text = text + "Enter code: " + "\n";
		Scanner in = new Scanner(System.in);
//		System.out.print("> ");
		int code = in.nextInt();
		if (code == 41) {
			display(28);
			puzzles.puzzDes[0].changeToSolved("isPortraitChecked");
			goBack();
		} else if (code != 41) {
			display(27);
			take();
		} else {      //expected for no input, not yet working
			goBack();
		}
		in.close();
	}
	
	private void brokenTile() {
		String text = "";
		branchDisplay(24, 37);
		Scanner in = new Scanner(System.in);
		text = text + "(C - Continue cheking the portrait) (G - go back to table)" + "\n";
//		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toUpperCase()) {
		case "C":
			portrait();
			break;
		case "G":
			goBack();
			break;
		default:
			text = text + "That's not a command I recognize." + "\n";
			//slick.display(text);
			brokenTile();	
		}
	}
	
	private void door2() {
		String text = "";
		branchDisplay(31, 38);
		Scanner in = new Scanner(System.in);
		text = text + "(S - Say the name) (G - go back to table)" + "\n";
//		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toUpperCase()) {
		case "S":
			pass6();
			break;
		case "G":
			goBack();
			break;
		default:
			text = text + "That's not a command I recognize." + "\n";
			//slick.display(text);
			door2();		
		}
	}
	
	private void pass6() {
		String text = "";
		text = text + "Enter the answer: " + "\n";
		Scanner in = new Scanner(System.in);
//		System.out.print("> ");
		String command = in.nextLine();
		String pass = new String("charley");
		command = command.toLowerCase();
		if (!command.matches(pass) ) {
			display(32);
			door2();
		} else if (command.matches(pass)) {
			display(33);
			//puzzles.puzzDes[0].changeToSolved("isDoorChecked");
			display(39);
			bridge();
		} else {
			door2();
		}
		in.close();
	}
	
	private void goBack() {
		display(30);
		options(1);
	}
	
	private void bridge() {
		String text = "";
		display(54);
		text = text + "(C - continue the story) (E - exit the game)" + "\n";
		Scanner in = new Scanner(System.in);
//		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toUpperCase()) {
		case "C":
			story2();
			break;
		case "E":
			System.exit(0);
			break;
		default:
			text = text + "That's not a command I recognize." + "\n";
			//slick.display(text);
			bridge();	
		}
	}
	
	private void story2() {
		String text = "";
		display(41);
		display(42);
		text = text + "(C - Go to Charley's house) (G - go back to bed)" + "\n";
		Scanner in = new Scanner(System.in);
//		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toUpperCase()) {
		case "C":
			charleysHouse();
			break;
		case "G":
			goBack2();
			break;
		default:
			text = text + "That's not a command I recognize." + "\n";
			//slick.display(text);
			story2();		
		}
	}
	
	private void charleysHouse() {
		String text = "";
		display(44);
		text = text + "(E - examine his room) (go back home)" + "\n";
//		System.out.print("> ");
		Scanner in = new Scanner(System.in);
		String command = in.nextLine();
		switch(command.toUpperCase()) {
		case "E":
			examine2();
			break;
		case "G":
			goBack2();
			break;
		default:
			text = text + "That's not a command I recognize." + "\n";
			//slick.display(text);
			charleysHouse();
		}
	}
	
	private void examine2() {
		String text = "";
		branchDisplay(45, 46);
		text = text + "(E -Enter code) (C - check email again) (G - go back home)" + "\n";
//		System.out.print("> ");
		Scanner in = new Scanner(System.in);
		String command = in.nextLine();
		switch (command.toUpperCase()) {
		case "E":
			pass7();
			break;
		case "C":
			checkEmail();
			break;
		case "G":
			goBack2();
			break;
		default:
			text = text + "That's not a command I recognize." + "\n";
			
			//slick.display(text);
			examine2();
		}
	}
	
	private void checkEmail() {
		String text = "";
		display(42);
		text = text + "(C - go to Charley's house) (G - go back to bed)" + "\n";
//		System.out.print("> ");
		Scanner in = new Scanner(System.in);
		String command = in.nextLine();
		switch (command.toUpperCase()) {
		case "C":
			charleysHouse();
			break;
		case "G":
			goBack2();
			break;
		default:
			text = text + "That's not a command I recognize." + "\n";
			//slick.display(text);
			checkEmail();
		}
	}
	
	//might need fixing
	//accepts int again
	//also needs error handling if user inputs string instead of int
	private void pass7() {
		String text = "";
		text = text + "Enter code: " + "\n";
		Scanner in = new Scanner(System.in);
//		System.out.print("> ");
		int code = in.nextInt();
		if (code == 120) {
			pass8();
		} else if (code != 120) {
			display(47);
			examine2();
		} else {      //expected for no input, not yet working
			charleysHouse();
		}
		in.close();
	}
	
	//might need fixing
	//accepts int again
	//also needs error handling if user inputs string instead of int
	private void pass8() {
		String text = "";
		branchDisplay(48,49);
		text = text + "Enter code: " + "\n";
		Scanner in = new Scanner(System.in);
//		System.out.print("> ");
		int code = in.nextInt();
		if (code == 5247) {
			end();
		} else if (code != 5247) {
			display(50);
			pass8();
		} else {      //expected for no input, not yet working
			charleysHouse();
		}
		in.close();
	}
	
	private void goBack2() {
		String text = "";
		display(43);
		text = text + "(C - check email) (G - go to Charley's house)" + "\n";
//		System.out.print("> ");
		Scanner in = new Scanner(System.in);
		String command = in.nextLine();
		switch (command.toUpperCase()) {
		case "C":
			checkEmail();
			break;
		case "G":
			charleysHouse();
			break;
		default:
			text = text + "That's not a command I recognize." + "\n";
			//slick.display(text);
			goBack2();	
		}
	}
	
	//needs implementation for restarting game?
	private void end() {
		String text = "";
		display(51);
		display(52);
		display(54);
		text = text + "(P - play again) (Q - Quit the game)" + "\n";
//		System.out.println("> ");
		Scanner in = new Scanner(System.in);
		String command = in.nextLine();
		switch (command.toUpperCase()) {
		case "P":
		printToTextArea();
			break;
		case "Q":
			System.exit(0);
			break;
		default:
			text = text + "That's not a command I recognize." + "\n";
			//slick.display(text);
			end();
		}
	}

}
