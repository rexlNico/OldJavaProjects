package de.rexlNico.Main;

import java.io.File;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

public class SignApi {
	
	public static int point = 0;
	public static int TaskID;
	public static void setSign(Location loc,String Servername, String Spielmodus, String Ip, int Port, boolean online){
		
		Server server = new Server(Ip, Port);
		server.ping();
		
		Sign s = (Sign) loc.getBlock().getState();
		if(online == true){
		s.setLine(0, "§0[§a"+Spielmodus+"§0]");
		s.setLine(1, "- "+Servername+" -");
		s.setLine(2, "➟ §aOnline");
		s.setLine(3, server.getOnlineplayers()+" ● "+server.getMaxplayers());
		s.update();
		}else{
			if(point != 15){
				point++;
			}else{
				point = 0;
			}
			switch (point) {
			case 1: 
				s.setLine(0, "");
				s.setLine(2, "");
				s.setLine(1, "Server Loading.");
				s.setLine(3, "");
				s.update();
				break;

			case 5: 
				s.setLine(0, "");
				s.setLine(2, "");
				s.setLine(1, "Server Loading..");
				s.setLine(3, "");
				s.update();
				break;
			case 10: 
				s.setLine(0, "");
				s.setLine(2, "");
				s.setLine(1, "Server Loading...");
				s.setLine(3, "");
				s.update();
				break;
			case 14:
				s.setLine(0, "");
				s.setLine(2, "");
				s.setLine(1, "Server Loading");
				s.setLine(3, "");
				s.update();
				break;
			}
			
		}
	}
	
	public static void updateSign(){
		File file = new File("plugins/rexlSign/config.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		Sign s;
		List<String> signs = cfg.getStringList("Servernamen");
		for(int i = 0; i<signs.size(); i++){
			Location loc = new Location(Bukkit.getWorld(cfg.getString(signs.get(i)+".W")), cfg.getDouble(signs.get(i)+".X"), cfg.getDouble(signs.get(i)+".Y"), cfg.getDouble(signs.get(i)+".Z"));
			Server server = new Server(cfg.getString(signs.get(i)+".Ip"), cfg.getInt(signs.get(i)+".Port"));
			server.ping();
			s = (Sign) loc.getBlock().getState();
			if(server.getOnline()){
				setSign(loc, signs.get(i), cfg.getString(signs.get(i)+".Game"), cfg.getString(signs.get(i)+".Ip"), cfg.getInt(signs.get(i)+".Port"), true);
			}else{
				setSign(loc, signs.get(i), cfg.getString(signs.get(i)+".Game"), cfg.getString(signs.get(i)+".Ip"), cfg.getInt(signs.get(i)+".Port"), false);
			}
		}
	}
	
	public static void joinModi(Player p, Location loc){
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		Sign s = (Sign) loc.getBlock().getState();
		File file = new File("plugins/rexlSign/config.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if(s.getLine(2).equals("➟ §aOnline") || s.getLine(2).equals("➟ §6Online")){
			
			Server server = new Server(cfg.getString(s.getLine(1).replace(" -", "").replace("- ", "")+".Ip"), cfg.getInt(s.getLine(1).replace(" -", "").replace("- ", "")+".Port"));
			
			server.ping();
			if(server.getOnlineplayers() == server.getMaxplayers()){
				p.sendMessage("§cDer Server ist Voll.");
				p.sendMessage("§cKaufe dir §6Premium §cum trotzdem joinen zu können.");
				return;
			}
			String serv = s.getLine(1).replace("- ", "").replace(" -", "");
			List<String> serverlist = cfg.getStringList("Servernamen");
			for(int i = 0; i<serverlist.size(); i++){
				
				if(serverlist.get(i).equalsIgnoreCase(serv)){
					p.sendMessage("§cVerbinden...");
					out.writeUTF("Connect");
					out.writeUTF(serverlist.get(i));
					p.sendPluginMessage(Main.getPlugin(), "BungeeCord", out.toByteArray());
					return;
				}
			}
		}
	}
	
	
}
