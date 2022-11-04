import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JOptionPane;
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
		
		for(Fire fire : fires) {
			
			if(new Rectangle(fire.getX(), fire.getY(), 10,20).intersects(targetX,0,20,20)) {
				return true;
			}
		}
		return false;
	}
	
	Game() {
		
		try {
			image = ImageIO.read(new FileImageInputStream(new File("SpaceRocket.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setBackground(Color.BLACK);
		
		timer.start();
	}
	
	
	
	
	@Override
	public void repaint() {
		super.repaint();
	}

	@Override
	public void paint(Graphics g) {
		
		time_to_pass += 5;
		
		super.paint(g);
		
		g.setColor(Color.RED);
		g.fillOval(targetX, 0, 20, 20);
		g.drawImage(image, spaceshipX, 490, image.getWidth() / 10, image.getHeight() / 10, this);
		
		for(Fire fire : fires) {
			
			if(fire.getY() < 0) {
				fires.remove(fire);
			}
		}
		g.setColor(Color.BLUE);
		
		for(Fire fire : fires) {
			
			g.fillRect(fire.getX(), fire.getY(), 8, 12);
		}
		
		if(control()) {
			timer.stop();
			
			String message = "Congratulations!\n"
							+" You managed to hit the target!"
							+"Spent Fires : " + spendFire + "\nElapsed time : " + time_to_pass / 1000.0;
			
			JOptionPane.showMessageDialog(null, message);
			
			System.exit(0);
			
		}
		
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
