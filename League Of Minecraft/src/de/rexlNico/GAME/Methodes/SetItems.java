package de.rexlNico.GAME.Methodes;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Campions.KitManager;

public class SetItems {

	public static void setBackAndCham(Player p){
		setBackport(p);
		setChampItems(p);
	}
	
	public static void setBackport(Player p){
		ItemStack item = new ItemStack(Material.BLAZE_POWDER);
		ItemMeta im = item.getItemMeta();
		im.setDisplayName("§9Backport");
		item.setItemMeta(im);
		p.getInventory().setItem(8, item);
		
	}
	public static void setChampItems(Player p){
		for(int i = 0; i < KitManager.getPlayerKit(p).getStartItems().size(); i++){
			p.getInventory().setItem(i, KitManager.getPlayerKit(p).getStartItems().get(i));
		}
	}
	
}
