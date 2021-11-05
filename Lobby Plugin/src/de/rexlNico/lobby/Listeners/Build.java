package de.rexlNico.lobby.Listeners;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class Build implements Listener{

	@EventHandler
	public void on(BlockPlaceEvent e){
		Player p = e.getPlayer();
		if(!p.getGameMode().equals(GameMode.CREATIVE)){
			e.setCancelled(true);
		}
	}
	@EventHandler
	public void on(BlockBreakEvent e){
		Player p = e.getPlayer();
		if(!p.getGameMode().equals(GameMode.CREATIVE)){
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void on(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			if(e.getClickedBlock().getType().equals(Material.WOODEN_DOOR)
					||e.getClickedBlock().getType().equals(Material.DARK_OAK_DOOR)
					||e.getClickedBlock().getType().equals(Material.SPRUCE_DOOR)
					||e.getClickedBlock().getType().equals(Material.BIRCH_DOOR)
					||e.getClickedBlock().getType().equals(Material.ACACIA_DOOR)
					||e.getClickedBlock().getType().equals(Material.LEVER)
					||e.getClickedBlock().getType().equals(Material.STONE_BUTTON)
					||e.getClickedBlock().getType().equals(Material.WOOD_BUTTON)
					||e.getClickedBlock().getType().equals(Material.TRAP_DOOR)
					||e.getClickedBlock().getType().equals(Material.CHEST)
					||e.getClickedBlock().getType().equals(Material.ENDER_CHEST)
					||e.getClickedBlock().getType().equals(Material.TRAPPED_CHEST)
					||e.getClickedBlock().getType().equals(Material.REDSTONE_COMPARATOR)
					||e.getClickedBlock().getType().equals(Material.ANVIL)
					||e.getClickedBlock().getType().equals(Material.ARMOR_STAND)){
				if(!p.getGameMode().equals(GameMode.CREATIVE)){
					e.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
	public void on(PlayerArmorStandManipulateEvent e){
		if(!e.getPlayer().getGameMode().equals(GameMode.CREATIVE)){
			e.setCancelled(true);
		}
	}
	@EventHandler
	public void on(EntityDamageByEntityEvent e){
		if(e.getEntity() instanceof ArmorStand){
			Player p = (Player) e.getDamager();
			if(!p.getGameMode().equals(GameMode.CREATIVE)){
				e.setCancelled(true);
			}
		}else{
			e.setCancelled(true);
		}
	}
	
}
