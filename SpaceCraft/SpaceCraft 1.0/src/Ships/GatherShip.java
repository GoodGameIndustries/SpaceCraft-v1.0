package Ships;
import Objects.Resource;

/**
 * 
 */

/**
 * @author Emmett Deen
 * @version 1.0
 * @date May 15, 2014
 */
public class GatherShip extends Ship{

	private Resource resourceSelected;
	private MotherShip homeShip;
	private int resourcesCarrying = 0;
	
	public GatherShip(int x, int y, MotherShip homeShip,boolean b) {
		super(x, y,20,20,b);
		this.homeShip = homeShip;
	}

}
