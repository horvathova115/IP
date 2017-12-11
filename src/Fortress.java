public class Fortress {
	 
	String name;
	String owner;
	int treasure;
	boolean occupied;

	public Fortress(String name, String owner, int treasure, boolean occupied) {
		this.name = name;
		this.owner = owner;
		this.treasure = treasure;
		this.occupied = occupied;
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
}