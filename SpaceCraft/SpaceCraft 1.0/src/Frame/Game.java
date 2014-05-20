package Frame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

import Objects.Beacon;
import Objects.SpaceOBJ;
import Ships.Ship;

/**
 * 
 */

/**
 * @author Emmett Deen
 * @version 1.0
 * @date May 12, 2014
 */
public class Game extends JFrame implements MouseMotionListener,MouseListener{
	
	
	private boolean moveUp = false;
	private boolean moveDown = false;
	private boolean moveLeft = false;
	private boolean moveRight = false;
	private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//screen size dimension
	private Space space = new Space(this,dim);
	
	private double step = 0.0001;
	
	public Game(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		
		this.setSize(dim);//sets frame size
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);//sets the frame to the center of the screen
		this.setUndecorated(true);//undecorates the frame, no outline top bar and x
		
		this.setLayout(new BorderLayout());
		
		//this.add(ui);
		this.add(space);
		
		
		
		
		this.setVisible(true);//sets the frame to be visible
		space.run();
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			new Opening("assets/spaceCraftStartup.png");
			new Opening("assets/poweredByGGI.png");
			
			new MainMenu();
			new Game();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		if(e.getX()>(dim.width-50)){
			moveRight = true;
			moveWorldRight();
		}
		else{moveRight = false;}
		if(e.getX()<50){
			moveLeft = true;
			moveWorldLeft();
		}
		else{moveLeft = false;}
		if(e.getY()>(dim.height-50)){
			moveDown = true;
			moveWorldDown();
		}
		else{moveDown = false;}
		if(e.getY()<50){
			moveUp = true;
			moveWorldUp();
		}
		else{moveUp = false;}
		
		
		repaint();
		space.repaint();
		space.ui.repaint();
		
	}
	
	private boolean isRunning = false;
	private synchronized boolean checkAndMark() {
	    if (isRunning) return false;
	    isRunning = true;
	    return true;
	}
	private void moveWorldRight() {
	    if (checkAndMark()) {
	        new Thread() {
	            public void run() {
	                do {
	                	if(space.getX()-1 <0 && space.getX()+4999 >dim.width){
	                	space.setX(space.getX()-1);
	                	space.ui.setBounds(-space.getX(),-space.getY()+dim.height-100,space.ui.getWidth(),space.ui.getHeight());
	                	}
	        			
	                	try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	        			
	                } while (moveRight);
	                isRunning = false;
	            }
	        }.start();
	    }
	}
	private void moveWorldLeft() {
	    if (checkAndMark()) {
	        new Thread() {
	            public void run() {
	                do {
	                	
	                	if(space.getX()+1 <0 && space.getX()+5001 >dim.width){
	        			space.setX(space.getX()+1);
	        			space.ui.setBounds(-space.getX(),-space.getY()+dim.height-100,space.ui.getWidth(),space.ui.getHeight());
	                	}
	        			try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	        			
	                } while (moveLeft);
	                isRunning = false;
	            }
	        }.start();
	    }
	}
	private void moveWorldDown() {
	    if (checkAndMark()) {
	        new Thread() {
	            public void run() {
	                do {
	                	
	                	if(space.getY()-1 <0 && space.getY()+4999 >dim.height){
	        			space.setY(space.getY()-1);
	        			space.ui.setBounds(-space.getX(),-space.getY()+dim.height-100,space.ui.getWidth(),space.ui.getHeight());
	                	}
	        			try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	        			
	                } while (moveDown);
	                isRunning = false;
	            }
	        }.start();
	    }
	}
	private void moveWorldUp() {
	    if (checkAndMark()) {
	        new Thread() {
	            public void run() {
	                do {
	                	
	        			if(space.getY()+1 <0 && space.getY()+5001 >dim.height){
	                	space.setY(space.getY()+1);
	                	space.ui.setBounds(-space.getX(),-space.getY()+dim.height-100,space.ui.getWidth(),space.ui.getHeight());
	        			}
	        			
	                	try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                	
	                } while (moveUp);
	                isRunning = false;
	            }
	        }.start();
	    }
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.isMetaDown() && space.selected.size()>0){
			SpaceOBJ temp = null;
		
			if(space.atSpot(e.getX()-space.getX(),e.getY()-space.getY()) == null){temp = new Beacon(e.getX()-space.getX(),e.getY()-space.getY());}
			else{temp = space.atSpot(e.getX()-space.getX(),e.getY()-space.getY());}
			
			for(Ship obj : space.selected){
				obj.setTarget(temp);
			}
			
		}
		else if((space.atSpot(e.getX()-space.getX(),e.getY()-space.getY()) != null) && (space.atSpot(e.getX()-space.getX(),e.getY()-space.getY()) instanceof Ship)){
			space.selected.add((Ship) space.atSpot(e.getX()-space.getX(),e.getY()-space.getY()));
			System.out.println("Ship selected");
		}
		
		else{
			//System.out.println("x: " + e.getX() + "y: " + e.getY());
			space.selected.clear();
		}
		
		
		space.ui.update();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
