/**
 * class Combat serves for all the action. Movements of fighters, Fighting, loosing and winning
 * works with classes Map and Team1, Team2
 * @param isfight represents if is active fight
 * @param notInMap is telling if moving fighter is moving out of the map
 * @param occupied is telling if moving fighter is moving to occupied position by his team  
 * @param endOfTheGame is telling if are some winners in the game already and accordingly is no need to play.
 * @author Klara Horvathova
 *
 */
public class Combat {
	public Team1 t1;
	public Team2 t2;
	public Mapa m;
	public String isfight;
	public Messages mes=new Messages();
	public boolean notInMap;
	public boolean occupied;
	public boolean endOfTheGame;
	
	public Combat(Team1 team1, Team2 team2, Mapa mapa){
		t1=team1;
		t2=team2;
		m=mapa;
		endOfTheGame=false;
	}
	
	
	/**
	 * method t1lanceiro is called from Main and execute the action of lanceiro from team1
	 * @param mov is direction of which wants to be moved
	 * @return message of executed action
	 */
	public String t1lanceiro(String mov){
		int x=t1.lanceiro.getX();
		int y=t1.lanceiro.getY();
		String name="lanceiro", team=t1.name();
		if(!t1.lanceiro.alive()){
			return mes.deathMessage(name, team);
		}else if(!t1move(mov, x, y, name, team)){
			if(notInMap){
				return mes.notIntheMap(name, team);}
			else if(occupied){
					return mes.occupied(name, team);
			}
		}
		int nx=t1.lanceiro.getX();
		int ny=t1.lanceiro.getY();
		if(t1captureFlag(nx, ny)){
			return mes.winMessage(t2.name(),team);
		}if(t1Isfight(nx,ny)){
			return t1fight(name,isfight);
		}if(!t1TeamAlive()){
			return mes.winMessage(team, t2.name());
		}else if(!t2TeamAlive()){
			return mes.winMessage(t2.name(),team);
		}
		return "";
	}
	
	public String t2lanceiro(String mov){
		int x=t2.lanceiro.getX();
		int y=t2.lanceiro.getY();
		String name="lanceiro", team=t2.name();
		if(!t2.lanceiro.alive()){
			return mes.deathMessage(name, team);
		}else if(!t2move(mov, x, y, name, team)){
			if(notInMap){
				return mes.notIntheMap(name, team);}
			else if(occupied){
					return mes.occupied(name, team);
			}
		}
		int nx=t2.lanceiro.getX();
		int ny=t2.lanceiro.getY();
		if(t2captureFlag(nx, ny)){
			return mes.winMessage(t1.name(),team);
		}if(t2Isfight(nx,ny)){
			return t2fight(name,isfight);
		}if(!t2TeamAlive()){
			return mes.winMessage(team, t1.name());
		}else if(!t1TeamAlive()){
			return mes.winMessage(t1.name(),team);
		}
		return "";
	}
	public String t1espadachim(String mov){
		int x=t1.espadachim.getX();
		int y=t1.espadachim.getY();
		String name="espadachim", team=t1.name();
		if(!t1.espadachim.alive()){
			return mes.deathMessage(name, team);
		}else if(!t1move(mov, x, y, name, team)){
			if(notInMap){
				return mes.notIntheMap(name, team);}
			else if(occupied){
					return mes.occupied(name, team);
			}
		}
		int nx=t1.espadachim.getX();
		int ny=t1.espadachim.getY();
		if(t1captureFlag(nx, ny)){
			return mes.winMessage(t2.name(),team);
		}if(t1Isfight(nx,ny)){
			return t1fight(name,isfight);
		}if(!t1TeamAlive()){
			return mes.winMessage(team, t2.name());
		}else if(!t2TeamAlive()){
			return mes.winMessage(t2.name(),team);
		}
		return "";
	}
	public String t2espadachim(String mov){
		int x=t2.espadachim.getX();
		int y=t2.espadachim.getY();
		String name="espadachim", team=t2.name();
		if(!t2.espadachim.alive()){
			return mes.deathMessage(name, team);
		}else if(!t2move(mov, x, y, name, team)){
			if(notInMap){
				return mes.notIntheMap(name, team);}
			else if(occupied){
					return mes.occupied(name, team);
			}
		}
		int nx=t2.espadachim.getX();
		int ny=t2.espadachim.getY();
		if(t2captureFlag(nx, ny)){
			return mes.winMessage(t1.name(),team);
		}if(t2Isfight(nx,ny)){
			return t2fight(name,isfight);
		}if(!t2TeamAlive()){
			return mes.winMessage(team, t1.name());
		}else if(!t1TeamAlive()){
			return mes.winMessage(t1.name(),team);
		}
		return "";
	}
	
