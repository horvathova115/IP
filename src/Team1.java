/**
 * class Team1 initializes classes T1Lanceiro, T1Cavaleiro, T1Espadachim, which are fighters if team1
 * was initialized by class Game
 * have parameters name of the team, and position of flag 
 * @author Klara Horvathova
 *
 */
public class Team1 {
	
	private  String name;
	private  int flagx;
	private  int flagy;
	public T1Lanceiro lanceiro;
	public T1Cavaleiro cavaleiro;
	public T1Espadachim espadachim;
	
	public Team1(String team1, int x,int y){
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
	
	public T1Lanceiro lanceiro(int x, int y) {
		T1Lanceiro lanceiro = new T1Lanceiro(x,y,"vivo");
		return lanceiro;
	}
	
	public T1Espadachim espadachim(int x, int y) {
		T1Espadachim espadachim = new T1Espadachim(x,y,"vivo");
		return espadachim;
	}

	public T1Cavaleiro cavaleiro(int x, int y ) {
		T1Cavaleiro cavaleiro = new T1Cavaleiro(x,y,"vivo");
		return cavaleiro;
	}
	
}



