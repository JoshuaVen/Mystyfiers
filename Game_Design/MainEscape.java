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

/**
* Hi, you can try to run this code, there is no KeyEvent for "Enter" key yet, so if
* you want to print the script lines, just click Enter button.
* Enter is also until the last line of
* puzz2.addScript(1, string), after that, it will show 
* Exception in thread "AWT-EventQueue-1" java.lang.ArrayIndexOutOfBoundsException
*/

public class MainEscape extends JApplet {
	PuzzleDesign puzzles;
	int current;
	JTextArea textArea;
	String printScript;
	JTextField textFieldUserInput;
	JPanel mainPanel = new JPanel();
	
	int line = 0;
	
	public MainEscape() {
		this.puzzles = new PuzzleDesign();
		this.current = 1;
		
		getContentPane().setLayout(null);
		
		JPanel panelBorderBlack = new JPanel();
		panelBorderBlack.setBackground(Color.BLACK);
		panelBorderBlack.setBounds(0, 0, 1000, 700);
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
	    textArea.setMargin(new Insets(10,10,10,10));
	    
	    JScrollPane scroll = new JScrollPane (textArea);
	    scroll.setBounds(10, 11, 960, 600);
	    mainPanel.add(scroll);
	    

	    
	    textFieldUserInput = new JTextField();
	    textFieldUserInput.setBounds(10, 622, 809, 45);
	    mainPanel.add(textFieldUserInput);
	    textFieldUserInput.setColumns(10);
	    
	    JButton btnNewButton = new JButton("ENTER");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		startThread(line);
	    		textArea.append(printScript);	// PRINTING TO THE TEXT AREA FROM DISPLAY
	    		line++;
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
		String scr = "";
			scr = scr + puzzles.puzzDes[0].textSc[scriptNum - 1][index].read() + "\n";
		
		printScript = scr;
		System.out.println("Progress: " + puzzles.puzzDes[0].counter);
	}
}
