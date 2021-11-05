package de.rexlNico.GAME.listeners;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.rexlNico.GAME.GameStates.GameStateHandler;
import de.rexlNico.GAME.GameStates.LobbyState;
import de.rexlNico.GAME.Methodes.Var;

public class TeamAuswahl implements Listener{

	@EventHandler
	public void on(PlayerInteractEvent e){
		Player p = e.getPlayer();
		
		if(e.getAction().equals(Action.LEFT_CLICK_AIR) ||
				e.getAction().equals(Action.RIGHT_CLICK_AIR) ||
				e.getAction().equals(Action.LEFT_CLICK_BLOCK) ||
				e.getAction().equals(Action.RIGHT_CLICK_BLOCK) ){
			
			if(p.getItemInHand() != null){
				if(p.getItemInHand().getType().equals(Material.BED)){
					if(GameStateHandler.getGamestate() instanceof LobbyState){
						
						UpdateInventorry(p);
						
					}
				}
			}
		}
	}
	
	@EventHandler
	public void on(InventoryClickEvent e){
		Player p = (Player)e.getWhoClicked();
		if(e.getInventory().getName().equals("§bTeam wahl")){
			e.setCancelled(true);
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Rot")){
				if(Var.Rot.size() < Var.MAX_PLAYERS_PER_TEAM){
					p.setDisplayName("§4"+p.getName());
					p.setPlayerListName("§4"+p.getName());
					if(!Var.Rot.contains(p)){
						Var.Rot.add(p);
						if(Var.Blau.contains(p)){
							Var.Blau.remove(p);
						}
						if(Var.noTeam.contains(p)){
							Var.noTeam.remove(p);
						}
						UpdateInventorry(p);
					}
				}
			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§1Blau")){
				if(Var.Blau.size() < Var.MAX_PLAYERS_PER_TEAM){
					p.setDisplayName("§1"+p.getName());
					p.setPlayerListName("§1"+p.getName());
					if(!Var.Blau.contains(p)){
						Var.Blau.add(p);
						if(Var.Rot.contains(p)){
							Var.Rot.remove(p);
						}
						if(Var.noTeam.contains(p)){
							Var.noTeam.remove(p);
						}
						UpdateInventorry(p);
					}
				}
			}
		}
	}
	
	public static void setItem(Inventory inv, int i, Material item, String name, int flo, ArrayList<Player> mapwahl){
		
		if(mapwahl != null){
		
		ArrayList<String> lore1 = new ArrayList<>();	
		lore1.add(mapwahl.size()+"/5");
		
		ItemStack i1 = new ItemStack(item,1,(short) flo);
		ItemMeta im1 = i1.getItemMeta();
		im1.setDisplayName(name);
		im1.setLore(lore1);
		i1.setItemMeta(im1);
		
		inv.setItem(i, i1);
		}else{
			
			ItemStack i1 = new ItemStack(item,1,(short) flo);
			ItemMeta im1 = i1.getItemMeta();
			im1.setDisplayName(name);
			i1.setItemMeta(im1);
			
			inv.setItem(i, i1);
		}
		
	}
	public static void UpdateInventorry(Player p){
		Inventory inv = Bukkit.createInventory(null, InventoryType.HOPPER, "§bTeam wahl");
		
		setItem(inv, 0, Material.STAINED_GLASS_PANE, "", 15, null);
		setItem(inv, 2, Material.STAINED_GLASS_PANE, "", 15, null);
		setItem(inv, 4, Material.STAINED_GLASS_PANE, "", 15, null);
		setItem(inv, 1, Material.STAINED_GLASS_PANE, "§4Rot", 14, Var.Rot);
		setItem(inv, 3, Material.STAINED_GLASS_PANE, "§1Blau", 11, Var.Blau);
		
		p.openInventory(inv);
	}
	
}
