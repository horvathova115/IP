import java.util.Scanner;

public class Main {

	//Constantes que definem os comandos
	public static final String leaving = "sai";
	public static final String help = "ajuda";
	public static final String newgame = "novo";
	public static final String map = "mapa";
	public static final String castles = "castelos";
	public static final String troops = "exercito";  //army
	public static final String kingdoms = "reinos";
	public static final String recruit = "recruta";
	public static final String soldier = "soldado";
	
	//Constantes que definem as mensagens
	public static final String goodbye = "Obrigado por jogar. Ate a proxima.";
	public static final String wrongcomm = "Opcao inexistente.";
	public static final String message_newgame = "Novo jogo";
	public static final String message_soldier = "Move o soldado";
	public static final String message_recruit = "Recruta um soldado num castelo";
	public static final String message_map = "Lista todos os castelos do mapa, incluindo os abandonados, pela ordem de criacao no jogo\n e todos os reinos ainda em jogo, pela ordem de jogada";
	public static final String message_castles = "Lista os castelos do jogador activo, pela ordem pela qual foram conquistados";
	public static final String message_troops = "Lista os soldados vivos do jogador activo, pela ordem de recrutamento";
	public static final String message_kingdoms = "Lista os varios reinos ainda em jogo, ordenados por nome do reino";
	public static final String message_help = "Mostra a ajuda";
	public static final String message_leaving = "Termina a execucao do programa";
	

  //constants for preconditions
	private static final int MAX_KINGDOMS = 8;
	private static final int MIN_KINGDOMS = 2;
	private static final int MAP_MIN_DIM = 10;
	private static final int MIN_NUM_OF_CASTLES = numberOfKingdoms;
	private static final int MAX_NUM_OF_CASTLES = mapPosX*mapPosY;
	
	
	private int numberOfKingdoms;
	private int mapPosX;
	private int mapPosY;
  
  
	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Bem vindo");
		FiveKingdoms fk = new FiveKingdoms();
		String comm = "";
		do {
			comm = getCommand(in, fk);
			if (!comm.equals(leaving)) {
				if(!fk.gameOn){
					switch (comm){
					case help: processHelp1(fk);break;
					case newgame: in.nextLine();processNewGame(in, fk);break;
					default: System.out.print(wrongcomm);
					}
				}else{
					switch (comm){
					//by Klara
					case help: processHelp2(fk);break;
					case newgame: processNewGame(in, fk);break;
					case map:  in.nextLine(); processMap(fk); break;
					case castles: in.nextLine(); processCastles(fk); break; //class castel
					case troops: in.nextLine(); processTroops(fk); break;
					
					//commands by Luis
					case kingdoms: in.nextLine(); processKingdoms(fk); break; //class kingdom
					case recruit: processRecruit(in, fk); break;
					case soldier: processSoldier(in, fk); break;
					default: System.out.print(wrongcomm);
					}
				}
			}		
		 } while (!comm.equals(leaving));
		 System.out.println(goodbye);
		 in.close();
	}

	private static void processSoldier(Scanner in, FiveKingdoms fk) {
		// TODO Auto-generated method stub
		
		//while (in.next()) 
		
	}

	private static void processRecruit(Scanner in, FiveKingdoms fk) {
		// TODO Auto-generated method stub
		
	}

	private static void processKingdoms(FiveKingdoms fk) {
		// TODO Auto-generated method stub
		
	}

	private static void processTroops(FiveKingdoms fk) {
		
	}

	private static void processCastles(FiveKingdoms fk) {
		// TODO Auto-generated method stub
		
	}

	private static void processMap(FiveKingdoms fk) {
		// TODO Auto-generated method stub
		
	}

	private static void processNewGame(Scanner in, FiveKingdoms fk) {
		// TODO Auto-generated method stub
		mapPosX=in.nextInt();
		mapPosY=in.nextInt();
		numOfKingdoms=in.nextInt();
		numOfCastels=in.nextInt();
		
	}

	private static void processHelp1() { 
			System.out.println(newgame+" - "+message_newgame);
			System.out.println(help+" - "+ message_help);
			System.out.println(leaving+" - "+ message_leaving);
	}
	
	
	private static void processHelp2() {
			System.out.println(newgame+" - "+message_newgame);
			System.out.println(soldier+" - "+message_soldier);
			System.out.println(recruit+" - "+message_recruit);
			System.out.println(map+" - "+message_map);
			System.out.println(castles+" - "+message_castles);
			System.out.println(troops+" - "+message_troops);
			System.out.println(kingdoms+" - "+message_kingdoms);
			System.out.println(help+" - "+ message_help);
			System.out.println(leaving+" - "+ message_leaving);
	}


	private static String getCommand(Scanner in, FiveKingdoms fk) {
		System.out.print(">"+fk.teamPlaying);
		String option = in.next().toLowerCase();
		return option;
	}
}
