package de.rexlNico.Mafia.objects;

import java.util.ArrayList;

public class MafiaObj {

	
	private String name;
	private String kürzel;
	private RGB color;
	private ArrayList<String> mitglieder;
	private ArrayList<String> mafossis;
	private String boss;
	
	public MafiaObj(String name, String kürzel,RGB color, ArrayList<String> mitglieder, ArrayList<String> mafossis, String boss){
		
		this.name = name;
		this.kürzel = kürzel;
		this.color = color;
		this.mitglieder = mitglieder;
		this.mafossis = mafossis;
		this.boss = boss;
		
	}
	
	public RGB getColor() {
		return color;
	}

	public void setColor(RGB color) {
		this.color = color;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKürzel() {
		return kürzel;
	}

	public void setKürzel(String kürzel) {
		this.kürzel = kürzel;
	}

	public ArrayList<String> getMitglieder() {
		return mitglieder;
	}

	public void setMitglieder(ArrayList<String> mitglieder) {
		this.mitglieder = mitglieder;
	}

	public ArrayList<String> getMafossis() {
		return mafossis;
	}

	public void setMafossis(ArrayList<String> mafossis) {
		this.mafossis = mafossis;
	}

	public String getBoss() {
		return boss;
	}

	public void setBoss(String boss) {
		this.boss = boss;
	}
	
	
}
