/**
* The Capture the Flag game
*
* @author  Klara Horvathova
* @version 1.0
* @since   2017-11-8 
*/
import java.util.Scanner;
public class Main {
	/**This is the Main class where all the input/output messages and calling methods form other classes are executed
	*@param onGame defines if any Game was started or finished
	*@param game connects Main class with Game class
	*@param t1onTurn and t2onTurn defines which team is on turn
	*/ 
	private static boolean onGame;
	private static Game game;
	private static boolean t1onTurn;
	private static boolean t2onTurn;
	
	/**method main shows the welcome screen and handles the input
	 * each time user inputs option corresponding method is called
	 * 
	 */
	public static void main(String[] args) {
		onGame=false;
		ajuda1();
		Scanner in = new Scanner(System. in );
		String option;
		option = readCommand(in); 
		while(!option.equals("SAI")) {
			switch (option){
			case "AJUDA": ajuda();break;
			case "NOVO":  novo(in);break;
			case "MAPA": in.nextLine(); map(); break;
			case "CAVALEIRO":  cavaleiro(in); break;
			case "ESPADACHIM": espadachim(in); break;
			case "LANCEIRO":  lanceiro(in); break;
			default: System.out.print("Opcao inexistente.");
			}
			option=readCommand(in);
		}
		in.close();
		System.out.println(teamOnturn()+"Obrigado por jogar. Ate a proxima.");
	}
	/**
	 * @method ajuda1 works as welcome screen when is no Game on/
	 */
	public static void ajuda1(){
	System.out.println("novo - Novo jogo");
	System.out.println("ajuda - Mostra a ajuda");
	System.out.println("sai - Termina a execucao do programa");
	}
	/**
	 * @method ajuda is executed every time is input "ajuda"
	 */
	public static void ajuda(){
		if(!onGame){
		System.out.println("> novo - Novo jogo");
		System.out.println("ajuda - Mostra a ajuda");
		System.out.println("sai - Termina a execucao do programa");
		}
		else{
			System.out.print(teamOnturn());
			System.out.println("novo - Novo jogo");
			System.out.println("mapa - Mostra o mapa do jogo");
			System.out.println("cavaleiro - Move o cavaleiro");
			System.out.println("espadachim - Move o espadachim");
			System.out.println("lanceiro - Move o lanceiro");
			System.out.println("ajuda - Mostra a ajuda");
			System.out.println("sai - Termina a execucao do programa");
		}
	}
	/**
	 * method for reading commands
	 * @param in receive input from Scanner
	 * @return option from Scanner changed from type Scanner to String
	 */
	private static  String readCommand(Scanner in) {
		String op;
		op = in.next().toUpperCase();
		return op;
	}
	/**
	 * method "novo" initiates new Game game if is valid @see valid(), set onGame on true 
	 * @param in receive input from Scanner
	 */
	public static void novo(Scanner in){
		int mapDimx, mapDimy, flag1x, flag1y, flag2x, flag2y ;
		String name1, name2;
		mapDimx=in.nextInt();
		mapDimy=in.nextInt();
		in.nextLine();
		name1=in.next();
		flag1x=in.nextInt();
		flag1y=in.nextInt();
		in.nextLine();
		name2=in.next();
		flag2x=in.nextInt();
		flag2y=in.nextInt();
		in.nextLine();
		int check = Math.abs(flag1x-flag2x) + Math.abs(flag1y-flag2y);
		if( valid(mapDimx, mapDimy, flag1x, flag1y, flag2x, flag2y, name1, name2, check)){
			onGame=true;
			if(!t1onTurn){
			System.out.println("> Jogo iniciado, comeca a equipa "+ name1 +".");}
			else if(t1onTurn || t2onTurn){System.out.println(teamOnturn()+"Jogo iniciado, comeca a equipa "+ name1 +".");}
			t1onTurn=true;
			t2onTurn=false;
			game=new Game(mapDimx, mapDimy, flag1x, flag1y, flag2x, flag2y, name1, name2);
			game.c.endOfTheGame=false;
		}else{
		onGame=false;
		t1onTurn=false;
		t2onTurn=false;
		}
	}
	
/**
 * method valid checks if all the parameters for new Game are valid and also output messages if something is not valid
 * @param mapDimx is x coordinate for map
 * @param mapDimy is y coordinate for map
 * @param flag1x is x coordinate for flag of team 1
 * @param flag1y is y coordinate for flag of team 1
 * @param flag2x is x coordinate for flag of team 2
 * @param flag2y is x coordinate for flag of team 2
 * @param name1 is name of team 1
 * @param name2 is name of team 2
 * @param check is the distance between two flags 
 * @return if is valid or not (true or false)
 */
	private static boolean valid(int mapDimx, int mapDimy, int flag1x, int flag1y, int flag2x, int flag2y, String name1,
			String name2, int check) {
		if (mapDimx<10 || mapDimy<10 ){
			System.out.println(teamOnturn()+"Mapa pequeno demais para o jogo.");
			return false;
		}
		if(flag1x >= mapDimx || flag1y >= mapDimy|| flag1x<=1 || flag1y <=1){
			System.out.println(teamOnturn()+ name1 + " bandeira em posicao invalida "+
					flag1x + " "+flag1y+".");
			if(flag2x >= mapDimx || flag2y >= mapDimy || check<=5 || flag2x<=1 || flag2y<=1){
				System.out.println( name2 + " bandeira em posicao invalida "+
						flag2x + " "+flag2y+".");}
			return false;}
		else if(flag2x >= mapDimx || flag2y >= mapDimy || check<=5 || flag2x<=1 || flag2y<=1){
			System.out.println( teamOnturn()+name2 + " bandeira em posicao invalida "+
					flag2x + " "+flag2y+".");
			return false;}
		
		if(name1.equals(name2)){
			System.out.println(teamOnturn()+"As equipas nao podem ter o mesmo nome.");
			return false;
		}
		return true;
	}
	/**
	 * method map outputs all the information about the size of map, each team name, position of flag and position and state of each fighter
	 */
	public static void map(){
		if (!onGame){
			System.out.println("> Comando inactivo.");
		}
		else{
			System.out.println(teamOnturn()+game.m.getX() + " "+ game.m.getY());
			System.out.print(game.t1.name() + " "+ game.t1.getFlagX()+" "+ game.t1.getFlagY());
			System.out.print(" cavaleiro("+ game.t1.cavaleiro.getState()+") "+ game.t1.cavaleiro.getX()+" "+ game.t1.cavaleiro.getY());
			System.out.print(" espadachim("+ game.t1.espadachim.getState()+") "+ game.t1.espadachim.getX()+" "+ game.t1.espadachim.getY());
			System.out.println(" lanceiro("+ game.t1.lanceiro.getState()+") "+ game.t1.lanceiro.getX()+" "+ game.t1.lanceiro.getY());
			System.out.print(game.t2.name() + " "+ game.t2.getFlagX()+" "+ game.t2.getFlagY());
			System.out.print(" cavaleiro("+ game.t2.cavaleiro.getState()+") "+ game.t2.cavaleiro.getX()+" "+ game.t2.cavaleiro.getY());
			System.out.print(" espadachim("+ game.t2.espadachim.getState()+") "+ game.t2.espadachim.getX()+" "+ game.t2.espadachim.getY());
			System.out.println(" lanceiro("+ game.t2.lanceiro.getState()+") "+ game.t2.lanceiro.getX()+" "+ game.t2.lanceiro.getY());
		}
	}
	/**
	 * method teamOnturn finds out which team is on the turn
	 * @return the name of the team which is on the turn
	 */
	private static String teamOnturn() {
		if(!onGame){
			return "> ";
		}
		if(t1onTurn){
			return game.t1.name()+" > ";
		}else{
			return game.t2.name()+" > ";
		}
	}

/**
 * method lanceiro calls method lanceiro in class Combat to make a movement in direction from
 * @param in receive input form Scanner 
 * @return message of his action (where he moved, if he moved)
 */
	private static String lanceiro(Scanner in) {
		String res="";
		String mov=in.next();
		if(!onGame){
			System.out.println("Nenhum jogo a decorrer.");
		}
		if(t1onTurn){
			res = game.c.t1lanceiro(mov);
		}else{
			res = game.c.t2lanceiro(mov);
			}
		System.out.print(teamOnturn());
		if(res!=""){System.out.println(res);}
		System.out.println(stateMessage("lanceiro"));
		changeTurn();
		return res;
	}

