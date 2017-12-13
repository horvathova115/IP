public class FiveKingdoms {
	
	private static final int MAX_KINGDOMS = 8;
	public static final int PRICE_CAV = 4;
	public static final int PRICE_LAN_ESP = 2;
	
	private int maplenghtx;
	private int maglenghty;
	private Fortress[] fortresses;
	private Kingdom[] kingdoms;
	private Army[] armies;
	public boolean gameOn;
	private int counter;
	public String teamPlaying; //still don't know if we need this or not
	private int numOfKingdoms;
	private int numOfCastles;
	private int currentKingdom;
	private int currentCastle;
	private int currentArmy;

	public FiveKingdoms(int mapx, int mapy, int numOfKingdoms, int numOfCastles) {
		this.maplenghtx = mapx;
		this.maplenghty = mapy;
		kingdoms = new Kingdom[numOfKingdoms];
		fortresses = new Fortress[numOfCastles];
		armies = new Army[numOfCastles];
		gameOn = true;
		counter = 0;
		teamPlaying = ""; //still don't know if we need this or not
		currentKingdom = -1;
		currentCastle = -1;
		currentArmy = -1;
		this.nKingdoms = numOfKingdoms;
		this.nCastles = numOfCastles;
	}
	
	public void initializeIteratorKingdoms() {
		currentKingdom = 0;
	}
	
	public void initializeIteratorCastles() {
		currentCastle = 0;
	}
	
	public boolean hasNextKingdom(){
		return ((currentKingdom >= 0 ) && (currentKingdom < counter));
	}
	
	public String nextName(){
		return kingdoms[currentKingdom++].name;
	}
	
	public int activeKingdoms() {
		int k = 0;
		for (int i = 0; i == numOfKingdoms; i++) {
			if (kingdoms[i].active == true) {
				k++;
			}
		}
		return k;
	}
	
	
}
