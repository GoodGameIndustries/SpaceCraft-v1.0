package Objects;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class Sun extends SpaceOBJ{
	private final int MASS=1000;
	private int xLim=200,yLim=200;
	public Sun(int x, int y){
		super();
		this.x=x;this.y=y;
		this.setBounds(x,y,200,200);
	}
	
	public void paintComponent(Graphics g){
		Graphics g2 = (Graphics2D) g;
		g2.setColor(Color.yellow);
		g2.fillOval(0,0,200,200);
	}
	
	public void move(){}
	
	public int getMass(){return MASS;}
	
}
