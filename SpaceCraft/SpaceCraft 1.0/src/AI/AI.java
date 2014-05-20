package AI;

import java.awt.Color;

import Frame.Space;
import Ships.MotherShip;

public class AI {
	protected MotherShip mothership;
	
	public AI(int x, int y, Space space){
		mothership=new MotherShip(x,y,space,Color.red);
	}
	
	public MotherShip getMotherShip(){return mothership;}
	
	
	
}
