package de.rexlNico.Main;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.rexlNico.Commans.Strike;
import de.rexlNico.methodes.Var;


public class Main extends JavaPlugin{

	private Main plugin;
	private PluginManager pm = Bukkit.getPluginManager();
	private int tID;
	
	@Override
	public void onEnable() {
		plugin = this;
		Bukkit.getConsoleSender().sendMessage("§5FlansModplugin geladen");
		
		getCommand("strike").setExecutor(new Strike());
		
		
		
		tID = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			
			@Override
			public void run() {
				
				for(Player a: Bukkit.getOnlinePlayers()){
					int i = Var.cfg.getInt(a.getName()+".strike.bantime");
					if(i > 0){
						Var.cfg.set(a.getName()+".strike.bantime", i-1);
						try {
							Var.cfg.save(Var.file);
						} catch (IOException e) {
						}
					}else if(i == 0){
						
						a.setBanned(false);
						
						Var.cfg.set(a.getName()+".strike.bantime", -1);
						Var.cfg.set(a.getName()+".strike.bantime", i-1);
						try {
							Var.cfg.save(Var.file);
						} catch (IOException e) {
						}
					}
				}
				
				
			}
		}, 0, 20*1);
		
	}
	
	public Main getPlugin() {
		return plugin;
	}
	
}
