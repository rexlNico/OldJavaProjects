package de.rexlNico.Listeners;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Death implements Listener{

	@EventHandler
	public void on(PlayerDeathEvent e){
		Player p = e.getEntity();
		if(p.getLastDamageCause().equals(DamageCause.ENTITY_ATTACK)){
			File file = new File("plugins/players/"+p.getUniqueId().toString()+".yml");
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			
				cfg.set("lives", cfg.getInt("lives")-1);
				try {
					cfg.save(file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(cfg.getInt("lives") == 0){
					p.kickPlayer("§4Du hast keine Leben mehr deshalb bist du raus");
					p.setBanned(true);
				}
			
		}
	}
	
}
