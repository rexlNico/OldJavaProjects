package de.rexlNico.lobby.Listeners;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;

import de.rexlNico.lobby.Api.ItemBuilder;
import de.rexlNico.lobby.Api.Var;

public class PlayerHider implements Listener{

	public static ArrayList<Player> noPlayer = new ArrayList<>();
	public static ArrayList<Player> onlyPremium = new ArrayList<>();
	@EventHandler
	public void on(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			if(p.getItemInHand().getType().equals(Material.BLAZE_ROD) && (p.getItemInHand().getItemMeta().getDisplayName().equals("§6Player Hider"))){
				Inventory inv = Bukkit.createInventory(null, 9, "§6Player Hider");
				for(int i = 0; i<9; i++){
					inv.setItem(i, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 15).build());
				}
				if(noPlayer.contains(p)){
					inv.setItem(2, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 15).setName("§aAlle anzeigen").build());
					inv.setItem(4, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 10).setName("§5Team anzeigen").build());
					inv.setItem(6, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 14).enchant(Enchantment.ARROW_DAMAGE, 1).addFlags(ItemFlag.HIDE_ENCHANTS).setName("§4Keinen anzeigen").build());
				}else if(onlyPremium.contains(p)){
					inv.setItem(2, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 5).setName("§aAlle anzeigen").build());
					inv.setItem(4, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 10).enchant(Enchantment.ARROW_DAMAGE, 1).addFlags(ItemFlag.HIDE_ENCHANTS).setName("§aAlle anzeigen").build());
					inv.setItem(6, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 14).setName("§4Keinen anzeigen").build());
				}else{
					inv.setItem(2, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 5).enchant(Enchantment.ARROW_DAMAGE, 1).addFlags(ItemFlag.HIDE_ENCHANTS).setName("§aAlle anzeigen").build());
					inv.setItem(4, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 10).setName("§5Team anzeigen").build());
					inv.setItem(6, new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 14).setName("§4Keinen anzeigen").build());
				}
				p.openInventory(inv);
			}
		}
	}

	@EventHandler
	public void on(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getName().equals("§6Player Hider")){
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§aAlle anzeigen")){
				for(Player a:Bukkit.getOnlinePlayers()){
					p.showPlayer(a);
				}
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
				p.closeInventory();
				if(noPlayer.contains(p)){
					noPlayer.remove(p);
				}
				if(onlyPremium.contains(p)){
					onlyPremium.remove(p);
				}
			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Keinen anzeigen")){
				for(Player a:Bukkit.getOnlinePlayers()){
						p.hidePlayer(a);
				}
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
				p.closeInventory();
				if(!noPlayer.contains(p)){
					noPlayer.add(p);
				}
				if(onlyPremium.contains(p)){
					onlyPremium.remove(p);
				}
			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§5Team anzeigen")){
				for(Player a:Bukkit.getOnlinePlayers()){
					if(!a.hasPermission(Var.perms+"team")){
						p.hidePlayer(a);
					}
				}
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
				p.closeInventory();
				if(noPlayer.contains(p)){
					noPlayer.remove(p);
				}
				if(!onlyPremium.contains(p)){
					onlyPremium.add(p);
				}
			}
			
		}
	}
	
}
