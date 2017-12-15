public class Army {

	String owner;
	String castle;
	String type;
	private Position z;
	
	public Army(String owner, String castle, String type, int x, int y) {
		this.owner = owner;
		this.castle = castle;
		this.type = type;
		z=new Position(x,y);
	}
	
	public String getOwner() {
		return owner;
	}
	
	public String getCastle() {
		return castle;
	}
	
	public String getType() {
		return type;
	}
	
	public Position getPos() {
		return z;
	}
	
	public void changePos(Position newest) {
		z = newest;
	}
}
