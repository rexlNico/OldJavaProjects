package de.rexlNico.perms.Main;

import java.io.File;
import java.io.IOException;
import java.security.acl.Group;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.yaml.snakeyaml.Yaml;

import de.rexlNico.perms.Commands.Command;
import de.rexlNico.perms.Listeners.Chat;
import de.rexlNico.perms.Listeners.Join;
import de.rexlNico.perms.Listeners.Quit;
import de.rexlNico.perms.Methodes.Groups;
import de.rexlNico.perms.Methodes.PermsAPI;

public class Main extends JavaPlugin{
	public static Main plugin;
	private PluginManager pm = Bukkit.getPluginManager();
	@Override
	public void onEnable(){
		File gfile = new File("plugins/Permplugin/config.yml");
		YamlConfiguration gcfg = YamlConfiguration.loadConfiguration(gfile);
		plugin = this;
		Bukkit.getConsoleSender().sendMessage("§0[§ePermissions§0] §ageladen!");
		init();
		
		
		if(gcfg.get("PluginFirstLoad") == null || gcfg.getBoolean("PluginFirstLoad") == true){
			setConfig();
			
		}
		
	}
	
	@Override
	public void onDisable() {
		for(Player a : Bukkit.getOnlinePlayers()){
			PermsAPI.removePerm(a);
		}
		super.onDisable();
	}
	
	public static Main getPlugin() {
		return plugin;
	}
	public void init(){
		
		pm.registerEvents(new Join(), this);
		pm.registerEvents(new Quit(), this);
		pm.registerEvents(new Chat(), this);
		
		getCommand("perms").setExecutor(new Command());
		
		Groups.toList();
		PermsAPI.updateList();
		for(Player a : Bukkit.getOnlinePlayers()){
			PermsAPI.setPerm(a);
		}
	}
	
	public static void setConfig(){
		Bukkit.getConsoleSender().sendMessage("§4Config gesetzt");
		File gfile = new File("plugins/Permplugin/config.yml");
		File pfile = new File("plugins/Permplugin/permissions.yml");
		YamlConfiguration gcfg = YamlConfiguration.loadConfiguration(gfile);
		YamlConfiguration pcfg = YamlConfiguration.loadConfiguration(pfile);
		
		
			gcfg.set("PluginFirstLoad", false);
			gcfg.set("b960f24d-81fe-47d2-a326-71597df2689b.group", Groups.admin);
			try {
				gcfg.save(gfile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			List<String> perms1 = new ArrayList<>();
			List<String> perms2 = new ArrayList<>();
			List<String> perms3 = new ArrayList<>();
			List<String> perms4 = new ArrayList<>();
			List<String> perms5 = new ArrayList<>();
			List<String> perms6 = new ArrayList<>();
			List<String> perms7 = new ArrayList<>();
			List<String> perms8 = new ArrayList<>();
			perms1.add("group.admin");
			pcfg.set(Groups.admin+".prefig", "&4Admin");
			pcfg.set(Groups.admin+".perms", perms1);
			try {
				pcfg.save(pfile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			perms2.add("group.dev");
			pcfg.set(Groups.dev+".prefig", "&bDev");
			pcfg.set(Groups.dev+".perms", perms2);
			try {
				pcfg.save(pfile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			perms3.add("group.builder");
			pcfg.set(Groups.builder+".prefig", "&9Builder");
			pcfg.set(Groups.builder+".perms", perms3);
			try {
				pcfg.save(pfile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			perms4.add("group.mod");
			pcfg.set(Groups.mod+".prefig", "&1Mod");
			pcfg.set(Groups.mod+".perms", perms4);
			try {
				pcfg.save(pfile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			perms5.add("group.supp");
			pcfg.set(Groups.supp+".prefig", "&2Supp");
			pcfg.set(Groups.supp+".perms", perms5);
			try {
				pcfg.save(pfile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			perms6.add("group.youtuber");
			pcfg.set(Groups.youtuber+".prefig", "&5Youtuber");
			pcfg.set(Groups.youtuber+".perms", perms6);
			
			try {
				pcfg.save(pfile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pcfg.set(Groups.premium+".prefig", "&6Premium");
			perms7.add("group.premium");
			pcfg.set(Groups.premium+".perms", perms7);
			try {
				pcfg.save(pfile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pcfg.set(Groups.spieler+".prefig", "&aSpieler");
			perms8.add("group.spieler");
			pcfg.set(Groups.spieler+".perms", perms8);
			
			try {
				pcfg.save(pfile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	
}
