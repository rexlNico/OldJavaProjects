package de.rexlNico.Api;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.YamlConfiguration;

import de.rexlNico.Commands.AddSign;

public class SignApi {
	
	public static void setSign(Location loc, File file, YamlConfiguration cfg, String Servername, List<String> l,String Modi, String ip, int port){
		cfg.set("AllServer", l);
		cfg.set(Servername+".World", loc.getWorld().getName().toString());
		cfg.set(Servername+".X", loc.getX());
		cfg.set(Servername+".Y", loc.getY());
		cfg.set(Servername+".Z", loc.getZ());
		cfg.set(Servername+".IP", ip);
		cfg.set(Servername+".Port", port);
		cfg.set(Servername+".Modi", Modi);
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static Sign getSign(YamlConfiguration cfg, String Servername){
		
		Location l = new Location(Bukkit.getWorld(cfg.getString(Servername+".World"))
				, cfg.getDouble(Servername+".X") 
				, cfg.getDouble(Servername+".Y")
				, cfg.getDouble(Servername+".Z"));
		
		Sign s = (Sign) l.getBlock().getState();
		
		return s;
	}
	
	public static int getPort(String servername){
		return AddSign.cfg.getInt(servername+".Port");
	}
	public static String getIp(String servername){
		return AddSign.cfg.getString(servername+".IP");
	}
	
	public static void updateServer(int pp) {
		List<String> list = AddSign.cfg.getStringList("AllServer");
		for(int i = 0; i < list.size(); i++){
			Sign s = getSign(AddSign.cfg, list.get(i));
			Server server = new Server(getIp(list.get(i)), getPort(list.get(i)));
			server.ping();
			if(server.getOnline()){
				s.setLine(0, "§0[§a"+AddSign.cfg.getString(list.get(i)+".Modi")+"§0]");
				s.setLine(1, "- "+list.get(i)+" -");
				if(server.getMotd().equals("GAMESTART")){
					s.setLine(2, "➟ §4Online");
				}else if(server.getOnlineplayers() == server.getMaxplayers()){
					s.setLine(2, "➟ §6Online");
				}else{
					s.setLine(2, "➟ §aOnline");
				}
				s.setLine(3, server.getOnlineplayers()+" ● "+server.getMaxplayers());
				s.update();
			}else{
				s.setLine(0, "");
				s.setLine(2, "");
				s.setLine(3, "");
				if(pp == 1) s.setLine(1, "§7Loading §7●§f●●");
				if(pp == 2) s.setLine(1, "§7Loading §f●§7●§f●");
				if(pp == 3) s.setLine(1, "§7Loading §f●●§7●");
				s.update();
				
			}
		}
	}
	
}
