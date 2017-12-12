public class Fortress {
	 
	private String name;
	private String owner;
	private int treasure;
	private boolean occupied;
	private Position x;
	private Position y;
	

	public Fortress(Position x, Position y, int treasure, String name, boolean occupied,) {
		this.name = name;
		this.treasure = treasure;
		this.occupied = occupied;
		this.x=x;
		this.y=y;
	}
	
	public Fortress(String owner){
		this.owner = owner;
		this.occupied=true;
	}

	
	public String getName() {
		return name;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public boolean isOccupied() {
		return occupied;
	}
	
	public Position getX(){
		return x;
	}
	public Position getY(){
		return y;
	}
}
