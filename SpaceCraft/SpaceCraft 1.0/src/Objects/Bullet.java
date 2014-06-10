package Objects;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import Frame.Space;
import Ships.Ship;


public class Bullet extends Ship{
	
	private boolean stopped=false;
	
	private int type=-1;
	
	public Bullet(Space s,int x, int y) {
		super(s,x, y,5,5,Color.white);
		speed=2;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		if(type==0){
			g2.setColor(Color.yellow);
			g2.fillOval(0,0,3,3);
		}
		else if(type==1){
			g2.setColor(Color.cyan);
			g2.fillOval(0,0,7,4);
		}
		else if(type==2){
			g2.setColor(Color.blue);
			g2.fillOval(0,0,10,3);
		}
		else if(type==3){
			g2.setColor(Color.red);
			g2.fillOval(0,0,10,10);
		}
	}
	
	public void move(){
		if(type==0){speed=3;}
		else if(type==1){speed=2;}
		else if(type==2){speed=5;}
		else if(type==3){speed=1;}
		calculateMove(target);
	}
	
	public boolean stopped(){
		return stopped;
	}
	
	protected void calculateMove(SpaceOBJ t) {
		double r=calculateDistance(t);
		if(!t.collision(this)){
			x=(int) (x+(int)((t.getX()+(t.getXLim()/2))-x)*speed*10/r);
			y=(int) (y+(int)((t.getY()+(t.getYLim()/2))-y)*speed*10/r);
		}
		else{stopped=true;}
		System.out.println("<"+x+","+y+">");
	}
	
	public void setStopped(){stopped=true;}
	
	public void setType(int attackType){type=attackType;}
	
	public int getType(){return type;}
	
	
}
