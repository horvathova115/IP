/**
 * The class Mapa represents map of the game
 * it has 2 private variables x, y dimensions of the map.
 * Map is initialized by Game @see clas Game 
 * there are two methods getX and getY for other Classes to be able receive  dimensions of the map
 * @author Klara Horvathova
 *
 */
public class Mapa {
	
	private  int x;
	private  int y;
	
	public Mapa(int dimx, int dimy){
		x=dimx;
		y=dimy;
	}
	
	public int getX(){return x;}
	public int getY(){return y;}
	
}
