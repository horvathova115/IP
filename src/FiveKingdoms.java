public class FiveKingdoms {
	
	private static final int MAX_KINGDOMS = 8;
	public static final int PRICE_CAV = 4;
	public static final int PRICE_LAN_ESP = 2;
	
	//private int maplenghtx;
	//private int maglenghty;
	private Position map;
	private Castles[] castles;
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
	private int counterKingdoms;
	private int counterCastles;
	

	public FiveKingdoms(int mapx, int mapy, int numOfKingdoms, int numOfCastles) {
		//this.maplenghtx = mapx;
		//this.maglenghty = mapy;
		map = new Position(mapx,mapy);
		kingdoms = new Kingdom[numOfKingdoms];
		castles = new Castles[numOfCastles];
		armies = new Army[numOfCastles];
		gameOn = true;
		counter = 0;
		counterCastles=0;
		counterKingdoms=0;
		teamPlaying = ""; //still don't know if we need this or not
		currentKingdom = -1;
		currentCastle = -1;
		currentArmy = -1;
		this.numOfKingdoms = numOfKingdoms;
		this.numOfCastles = numOfCastles;
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

	//what with theese methods in Five Kingdoms, which I cant reach while not initializing FiveKigdoms constructor...
	public void addCastle(Castles c) {
		// TODO Auto-generated method stub
		castles[counter]=c;
		counter++;
	}

	public void removeAllCastles() {
		// TODO Auto-generated method stub
		castles= new Castles[numOfCastles];
	}

	public boolean existCastlePos(int x, int y) {
		// TODO Auto-generated method stub
		for(int i=0;i<counterCastles;i++){
			if(castles[i].pos().getX()==x && castles[i].pos().getY()==y){
				return true;
			}
		}
		
		return false;
	}

	public boolean existCastleName(String name) {
		// TODO Auto-generated method stub
		boolean exist = false;
		for(int i=0;i<counterCastles;i++){
			if(castles[i].getName().equals(name)){
				exist= true;
			}
		}
		return exist;
	}

	public Position getMapPosition() {
		// TODO Auto-generated method stub
		return map;
	}

	public boolean hasNextCastle() {
		// TODO Auto-generated method stub
		return ((currentCastle<counterCastles) && (currentCastle>=0));
	}

	public Kingdom nextKingdom() {
		// TODO Auto-generated method stub
		return kingdoms[currentKingdom++];
	}

	public Castles nextCastle() {
		// TODO Auto-generated method stub
		return castles[currentCastle++];
	}

	public void addKingdom(Kingdom k) {
		// TODO Auto-generated method stub
		kingdoms[counterKingdoms]=k;
	}

	public void removeAllKingdoms() {
		// TODO Auto-generated method stub
		kingdoms = new Kingdom[numOfKingdoms];
	}

	public boolean existKingdom(String kingdom) {
		// TODO Auto-generated method stub
		boolean exist=false;
		for(int i=0;i<numOfKingdoms;i++){
			if(kingdoms[i].getName().equals(kingdom)){
				exist=true;
			}
		}
		return exist;
	}

	public boolean castleFree(String castle) {
		// TODO Auto-generated method stub
		boolean occupied=false;
		for(int i=0;i<numOfCastles;i++){
			Castles c= castles[i];
			if(c.getName().equals(castle)){
				if(c.isOccupied()){
					occupied=true;
				}
			}
		}
		return occupied;
	}
	
	public int getNumberofCastles(){
		return numOfCastles;
	}
	public int getNumberOfKingdoms(){
		return numOfKingdoms;
	}
}
