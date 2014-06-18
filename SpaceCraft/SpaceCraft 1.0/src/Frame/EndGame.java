package Frame;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EndGame extends JFrame{
	private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	private JLabel bg;
	public EndGame(boolean player){
		this.setAlwaysOnTop(true);
		this.setSize(dim);//sets frame size
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);//sets the frame to the center of the screen
		this.setUndecorated(true);
		
		try {
			if(!player){
				bg = new JLabel(new ImageIcon(getScaledImage(ImageIO.read(new File("assets/playerWins.png")),dim.width,dim.height)));
			}
			else{
				bg = new JLabel(new ImageIcon(getScaledImage(ImageIO.read(new File("assets/aiWins.png")),dim.width,dim.height)));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
