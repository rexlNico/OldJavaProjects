package de.rexlNico.GAME.Methodes;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Var {

	public static File file = new File("plugins/LOM/blöcke.txt");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	public static final String pr = "§8[§a§lLoM§8] §7",
			noperm = pr+"§cDazu hast du keine Rechte!",
			error = pr+"Bitte nutze §c/",
			console = "§4Das darf nur ein Spieler ausführen.",
			perms = "lom.";
	
	public static boolean canMove = true,
						  pvp = false;
	
	public static String Map = "ARAM";
	public static int MAX_PLAYERS_PER_TEAM = 5;
	
	public static ArrayList<Player> noTeam = new ArrayList<>();
	public static ArrayList<Player> Rot = new ArrayList<>();
	public static ArrayList<Player> Blau = new ArrayList<>();
	public static ArrayList<Player> playing = new ArrayList<>();
	
	//Map Vote
	public static ArrayList<Player> noMap = new ArrayList<>();
	public static ArrayList<Player> aram = new ArrayList<>();
	public static ArrayList<Player> wald = new ArrayList<>();
	public static ArrayList<Player> kluft = new ArrayList<>();
	
	
			
	
}
