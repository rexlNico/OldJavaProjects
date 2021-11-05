package de.rexlNico.Mafia.Api;

import java.io.File;
import java.util.HashMap;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Var {

	public static HashMap<Player, String> playersMafia = new HashMap<>();
	
	public static File mafia = new File("plugins/Mafia/mafia.yml");
	public static YamlConfiguration cfgmafia = YamlConfiguration.loadConfiguration(mafia);
	
	public static File users = new File("plugins/Mafia/users.yml");
	public static YamlConfiguration cfgusers = YamlConfiguration.loadConfiguration(users);
	
	public static String perms = "mafia.";
	
}
