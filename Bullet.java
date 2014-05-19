import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class Bullet extends Ship{
	
	private boolean stopped=false;
	
	public Bullet(int x, int y) {
		super(x, y,5,5,false);
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
