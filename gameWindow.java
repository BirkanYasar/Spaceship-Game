import java.awt.HeadlessException;

import javax.swing.JFrame;

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
	
	
	
		
	}

}
