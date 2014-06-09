package Ships;

import java.awt.Color;

import Frame.Space;

public class DefenseShip extends Ship{

	protected int shield = 100;
	
	public DefenseShip(Space s,int x,int y,Color t){
		super(s,x,y,t);
		name = "DefenseShip";
		health=200;
	}
	
	public DefenseShip(Space s,int x,int y,int xLim,int yLim,Color t){
		super(s,x,y,xLim,yLim,t);
		name = "DefenseShip";
		health=200;
	}
	
	public String getInfo(){
		return "Name: " + name +" Shield: " + shield + " Health: " + health + " Speed: " + speed + " X: " + x + " Y: " + y;
	}
	
}
