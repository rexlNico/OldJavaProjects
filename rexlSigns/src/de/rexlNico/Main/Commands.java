package de.rexlNico.Main;

import java.awt.PopupMenu;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor{

	@SuppressWarnings("unchecked")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if(sender instanceof Player){
			Player p = (Player)sender;
			File file = new File("plugins/rexlSign/config.yml");
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			if(p.hasPermission("rexlsign.addsign")){
				if(args.length != 4){
					p.sendMessage("§8/§eaddsign <Spielmodus> <ServerName> <Ip> <Port>");
				}else{
					Sign s = (Sign) p.getTargetBlock((HashSet<Byte>) null, 100).getState();
					int Port = 0;
					String Game = args[0];
					String ServerName = args[1];
					String Ip = args[2];
					try {
						Port = Integer.parseInt(args[3]);
					} catch (Exception e) {
						p.sendMessage("§cBitte gib einen richtigen port an");
						return true;
					}
					
					List<String> server = cfg.getStringList("Servernamen");
					server.add(ServerName);
					
					cfg.set(ServerName+".X", s.getLocation().getX());
					cfg.set(ServerName+".Y", s.getLocation().getY());
					cfg.set(ServerName+".Z", s.getLocation().getZ());
					cfg.set(ServerName+".W", s.getLocation().getWorld().getName());
					cfg.set(ServerName+".Game", Game);
					cfg.set(ServerName+".ServerName", ServerName);
					cfg.set(ServerName+".Ip", Ip);
					cfg.set(ServerName+".Port", Port);
					cfg.set("Servernamen", server);
					try {
						cfg.save(file);
					} catch (IOException e) {
						e.printStackTrace();
					}
					p.sendMessage("§aDas Schild wurde hinzugefügt");
					
					
				}
			}
		}
		return false;
	}

}
