package de.rexlUnity.Main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.rexlUnity.Commands.SetJumpAndRun;
import de.rexlUnity.Commands.SetYtBox;
import de.rexlUnity.Commands.Setspawn;
import de.rexlUnity.Listeners.Damage;
import de.rexlUnity.Listeners.Join;
import de.rexlUnity.Listeners.JumpAndRunnSigns;
import de.rexlUnity.Listeners.YoutuberBox;

public class Main extends JavaPlugin{

	private static Main plugin;
	
	PluginManager pm = Bukkit.getPluginManager();
	
	@Override
	public void onEnable() {
		plugin = this;
		Bukkit.getConsoleSender().sendMessage("§cDie §eRexlUnity §cist nun §aaktiv");
		
		
		
		pm.registerEvents(new JumpAndRunnSigns(), this);
		pm.registerEvents(new Join(), this);
		pm.registerEvents(new Damage(), this);
		pm.registerEvents(new YoutuberBox(), this);
		
		getCommand("setJump").setExecutor(new SetJumpAndRun());
		getCommand("spawn").setExecutor(new Setspawn());
		getCommand("setspawn").setExecutor(new Setspawn());
		getCommand("setYTBox").setExecutor(new SetYtBox());
		
	}
	
	public static Main getPlugin() {
		return plugin;
	}

	
}
