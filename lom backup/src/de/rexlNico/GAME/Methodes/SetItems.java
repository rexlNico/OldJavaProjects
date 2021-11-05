package de.rexlNico.GAME.Methodes;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Campions.KitManager;

public class SetItems {

	public static void setBackport(Player p){
		ItemStack item = new ItemStack(Material.BLAZE_POWDER);
		ItemMeta im = item.getItemMeta();
		im.setDisplayName("§9Backport");
		item.setItemMeta(im);
		p.getInventory().setItem(8, item);
		
	}
	public static void setChampItems(Player p){
		p.getInventory().setItem(0, KitManager.getPlayerKit(p).getStartItems().get(0));
		p.getInventory().setItem(1, KitManager.getPlayerKit(p).getStartItems().get(1));
		p.getInventory().setItem(2, KitManager.getPlayerKit(p).getStartItems().get(2));
		p.getInventory().setItem(3, KitManager.getPlayerKit(p).getStartItems().get(3));
	}
	
}
