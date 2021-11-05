package de.rexlNico.Commands;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.rexlNico.Api.SignApi;
import de.rexlNico.Main.Main;

public class AddSign implements CommandExecutor{

	public static File file = new File("signSystem", "signs.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if(sender instanceof Player){
			Player p = (Player)sender;
			if(lable.equalsIgnoreCase("addSign")){
			if(p.hasPermission("signs.set")){
				if(args.length == 4){
					List<String> list = cfg.getStringList("AllServer");
					if(list.contains(args[1])){
						p.sendMessage("§4Es existiert bereits ein Schild mit dem Server §6"+args[1]+"§4!");
						return false;
					}
					list.add(args[1]);
					SignApi.setSign(p.getTargetBlock((HashSet<Byte>) null, 100).getLocation(), file, cfg, args[1], list, args[0], args[2], Integer.parseInt(args[3]));
					p.sendMessage("§4Das Schild wurde §aerfolgreich §4gesetzt!");
				}else{
					p.sendMessage("§4Bitte nutze §7/§eaddSign §7<§eSpielmodus§7> <§eServer§7> <§eIp§7> <§ePort§7>");
				}
			}else{
				
			}
		}else if(lable.equalsIgnoreCase("removeSign")){
			
			if(p.hasPermission("sign.remove")){
				if(args.length == 0){
					List<String> list = cfg.getStringList("AllServer");	
					Sign s = (Sign) p.getTargetBlock((HashSet<Byte>) null, 100).getState();
					if(list.contains(s.getLine(1).replaceAll("- ", "").replaceAll(" -", ""))){
						String serverName = s.getLine(1).replaceAll("- ", "").replaceAll(" -", "");
						list.remove(serverName);
						cfg.set("AllServer", list);
						try {
							cfg.save(file);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						s.getLocation().getBlock().breakNaturally();
						p.sendMessage("§4Das Schild wurde §aerfolgreich §4gelöscht!");
						return false;
					}
					p.sendMessage("§4Das Schild existiert nicht in der Config!");
				}else{
					p.sendMessage("§4Bitte nutze §7/§eremoveSign");
				}
			}else{
				p.sendMessage(Main.noperm);
			}
		}
		}else{
			sender.sendMessage(Main.noperm);
		}
		return false;
	}

}
