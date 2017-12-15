public class FiveKingdoms {
	
	public static final int PRICE_CAV = 4;
	public static final int PRICE_LAN_ESP = 2;
	private static final String KNIGHT = "cavaleiro";
	private static final String SWORDSMAN = "espadachim";
	private static final String LANCER = "lanceiro";
	
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
	private int counterArmies;
	

	public FiveKingdoms(int mapx, int mapy, int numOfKingdoms, int numOfCastles) {
		map = new Position(mapx,mapy);
		kingdoms = new Kingdom[numOfKingdoms];
		castles = new Castles[numOfCastles];
		armies = new Army[numOfCastles];
		gameOn = true;
		counter = 0;
		counterCastles=0;
		counterKingdoms=0;
		counterArmies=0;
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
	public void initializeIteratorArmies() {
		currentArmy = 0;
	}
	
	public boolean hasNextKingdom(){
		return ((currentKingdom >= 0 ) && (currentKingdom < counter));
	}
	
	public boolean hasNextCastle() {
		return ((currentCastle<counterCastles) && (currentCastle>=0));
	}
	
	public boolean hasNextArmy() {
		return ((currentArmy<counterArmies) && (currentArmy>=0));
	}

	public Kingdom nextKingdom() {
		return kingdoms[currentKingdom++];
	}

	public Castles nextCastle() {
		return castles[currentCastle++];
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
	
	// @pre: canCastleBuy(castle)
	public void atributeSoldier(String type, String castle) {
		for (int i = 0; i < counterArmies; i++) {
			if (castles[i].getName().equals(castle)) {
				castles[i].depositGold(getPrice(type));
			}
		}
		armies[counterArmies].castle = castle;
		armies[counterArmies].type = type;
		counterArmies++;
	}
	
	public int getPrice(String type) {
		if (type.equals(KNIGHT)) {
			return PRICE_CAV;
		}
		else if (type.equals(LANCER) || type.equals(SWORDSMAN)) {
			return PRICE_LAN_ESP;
		}
		else {
			return 0;
		}
	}
	
	public String getSoldOwner(Position sold) {
		String k = null;
		for (int i = 0; i < counterArmies; i++) {
			if (armies[i].getPos().equals(sold)) {
				k = armies[i].owner;
				return k;
			}
			else {
				k = null;
			}
		}
		return k;
	}
	
	public String checkType(int x, int y) {
		Position kpos = new Position(x,y);
		String k = null;
		for (int i = 0; !hasNextArmy(); i++) {
			//the getX
			if ((armies[i].getPos().equals(kpos))) {
				k = armies[i].type;
			}
			else {
				k = null;
			}
		}
		return k;
	}
	
	public int kingdomsnTreasure(String name) {
		int k = 0;
		for (int i = 0; i == numOfKingdoms; i++) {
			if (castles[i].getOwner().equals(name)) {
				k+= castles[i].getTreasure();
			}
		}
		return k;
	}
	
	public int kingdomsnCastles(String name) {
		int k = 0;
		for (int i = 0; i == numOfKingdoms; i++) {
			if (castles[i].getOwner().equals(name)) {
				k++;
			}
		}
		return k;
	}
	
	public int kingdomsnSoldiers(String name) {
		int k = 0;
		for (int i = 0; !hasNextArmy() ; i++) {
			if (armies[i].getOwner().equals(name)) {
				k++;
			}
		}
		return k;
	}
	

	public boolean validateCastleOwner(String name, String castle) {
		boolean belongs = false;
		for (int i = 0; i == numOfCastles; i++) {
			if (castles[i].getOwner().equals(name)) {
				belongs = true;
				return belongs;
			}
			else {
				belongs = false;
			}
		}
		return belongs;
	}
	
	public boolean canCastleBuy(String name) {
		boolean buys = false;
		for (int i = 0; i == numOfCastles; i++) {
			if (castles[i].getName().equals(name)) {
				buys = true;
				return buys;
			}
			else {
				buys = false;
			}
		}
		return buys;
	}

	public void addCastle(Castles c) {
		castles[counter]=c;
		counterCastles++;
	}

	public void removeAllCastles() {
		castles= new Castles[numOfCastles];
	}

	public boolean existCastlePos(int x, int y) {
		for(int i=0;i<counterCastles;i++){
			if(castles[i].getPos().getX()==x && castles[i].getPos().getY()==y){
				return true;
			}
		}
		
		return false;
	}

	public boolean existCastleName(String name) {
		boolean exist = false;
		for(int i=0;i<counterCastles;i++){
			if(castles[i].getName().equals(name)){
				exist= true;
			}
		}
		return exist;
	}

	public Position getMapPosition() {
		return map;
	}

	public void addKingdom(Kingdom k) {
		kingdoms[counterKingdoms]=k;
		counterKingdoms++;
	}

	public void removeAllKingdoms() {
		kingdoms = new Kingdom[numOfKingdoms];
	}
	
	// @pre: getNumberOfKingdoms>0;
	public boolean existKingdom(String kingdom) {
		boolean exist=false;
		for(int i=0;i<counterKingdoms;i++){
			if(kingdoms[i].getName().equals(kingdom)){
				exist=true;
			}
		}
		return exist;
	}

	public boolean castleFree(String castle) {
		boolean occupied=false;
		Castles c = getCastle(castle);  
		if(c.isOccupied()){
			occupied=true;
		}	
		return occupied;
	}
	
	public int getNumberofCastles(){
		return counterCastles;
	}
	public int getNumberOfKingdoms(){
		return counterKingdoms;
	}

	public Castles getCastle(String castle) {
		Castles c = null;
		for(int i=0;i<counterCastles-1;i++){
			if(castles[i].getName().equals(castle)){
				return castles[i];
			}
		}
		return c;
	}
	
	public String getCastleName(Position castlepos) {
		String k = null;
		for(int i=0;i<counterCastles-1;i++){
			if(castles[i].getPos().equals(castlepos)){
				k = castles[i].getName();
				return k;
			}
			else {
				k = null;
			}
		}
		return k;
	}

	public String castlesOfKingdom(String teamPlaying) {
		String res="";
		Kingdom k = findKingdom(teamPlaying);
		k.initializeIterator();
		while(k.hasNext()){
			Castles c = k.next();
			res+=c.getName() + " ";
			res+=c.getTreasure()+ " ";
			res+="("+ c.getPos().getX()+", "+c.getPos().getY()+")";
			res+="\n";
		}
		return res;
	}

	private Kingdom findKingdom(String teamPlaying) {
		Kingdom k=null;
		for(int i=0;i<counterKingdoms;i++){
			if(kingdoms[i].getName().equals(teamPlaying)){
				k=kingdoms[i];
			}
		}
		return k;
	}
	
	public void moving(Position previous, String direction) {
		Position newest = new Position(0,0);
		newest.equals(previous);
		if (direction.equals("norte")) {
			newest.addX(1);
		}
		else if (direction.equals("sul")) {
			newest.addX(-1);
		}
		else if (direction.equals("oeste")) {
			newest.addY(-1);
		}
		else if (direction.equals("este")) {
			newest.addY(1);
		}
		else {
			newest.addX(0);
			newest.addY(0);
		}
		for (int i = 0; i<counterArmies; i++) {
			if (armies[i].getPos().equals(previous)) {
				armies[i].changePos(newest);
			}
		}
	}
	
	public void movingSoldier(Position previous, Position newest) {
		for(int i = 0; i<counterArmies; i++) {
			if(armies[i].getPos().equals(previous)) {
				armies[i].changePos(newest);
			}
		}
	}
	
	public void conquerCastle(Position castlepos, Kingdom newOwner) {
		for(int i = 0; i<counterCastles; i++) {
			if(castles[i].getPos().equals(castlepos)) {
				castles[i].setOwner(newOwner);
			}
		}
	}
	
	public boolean belongsToMap(Position test) {
		if (test.getX() > map.getX() || test.getY() > map.getY() || test.getX() < 0 || test.getY() < 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public String whobattle(String first, String second) {
		if (first.equals(KNIGHT) && second.equals(KNIGHT)) {
			return first;
		}
		else if (first.equals(KNIGHT) && second.equals(LANCER)) {
			return second;
		}
		else if (first.equals(KNIGHT) && second.equals(SWORDSMAN)) {
			return first;
		}
		else if (first.equals(LANCER) && second.equals(KNIGHT)) {
			return first;
		}
		else if (first.equals(LANCER) && second.equals(LANCER)) {
			return first;
		}
		else if (first.equals(LANCER) && second.equals(SWORDSMAN)) {
			return second;
		}
		else if (first.equals(SWORDSMAN) && second.equals(KNIGHT)) {
			return second;
		}
		else if (first.equals(SWORDSMAN) && second.equals(LANCER)) {
			return first;
		}
		else if (first.equals(SWORDSMAN) && second.equals(SWORDSMAN)) {
			return first;
		}
		return null;
	}
	
	public int getSoldierIndex(Position soldpos) {
		int j = 0;
		for (int i = 0; i<counterArmies ; i++) {
			if (armies[i].getPos().equals(soldpos)) {
				j = i;
			}
			else {
				j = 0;
			}
		}
		return j;
	}
	
	public void removeSoldier(int index) {
		for(int i = index; i<counterArmies; i++) {
			armies[i] = armies[i+1];
		}
		counterArmies--;
	}
	
	public boolean existsSoldier(Position test) {
		boolean exists = false;
		for (int i = 0; i<counterArmies ; i++) {
			if (armies[i].getPos().equals(test)) {
				exists = true;
			}
		}
		return exists;
	}
	
}
