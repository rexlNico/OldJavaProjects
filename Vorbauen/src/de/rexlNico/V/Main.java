package de.rexlNico.V;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	private static Main plugin;
	PluginManager pm;
	
	@Override
	public void onEnable() {
		plugin = this;
		pm = Bukkit.getPluginManager();
		
		
		Bukkit.getConsoleSender().sendMessage("§4Aktiviert §erexlSign");
		load();
		Bukkit.getConsoleSender().sendMessage("§erexlSign§4: §5Commands§8, §6Events §aregistriert");
		File file = new File("plugins/Vorbauen/config.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if(!file.exists()){
			List<String> p = new ArrayList<>();
			p.add("TESTUUID");
			cfg.set("Players", p);
			try {
				cfg.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void load(){
		pm.registerEvents(new joinServer(), this);
		
	}
	public static Main getPlugin() {
		return plugin;
	}
	
}
