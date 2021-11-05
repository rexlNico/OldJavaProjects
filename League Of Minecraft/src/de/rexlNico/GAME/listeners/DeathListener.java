package de.rexlNico.GAME.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import de.rexlNico.GAME.Methodes.SetItems;
import de.rexlNico.GAME.Methodes.Var;

public class DeathListener implements Listener{
	
	@EventHandler
	public void on(PlayerDeathEvent e){
		Player p = e.getEntity();;
		SetItems.setBackAndCham(p);
	}
	
	@EventHandler
	public void on(EntityDamageByEntityEvent e){
		Player ph = (Player) e.getDamager();
		Player pwh = (Player) e.getEntity();
		
		if(Var.Blau.contains(pwh) && Var.Blau.contains(ph)){
			e.setCancelled(true);
		}else if(Var.Rot.contains(pwh) && Var.Rot.contains(ph)){
			e.setCancelled(true);
		}
		
		
		
	}

}
