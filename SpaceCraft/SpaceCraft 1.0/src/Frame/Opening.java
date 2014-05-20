package Frame;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 */

/**
 * @author Emmett Deen
 * @version 1.0
 * @date Apr 15, 2014
 */
public class Opening extends JFrame{

	private int x = 800; //window width
	private int y = 500;//window length
	
	private JLabel ggiBg;//bg label
	
	public Opening(String d) throws InterruptedException{//default constructor
		ggiBg = new JLabel(new ImageIcon(d));//sets ggibg to image
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//screen size dimension
		this.setSize(x,y);//sets frame size
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);//sets the frame to the center of the screen
		this.setUndecorated(true);//undecorates the frame, no outline top bar and x
		this.setVisible(true);//sets the frame to be visible
		
		startup();//runs starup
		
		
	}
	
	private void startup() throws InterruptedException {
		this.setOpacity(0);//sets the opacity to 0
		repaint();//updates the frame
		this.add(ggiBg);//adds the image
		ggiBg.setBounds(0,0,x,y);//sets the bg images size
		repaint();//updates the frame
		for(float i = 0f; i < .9f; i+=0.01f){//gradually increases the opacity causing a fade in effect
			this.setOpacity(i);//sets the opacity to i
			repaint();//updates the frame
			Thread.sleep(10);//makes the method wait can change for faster or slower fade in
		}
		Thread.sleep(1000);//waits for 1 sec when the image is as opaque as it gets
		for(float i = .9f; i>0f; i-=0.01f){//gradually decreases the opacity causing a fade out effect
			this.setOpacity(i);//sets opacity to i
			repaint();//updates the frame
			Thread.sleep(10);//makes the method wait can change for faster or slower fade out
		}
		this.remove(ggiBg);//removes the image
		//this.setOpacity(1.0f);
		repaint();//updates
		this.setVisible(false);//makes invisible
		this.dispose();//destroys frame
		
		
	}

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {//runs the opening
		new Opening("");

	}

}
