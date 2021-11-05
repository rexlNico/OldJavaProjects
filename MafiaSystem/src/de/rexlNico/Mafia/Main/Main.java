package de.rexlNico.Mafia.Main;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.google.common.reflect.ClassPath;

import de.rexlNico.Mafia.Commands.CommandP;
import de.rexlNico.Mafia.Listeners.Join;
import de.rexlNico.Mafia.managers.MafiaManager;

public class Main extends JavaPlugin{

	private static Main instance;
	private MafiaManager mafiaManager;
	PluginManager pm;
	
	@Override
	public void onEnable() {
		instance = this;
		mafiaManager = new MafiaManager();
		pm = Bukkit.getPluginManager();
		
		System.out.println(" ");
		System.out.println(" CraftAttack5-Mafia loading...");
		System.out.println(" ");
		
		pm.registerEvents(new Join(), this);
		getCommand("mafia").setExecutor(new CommandP());
		
		System.out.println(" ");
		System.out.println(" CraftAttack5-Mafia enabled...");
		System.out.println(" ");
	}
	
	public MafiaManager getMafiaManager() {
		return mafiaManager;
	}
	
	public static Main getInstance() {
		return instance;
	}
	
}
