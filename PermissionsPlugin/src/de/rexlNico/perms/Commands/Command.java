package de.rexlNico.perms.Commands;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.rexlNico.perms.Methodes.Groups;
import de.rexlNico.perms.Methodes.PermsAPI;

public class Command implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender s, org.bukkit.command.Command cmd, String lable, String[] args) {
		File file = new File("plugins/Permplugin/permissions.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if(s instanceof Player){
		}else{
			if(args.length == 3){
				if(args[0].equalsIgnoreCase("add")){
						if(PermsAPI.isAGroup(args[1])){
							List<String> perm = cfg.getStringList(args[1].toLowerCase()+".perms");
							cfg.set(args[1].toLowerCase()+".perms", perm);
							try {
								cfg.save(file);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							s.sendMessage("§4Du hast der Gruppe §b"+args[1]+" §4die Rechte §6"+args[2]+" §4gegeben!");
						}else{
							s.sendMessage("§4Die Gruppe §b"+args[1]+" §4gibt es nicht");
							s.sendMessage(" ");
							s.sendMessage("§8-------------");
							s.sendMessage("§4Gruppen§8:");
							s.sendMessage("§b"+Groups.admin);
							s.sendMessage("§b"+Groups.dev);
							s.sendMessage("§b"+Groups.builder);
							s.sendMessage("§b"+Groups.mod);
							s.sendMessage("§b"+Groups.supp);
							s.sendMessage("§b"+Groups.youtuber);
							s.sendMessage("§b"+Groups.premium);
							s.sendMessage("§b"+Groups.spieler);
							s.sendMessage("§8-------------");
						}
				}else if(args[0].equalsIgnoreCase("set")){
					if(PermsAPI.isAGroup(args[2]) == false){
						s.sendMessage("§4Die Gruppe §b"+args[2]+" §4gibt es nicht!");
						return true;
					}
					Player p = Bukkit.getPlayer(args[1]);
					if(p != null){
						PermsAPI.setGroup(p, args[2]);
						PermsAPI.updateList();
						PermsAPI.removePerm(p);
						PermsAPI.setPerm(p);
					}else{
						s.sendMessage("§4Der Spieler §e"+args[1]+" §4ist nicht Online!");
					}
				}else if(args[0].equalsIgnoreCase("remove")){
					if(PermsAPI.isAGroup(args[1])){
						List<String> perm = cfg.getStringList(args[1].toLowerCase()+".perms");
						boolean b = false;
						for(int i = 0; i< perm.size(); i++){
							if(perm.get(i).equalsIgnoreCase(args[2])){
								b = true;
							}
						}
						
						if(b == true){
						
							cfg.set(args[1].toLowerCase()+".perms", perm);
							try {
								cfg.save(file);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}else{
							s.sendMessage("§4Die Gurppe §b"+args[1]+" §4hat die Rechte §6"+args[2]+" §4nicht!");
							return false;
							}
						s.sendMessage("§4Du hast der Gruppe §b"+args[1]+" §4die Rechte §6"+args[2]+" §4genommen!");
					}else{
						s.sendMessage("§4Die Gruppe §b"+args[1]+" §4gibt es nicht");
						s.sendMessage(" ");
						s.sendMessage("§8-------------");
						s.sendMessage("§4Gruppen§8:");
						s.sendMessage("§b"+Groups.admin);
						s.sendMessage("§b"+Groups.dev);
						s.sendMessage("§b"+Groups.builder);
						s.sendMessage("§b"+Groups.mod);
						s.sendMessage("§b"+Groups.supp);
						s.sendMessage("§b"+Groups.youtuber);
						s.sendMessage("§b"+Groups.premium);
						s.sendMessage("§b"+Groups.spieler);
						s.sendMessage("§8-------------");
					}
				}else{
					s.sendMessage(" ");
					s.sendMessage("§8-------------");
					s.sendMessage("§4Commands§8:");
					s.sendMessage("§a/perms <add/remove> <Gruppe> <Rechte>");
					s.sendMessage("§a/perms set <PLAYER> <Gruppe>");
					s.sendMessage("§8-------------");
				}
			}else{
				s.sendMessage(" ");
				s.sendMessage("§8-------------");
				s.sendMessage("§4Commands§8:");
				s.sendMessage("§a/perms <add/remove> <Gruppe> <Rechte>");
				s.sendMessage("§a/perms set <PLAYER> <Gruppe>");
				s.sendMessage("§8-------------");
			}
		}
		return false;
	}

}

// perms [add/remove] <NAME> <PERMs>
// perms set <PLAYER> <GROUP>
