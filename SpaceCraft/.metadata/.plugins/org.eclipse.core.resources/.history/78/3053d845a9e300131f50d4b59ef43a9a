package Frame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Ships.MotherShip;


public class ShipsPanel extends JPanel{

	private Space space;
	private SelectedPanel selected;
	private BuildPanel build;
	private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//screen size dimension
	private JScrollPane scroll;
	private MotherShip player;
	//private int shipSelected=-1;
	
	public ShipsPanel(Space space, Game g, MotherShip player){
		this.player = player;
		this.space = space;
		selected = new SelectedPanel(space,g,dim);
		scroll = new JScrollPane(selected);
		JPanel scrollHold = new JPanel();
		scrollHold.add(scroll);
		scrollHold.setSize(dim.width/2,99);
		build = new BuildPanel(space,dim,this,player);
		//JPanel buildHold = new JPanel();
		//buildHold.add(build);
		//build.setSize(dim.width/2,99);
		
		this.setLayout(new BorderLayout());
		this.add(scrollHold,BorderLayout.WEST);
		this.add(build,BorderLayout.CENTER);
		this.setSize(dim.width,99);
		
	}
	
	public void update(){
		selected.updatePanel();
	}
	
	
	
	public int getSelectedShip(){return build.getShipSelected();}
	
	public void reset(){build.reset();}
	
}
