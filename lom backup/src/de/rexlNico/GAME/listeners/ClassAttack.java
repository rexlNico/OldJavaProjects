package de.rexlNico.GAME.listeners;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import de.rexlNico.GAME.GameStates.IngameState;
import de.rexlNico.GAME.Main.Main;
import de.rexlNico.GAME.Methodes.SetItems;

public class ClassAttack implements Listener{

	ArrayList<Player> Gold = new ArrayList<>();
	ArrayList<Player> backport = new ArrayList<>();
	
	@EventHandler
	public void on(PlayerInteractEvent e){
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			Player p = e.getPlayer();
			if(p.getItemInHand().getType().equals(Material.GOLD_INGOT)){
				p.getInventory().clear(0);
				Gold.add(p);
				
				
				
				
			}else if(p.getItemInHand().getType().equals(Material.BLAZE_POWDER)){
				p.getInventory().clear(8);
				backport.add(p);
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
					
					@Override
					public void run() {
						if(backport.contains(p)){
							IngameState.TeleportTeam(p);
							SetItems.setBackport(p);
						}
					}
				}, 20*5);
				
			}
		}
	}
	
	@EventHandler
	public void on(PlayerMoveEvent e){
		Player p = e.getPlayer();
		if(backport.contains(p)){
			backport.remove(p);
			SetItems.setBackport(p);
		}
	}
	
}
