package de.rexlNico.GAME.Methodes;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import de.rexlNico.GAME.GameStates.GameState;
import de.rexlNico.GAME.GameStates.GameStateHandler;

public class setTower {

	
	
	public static void setNexus(Location loc){
		
		loc.getWorld().getBlockAt(loc).setType(Material.EMERALD_BLOCK);
		
		loc.setY(loc.getY()+1);
		
		Location as = loc;

		//fehlerhaft von hier
		
		ArmorStand arm = (ArmorStand) Bukkit.getWorld(as.getWorld().toString()).spawnEntity(as, EntityType.ARMOR_STAND);
		
		//bis hier
		
		arm.setCustomName("§a1200");
		arm.setCustomNameVisible(true);
		arm.setBasePlate(false);
		arm.setRemoveWhenFarAway(false);
		arm.setSmall(true);
		arm.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 999999));
		arm.setFallDistance(0);
		
	}
	
	public static void damageNexus(Location loc, int damage){
		loc.setY(loc.getY());
		
		Location locr = BlockFactory.getConfigLocation(Var.Map+".rot.nexus", Var.cfg);
		Location locb = BlockFactory.getConfigLocation(Var.Map+".blau.nexus", Var.cfg);
		
		Location as = loc;
		World world = as.getWorld();
		
		
		ArmorStand arm = null;
		
		List<Entity> entities = world.getEntities();
		for(Entity items : entities){
			if(items instanceof ArmorStand){
				if(items.getLocation() == as){
					arm = (ArmorStand) items;
					
					String leben = arm.getCustomName().replaceAll("§a", "").replaceAll("&a", "");
					
					int i = Integer.parseInt(leben);
					
					int all = i-damage;
					
					if(all >= 1){
					
						arm.setCustomName("§a"+all);
						arm.setCustomNameVisible(true);
						arm.setBasePlate(false);
						arm.setRemoveWhenFarAway(false);
						arm.setSmall(true);
						arm.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 999999));
						arm.setFallDistance(0);
					
					}else{
						
						arm.remove();
						as.setY(as.getY()-1);
						
						as.getBlock().setType(Material.AIR);
						if(as == locr){
							
							Bukkit.broadcastMessage(Var.pr+"§bDas Team §1Blau §bhat gewonnen");
							for(Player a : Var.Blau){
								a.sendTitle("§aGewonnen", "");
							}
							for(Player a : Var.Rot){
								a.sendTitle("§cVerloren", "");
							}
							
							GameStateHandler.setGameState(GameState.END_STATE);
							
						}else if(as == locb){
							
							Bukkit.broadcastMessage(Var.pr+"§bDas Team §4Rot §bhat gewonnen");
							for(Player a : Var.Rot){
								a.sendTitle("§aGewonnen", "");
								
								
							}
							for(Player a : Var.Blau){
								a.sendTitle("§cVerloren", "");
							}
							
							GameStateHandler.setGameState(GameState.END_STATE);
							
						}
						
						
					}
				}
			}
		}
	}
}
