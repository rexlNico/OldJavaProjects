package de.rexlNico.GAME.listeners;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.rexlNico.GAME.GameStates.GameStateHandler;
import de.rexlNico.GAME.GameStates.LobbyState;
import de.rexlNico.GAME.Methodes.Factory;
import de.rexlNico.GAME.Methodes.Var;

public class Join implements Listener{

	private File file = new File("plugins/LOM/spawns.txt");
	private YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	@SuppressWarnings("static-access")
	@EventHandler
	public void on(PlayerJoinEvent e){
		Player p = e.getPlayer();
		e.setJoinMessage(null);
		if(GameStateHandler.getGamestate() instanceof LobbyState){
			p.teleport(Factory.getConfigLocation("Lobby", cfg));
			
			ItemStack i1 = new ItemStack(Material.PAPER);
			ItemMeta im1 = i1.getItemMeta();
			im1.setDisplayName("§bMap Wahl");
			i1.setItemMeta(im1);
			
			ItemStack i2 = new ItemStack(Material.CHEST);
			ItemMeta im2 = i2.getItemMeta();
			im2.setDisplayName("§bChampion Wahl");
			i2.setItemMeta(im2);
			
			ItemStack i3 = new ItemStack(Material.BED);
			ItemMeta im3 = i3.getItemMeta();
			im3.setDisplayName("§bTeam Wahl");
			i3.setItemMeta(im3);
			
			
			
			LobbyState ls = (LobbyState) GameStateHandler.getGamestate();
			Var.playing.add(p);
			Var.noMap.add(p);
			
			Bukkit.broadcastMessage(Var.pr+"Der Spieler §a"+p.getDisplayName()+"§7 ist dem Spiel beigetreten. §r §8[§c"+Var.playing.size()+"§8/§c"+LobbyState.MAX_PLAYERS+"§8]");
			p.setLevel(0);
			p.getInventory().clear();
			p.getInventory().setItem(4, i1);
			p.getInventory().setItem(6, i2);
			p.getInventory().setItem(2, i3);
			
			
			if(Var.playing.size() >= LobbyState.MIN_PLAYERS){
				if(ls.getCountdown().isRunning == false){
					ls.getCountdown().stopIdle();
					ls.getCountdown().start();
				}
			}
			if(Var.playing.size() < LobbyState.MIN_PLAYERS){
				if(ls.getCountdown().isIdelind == false){
					ls.getCountdown().idle();
				}
			}
		}
	}
	
}
