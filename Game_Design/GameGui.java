import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameGui {

	GameFlow game;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameFlow start = new GameFlow();
					GameGui window = new GameGui(start);
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
	public GameGui(GameFlow game) {
		this.game = game;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 707, 459);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitleHere = new JLabel("title here");
		lblTitleHere.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleHere.setFont(new Font("Serif", Font.PLAIN, 31));
		lblTitleHere.setBounds(135, 38, 433, 73);
		frame.getContentPane().add(lblTitleHere);
		
		JButton btnStart = new JButton("Start");
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MainGui newWindow = new MainGui();
				newWindow.setVisible(true);
				frame.dispose();
			}
		});
		btnStart.setBounds(304, 209, 89, 23);
		frame.getContentPane().add(btnStart);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				QuitDialog quit = new QuitDialog();
				quit.setVisible(true);
				quit.setAlwaysOnTop(true);
			}
		});
		btnQuit.setBounds(304, 283, 89, 23);
		frame.getContentPane().add(btnQuit);
	}
}
