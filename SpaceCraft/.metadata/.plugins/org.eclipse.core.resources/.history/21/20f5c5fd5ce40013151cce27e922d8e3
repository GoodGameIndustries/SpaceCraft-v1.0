package Frame;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Ships.MotherShip;

/**
 * 
 */

/**
 * @author Emmett Deen
 * @version 1.0
 * @date May 15, 2014
 */
public class BuildPanel extends JPanel implements ActionListener{

	
	
	private Space space;
	private Dimension dim;
	private ShipsPanel sp;
	
	private String[] attackNames = {"Scout","Destroyer","Sniper","Tank"};
	private String[] defenseNames = {"Bubble","Brick"};
	private String[] gatherNames = {"Basic","Advanced"};
	
	private JButton[] attackButtons;
	private JButton[] defenseButtons;
	private JButton[] gatherButtons;
	
	private MotherShip player;
	
	private int shipSelected=-1;
	
	public BuildPanel(Space space,Dimension d,ShipsPanel sp, MotherShip player){
		this.sp = sp;
		this.space = space;
		this.dim = d;
		this.player = player;
		this.setLayout(new GridLayout(0,5));
		this.addKeyListener(space.g);
		
		genButtons();
		setup();
	}

	private void setup() {
		this.add(new JLabel("Resources: "));
		this.add(new JLabel(""+ space.getResources()));
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel("Cost: "));
		this.add(new JLabel("100"));
		this.add(new JLabel("300"));
		this.add(new JLabel("500"));
		this.add(new JLabel("750"));
		
		
		this.add(new JLabel("Attack Ships"));
		for(int i = 0; i < attackButtons.length; i++){
			this.add(attackButtons[i]);
		}
		this.add(new JLabel("Defense Ships"));
		for(int i = 0; i < defenseButtons.length; i++){
			this.add(defenseButtons[i]);
		}
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel("Gather Ships"));
		for(int i = 0; i < gatherButtons.length; i++){
			this.add(gatherButtons[i]);
		}
		this.add(new JLabel());
		this.add(new JLabel());
		
	}

	private void genButtons() {
		attackButtons = new JButton[attackNames.length];
		defenseButtons = new JButton[defenseNames.length];
		gatherButtons = new JButton[gatherNames.length];
		
		for(int i = 0; i < attackButtons.length; i++){
			attackButtons[i] = new JButton(attackNames[i]);
			attackButtons[i].addActionListener(this);
			attackButtons[i].addKeyListener(space.g);
		}
		for(int i = 0; i < defenseButtons.length; i++){
			defenseButtons[i] = new JButton(defenseNames[i]);
			defenseButtons[i].addActionListener(this);
			defenseButtons[i].addKeyListener(space.g);
		}
		for(int i = 0; i < gatherButtons.length; i++){
			gatherButtons[i] = new JButton(gatherNames[i]);
			gatherButtons[i].addActionListener(this);
			gatherButtons[i].addKeyListener(space.g);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(attackButtons[0])){shipSelected=0;}
		else if(e.getSource().equals(attackButtons[1])){shipSelected=1;}
		else if(e.getSource().equals(attackButtons[2])){shipSelected=2;}
		else if(e.getSource().equals(attackButtons[3])){shipSelected=3;}
		
		else if(e.getSource().equals(defenseButtons[0])){shipSelected=4;}
		else if(e.getSource().equals(defenseButtons[1])){shipSelected=5;}
		
		else if(e.getSource().equals(gatherButtons[0])){shipSelected=6;}
		else if(e.getSource().equals(gatherButtons[1])){shipSelected=7;}
		
	}


	public void reset(){shipSelected=-1;}

	public int getShipSelected(){return shipSelected;}
	
}
