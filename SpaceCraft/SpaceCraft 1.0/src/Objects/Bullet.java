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
		return Math.abs(getDistance(target))<1;
	}
	
	protected void calculateMove(SpaceOBJ t) {
		double r=calculateDistance(t);
		if(r>1){
			x=(int) (x+(int)((t.getX()+(t.getXLim()/2))-x)*speed*10/r);
			y=(int) (y+(int)((t.getY()+(t.getYLim()/2))-y)*speed*10/r);
		}
		System.out.println("<"+x+","+y+">");
	}
	
	public void setStopped(){stopped=true;}
	
	
}
