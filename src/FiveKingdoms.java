public class FiveKingdoms {
	
	private static final int MAX_KINGDOMS = 8;
	public static final int PRICE_CAV = 4;
	public static final int PRICE_LAN_ESP = 2;
	
	private Fortress[] fortresses;
	private Kingdom[] kingdoms;
	public boolean gameOn;
	private int counter;
	public String teamPlaying; //still don't know if we need this
	private int currentKingdom;
	private int nKingdoms;
	private int currentCastle;

	public FiveKingdoms(int nKingdoms) {
		kingdoms = new Kingdom[MAX_KINGDOMS];
		fortresses = new Fortress[50];
		gameOn = false;
		counter = 0;
		teamPlaying = ""; //still don't know if we need this
		currentKingdom = -1;
		this.nKingdoms = nKingdoms;
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
		for (int i = 0; i == nKingdoms; i++) {
			if (kingdoms[i].active == true) {
				k++;
			}
		}
		return k;
	}
	
	
}
