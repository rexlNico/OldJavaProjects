package de.rexlNico.Main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	public static int LIVES = 15;
	public Main plugin;
	private PluginManager pm;
	
	@Override
	public void onEnable() {
		plugin = this;
		pm = Bukkit.getPluginManager();
		Bukkit.getConsoleSender().sendMessage("§4FlansmodPlugin geladen");
		
		
		
	}
	
	
	
}
