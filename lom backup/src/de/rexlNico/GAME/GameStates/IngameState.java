package de.rexlNico.GAME.GameStates;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.rexlNico.GAME.Main.Main;
import de.rexlNico.GAME.Methodes.BlockFactory;
import de.rexlNico.GAME.Methodes.Factory;
import de.rexlNico.GAME.Methodes.SetItems;
import de.rexlNico.GAME.Methodes.Var;

public class IngameState extends GameState{

	public static File file = new File("plugins/LOM/spawns.txt");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	private int TaskID;
	
	@Override
	public void init() {
		setTeam();
		TeleportTeam(null);
		startTimer();
		
		
		
		
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}
	
	private void setTeam(){
		for(Player a : Var.noTeam){
			if(Var.Blau.size() < Var.MAX_PLAYERS_PER_TEAM){
				Var.noTeam.remove(a);
				Var.Blau.add(a);
			}else if(Var.Rot.size() < Var.MAX_PLAYERS_PER_TEAM){
				Var.noTeam.remove(a);
				Var.Rot.add(a);
			}else{
				a.kickPlayer("§4Alle Teams sind voll. \\n §aBitte warte bis eine neue Runde begint");
			}
		}
	}
	public static void TeleportTeam(Player p){
		
		if(p != null){
			if(Var.Blau.contains(p)){
				p.teleport(Factory.getConfigLocation(Var.Map+".blau", cfg));	
			}
			if(Var.Rot.contains(p)){
				p.teleport(Factory.getConfigLocation(Var.Map+".rot", cfg));	
			}
			
		}else{
		
			for(Player a : Var.Blau){
				a.teleport(Factory.getConfigLocation(Var.Map+".blau", cfg));
			
			}
			for(Player a : Var.Rot){
				a.teleport(Factory.getConfigLocation(Var.Map+".rot", cfg));
			}
		
			for(Player a : Var.playing){
				a.getInventory().clear();
				SetItems.setBackport(a);
				SetItems.setChampItems(a);
			}
		}
		
	}
	
	private void startTimer(){
		TaskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
			
			
			@Override
			public void run() {
				
				Location locr = BlockFactory.getConfigLocation(Var.Map+".rot.nexus", Var.cfg);
				Location locb = BlockFactory.getConfigLocation(Var.Map+".blau.nexus", Var.cfg);
				
				if(Bukkit.getWorld(locr.getWorld().toString()).getBlockAt(locr).getType() != Material.DIAMOND_BLOCK){
					Bukkit.broadcastMessage(Var.pr+"§bDas Team §1Blau §bhat gewonnen");
					for(Player a : Var.Blau){
						a.sendTitle("§aGewonnen", "");
					}
					for(Player a : Var.Rot){
						a.sendTitle("§cVerloren", "");
					}
					
					GameStateHandler.setGameState(GameState.END_STATE);
				}
				if(Bukkit.getWorld(locb.getWorld().toString()).getBlockAt(locb).getType() != Material.DIAMOND_BLOCK){
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
		}, 0, 20*1);
	}
	
	
}
