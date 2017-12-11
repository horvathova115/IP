public class GameHalls {

	//the purpose of this class is to deal with the collections and its operation
	
	private static final int MAX_KINGDOMS = 8;
	public static final int PRICE_CAV = 4;
	public static final int PRICE_LAN_ESP = 2;
	
	private Kingdom[] kingdoms;
	private Army[] armies;
	private Fortress[] fortresses;
	
	
	public GameHalls() {
		kingdoms = new Kingdom[MAX_KINGDOMS];
		armies = new Army[50];
		fortresses = new Fortress[50];
	}
	
	public void recruitCav(int much) {
		int worth = much*PRICE_CAV;
		if (occupied = true) {		
			if (worth < treasure) {
			
			}
			else {
				cav += much;
			}
		}
		else {
			
		}
	}
	
	public void recruitLan(int much) {
		int worth = much*PRICE_CAV;
		if (occupied = true) {		
			if (worth < treasure) {
			
			}
			else {
				lan += much;
			}
		}
		else {
			
		}
	}
	
	public void recruitEsp(int much) {
		int worth = much*PRICE_CAV;
		if (occupied = true) {		
			if (worth < treasure) {
			
			}
			else {
				esp += much;
			}
		}
		else {
			
		}
	}
	
}