	public String t1cavaleiro(String mov){
		int x=t1.cavaleiro.getX();
		int y=t1.cavaleiro.getY();
		String name="cavaleiro", team=t1.name();
		if(!t1.cavaleiro.alive()){
			return mes.deathMessage(name, team);
		}else if(!t1move(mov, x, y, name, team)){
			if(notInMap){
				return mes.notIntheMap(name, team);}
			else if(occupied){
					return mes.occupied(name, team);
			}
		}
		int nx=t1.cavaleiro.getX();
		int ny=t1.cavaleiro.getY();
		if(t1captureFlag(nx, ny)){
			endOfTheGame=true;
			return mes.winMessage(t2.name(),team);
		}if(t1Isfight(nx,ny)){
			return t1fight(name,isfight);
		}if(!t1TeamAlive()){
			endOfTheGame=true;
			return mes.winMessage(team, t2.name());
		}else if(!t2TeamAlive()){
			endOfTheGame=true;
			return mes.winMessage(t2.name(),team);
		}
		return "";
	}
	public String t2cavaleiro(String mov){
		int x=t2.cavaleiro.getX();
		int y=t2.cavaleiro.getY();
		String name="cavaleiro", team=t2.name();
		if(!t2.cavaleiro.alive()){
			return mes.deathMessage(name, team);
		}else if(!t2move(mov, x, y, name, team)){
			if(notInMap){
				return mes.notIntheMap(name, team);}
			else if(occupied){
					return mes.occupied(name, team);
			}
		}
		int nx=t2.cavaleiro.getX();
		int ny=t2.cavaleiro.getY();
		if(t2captureFlag(nx, ny)){
			endOfTheGame=true;
			return mes.winMessage(t1.name(),team);
		}if(t2Isfight(nx,ny)){
			return t2fight(name,isfight);
		}if(!t2TeamAlive()){
			endOfTheGame=true;
			return mes.winMessage(team, t1.name());
		}else if(!t1TeamAlive()){
			endOfTheGame=true;
			return mes.winMessage(t1.name(),team);
		}
		return "";
	}
/**
 * controls if is any fighter from team2 alive
 * @return true or false
 */
	private boolean t2TeamAlive() {
		if(t2.cavaleiro.getState().equals("morte")&&t2.espadachim.getState().equals("morte")&&t2.lanceiro.getState().equals("morte")){
			return false;
		}
		return true;
	}
	/**
	 * controls if is any fighter from team1 alive
	 * @return true or false
	 */
	private boolean t1TeamAlive() {
		if(t1.cavaleiro.getState().equals("morte")&&t1.espadachim.getState().equals("morte")&&t1.lanceiro.getState().equals("morte")){
			return false;
		}
		return true;
	}
/**
 * controls if fighter's movement is in the map
 * @param x position on map
 * @param y position on map
 * @return true or false
 */
	public boolean inTheMap(int x, int y){
		int mx=m.getX();
		int my = m.getY();
		if(x>mx || y>my || x<1 || y<1){
			return false;
		}
		return true;
	}
	
