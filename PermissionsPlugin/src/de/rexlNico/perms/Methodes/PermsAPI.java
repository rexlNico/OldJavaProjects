package de.rexlNico.perms.Methodes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.xml.bind.attachment.AttachmentMarshaller;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

import de.rexlNico.perms.Main.Main;

public class PermsAPI {
	
	public static HashMap<Player, String> group = new HashMap<>();
	public static HashMap<Player, PermissionAttachment> att = new HashMap<>();
	public static ArrayList<Player> inGroup = new ArrayList<>();
	
	public static void addToPermList(Player p){
		inGroup.add(p);
		group.put(p, getGroupFormConfig(p));
	}
	public static String getGroupFormConfig(Player p){
		File file = new File("plugins/Permplugin/config.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		if(cfg.getString(p.getUniqueId().toString()+".group") == null){
			cfg.set(p.getUniqueId().toString()+".group", Groups.spieler);
			try {
				cfg.save(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return cfg.getString(p.getUniqueId().toString()+".group");
	}
	
	public static void updateList(){
		group.clear();
		inGroup.clear();
		for(Player a : Bukkit.getOnlinePlayers()){
			inGroup.add(a);
			group.put(a, getGroupFormConfig(a));
		}
	}
	public static boolean isAGroup(String group){
		if(group.equalsIgnoreCase(Groups.admin) 
				|| group.equalsIgnoreCase(Groups.admin)
				|| group.equalsIgnoreCase(Groups.dev)
				|| group.equalsIgnoreCase(Groups.builder)
				|| group.equalsIgnoreCase(Groups.mod)
				|| group.equalsIgnoreCase(Groups.supp)
				|| group.equalsIgnoreCase(Groups.youtuber)
				|| group.equalsIgnoreCase(Groups.premium)
				|| group.equalsIgnoreCase(Groups.spieler)) return true;
		
		
		return false;
	}
	public static void setGroup(Player p, String group){
		File file = new File("plugins/Permplugin/config.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if(inGroup.contains(p)){
			PermsAPI.group.remove(p);
			PermsAPI.group.put(p, group);
			cfg.set(p.getUniqueId().toString(), group);
			try {
				cfg.save(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			PermsAPI.group.put(p, group);
			inGroup.add(p);
			cfg.set(p.getUniqueId().toString(), group);
			try {
				cfg.save(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static String getGroup(Player p){
		if(!inGroup.contains(p)) return getGroupFormConfig(p);
		return group.get(p);
	}
	public static List<String> getGroupPerm(String group){
		File file = new File("plugins/Permplugin/permissions.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if(!isAGroup(group)) return null;
		List<String> p = cfg.getStringList(group+".perms");
		return p;
	}
	public static void setPerm(Player p){
		List<String> perm = getGroupPerm(getGroup(p));
		PermissionAttachment at = p.addAttachment(Main.getPlugin());
		for(int i = 0; i<perm.size(); i++){
			at.setPermission(perm.get(i), true);
		}
		att.put(p, at);
	}
	public static void removePerm(Player p){
		List<String> perm = getGroupPerm(getGroup(p));
		PermissionAttachment at = att.get(p);
		for(int i = 0; i<perm.size(); i++){
			at.setPermission(perm.get(i), false);
		}
		att.remove(p);
	}
}
