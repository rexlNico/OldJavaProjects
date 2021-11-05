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
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;

import de.rexlNico.lobby.Api.ItemBuilder;

public class SHub implements Listener{

	public static ArrayList<Player> inShub = new ArrayList<>();
	@EventHandler
	public void on(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			if(p.getItemInHand().getType().equals(Material.TNT) && p.getItemInHand().getItemMeta().getDisplayName().equals("§4S-Hub")){
				if(inShub.contains(p)){
					inShub.remove(p);
					for(Player a : Bukkit.getOnlinePlayers()){
						p.showPlayer(a);
					}
					p.getInventory().setItem(3, new ItemBuilder(Material.TNT, 1).setName("§4S-Hub").build());
					p.playSound(p.getLocation(), Sound.GHAST_FIREBALL, 1, 1);
				}else{
					inShub.add(p);
					for(Player a : Bukkit.getOnlinePlayers()){
						p.hidePlayer(a);
					}
					p.getInventory().setItem(3, new ItemBuilder(Material.TNT, 1).enchant(Enchantment.ARROW_DAMAGE, 1).addFlags(ItemFlag.HIDE_ENCHANTS).setName("§4S-Hub").build());
					p.playSound(p.getLocation(), Sound.GHAST_FIREBALL, 1, 1);
				}
			}
		}
	}
	
}
