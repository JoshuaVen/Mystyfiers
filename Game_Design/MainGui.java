import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

@SuppressWarnings({ "unused", "serial" })
public class MainGui extends JFrame {

	private JPanel contentPane;
	private JTextField textInput;
	JTextArea displayText;
	JTextPane progressCounter;
	PuzzleDesign puzzles;
	JButton btnEnter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGui frame = new MainGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainGui() {
		this.puzzles = new PuzzleDesign();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		displayText = new JTextArea();
		displayText.setLineWrap(true);
		displayText.setFont(new Font("Monospaced", Font.PLAIN, 13));
		displayText.setEditable(false);
		displayText.setBounds(10, 11, 741, 359);
		contentPane.add(displayText);

		textInput = new JTextField();
		textInput.setBounds(10, 381, 270, 28);
		contentPane.add(textInput);
		textInput.setColumns(10);

		progressCounter = new JTextPane();
		progressCounter.setBounds(389, 386, 104, 20);
		contentPane.add(progressCounter);

		JLabel lblProgress = new JLabel("Progress");
		lblProgress.setBounds(503, 388, 89, 14);
		contentPane.add(lblProgress);

		btnEnter = new JButton("Enter");
		btnEnter.setBounds(290, 384, 89, 23);
		contentPane.add(btnEnter);

		JButton btnMenu = new JButton("Menu");
		btnMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				QuitDialog quit = new QuitDialog();
				quit.setVisible(true);
				quit.setAlwaysOnTop(true);
			}
		});
		btnMenu.setBounds(662, 384, 89, 23);
		contentPane.add(btnMenu);

		intro();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void intro() {
		display(1);
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				display(2);
				displayText.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						optionsDisplay();
					}
				});
			}
		});
		
	}

	
	public void display(int scriptNum) {
		displayText.addMouseListener(new MouseAdapter() {
			String text = "";
			public void mouseClicked(MouseEvent e) {
				
				int toMatchTheArray = 1; // removed the magic number
				for (int i = 0; i < puzzles.puzzDes[0].actualSizeOfSc(scriptNum); i++) {
					text = text + puzzles.puzzDes[0].textSc[scriptNum - toMatchTheArray][i].read()  + "\n" ;
				}
				displayText.setText(text);
			}
			
		});
	}


	public  void branchDisplay(int ifScript, int elseScript) {
		int toMatchTheArray = 1; // removed the magic number
		int firstLineOfTheScript = 0;
		if (puzzles.puzzDes[0].textSc[ifScript - toMatchTheArray][firstLineOfTheScript].isRead == false) {
			display(ifScript);
		} else {
			display(elseScript);
		}
	}


	//not sure if this needs fixing 
	public void optionsDisplay() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String text = "";
				if (puzzles.puzzDes[0].checkProblemIfSolved("isHoundChecked") && puzzles.puzzDes[0].checkProblemIfSolved("isPlantsChecked")
						&& puzzles.puzzDes[0].checkProblemIfSolved("isCoffeeChecked") && puzzles.puzzDes[0].checkProblemIfSolved("isPortraitChecked")) {
					text = "(P - go near the portrait) (B - go near the bookshelf) (C - check the plants) (T - go to coffee table) (D - come closer to the door)"  + "\n";
				} else {
					text = "(B - go near the bookshelf) (C - check the plants) (T - go to coffee table) (P - go near the portrait)"  + "\n";
				}
				displayText.setText(text);
				options();
			}
		});
		
	}

	public void options() {
		btnEnter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String input = textInput.getText();
				switch (input.toUpperCase()) {
				case "P":
					portrait();
					break;
				case "B":
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
					break;		
				}
			}
		});
	} 


	//following examine2 format for the succeeding methods
	private void bookshelf() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String text = ""; 
				displayText.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						branchDisplay(2, 40);
					}
				});
				
				text = "(S - check 'A Study in Scarlet') (B- check 'The Hound of Baskervilles') (H - check 'Hamlet') (G - go back to table)" + "\n";
				displayText.setText(text);
				bookshelfOptions();
			}
		});
	
	}

	private void bookshelfOptions() {
		btnEnter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String input = textInput.getText();
				switch (input.toUpperCase()) {
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
					bookshelf();
				}
			}
		});
		
	}

	private void scarlet() {
		display(6);
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				scarletOptions();
			}
		});
		
	}
	
	private void scarletOptions() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String text = "(C - continue searching bookshelf) (G - go back to table)" + "\n";
				displayText.setText(text);
			}
		});
		scarletChoice();
	}

	private void scarletChoice() {
		btnEnter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String input = textInput.getText();
				switch (input.toUpperCase()) {
				case "C":
					bookshelf();
					break;
				case "G":
					goBack();
					break;
				default:
					
					scarlet();	
				}
			}
		});
		
	}

	private void basker() {
		
		if (puzzles.puzzDes[0].checkProblemIfSolved("isHoundChecked") == false) {
			branchDisplay(3, 34);
			displayText.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					baskerOptions();
				}
			});
		} else {
			display(14);
//			displayText.addMouseListener(new MouseAdapter() {
//				public void mouseClicked(MouseEvent e) {
//					
//				}
//			});
			goBack();
		}
		
	}

	private void baskerOptions() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String text = "(C - continue searching bookshelf) (E - enter solution) (G - go back to table)" + "\n";
				displayText.setText(text);
			}
		});
		baskerChoice();
	}

	private void baskerChoice() {
		btnEnter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String input = textInput.getText();
				switch (input.toUpperCase()) {
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
			
					basker();		
				}
			}
		});
		
	}

	private void pass1() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String text = "Enter text message: " + "\n";
				displayText.setText(text);
				pass1Input();
			}
		});
		
	}

	private void pass1Input() {
		btnEnter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String input = textInput.getText();
				switch (input.toLowerCase()) {
				case "man":
					passed1();
					break;
				default:
					failed1();
					break;
				}
			}
		});
		
		goBack();
	}
	
	private void failed1() {
		display(5);
	}
	
	private void passed1() {
		display(4);
		puzzles.puzzDes[0].changeToSolved("isHoundChecked");
	}

	private void hamlet() {
		display(7);
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				hamletOptions();
			}
		});
		
	}

	private void hamletOptions() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String text = "(C - continue searching bookshelf) (G - go back to table)" + "\n";
				displayText.setText(text);
			}
		});
		hamletChoice();
	}

	private void hamletChoice() {
		btnEnter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String command = textInput.getText();
				switch (command.toUpperCase()) {
				case "C":
					bookshelf();
					break;
				case "G":
					goBack();
					break;
				default:
					hamlet();	
				}
			}
		});
		
	}

	private void plants() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (puzzles.puzzDes[0].checkProblemIfSolved("isPlantsChecked") == false) {
					branchDisplay(8, 9);
				} else {
					display(15);
					goBack();
				}
				plantsOptions();
			}
		});
		
	}

	private void plantsOptions() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String text = "(C - check bottom of pots) (G - go back to table)" + "\n";
				displayText.setText(text);
				plantsChoice();
			}
		});
		
	}

	private void plantsChoice() {
		btnEnter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String command = textInput.getText();
				switch (command.toUpperCase()) {
				case "C":
					bottom();
					break;
				case "G":
					goBack();
					break;
				default:
					
					plants();	
				}
			}
		});
		
	}

	private void bottom() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				branchDisplay(10, 35);
				bottomOptions();
			}
		});
		
	}

	private void bottomOptions() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String text = "(E - enter solution) (G - go back to table)" + "\n";
				displayText.setText(text);
				bottomChoice();
			}
		});
		
	}

	private void bottomChoice() {
		btnEnter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String command = textInput.getText();
				switch (command.toUpperCase()) {
				case "E":
					pass2();
					break;
				case "G":
					goBack();
					break;
				default:
					
					bottom();		
				}
			}
		});
		
	}

	//should this be in string?
	//needs converting if yes
	//also needs error handling if user inputs string instead of int
	private void pass2() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String text = "Enter code: " + "\n";
				displayText.setText(text);
				pass2Input();
			}
		});
		
	}

	private void pass2Input() {
		btnEnter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String input = textInput.getText();
				Integer code = Integer.parseInt(input);
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
		});
		
	}

	private void key() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String text = "";
				if (puzzles.puzzDes[0].checkProblemIfSolved("isHoundChecked")) {
					text = "(U - use key) (G - go back to table)" + "\n";
				} else {
					text = "(G - go back to table)" + "\n";
				}
				displayText.setText(text);
				keyChoice();
			}
		});
		
	}

	private void keyChoice() {
		btnEnter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String command = textInput.getText();
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
					
					key();	
				}
			}
		});
		
	}

	private void coffee() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (puzzles.puzzDes[0].checkProblemIfSolved("isCoffeeChecked") == false) {
					branchDisplay(16, 17);
				} else {
					display(21);
					goBack();
				}
				coffeeOptions();
			}
		});
		
	}

	private void coffeeOptions() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String text = "(R - recline the chair)(G - go back to table)"+ "\n";
				displayText.setText(text);
				coffeeChoice();
			}
		});
		
	}

	private void coffeeChoice() {
		btnEnter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String command = textInput.getText();
				switch (command.toUpperCase()) {
				case "R":
					recline();
					break;
				case "G":
					goBack();
					break;
				default:
					
					coffee();	
				}
			}
		});
		
	}

	private void recline() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				branchDisplay(18, 36);
				reclineOptions();
			}
		});
		
	}

	private void reclineOptions() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String text = "(T - type password) (G - go back to table)" + "\n";
				displayText.setText(text);
				reclineChoice();
			}
		});
		
	}

	private void reclineChoice() {
		btnEnter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String command = textInput.getText();
				switch (command.toUpperCase()) {
				case "T":
					pass4();
					break;
				case "G":
					goBack();
					break;
				default:
					
					recline();	
				}
			}
		});
		
	}

	private void pass4() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String text = "Enter the answer: " + "\n";
				displayText.setText(text);
				pass4Input();
			}
		});
		
	}

	private void pass4Input() {
		btnEnter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String command = textInput.getText();
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
		});
		
	}

	private void portrait() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (puzzles.puzzDes[0].checkProblemIfSolved("isPortraitChecked") == false) {
					branchDisplay(22, 23);
				} else {
					display(29);
					goBack();
				}
				portraitOptions();
			}
		});

		
	}

	private void portraitOptions() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String text = "";
				text = "(T - try to take it off)(G - go back to table)(C - Check broken tile)" + "\n";
				displayText.setText(text);
				portraitChoice();
			}
		});
		
	}

	private void portraitChoice() {
		btnEnter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String input = textInput.getText();
				switch (input.toUpperCase()) {
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
					portrait();		
				}
			}
		});
		
	}

	private void take() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				branchDisplay(25, 26);
				takeOptions();
			}
		});
		
	}

	private void takeOptions() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String text = "(E - enter code) (G - go back to table)" + "\n";
				displayText.setText(text);
				takeChoice();
			}
		});
		
	}

	private void takeChoice() {
		btnEnter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String input = textInput.getText();
				switch (input.toUpperCase()) {
				case "E":
					pass5();
					break;
				case "G":
					goBack();
					break;
				default:
					
					take();		
				}
			}
		});
		
	}

	//might need fixing since input should be int
	//also needs error handling if user inputs string instead of int
	private void pass5() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String text = "Enter code: " + "\n";
				displayText.setText(text);
				pass5Input();
			}
		});
	}
		

	private void pass5Input() {
		btnEnter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String input = textInput.getText();
				Integer code = Integer.parseInt(input);
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
			}
		});
		
	}

	private void brokenTile() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				branchDisplay(24, 37);
				brokenTileOptions();
			}
		});
		
	}

	private void brokenTileOptions() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String text = "(C - Continue cheking the portrait) (G - go back to table)" + "\n";
				displayText.setText(text);
				brokenTileChoice();
			}
		});
		
	}

	private void brokenTileChoice() {
		btnEnter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String input = textInput.getText();
				switch (input.toUpperCase()) {
				case "C":
					portrait();
					break;
				case "G":
					goBack();
					break;
				default:
					
					brokenTile();	
				}
			}
		});
		
	}

	private void door2() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				branchDisplay(31, 38);
				door2Options();
			}
		});
		
	}

	private void door2Options() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String text = "(S - Say the name) (G - go back to table)" + "\n";
				displayText.setText(text);
				door2Choice();
			}
		});		
		
	}

	private void door2Choice() {
		btnEnter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String input = textInput.getText();
				switch (input.toUpperCase()) {
				case "S":
					pass6();
					break;
				case "G":
					goBack();
					break;
				default:
					
					door2();		
				}
			}
		});
		
	}

	private void pass6() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String text = "Enter the answer: " + "\n";
				displayText.setText(text);
				pass6Input();
			}
		});
		
	}
	private void pass6Input() {
		btnEnter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String input = textInput.getText();
				String pass = new String("charley");
				input = input.toLowerCase();
				if (!input.matches(pass) ) {
					display(32);
					door2();
				} else if (input.matches(pass)) {
					display(33);
					//puzzles.puzzDes[0].changeToSolved("isDoorChecked");
					display(39);
					bridge();
				} else {
					door2();
				}
			}
		});
		
	}

	private void goBack() {
		display(30);
		optionsDisplay();
	}

	private void bridge() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				display(54);
				bridgeOptions();
			}
		});
		
	}

	private void bridgeOptions() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String text = "(C - continue the story) (E - exit the game)" + "\n";
				displayText.setText(text);
				bridgeChoice();
			}
		});
		
	}
	
	private void bridgeChoice() {
		btnEnter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String command = textInput.getText();
				switch (command.toUpperCase()) {
				case "C":
					story2();
					break;
				case "E":
					System.exit(0);
					break;
				default:
					
					bridge();	
				}
			}
		});
		
	}

	private void story2() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				display(41);
				display(42);
				story2Options();
			}
		});
		
	}
	
	private void story2Options() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String text = "(C - Go to Charley's house) (G - go back to bed)" + "\n";
				displayText.setText(text);
				story2Choice();
			}
		});
		
	}
	
	private void story2Choice() {
		btnEnter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String command = textInput.getText();
				switch (command.toUpperCase()) {
				case "C":
					charleysHouse();
					break;
				case "G":
					goBack2();
					break;
				default:
					
					story2();		
				}
			}
		});
		
	}

	private void charleysHouse() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				display(44);
				charleysHouseOptions();
			}
		});
		
	}
	
	private void charleysHouseOptions() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String text = "(E - examine his room) (go back home)" + "\n";
				displayText.setText(text);
				charleysHouseChoice();
			}
		});
		
	}
	
	private void charleysHouseChoice() {
		btnEnter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String command = textInput.getText();
				switch(command.toUpperCase()) {
				case "E":
					examine2();
					break;
				case "G":
					goBack2();
					break;
				default:
					
					charleysHouse();
				}
			}
		});
		
	}

	private void examine2() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				branchDisplay(45, 46);
				examine2Options();
			}
		});
		
	}
	
	private void examine2Options() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String text = "(E -Enter code) (C - check email again) (G - go back home)" + "\n";
				displayText.setText(text);
				examine2Choice();
			}
		});
		
	}
	
	private void examine2Choice() {
		btnEnter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String command = textInput.getText();
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
					
					examine2();
				}
			}
		});
		
	}

	private void checkEmail() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				display(42);
				checkEmailOptions();
			}
		});
		
	}
	
	private void checkEmailOptions() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String text = "(C - go to Charley's house) (G - go back to bed)" + "\n";
				displayText.setText(text);
				checkEmailChoice();
			}
		});
		
	}
	
	private void checkEmailChoice() {
		btnEnter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String command = textInput.getText();
				switch (command.toUpperCase()) {
				case "C":
					charleysHouse();
					break;
				case "G":
					goBack2();
					break;
				default:
					
					checkEmail();
				}
			}
		});
		
	}

	//might need fixing
	//accepts int again
	//also needs error handling if user inputs string instead of int
	private void pass7() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String text = "Enter code: " + "\n";
				displayText.setText(text);
				pass7Input();
			}
		});
		
	}
	
	private void pass7Input() {
		btnEnter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Integer input = Integer.parseInt(textInput.getText());
				Integer code = input;
				if (code == 120) {
					pass8();
				} else if (code != 120) {
					display(47);
					examine2();
				} else {      //expected for no input, not yet working
					charleysHouse();
				}
			}
		});
		
	}

	//might need fixing
	//accepts int again
	//also needs error handling if user inputs string instead of int
	private void pass8() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				branchDisplay(48,49);
				pass8Input();
			}
		});
		
	}
	
	private void pass8Input() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String text = "Enter code: " + "\n";
				displayText.setText(text);
				pass8Choice();
			}
		});
		
	}
	
	private void pass8Choice() {
		btnEnter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Integer input = Integer.parseInt(textInput.getText());
				Integer code = input;
				if (code == 5247) {
					end();
				} else if (code != 5247) {
					display(50);
					pass8();
				} else {      //expected for no input, not yet working
					charleysHouse();
				}
			}
		});
		
	}

	private void goBack2() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				display(43);
				goBack2Options();
			}
		});
		
	}
	
	private void goBack2Options() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String text = "(C - check email) (G - go to Charley's house)" + "\n";
				displayText.setText(text);
				goBack2Choice();
			}
		});
		
	}
	
	private void goBack2Choice() {
		btnEnter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String command = textInput.getText();
				switch (command.toUpperCase()) {
				case "C":
					checkEmail();
					break;
				case "G":
					charleysHouse();
					break;
				default:
					
					goBack2();	
				}
			}
		});
		
	}

	//needs implementation for restarting game?
	private void end() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				display(51);
				display(52);
				display(54);
				endOptions();
			}
		});
		
	}
	
	private void endOptions() {
		displayText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String text = "(P - play again) (Q - Quit the game)" + "\n";
				displayText.setText(text);
				endChoice();
			}
		});
		
	}
	
	private void endChoice() {
		btnEnter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String command = textInput.getText();
				switch (command.toUpperCase()) {
				case "P":
					MainGui newgame = new MainGui();
					newgame.setVisible(true);
					dispose();
					break;
				case "Q":
					System.exit(0);
					break;
				default:
					
					end();
				}
			}
		});
		
	}

}
