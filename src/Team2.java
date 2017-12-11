/**
 * class Team2 initializes classes T2Lanceiro, T2Cavaleiro, T2Espadachim, which are fighters if team2
 * was initialized by class Game
 * have parameters name of the team, and position of flag 
 * @author Klara Horvathova
 *
 */
public class Team2 {
	private  String name;
	private  int flagx;
	private  int flagy;
	public T2Lanceiro lanceiro;
	public T2Cavaleiro cavaleiro;
	public T2Espadachim espadachim;
	
	public Team2(String team1, int x,int y){
		name=team1;
		flagx=x;
		flagy=y;
		lanceiro=lanceiro(flagx,flagy-1);
		int cy=flagy+1;
		cavaleiro=cavaleiro(flagx,cy);
		espadachim = espadachim(flagx+1,flagy);
	}
	
	public String name(){return name;}
	
	public int getFlagX(){ return flagx ;}
	public int getFlagY(){ return flagy ;}
	
	public T2Lanceiro lanceiro(int x, int y) {
		T2Lanceiro lanceiro = new T2Lanceiro(x,y,"vivo");
		return lanceiro;
	}
	
	public T2Espadachim espadachim(int x, int y) {
		T2Espadachim espadachim = new T2Espadachim(x,y,"vivo");
		return espadachim;
	}

	public T2Cavaleiro cavaleiro(int x, int y ) {
		T2Cavaleiro cavaleiro = new T2Cavaleiro(x,y,"vivo");
		return cavaleiro;
	}
	
}



