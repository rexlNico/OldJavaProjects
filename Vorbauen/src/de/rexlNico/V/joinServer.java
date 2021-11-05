package de.rexlNico.V;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class joinServer implements Listener{

	@EventHandler
	public void on(PlayerJoinEvent e){
		Player p = e.getPlayer();
		File file = new File("plugins/Vorbauen/config.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		List<String> players = cfg.getStringList("Players");
		boolean bol = false;
		for(int i=0; i<players.size(); i++){
			if(players.get(i).equals(p.getUniqueId().toString())){
				bol = true;
			}
		}
		if(bol = true){
			p.teleport(new Location(Bukkit.getWorld("bawe"), 0.481, 65.5, 14.541));
			players.add(p.getUniqueId().toString());
			cfg.set("Players", players);
			try {
				cfg.save(file);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	@EventHandler
	public void on(WeatherChangeEvent e){
		e.setCancelled(true);
	}
	
}
