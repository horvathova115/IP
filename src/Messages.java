/**
 * executes all the messages outputs 
 * @author Klara Horvathova
 *
 */
public class Messages {
	
	public Messages(){
		
	}
	public String deathMessage(String type, String name) {
		return "O "+ type +" da ilustre casa de "+ name+" ja nao esta entre nos.";
	}
	public String killMessage(String name, String team){
		return "Muhahah,sou um "+ team +"! Sou invencivel! Nenhum "+name+" me faz frente!";
	}
	public String dieMessage(String name, String team){
		return "Argh! A dor! Maldito sejas,"+name+" "+team+".";
	}
	public String notIntheMap(String type, String name){
		return "O "+ type +" da ilustre casa de "+ name +" e um cobardolas.";
	}
	
	public String occupied(String type, String name){
		return "O "+ type +" da ilustre casa de "+ name +" devia tentar ir para outro sitio.";
	}
	public String winMessage(String rival, String team) {
		return "Sou um heroi "+team+"! A bandeira "+rival+" e nossa! Vitoria gloriosa!";
	}

	public String stateMessage(String name, String team, String state, int x, int y) {
		return team+" "+name+"("+state+")"+" "+x+" "+y;
	}

}
