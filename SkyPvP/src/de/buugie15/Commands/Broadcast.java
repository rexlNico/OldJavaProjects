package de.buugie15.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.buugie15.Main.Var;

public class Broadcast implements CommandExecutor{
	String prefix = "§7[§4§lBroadcast§7]§f";

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender;
			if(p.hasPermission("system.broadcast")){	
			for(Player all : Bukkit.getOnlinePlayers()){
				if(args.length == 0){
					p.sendMessage("§7/§eBroadcast §7<§eText§7>");
				}else if(args.length >= 1){
					
				
					String message = "";
		            for (int i = 0; i < args.length; i++) {
		              message = message + args[i] + " ";
		            }
					all.sendMessage(prefix + " " +  message.replaceAll("&", "§"));
			
					
				}
						
					
			}
			}else{
				p.sendMessage(Var.noP);
			}
			
		
		
		
		return true;
	}
}
