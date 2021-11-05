package de.rexlNico.lobby.Listeners;

import java.io.IOException;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.rexlNico.lobby.Api.Items;
import de.rexlNico.lobby.Api.Var;

public class Join implements Listener{

	
	@EventHandler
	public void on(PlayerJoinEvent e){
		Player p = e.getPlayer();
		e.setJoinMessage(null);
		Items.giveItems(p);
		List<String> list = Var.pcfg.getStringList("PlayerList");
		if(list.contains(p.getUniqueId().toString())){
			if(!Var.pcfg.getString(p.getUniqueId().toString()).equals(p.getName())){
				Var.pcfg.set(p.getUniqueId().toString(), p.getName());
				try {
					Var.pcfg.save(Var.pfile);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}else{
			list.add(p.getUniqueId().toString());
			Var.pcfg.set("PlayerList", list);
			Var.pcfg.set(p.getUniqueId().toString(), p.getName());
			try {
				Var.pcfg.save(Var.pfile);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		for(Player a : SHub.inShub){
			a.hidePlayer(p);
		}
		
		
	}
	
}
