package de.rexlNico.perms.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import de.rexlNico.perms.Methodes.PermsAPI;

public class Quit implements Listener{

	@EventHandler
	public void on(PlayerQuitEvent e){
		e.setQuitMessage(null);
		PermsAPI.removePerm(e.getPlayer());
	}
	
}
