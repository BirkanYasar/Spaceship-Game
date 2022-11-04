import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

class Fire {
	
	private int x;
	private int y;
	
	public Fire(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	
	
}

public class Game extends JPanel implements KeyListener,ActionListener {

	Timer timer = new Timer(2,this);
	
	private int time_to_pass = 0;
	private int spendFire = 0;
	
	private BufferedImage image;
	
	private ArrayList<Fire> fires = new ArrayList<Fire>();
	
	private int firedirY = 10;
	private int targetX = 0;
	private int targetdirx = 10;
	private int spaceshipX = 350;
	
	boolean question = false;
	
	public boolean control() {
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
