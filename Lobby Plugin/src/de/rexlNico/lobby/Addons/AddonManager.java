package de.rexlNico.lobby.Addons;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class AddonManager {

	public static File file = new File("plugins/Lobby/Addons/");
	
	public static boolean isAddonLoadet(String addonName){
		
		for(Plugin pl : Bukkit.getPluginManager().loadPlugins(file)){
			
			if(pl.getName() == addonName){
				return true;
			}
		}
		return false;
	}
	public static void LoadAddons(){
		for(Plugin pl : Bukkit.getPluginManager().loadPlugins(file)){
			pl.onLoad();
			Bukkit.getPluginManager().enablePlugin(pl);
		}
	}
	
}
