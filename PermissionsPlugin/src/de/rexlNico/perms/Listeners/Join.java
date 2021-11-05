package de.rexlNico.perms.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.rexlNico.perms.Methodes.PermsAPI;

public class Join implements Listener{

	@EventHandler
	public void on(PlayerJoinEvent e){
		e.setJoinMessage(null);
		PermsAPI.addToPermList(e.getPlayer());
		PermsAPI.setPerm(e.getPlayer());
	}
	
}
