package de.rexlNico.GAME.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import de.rexlNico.GAME.Methodes.BlockFactory;
import de.rexlNico.GAME.Methodes.setTower;

public class NexusUndTowerDammage implements Listener{

	@EventHandler
	public void on(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(e.getAction() == Action.LEFT_CLICK_BLOCK){
			if(p.getItemInHand().getType().equals(Material.DIAMOND_SWORD)){
				setTower.damageNexus(e.getClickedBlock().getLocation(), 7);
			}else if(p.getItemInHand().getType().equals(Material.IRON_SWORD)){
				setTower.damageNexus(e.getClickedBlock().getLocation(), 6);
			}else if(p.getItemInHand().getType().equals(Material.GOLD_SWORD)){
				setTower.damageNexus(e.getClickedBlock().getLocation(), 4);
			}else if(p.getItemInHand().getType().equals(Material.STONE_SWORD)){
				setTower.damageNexus(e.getClickedBlock().getLocation(), 5);
			}else if(p.getItemInHand().getType().equals(Material.WOOD_SWORD)){
				setTower.damageNexus(e.getClickedBlock().getLocation(), 4);
			}
		}
		
	}
	
}