	/**
	 * check if fighters movement is not on some occupied position
	 * @param x on the map
	 * @param y on the map
	 * @return true or false
	 */
	public boolean t1notOccupied(int x,int y){
		if(t1.espadachim.getState().equalsIgnoreCase("vivo")){
			int xsp=t1.espadachim.getX();
			int ysp=t1.espadachim.getY();
			if(x==xsp && y==ysp){return false;}
		}
		if(t1.lanceiro.getState().equalsIgnoreCase("vivo")){
			int xsw=t1.lanceiro.getX();
			int ysw=t1.lanceiro.getY();
			if( x==xsw && y==ysw){return false;}
		}
		if(t1.cavaleiro.getState().equalsIgnoreCase("vivo")){
			int xk=t1.cavaleiro.getX();
			int yk=t1.cavaleiro.getY();
			if(x==xk && y==yk){return false;}
		}
		
		int fx=t1.getFlagX();
		int fy=t1.getFlagY();
		if(x==fx && y==fy){return false;}
		return true;
	}
	public boolean t2notOccupied(int x,int y){
		if(t2.espadachim.getState().equalsIgnoreCase("vivo")){
			int xsp=t2.espadachim.getX();
			int ysp=t2.espadachim.getY();
			if(x==xsp && y==ysp){return false;}
		}
		if(t2.lanceiro.getState().equalsIgnoreCase("vivo")){
			int xsw=t2.lanceiro.getX();
			int ysw=t2.lanceiro.getY();
			if( x==xsw && y==ysw){return false;}
		}
		if(t2.cavaleiro.getState().equalsIgnoreCase("vivo")){
			int xk=t2.cavaleiro.getX();
			int yk=t2.cavaleiro.getY();
			if(x==xk && y==yk){return false;}
		}
		
		int fx=t2.getFlagX();
		int fy=t2.getFlagY();
		if(x==fx && y==fy){return false;}
		{return true;}
	}
	/**
	 * checks if fighter during his movement didn't capture the flag of enemy's team
	 * @param x on the map
	 * @param y on the map
	 * @return true or false
	 */
	private boolean t1captureFlag(int x, int y) {
		if(x==t2.getFlagX() && y==t2.getFlagY()){
			return true;
		}
		return false;
	}
	private boolean t2captureFlag(int x, int y) {
		if(x==t1.getFlagX() && y==t1.getFlagY()){
			return true;
		}
		return false;
	}
	
	/**
	 * controls if the fighters movement is on position where is enemy's fighter and there is going to happen a fight
	 * @param x on the map
	 * @param y on the map
	 * @return true or false
	 */
	public boolean t1Isfight(int x, int y){
		int swx=t2.lanceiro.getX();
		int swy=t2.lanceiro.getY();
		int spx=t2.espadachim.getX();
		int spy=t2.espadachim.getY();
		int kx=t2.cavaleiro.getX();
		int ky=t2.cavaleiro.getY();
	
		if(x==swx && y==swy){isfight="lanceiro"; return true;}
		else if(x==spx && y==spy ){isfight="espadachim";return true;}
		else if(x==kx && y==ky ){isfight = "cavaleiro";return true;}
		return false;
	}
	public boolean t2Isfight(int x, int y){
		int swx=t1.lanceiro.getX();
		int swy=t1.lanceiro.getY();
		int spx=t1.espadachim.getX();
		int spy=t1.espadachim.getY();
		int kx=t1.cavaleiro.getX();
		int ky=t1.cavaleiro.getY();
	
		if(x==swx && y==swy){isfight="lanceiro"; return true;}
		else if(x==spx && y==spy ){isfight="espadachim";return true;}
		else if(x==kx && y==ky ){isfight = "cavaleiro";return true;}
		return false;
	}
	
	/**
	 * real fight is happening 
	 * @param name of fighter
	 * @param rival of enemy fighter
	 * @return message of results of the fight
	 */
	public String t1fight(String name, String rival){
		switch(name){
		case("cavaleiro"):return t1knightFight(rival);
		case("lanceiro"):return t1swordFight(rival);
		default:return t1spearFight(rival);
		}
	}
	public String t2fight(String name, String rival){
		switch(name){
		case("cavaleiro"):return t2knightFight(rival);
		case("lanceiro"):return t2swordFight(rival);
		default:return t2spearFight(rival);
		}
	}

	/**
	 * fights of each type of fighter
	 * @param rival name of enemy's fighter
	 * @return message of results of the fight
	 */
	private String t1spearFight(String rival) {
		switch(rival){
		case("espadachim"):t2.espadachim.setState("morte");return mes.killMessage("espadachim", t1.name());
		case("cavaleiro"):t2.cavaleiro.setState("morte");return mes.killMessage("cavaleiro", t1.name());
		default: t1.espadachim.setState("morte");return mes.dieMessage("lanceiro", t2.name());
		}
	}
	private String t2spearFight(String rival) {
		switch(rival){
		case("espadachim"):t1.espadachim.setState("morte");return mes.killMessage("espadachim", t2.name());
		case("cavaleiro"):t1.cavaleiro.setState("morte");return mes.killMessage("cavaleiro", t2.name());
		default: t2.espadachim.setState("morte");return mes.dieMessage("lanceiro", t1.name());
		}
	}

