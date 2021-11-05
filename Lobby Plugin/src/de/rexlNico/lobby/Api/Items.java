package de.rexlNico.lobby.Api;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import de.rexlNico.lobby.Addons.AddonManager;

public class Items {

	public static void giveItems(Player p){
		
		p.getInventory().setItem(0, new ItemBuilder(Material.COMPASS, 1).setName("§bTeleporter").build());
		p.getInventory().setItem(8, new ItemBuilder(Material.NETHER_STAR, 1).setName("§eLobby switcher").build());
		p.getInventory().setItem(2, new ItemBuilder(Material.BLAZE_ROD, 1).setName("§6Player Hider").build());
		
		if(p.hasPermission(Var.perms+"youtuber")){
			
			p.getInventory().setItem(3, new ItemBuilder(Material.TNT, 1).setName("§4S-Hub").build());
			if(AddonManager.isAddonLoadet("NickAddon")){
				p.getInventory().setItem(5, new ItemBuilder(Material.NAME_TAG, 1).setName("§5Autonick").build());
			}
			
		}
		
		if(AddonManager.isAddonLoadet("StatsAddon")){
			p.getInventory().setItem(6, new ItemBuilder(Material.CHEST, 1).setName("§3Stats").build());
		}
	}
	
}
