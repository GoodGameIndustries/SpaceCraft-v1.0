import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * 
 */


public class MotherShip extends Ship{

	private Color c;
	private int totalRescources = 0;
	private int MASS =200;
	private boolean player=false;
	private boolean movingUp=false, movingDown=false,movingLeft=false,movingRight=false;
	private Space space;
	
	public MotherShip(int x,int y,Color c,Space space,boolean player){
		super(x,y,50,50,player);
		this.player=player;
		this.x = x;
		this.y = y;
		this.c = c;
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
		g2.setColor(c);
		g2.fillRect(0,0,xLim,yLim);
	}
	
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(player){
		if(e.getKeyChar()=='w'){movingUp=true;}
		if(e.getKeyChar()=='s'){movingDown=true;}
		if(e.getKeyChar()=='a'){movingLeft=true;}
		if(e.getKeyChar()=='d'){movingRight=true;}
		}
		else{return;}
	}
	
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(player){
			if(e.getKeyChar()=='w'){movingUp=false;}
			if(e.getKeyChar()=='s'){movingDown=false;}
			if(e.getKeyChar()=='a'){movingLeft=false;}
			if(e.getKeyChar()=='d'){movingRight=false;}
			}
			else{return;}
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
	
}
