package de.rexlNico.lobby.Api;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

public class Var {

	public static File file = new File("plugins/Lobby/config.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	public static File pfile = new File("plugins/Lobby/players.yml");
	public static YamlConfiguration pcfg = YamlConfiguration.loadConfiguration(file);
	
	public static String pr = cfg.getString("Prefix").replaceAll("&", "");
	public static String noperm = cfg.getString("NoPerm").replaceAll("&", "").replace("%PREFIX%", pr);
	public static String perms = "lobby.";
	
	
}
