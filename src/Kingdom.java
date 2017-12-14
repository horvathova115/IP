public class Kingdom {

	String name;
	boolean active;
	private Castles[] castles;
	private int counter;
	
	private final int MAX=50;
	private final int GROWTH=2;
	private int current;
	
	
	public Kingdom(String name) {
		this.name = name;
		active = true;
		castles=new Castles[MAX];
		counter=0;
		current=-1;
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
	
	public void addCastle(Castles castle){
		this.castles[counter]=castle;
	}

	public void initializeIterator() {
		current = 0;
	}
		
	public boolean hasNext(){
		return ((current >= 0 ) && (current < counter));
	}
	
	public Castles next(){
		return castles[current++];
	}
	
 }
