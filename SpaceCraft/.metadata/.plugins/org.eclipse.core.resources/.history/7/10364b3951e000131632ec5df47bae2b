package Objects;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import Frame.Space;
import Ships.Ship;


public class Bullet extends Ship{
	
	private boolean stopped=false;
	
	public Bullet(Space s,int x, int y) {
		super(s,x, y,5,5,Color.white);
		speed=2;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.yellow);
		g2.fillOval(0,0,5,5);
	}
	
	public void move(){
		calculateMove(target);
	}
	
	public boolean stopped(){
		return Math.abs(getDistance(target))<10;
	}
	
	
	
}
