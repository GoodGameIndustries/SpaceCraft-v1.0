package Ships;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Frame.Space;

/**
 * 
 */


public class MotherShip extends Ship{

	
	private int totalRescources = 1000;
	private int MASS =200;
	private boolean player=false;
	private boolean movingUp=false, movingDown=false,movingLeft=false,movingRight=false;
	private Space space;
	
	public MotherShip(int x,int y,Space space,Color t){
		super(space,x,y,50,50,t);
		this.team=t;
		this.x = x;
		this.y = y;
		this.space = space;
		
		name = "MotherShip";
		health = 1000;
		
		xLim=50;yLim=50;
		if(player){
		addKeyListener(this);
		this.setFocusable(true);
		this.requestFocus();
		}
	}
	
	public void paintComponent(Graphics g){
		Graphics g2 = (Graphics2D) g;
		g2.setColor(team);
		g2.fillRect(0,0,xLim,yLim);
		paintOutline(g);
	}
	
	public void control(){
		if(player){
		if(movingUp){y=y-20;}if(movingDown){y=y+20;}if(movingLeft){x=x-20;}if(movingRight){x=x+20;}
		checkBoundary();
		}
		else{return;}
	}
	
	public int getMass(){return MASS;}
	
	public void create(Ship s){
		s.setX(x+xLim+50);
		s.setY(y);
		space.objects.add(s);
		
	}

	public int getTotalResources() {
		return totalRescources;
	}

	public void setTotalResources(int totalRescources) {
		this.totalRescources = totalRescources;
	}
	
}
