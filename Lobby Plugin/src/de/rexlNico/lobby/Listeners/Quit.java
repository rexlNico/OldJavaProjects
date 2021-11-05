package de.rexlNico.lobby.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Quit implements Listener{

	@EventHandler
	public void on(PlayerQuitEvent e){
		e.setQuitMessage(null);
	}
	
}
