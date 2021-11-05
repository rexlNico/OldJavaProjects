package gameeinstellungen;

public class Sprung extends Thread {
	
	static boolean fertig = true;
	static boolean hochpunk = false;
	
	int sprunghöhe = 85;
	static int ursprungsY = 235;
	static int sprungposition = ursprungsY;

	public Sprung(){
		
		sprungposition = sprungposition + sprunghöhe;
		
		
	}
}
