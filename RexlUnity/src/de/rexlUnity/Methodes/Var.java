package de.rexlUnity.Methodes;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Var {

	public static String pr = "§8▏ §e● §8▏ §eRexlUnity §8× §r",
			noperm = pr+"§7Dazu hast du keine §4Berechtigung§7.",
			error = pr+"§7Bitte nutze §c/",
			console = pr+"§4Das kann nur ein Spieler ausführen.",
			perm = "rexl.",
			notOnline = pr+"§cDieser Spieler befindet sich nicht auf dem Netzwerk.";
	
	public static File cfgfile = new File("plugins/rexlUnity/config.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(cfgfile);
	public static File Fcfgfile = new File("plugins/rexlUnity/Teleports.yml");
	public static YamlConfiguration Fcfg = YamlConfiguration.loadConfiguration(Fcfgfile);
	public static File YTcfgfile = new File("plugins/rexlUnity/YoutuberBox.yml");
	public static YamlConfiguration YTcfg = YamlConfiguration.loadConfiguration(YTcfgfile);
	
}