	/**
	 * method espadachim calls method espadachim in class Combat to make a movement in direction from
	 * @param in receive input form Scanner 
	 * @return message of his action (where he moved, if he moved)
	 */
	private static String espadachim(Scanner in) {
		String res="";
		String mov=in.next();
		if(!onGame){
			System.out.println("Nenhum jogo a decorrer.");
		}
		if(t1onTurn){
			res = game.c.t1espadachim(mov);
		}else{res =game.c.t2espadachim(mov);};
		
		System.out.print(teamOnturn());
		if(res!=""){System.out.println(res);}
		System.out.println(stateMessage("espadachim"));
		changeTurn();
		return res;
	}

	/**
	 * method cavaleiro calls method cavaleiro in class Combat to make a movement in direction from
	 * @param in receive input form Scanner 
	 * @return message of his action (where he moved, if he moved)
	 */
	private static String cavaleiro(Scanner in) {
		String res="";
		String mov=in.next();
		String mov2=in.next();
		String mov3=in.next();
		if(!onGame){
			System.out.println("Nenhum jogo a decorrer.");
		}
		if(t1onTurn){	
			res = game.c.t1cavaleiro(mov);
			System.out.print(teamOnturn());
			if(res!=""){System.out.println(res);}
			if(game.c.endOfTheGame){System.out.println(stateMessage("cavaleiro"));onGame=false;return  stateMessage("cavaleiro");}
			System.out.println(stateMessage("cavaleiro"));
			res = game.c.t1cavaleiro(mov2);
			if(res!=""){System.out.println(res);}
			if(game.c.endOfTheGame){System.out.println(stateMessage("cavaleiro"));onGame=false;return  stateMessage("cavaleiro");}
			System.out.println(stateMessage("cavaleiro"));
			res = game.c.t1cavaleiro(mov3);
			if(res!=""){System.out.println(res);}
			System.out.println(stateMessage("cavaleiro"));
		}else{
			res =game.c.t2cavaleiro(mov);
			System.out.print(teamOnturn());
			if(res!=""){System.out.println(res);}
			if(game.c.endOfTheGame){System.out.println(stateMessage("cavaleiro"));onGame=false;return  stateMessage("cavaleiro");}
			System.out.println(stateMessage("cavaleiro"));
			res =game.c.t2cavaleiro(mov2);
			if(res!=""){System.out.println(res);}
			if(game.c.endOfTheGame){System.out.println(stateMessage("cavaleiro"));onGame=false;return  stateMessage("cavaleiro");}
			System.out.println(stateMessage("cavaleiro"));
			res =game.c.t2cavaleiro(mov3);
			if(res!=""){System.out.println(res);}
			System.out.println(stateMessage("cavaleiro"));
		}		
		changeTurn();
		return res;
	}
	
