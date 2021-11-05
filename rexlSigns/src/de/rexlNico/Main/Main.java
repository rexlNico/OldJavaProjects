package de.rexlNico.Main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	private static Main plugin;
	private int TaskID;
	PluginManager pm;
	
	@Override
	public void onEnable() {
		plugin = this;
		pm = Bukkit.getPluginManager();
		
		
		Bukkit.getConsoleSender().sendMessage("§4Aktiviert §erexlSign");
		load();
		Bukkit.getConsoleSender().sendMessage("§erexlSign§4: §5Commands§8, §6Events §aregistriert");
		this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		TaskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
			
			@Override
			public void run() {
				SignApi.updateSign();
				
			}
		}, 0, 2);
		
	}
	
	public void load(){
		getCommand("addsign").setExecutor(new Commands());
		pm.registerEvents(new joinServer(), this);
		
	}
	public static Main getPlugin() {
		return plugin;
	}
	
}