	private String t1swordFight(String rival) {
		switch(rival){
		case("espadachim"):t2.espadachim.setState("morte");return mes.killMessage("espadachim", t1.name());
		case("lanceiro"):t2.lanceiro.setState("morte");return mes.killMessage("lanceiro", t1.name());
		default: t1.lanceiro.setState("morte");return mes.dieMessage("cavaleiro", t2.name());
		}
	}
	private String t2swordFight(String rival) {
		switch(rival){
		case("espadachim"):t1.espadachim.setState("morte");return mes.killMessage("espadachim", t2.name());
		case("lanceiro"):t1.lanceiro.setState("morte");return mes.killMessage("lanceiro", t2.name());
		default: t2.lanceiro.setState("morte");return mes.dieMessage("cavaleiro", t1.name());
		}
	}

	private String t1knightFight(String rival) {
		switch(rival){
		case("cavaleiro"):t2.cavaleiro.setState("morte");return mes.killMessage("cavaleiro", t1.name());
		case("lanceiro"):t2.lanceiro.setState("morte");return mes.killMessage("lanceiro", t1.name());
		default: t1.cavaleiro.setState("morte");return mes.dieMessage("espadachim", t2.name());
		}
	}
	private String t2knightFight(String rival) {
		switch(rival){
		case("cavaleiro"):t1.cavaleiro.setState("morte");return mes.killMessage("cavaleiro", t2.name());
		case("lanceiro"):t1.lanceiro.setState("morte");return mes.killMessage("lanceiro", t2.name());
		default: t2.cavaleiro.setState("morte");return mes.dieMessage("espadachim", t1.name());
		}
	}
	
	
	/**
	 * real movement of fighter to direction 
	 * @param mov direction of movement
	 * @param x position on map 
	 * @param y position on map
	 * @param name of fighter
	 * @param team from which is fighter
	 * @return if he can move to desired position
	 */
	public boolean t1move(String mov, int x, int y,String name, String team) {
		switch(mov){
		case("norte"): y=y+1;return t1canMove(x,y, name);
		case("sul"): y=y-1;return t1canMove(x,y, name);
		case("oeste"): x=x-1;return t1canMove(x,y,name);
		case("este"): x=x+1;return t1canMove(x,y,name);
		default: return false;
		}
	}
	public boolean t2move(String mov, int x, int y,String name, String team) {
		switch(mov){
		case("norte"): y=y+1;return t2canMove(x,y, name);
		case("sul"): y=y-1;return t2canMove(x,y, name);
		case("oeste"): x=x-1;return t2canMove(x,y,name);
		case("este"): x=x+1;return t2canMove(x,y,name);
		default: return false;
		}
	}
	/**
	 * check if fighter can move to desired position
	 * @param x desired position on map
	 * @param y desired position on map
	 * @param name of fighter
	 * @return true or false
	 */
	public boolean t1canMove(int x, int y,String name){
		
			if(!inTheMap(x, y)){
				notInMap=true;
				return false;}
			if(!t1notOccupied(x, y)){
				occupied=true;
				return false;
			}else{
				switch(name){
				case("cavaleiro"):t1.cavaleiro.set(x, y);break;
				case("lanceiro"):t1.lanceiro.set(x, y);break;
				case("espadachim"):t1.espadachim.set(x, y);break;
				default: return false;
				}return true;
				
			}
			
		}
	public boolean t2canMove(int x, int y,String name){
		if(!inTheMap(x, y)){
			notInMap=true;
			return false;}
		if(!t2notOccupied(x, y)){
			occupied=true;
			return false;
		}else{
			switch(name){
				case("cavaleiro"):t2.cavaleiro.set(x, y);break;
				case("lanceiro"):t2.lanceiro.set(x, y);break;
				case("espadachim"):t2.espadachim.set(x, y);break;
				default: return false;
			}return true;
		}
	}
	
	
}
