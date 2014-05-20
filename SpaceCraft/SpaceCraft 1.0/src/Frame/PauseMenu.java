/**
 * 
 */
package Frame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

/**
 * @author Emmett Deen
 *
 */
public class PauseMenu extends JDialog implements ActionListener{

	private JButton exit = new JButton("Exit");
	private JButton resume = new JButton("Resume");
	
	public PauseMenu(){
		
		//System.out.println("PauseMenu");
		
		exit.setBackground(Color.WHITE);
		exit.setForeground(Color.BLACK);
		exit.addActionListener(this);
		
		resume.setBackground(Color.WHITE);
		resume.setForeground(Color.BLACK);
		resume.addActionListener(this);
		
		this.setAlwaysOnTop(true);
		this.setBounds(0,0,200,200);
		this.setLayout(new GridLayout(0,1));
		this.add(resume);
		this.add(exit);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(exit)){
			System.exit(0);
		}
		else if(e.getSource().equals(resume)){
			this.dispose();
			this.setVisible(false);
		}
		
	}
	
}
