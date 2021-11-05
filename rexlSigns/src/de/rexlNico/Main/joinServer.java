package de.rexlNico.Main;

import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class joinServer implements Listener{

	@EventHandler
	public void on(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			if(e.getClickedBlock().getLocation().getBlock().getState() instanceof Sign){
				SignApi.joinModi(p, e.getClickedBlock().getLocation());
			}
		}
	}
	
}
