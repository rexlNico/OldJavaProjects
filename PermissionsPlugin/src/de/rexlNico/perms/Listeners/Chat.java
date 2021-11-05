package de.rexlNico.perms.Listeners;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import de.rexlNico.perms.Methodes.PermsAPI;

public class Chat implements Listener{

	@EventHandler
	public void on(AsyncPlayerChatEvent e){
		File file = new File("plugins/Permplugin/permissions.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		e.setCancelled(true);
		String pr = cfg.getString(PermsAPI.getGroup(e.getPlayer())+".prefig");
		String msg = e.getMessage();
		
		if(e.getPlayer().hasPermission("perms.collor")){
			Bukkit.broadcastMessage(pr.replaceAll("&", "§")+" "+e.getPlayer().getName()+" §7"+msg.replaceAll("&", "§"));
		}else{	
		Bukkit.broadcastMessage(pr.replaceAll("&", "§")+" "+e.getPlayer().getName()+" §7"+msg);
		}
		
	}
	
}
