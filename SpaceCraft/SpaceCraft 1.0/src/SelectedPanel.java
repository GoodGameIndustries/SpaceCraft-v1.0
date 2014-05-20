import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 
 */

/**
 * @author Emmett Deen
 * @version 1.0
 * @date May 14, 2014
 */
public class SelectedPanel extends JPanel{
	
	private Space space;
	private Game g;
	private JTextArea selectedStuff ;
	private String list = "Selected Ships: ";
	
	
	public SelectedPanel(Space space, Game g,Dimension dim){
	this.space = space;
	
	selectedStuff= new JTextArea(dim.width/2, 99);
	selectedStuff.setEditable(false);
	this.add(selectedStuff);
	
	//updatePanel();
	}

	public void updatePanel() {
		
		list = "Selected Ships: ";
		for(Ship s: space.selected){
			selectedStuff.setText(list);
			list += "\n" + s.getInfo();
		}
		selectedStuff.setText(list);
		
		repaint();
		
	}
}
