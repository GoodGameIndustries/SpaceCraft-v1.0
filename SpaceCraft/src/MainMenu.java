import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 * 
 */

/**
 * @author Emmett Deen
 * @version 1.0
 * @date May 19, 2014
 */
public class MainMenu extends JDialog implements ActionListener{

	private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//screen size dimension
	private JLabel bg;
	
	private JButton play = new JButton("Play Game");
	private JButton howToPlay = new JButton("How to Play");
	
	
	
	public MainMenu(){
		
		this.setAlwaysOnTop(true);
		this.setSize(dim);//sets frame size
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);//sets the frame to the center of the screen
		this.setUndecorated(true);//undecorates the frame, no outline top bar and x
		
		bg = new JLabel(new ImageIcon(getScaledImage(ImageIO.read(new File("assets/mainMenu.png")),dim.width,dim.height)));
		play.addActionListener(this);
		
		this.setLayout(null);
		this.add(play);
		play.setBounds((dim.width/2)-100,(dim.height/2)-50,200,50);
		this.add(howToPlay);
		howToPlay.setBounds((dim.width/2)-100,(dim.height/2)+50,200,50);
		this.add(bg);
		bg.setBounds(0,0,dim.width,dim.height);
		
		this.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(play)){
			this.dispose();
			this.setVisible(false);
			
		}
		
	}
	
	private BufferedImage getScaledImage(Image icon, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
	    Graphics2D g2 = resizedImg.createGraphics();
	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(icon, 0, 0, w, h, null);
	    g2.dispose();
	    return resizedImg;
  }
	
}
