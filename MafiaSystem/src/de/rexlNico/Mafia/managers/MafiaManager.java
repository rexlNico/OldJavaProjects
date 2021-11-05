package de.rexlNico.Mafia.managers;

import java.util.HashMap;

import de.rexlNico.Mafia.objects.MafiaObj;

public class MafiaManager {

	private HashMap<String, MafiaObj> mafias;
	
	public MafiaManager(){
		this.mafias = new HashMap<>();
	}
	public HashMap<String, MafiaObj> getMafias() {
		return mafias;
	}
}