	/**
	 * method stateMessage return the name of team, of fighter his position and actual state 
	 * @param name is name of a fighter
	 * @return String message the name of team, of fighter his position and actual state for each team
	 */
	public static String stateMessage(String name){
		if(t1onTurn){
			switch(name){
			case("cavaleiro"):return game.t1.name()+" cavaleiro("+ game.t1.cavaleiro.getState()+") "+ game.t1.cavaleiro.getX()+" "+ game.t1.cavaleiro.getY();
			case("lanceiro"):return game.t1.name()+" lanceiro("+ game.t1.lanceiro.getState()+") "+ game.t1.lanceiro.getX()+" "+ game.t1.lanceiro.getY();
			case("espadachim"):return game.t1.name()+" espadachim("+ game.t1.espadachim.getState()+") "+ game.t1.espadachim.getX()+" "+ game.t1.espadachim.getY();
			default: return "";
			}
		}else{
			switch(name){
			case("cavaleiro"):return game.t2.name()+" cavaleiro("+ game.t2.cavaleiro.getState()+") "+ game.t2.cavaleiro.getX()+" "+ game.t2.cavaleiro.getY();
			case("lanceiro"):return game.t2.name()+" lanceiro("+ game.t2.lanceiro.getState()+") "+ game.t2.lanceiro.getX()+" "+ game.t2.lanceiro.getY();
			case("espadachim"):return game.t2.name()+" espadachim("+ game.t2.espadachim.getState()+") "+ game.t2.espadachim.getX()+" "+ game.t2.espadachim.getY();
			default: return "";
			}
		}
	}

	/**
	 * method changeTurn changes the active team wich is on turn
	 */
	public static void changeTurn(){
		if(t1onTurn){
		t2onTurn = true;
			t1onTurn = false;}
		else {
			t2onTurn=false;
			t1onTurn=true;
		}
	}
		

}
