package de.rexlNico.Listeners;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.rexlNico.Main.Main;

public class Join implements Listener{

	@EventHandler
	public void on(PlayerJoinEvent e){
		Player p = e.getPlayer();
		File file = new File("plugins/players/"+p.getUniqueId().toString()+".yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if(!file.exists()){
			cfg.set("lives", Main.LIVES);
			try {
				cfg.save(file);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		
	}
	
}
