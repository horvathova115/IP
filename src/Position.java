/*

 * @author Klaruska
 *
 */

public class Position {

	
	private int x;
	private int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void addX(int much) {
		x+=much;
	}
	
	public void addY(int much) {
		y+=much;
	}
}
