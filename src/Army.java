public class Army {

	String owner;
	String castle;
	String type;
	
	public Army(String owner, String castle, String type) {
		this.owner = owner;
		this.castle = castle;
		this.type = type;
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
}
