public class Castles {
	 
	private String name;
	private Kingdom owner;
	private int treasure;
	private boolean occupied;
	private Position p;

	public Castles(int x, int y, int treasure, String name, boolean occupied) {
		this.name = name;
		this.treasure = treasure;
		this.occupied = occupied;
		p=new Position(x,y);
	}
	
/*	public Fortress(String owner){//set owner instead of another constructor
		this.owner = owner;
		this.occupied=true;
	}
*/
	
	public String getName() {
		return name;
	}
	
	public Kingdom getOwner() {
		return owner;
	}
	
	public boolean isOccupied() {
		return occupied;
	}
	
	public void depositGold(int much) {
		treasure += much;
	}
	
	public Position getPos(){
		return p;
	}

	public int getTreasure() {
		return treasure;
	}

	public void setOwner(Kingdom k) {
		occupied=true;
		owner=k;
	}
	
}
