import java.io.PrintStream;
import java.util.Scanner;

public class Main {

	//Constants which define commands
	public static final String leaving = "sai";
	public static final String help = "ajuda";
	public static final String newgame = "novo";
	public static final String map = "mapa";
	public static final String castles = "castelos";
	public static final String troops = "exercito";  //army
	public static final String kingdoms = "reinos";
	public static final String recruit = "recruta";
	public static final String soldier = "soldado";
	
	//Constants which define messages for the user
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
	private static final String inactivecomm = "Comando inactivo.";
	
	public static final String message_wrongMap = "Mapa pequeno demais para o jogo.";
	public static final String message_wrongKingdoms="Numero de reinos invalido.";
	public static final String message_wrongCastles="Numero de castelos invalido.";
	public static final String message_wrongCastelPos="Castelo em posicao invalida.";
	public static final String message_wrongCastelTreasure="Castelo com riqueza invalida.";
	public static final String message_wrongCastelName="Os castelos nao podem ter nomes duplicados.";
	public static final String message_wrongCastelNumber="Numero insuficiente de castelos criados.";
	public static final String message_wrongKingdomName = "Os reinos nao podem ter nomes duplicados.";
	public static final String message_occupiedCastle="Castelo ja ocupado.";
	public static final String message_nonexistentCastel="Castelo nao existe.";
	public static final String message_wrongKingdomNumber="Numero insuficiente de reinos criados.";
	public static final String message_unsuccesfulGame="Erro fatal, jogo nao inicializado.";
	public static final String message_succesfulNewGame="Jogo iniciado, comeca o reino ";
	public static final String message_wrongSoldierType = "Tipo de soldado inexistente.";
	public static final String message_CastleInvaded = "Castelo invadido ilegalmente."; 
	public static final String message_NoMoneyRecruit = "Riqueza insuficiente para recrutamento.";
	public static final String message_CastleNotFree = "Castelo nao livre.";
	private static final String message_enterCastles = "castelos:";
	private static final String message_enterKindoms = "reinos:";
	private static final String soldiers = "soldados";
	private static final String KNIGHT = "cavaleiro";
	private static final String SWORDSMAN = "espadachim";
	private static final String LANCER = "lanceiro";
	

	private static int numOfKingdoms;
	private static int numOfCastels;
	private static int mapPosX;
	private static int mapPosY;
	public static FiveKingdoms fk;
	private static boolean gameOn=false;
	//private static String teamPlaying="";
  
