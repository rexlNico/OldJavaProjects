package de.rexlUnity.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.rexlUnity.Methodes.Factory;
import de.rexlUnity.Methodes.Var;

public class Join implements Listener{

	@EventHandler
	public void on(PlayerJoinEvent e){
		Player p = e.getPlayer();
		p.teleport(Factory.getConfigLocation("Spawn", Var.Fcfg));
	}
	
}
