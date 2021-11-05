package de.rexlNico.GAME.Main;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import Campions.KitManager;
import de.rexlNico.GAME.Commands.Start;
import de.rexlNico.GAME.Commands.setBlocks;
import de.rexlNico.GAME.Commands.setMinionSpawn;
import de.rexlNico.GAME.Commands.setSpawn;
import de.rexlNico.GAME.GameStates.GameState;
import de.rexlNico.GAME.GameStates.GameStateHandler;
import de.rexlNico.GAME.listeners.ClassAttack;
import de.rexlNico.GAME.listeners.DeathListener;
import de.rexlNico.GAME.listeners.Join;
import de.rexlNico.GAME.listeners.MapWahl;
import de.rexlNico.GAME.listeners.NexusUndTowerDammage;
import de.rexlNico.GAME.listeners.Quit;
import de.rexlNico.GAME.listeners.TeamAuswahl;
import de.rexlNico.GAME.listeners.build;

public class Main extends JavaPlugin{

	private static Main plugin;
	private PluginManager pm = Bukkit.getPluginManager();
	private KitManager kman;
	
	
	@Override
	public void onEnable() {
		plugin = this;	
		Bukkit.getConsoleSender().sendMessage("###############");
		Bukkit.getConsoleSender().sendMessage("§eLoM §aGeladen");
		Bukkit.getConsoleSender().sendMessage("###############");
		Load();
		new GameStateHandler();
		kman = new KitManager();
		GameStateHandler.setGameState(GameState.LOBBY_STATE);
	}
	public static Main getPlugin() {
		return plugin;
	}
	
	private void Load(){
		//Commands
		RegCommand("start", new Start());
		RegCommand("setspawn", new setSpawn());
		RegCommand("setblock", new setBlocks());
		RegCommand("setminion", new setMinionSpawn());
		//Listeners
		pm.registerEvents(new Join(), this);
		pm.registerEvents(new Quit(), this);
		pm.registerEvents(new MapWahl(), this);
		pm.registerEvents(new TeamAuswahl(), this);
		pm.registerEvents(new build(), this);
		pm.registerEvents(new KitManager(), this);
		pm.registerEvents(new ClassAttack(), this);
		pm.registerEvents(new DeathListener(), this);
		pm.registerEvents(new NexusUndTowerDammage(), this);
	}
	
	private void RegCommand(String name,CommandExecutor exe){
		getCommand(name).setExecutor(exe);
	}
	
	public KitManager getKitMnager(){
		return this.kman;
		
	}
	
}
