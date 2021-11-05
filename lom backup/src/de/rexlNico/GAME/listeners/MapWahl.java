package de.rexlNico.GAME.listeners;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
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

import de.rexlNico.GAME.Methodes.Var;

public class MapWahl implements Listener{

	@EventHandler
	public void on(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(e.getAction().equals(Action.LEFT_CLICK_AIR) ||
				e.getAction().equals(Action.RIGHT_CLICK_AIR) ||
				e.getAction().equals(Action.LEFT_CLICK_BLOCK) ||
				e.getAction().equals(Action.RIGHT_CLICK_BLOCK) ){
			
			if(p.getItemInHand().getType().equals(Material.PAPER)){
				if(p.getItemInHand().getItemMeta().getDisplayName().equals("§bMap Wahl")){
					UpdateInventorry(p);
					p.playSound(p.getLocation(), Sound.CHEST_CLOSE, 1, 1);
					
				}
			}
			
		}
	}
	
	@EventHandler
	public void on(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getName().equals("§bMap Wahl")){
			e.setCancelled(true);
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§aKluft der Beschwörer")){
				if(Var.noMap.contains(p)){
					Var.noMap.remove(p);
					Var.kluft.add(p);
					p.sendMessage(Var.pr+"Du hast für §aKluft der Beschwörer§7 abgestimmt.");
					
					p.getItemInHand().getDurability();
					
					UpdateInventorry(p);
				}else{
					p.sendMessage(Var.pr+"§cDu hast bereits für eine Map abgestimmt.");
				}
			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§5Aram")){
				if(Var.noMap.contains(p)){
					Var.noMap.remove(p);
					Var.aram.add(p);
					p.sendMessage(Var.pr+"Du hast für §5Aram §7abgestimmt.");
					UpdateInventorry(p);
				}else{
					p.sendMessage(Var.pr+"§cDu hast bereits für eine Map abgestimmt.");
				}
			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§eGewundener Wald")){
				if(Var.noMap.contains(p)){
					Var.noMap.remove(p);
					Var.wald.add(p);
					p.sendMessage(Var.pr+"Du hast für §eGewundener Wald §7abgestimmt.");
					UpdateInventorry(p);
				}else{
					p.sendMessage(Var.pr+"§cDu hast bereits für eine Map abgestimmt.");
				}
			}	
		}
	}
	
	public static void setItem(Inventory inv, int i, Material item, String name, int flo, ArrayList<Player> mapwahl){
		
		if(mapwahl != null){
		
		ArrayList<String> lore1 = new ArrayList<>();	
		lore1.add("§cVotes§8 ➤ §6"+mapwahl.size());
		
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
		Inventory inv = Bukkit.createInventory(null, InventoryType.HOPPER, "§bMap Wahl");
		
		setItem(inv, 1, Material.STAINED_GLASS_PANE, "", 15, null);
		setItem(inv, 3, Material.STAINED_GLASS_PANE, "", 15, null);
		setItem(inv, 0, Material.STAINED_GLASS_PANE, "§aKluft der Beschwörer", 5, Var.kluft);
		setItem(inv, 2, Material.STAINED_GLASS_PANE, "§5Aram", 6, Var.aram);
		setItem(inv, 4, Material.STAINED_GLASS_PANE, "§eGewundener Wald", 4, Var.wald);
		
		p.openInventory(inv);
	}
	
}
