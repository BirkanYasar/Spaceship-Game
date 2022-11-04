import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class gameWindow extends JFrame{
	
	public gameWindow(String title) throws HeadlessException {
		super(title);
	}
	
	public static void main(String[] args) {
		
	gameWindow window = new gameWindow("Spaceship Game");
	
	window.setResizable(false);
	window.setFocusable(false);
	window.setSize(800,600);
	
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	Game game = new Game();
	
	game.requestFocus();
	
	game.addKeyListener(game);
	
	game.setFocusable(true);
	game.setFocusTraversalKeysEnabled(false);
	
	window.add(game);
	
	ArrayList<String> player_list = new ArrayList<String>();
	
	String names = JOptionPane.showInputDialog("Please text to your name.");
	
	player_list.add(names);
	
	window.setVisible(true);
	
		
	}

}
