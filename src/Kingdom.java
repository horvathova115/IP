public class Kingdom {

	String name;
	boolean active;
	
	
	public Kingdom(String name) {
		this.name = name;
		active = true;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void fallenKingdom() {
		active = false;
	}
}
