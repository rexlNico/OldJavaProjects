package de.buugie15.Main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.buugie15.Commands.Broadcast;
import de.buugie15.Commands.ClearChat;
import de.buugie15.Commands.Enderchest;
import de.buugie15.Commands.Fly;
import de.buugie15.Commands.Gamemode;
import de.buugie15.Commands.Msg;
import de.buugie15.Commands.heal;
import de.buugie15.Commands.vanish;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("######################");
		Bukkit.getConsoleSender().sendMessage("#      SkyPvP System                    #");
		Bukkit.getConsoleSender().sendMessage("#  §awurde aktiviert.                       #");
		Bukkit.getConsoleSender().sendMessage("######################");
	
		getCommand("heal").setExecutor(new heal());
		getCommand("enderchest").setExecutor(new Enderchest());
		getCommand("gm").setExecutor(new Gamemode());
		getCommand("msg").setExecutor(new Msg());
		getCommand("broadcast").setExecutor(new Broadcast());
		getCommand("chatclear").setExecutor(new ClearChat());
		getCommand("fly").setExecutor(new Fly());
		getCommand("vanish").setExecutor(new vanish());
	
	}
}
