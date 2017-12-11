
public class T1Cavaleiro {

	public int x;
	public int y;
	private String state;
	public T1Cavaleiro(int xx, int yy, String st){
		x=xx;
		y=yy;
		state=st;
	}
	
	public String getState(){return state;}
	public int getX(){ return x ;}
	public int getY(){ return y ;}
	public void set(int sx, int sy){x=sx;y=sy;}
	public void setState(String st){state=st;}
	
	public boolean alive(){
		if(state.equalsIgnoreCase("vivo")){
			return true;
		}
		return false;
	}



}
