/**
 * class Game initializes Mapa, Team1, Team2, Combat and was initialized in Main class when new game started
 * it has parameters of positions of both flags and dimensions of map
 * @author Klara Horvathova
 *
 */
public class Game {
	
	private int x1,y1, x2, y2, mx, my;
	private String team1, team2;
	public Team1 t1;
	public Team2 t2;
	public Combat c;
	public Mapa m;
	
	public Game(int mapx, int mapy, int flag1x, int flag1y, int flag2x, int flag2y, String name1, String name2){
		x1=flag1x;
		y1=flag1y;
		x2=flag2x;
		y2=flag2y;
		team1=name1;
		team2=name2;
		mx=mapx;
		my=mapy;
		t1=new Team1(team1,x1,y1);
		t2=new Team2(team2,x2,y2);
		m=new Mapa(mx,my);
		c=new Combat(t1,t2,m);
		
	}
	
	public Team1 team1(){
		Team1 t1 = new Team1(team1,x1,y1);
		return t1;
	}
	
	public Team2 team2(){
		Team2 t2 = new Team2(team2,x2,y2);
		return t2;
	}
	public Mapa mapa(int x,int y){
		Mapa m= new Mapa(x,y);
		return m;
	}
	public Combat combat(){
		Combat c = new Combat(t1,t2,m);
		return c;
	}
	
	
	
	
}