package de.rexlUnity.Listeners;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Vector;

import org.apache.logging.log4j.core.layout.PatternLayout;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import de.rexlUnity.Methodes.Var;

public class YoutuberBox implements Listener{

			
	
	@EventHandler 
	public void on(PlayerInteractEvent e){
		
		
		int x = 0,
				y = 0,
				z = 0;
		
		Player p = e.getPlayer();
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			if(e.getClickedBlock().getType() == Material.STONE_BUTTON){
				
				x = e.getClickedBlock().getX();
				y = e.getClickedBlock().getY() - 1;
				z = e.getClickedBlock().getZ();
				
				
				if(Bukkit.getWorld("world").getBlockAt(x,y,z).getState() instanceof Sign){
					Sign s = (Sign) Bukkit.getWorld("world").getBlockAt(x,y,z).getState();
					
					int Box = Integer.valueOf(s.getLine(2));
					int Numer = 1;
					Player Name = null;
					
					if(s.getLine(1).equals("")){
						s.setLine(0, "§0- §4Box §0-");
						if(p.hasPermission(Var.perm+"ytBox")){
							p.sendMessage(Var.pr+"§cUm die §4Box§c wieder zu verlassen drücke den Knopf.");
							s.setLine(1, "§5"+p.getName());
							s.update();
							
							float yaw = (float) Var.YTcfg.getDouble(s.getLine(2)+".Box.tp.Yaw");
							float pitch = (float) Var.YTcfg.getDouble(s.getLine(2)+".Box.tp.Pitch");
							
							Location loc = new Location((World) Var.YTcfg.get(s.getLine(2)+".Box.w", p.getLocation().getWorld()), Var.YTcfg.getDouble(s.getLine(2)+".Box.tp.x", p.getLocation().getX()), Var.YTcfg.getDouble(s.getLine(2)+".Box.tp.y", p.getLocation().getY()), Var.YTcfg.getDouble(s.getLine(2)+".Box.tp.z", p.getLocation().getZ()), yaw , pitch);
							
							p.teleport(loc);
							
							
							for(Player a : Bukkit.getOnlinePlayers()){
								if( !(a == p) ){
									a.sendMessage(Var.pr+"§cDer Youtuber §5"+p.getName()+"§c ist Youtuber §4Box §6"+s.getLine(2)+"§c.");
								}
							}
						}else{
							p.sendMessage(Var.noperm);
						}
						
					}else{
						if(p.hasPermission(Var.perm+"ytBox")){
							p.sendMessage(Var.pr+"§cDiese §4Box §cwird bereits benutzt.");
						}else{
						}
					}
					
					
					
				}
								
			}
		}
	}
	
}
