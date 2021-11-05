package de.rexlNico.Listeners;

import java.io.IOException;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.rexlNico.methodes.Var;

public class Join implements Listener{

	@EventHandler
	public void on(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if(Var.cfg.get(p.getName()+".strike.int") == null){
			Var.cfg.set(p.getName()+".strike.int", 0);
			Var.cfg.set(p.getName()+".strike.bantime", -1);
			try {
				Var.cfg.save(Var.file);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		
	}
	
}
