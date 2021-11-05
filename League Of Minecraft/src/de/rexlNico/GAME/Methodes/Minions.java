package de.rexlNico.GAME.Methodes;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;

import de.rexlNico.GAME.Main.Main;

public class Minions {
	
	private static int TaskID;
	private static int sec = 30;
	
	public static void SpawnMinions(){
		
		Location minionrot1 = MinionFactory.getConfigLocation(Var.Map+".Minion.1.rot", Var.cfg);
		Location minionblau1 = MinionFactory.getConfigLocation(Var.Map+".Minion.1.blau", Var.cfg);
		
		TaskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
			
			
			
			@Override
			public void run() {
				if(sec > 30 || sec <= 36){
					
				 
					ItemStack itemb = new ItemStack(Material.WOOL, 1, (short)11);
					
					Zombie zombieblau = (Zombie) minionblau1.getWorld().spawnEntity(minionblau1, EntityType.ZOMBIE);
					zombieblau.setCustomName("§1Minion");
					zombieblau.setCustomNameVisible(true);
					zombieblau.setBaby(true);
					zombieblau.getEquipment().setHelmet(itemb);
					zombieblau.setCanPickupItems(false);
					zombieblau.setRemoveWhenFarAway(false);
					
					
					ItemStack itemr = new ItemStack(Material.WOOL, 1, (short)14);
					
					Zombie zombierot = (Zombie) minionblau1.getWorld().spawnEntity(minionrot1, EntityType.ZOMBIE);
					zombierot.setCustomName("§4Minion");
					zombierot.setCustomNameVisible(true);
					zombierot.setBaby(true);
					zombierot.getEquipment().setHelmet(itemr);
					zombierot.setCanPickupItems(false);
					zombierot.setRemoveWhenFarAway(false);
					
				}
				
				if(sec > 36){
					sec = 0;
				}
				
				sec++;
				
			}
		}, 0, 20*1);
		
		
	}
	
}
