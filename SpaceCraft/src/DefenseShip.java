
public class DefenseShip extends Ship{

	protected int shield = 100;
	
	public DefenseShip(int x,int y,boolean b){
		super(x,y,b);
		name = "DefenseShip";
	}
	
	public DefenseShip(int x,int y,int xLim,int yLim,boolean b){
		super(x,y,xLim,yLim,b);
		name = "DefenseShip";
	}
	
	public String getInfo(){
		return "Name: " + name +" Shield: " + shield + " Health: " + health + " Speed: " + speed + " X: " + x + " Y: " + y;
	}
	
}
