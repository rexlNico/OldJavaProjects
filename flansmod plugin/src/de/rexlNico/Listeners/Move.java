package de.rexlNico.Listeners;

import java.io.File;

import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Move implements Listener{

	@EventHandler
	public void on(PlayerMoveEvent e){
		Player p = e.getPlayer();
		File file = new File("plugins/fmb/config.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		if(cfg.get("start") == null || cfg.getBoolean("start") == false){
			if(!e.getPlayer().isOp()){
				p.teleport(new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ()));
			}
		}
		
	}
	
}