	//constants for preconditions
	private static final int MAX_KINGDOMS = 8;
	private static final int MIN_KINGDOMS = 2;
	private static final int MAP_MIN_DIM = 10;
	private static final int MIN_NUM_OF_CASTLES = numOfKingdoms;
	private static final int MAX_NUM_OF_CASTLES = mapPosX*mapPosY;
	
	
	
	
  
	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);
		//System.out.println("Bem vindo");
		processHelp1(); 
		String comm = "";
		do {
			comm = getCommand(in);
			if (!comm.equals(leaving)) {
				if(!gameOn){
					switch (comm){
					case help: processHelp1();break;
					case newgame: processNewGame(in);break;
					default: System.out.print(wrongcomm);
					}
				}else{
					comm = getCommand2(in);
					switch (comm){
					//by Klara
					case help: processHelp2();break;
					case newgame: processNewGame(in);break;
					case map:  in.nextLine(); processMap(); break;
					case castles: in.nextLine(); processCastles(); break; //class castel
					case troops: in.nextLine(); processTroops(); break;
					
					//commands by Luis
					case kingdoms: in.nextLine(); processKingdoms(); break; //class kingdom
					case recruit: processRecruit(in); break;
					case soldier: processSoldier(in); break;
					default: System.out.print(wrongcomm);
					}
				}
			}		
		 } while (!comm.equals(leaving));
		 System.out.println(goodbye);
		 in.close();
	}

	private static void processSoldier(Scanner in) {
		int soldierx = in.nextInt();
		int soldiery = in.nextInt();
		if (fk.checkType(soldierx, soldiery).equals(KNIGHT)) {
			String d1 = in.next();
			String d2 = in.next();
			String d3 = in.next();
		}
		else if (fk.checkType(soldierx, soldiery).equals(SWORDSMAN) || 
			fk.checkType(soldierx, soldiery).equals(LANCER)) {
			String d = in.next();
		}
		else {
			//validations
		}
		
	}
	
	private static boolean validateSoldierType(String type) {
			if (!type.equals(KNIGHT) || !type.equals(LANCER) || !type.equals(SWORDSMAN)) {
				return false;
			}
			else {
				return true;
			}
	}
	
	private static void processRecruit(Scanner in) {
		String finaltype = in.next().toLowerCase();
		String finalcastle = in.next().toLowerCase();
		if (validateSoldierType(finaltype) == false) {
			System.out.println(message_wrongSoldierType);
		}
		else if (fk.validateCastleOwner(fk.teamPlaying, finalcastle) == false) {
			//verify the definition of teamPlaying
			System.out.println(message_CastleInvaded);
		}
		else if (fk.canCastleBuy(finalcastle) == false) {
			System.out.println(message_NoMoneyRecruit);
		}
		else if (fk.isCastleOccupied(finalcastle)) {
			System.out.println(message_CastleNotFree);
		}
		else {
			fk.atributeSoldier(finaltype, finalcastle);
		}
	}

	private static void processKingdoms() {
		System.out.println(fk.activeKingdoms()+"reinos");
		fk.initializeIteratorKingdoms();
		while (fk.hasNextKingdom()) {
			// System.out.println(fk.nextName());
		}
		
	}

	// @pre: 8 >= fk.activeKingdoms() >= 2
	private static void processTroops() {
		System.out.println(fk.activeKingdoms()+kingdoms);
			fk.initializeIteratorKingdoms();
			while (fk.hasNextKingdom()) {
				System.out.println(fk.nextKingdom().getName()+","+fk.kingdomsnCastles(fk.nextKingdom().getName())+castles+","+
			fk.kingdomsnSoldiers(fk.nextKingdom().getName())+soldiers+","+fk.kingdomsnTreasure(fk.nextKingdom().getName())+
			"de riqueza."); //need to change this to a String constant and the ";"s too
			}
	}

	private static void processCastles() {
		System.out.println(fk.castlesOfKingdom(fk.teamPlaying));
	}

	private static void processMap() {
		// TODO Auto-generated method stub
		if(!fk.gameOn){
			System.out.println(inactivecomm);
		}
		System.out.println(fk.getMapPosition().getX() + fk.getMapPosition().getY());
		System.out.println(numOfCastels + message_enterCastles);
		fk.initializeIteratorCastles();
		while(fk.hasNextCastle()){
			Castles c=fk.nextCastle();
			System.out.println(c.getName()+"("+c.getOwner()+")");
		}
		fk.initializeIteratorKingdoms();
		while(fk.hasNextKingdom()){
			Kingdom k = fk.nextKingdom();
			System.out.print(k.getName()+"; "); //this ";" cant be there just like this, but it has time :D
		}
	}


	private static void processNewGame(Scanner in) {
		// TODO Auto-generated method stub
		mapPosX=in.nextInt();
		//System.out.println(mapPosX);
		mapPosY=in.nextInt();
		numOfKingdoms=in.nextInt();
		System.out.println(numOfKingdoms);
		numOfCastels=in.nextInt();
		
		if(!validate(mapPosX,mapPosY,numOfKingdoms, numOfCastels)){
			System.out.println(message_unsuccesfulGame);
		}else{fk = new FiveKingdoms(mapPosX, mapPosY, numOfKingdoms, numOfCastels);
			if (!processCastles(in)){
				System.out.println(message_unsuccesfulGame);
			}else if(!processKingdoms(in)){
				System.out.println(message_unsuccesfulGame);
			}else{
				System.out.println(message_succesfulNewGame);
				gameOn=true;
			}
		}
	}
	
	private static boolean processKingdoms(Scanner in) {
		// TODO Auto-generated method stub
		boolean process=false;
		int count = 0;
		System.out.println(numOfKingdoms + message_enterKindoms);
		Scanner castScanner = new Scanner (System.in);
		String kingdom, castle;
		for (int i=0;i<numOfKingdoms;i++) {
		    kingdom = castScanner.next();
		    castle=castScanner.nextLine().trim();
		    System.out.println(castle);
		    //castScanner.nextLine();
		    if(validateKingdoms(kingdom, castle)){
		    	Kingdom k = new Kingdom(kingdom); //castle into collection of castles which belong to each kingdom, castle of type Castles
		    	fk.addKingdom(k);
		    	k.addCastle(fk.getCastle(castle));
		    	fk.getCastle(castle).setOwner(k);
		    	count++;	 //counting number of creating castles in real
		    }
		    }if(count<MIN_KINGDOMS){
		    	System.out.println(message_wrongKingdomNumber);
		    	fk.removeAllKingdoms();}
		    else{ process=true;}
		return process;
	}

	private static boolean validateKingdoms(String kingdom, String castle) {
		// TODO Auto-generated method stub
		boolean valid=false;
		//if names are not duplicated
		if(fk.getNumberOfKingdoms()>0){
			if(fk.existKingdom(kingdom)){
				System.out.println(message_wrongKingdomName);
			}
		}
		else if(fk.castleFree(castle)){
			System.out.println(message_occupiedCastle);
		}
		else if(!fk.existCastleName(castle)){
			System.out.println(castle);
			System.out.println(message_nonexistentCastel);
		}else{
			valid=true;
		}
		return valid;
	}

	private static boolean validate(int x,int y, int nok, int noc){
		if (x<=MAP_MIN_DIM && y<=MAP_MIN_DIM){
			System.out.println(message_wrongMap);
		}else if( MIN_KINGDOMS > nok &&  nok> MAX_KINGDOMS){
			System.out.println(nok +" "+ MIN_KINGDOMS+" "+MAX_KINGDOMS );
			System.out.println(message_wrongKingdoms);
		}else if(MIN_NUM_OF_CASTLES>noc && noc>MAX_NUM_OF_CASTLES){
			System.out.println(message_wrongCastles);
		}else {System.out.println(message_succesfulNewGame);
			return true;}
		
		return false;
	}
	
	private static boolean processCastles(Scanner in){
		boolean process=false;
		int count = 0;
		int x, y, treasure;
		String name;
		//System.out.println(numOfCastels + message_enterCastles);
		Scanner castScanner = new Scanner(System.in);
		System.out.println(numOfCastels + " "+ message_enterCastles);
		
		for (int i=0;i<numOfCastels;i++) {
		    x = castScanner.nextInt();
		    y = castScanner.nextInt();
		    treasure = castScanner.nextInt();
		    name = castScanner.nextLine().trim();
		    System.out.println(name);
		   // castScanner.nextLine();
		    if(validateCastles(x,y,treasure,name)){
		    	Castles c = new Castles(x,y,treasure,name, false);
		    	fk.addCastle(c); //problem not created yet fk
		    	count++;	 //counting number of creating castles in real
		    }
		    }if(count<MIN_NUM_OF_CASTLES){
		    	System.out.println(message_wrongCastelNumber);
		    	fk.removeAllCastles();}
		    else{ process=true;}
		return process;
	}
	
	private static boolean validateCastles(int x, int y, int treasure, String name ){
		if(x<1 && y<1 && x>mapPosX && y>mapPosY && fk.existCastlePos(x,y)){ //and also if there no castles on the same position
	    	System.out.println(message_wrongCastelPos);
	    }else if(treasure<0){
	    	System.out.println(message_wrongCastelTreasure);
	    }else if(fk.existCastleName(name)){
	    	System.out.println(message_wrongCastelName);
	    }else{return true;
	    }
		return false;
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


	private static String getCommand(Scanner in) {
		System.out.print(">");
		String option = in.next().toLowerCase();
		return option;
	}
	
	private static String getCommand2(Scanner in) {
		System.out.print(fk.teamPlaying+">");
		String option = in.next().toLowerCase();
		return option;
	}
}
