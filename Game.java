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
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
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

	Timer timer = new Timer(10,this);
	
	private int time_to_pass = 0;
	private int spendFire = 0;
	
	private BufferedImage image;
	
	private ArrayList<Fire> fires = new ArrayList<Fire>();
	
	private int firedirY = 10;
	private int targetX = 0;
	private int targetdirx = 10;
	private int spaceshipX = 350;
	private int spaceshipdirX = 20;
	
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
		g.drawImage(image, spaceshipX, 480, image.getWidth() / 13, image.getHeight() / 13, this);
		
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
	
	public void fireSound() {
		
		try {
			AudioInputStream audio = AudioSystem.getAudioInputStream(new File("spaceship_fire.wav"));
			
			Clip clip = AudioSystem.getClip();
			
			clip.open();
			clip.start();
			
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(Fire fire : fires) {
			fire.setY(fire.getY() - firedirY);
		}
		
		targetX += targetdirx;
		
		if(targetX >= 750) {
			targetdirx = -targetdirx;
		}
		if(targetX <= 0) {
			targetdirx = -targetdirx;
		}
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int c = e.getKeyCode();
		
		if(c == KeyEvent.VK_LEFT) {
			
			if(spaceshipX <= 0) {
				spaceshipX = 0;
			}else {
				spaceshipX -= spaceshipdirX;
			}
		}else if(c == KeyEvent.VK_RIGHT) {
			if(spaceshipX >= 750) {
				spaceshipX = 750;
			}else {
				spaceshipX += spaceshipdirX;
			}
		}
		else if(c == KeyEvent.VK_CONTROL) {
			
			fires.add(new Fire(spaceshipX+30, 470));
			
			spendFire++;
		}
		fireSound();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {		
	}

}
