package de.buugie15.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.buugie15.Main.Var;

public class vanish implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(sender instanceof Player){
			if(p.hasPermission(Var.perm+"vanish")){
				if(args.length == 1){
					if(args[0].equalsIgnoreCase("an")){
						for(Player all : Bukkit.getOnlinePlayers()) all.hidePlayer(p);
						p.sendMessage(Var.pr+"§7Du bist nun für alle Unsichtbar");
					}else if(args[0].equalsIgnoreCase("aus")){
						for(Player all : Bukkit.getOnlinePlayers()) all.showPlayer(p);
						p.sendMessage(Var.pr+"§7Du bist nun für alle Sichtbar");
					}else{
						p.sendMessage(Var.pr+"§7/§evanish §7<§ean§7/§eaus§7>");
					}
					
					
				}else if(args.length == 2){
					Player target = Bukkit.getPlayer(args[1]);
			          if (target != null){
			        	  
			        		  if(args[0].equalsIgnoreCase("an")){
			        			  for(Player all : Bukkit.getOnlinePlayers()) all.hidePlayer(target);
			        		  target.sendMessage(Var.pr+"§7Du bist nun für alle Unsichtbar");
			        		  p.sendMessage(Var.pr+"§7Der Spieler §6"+target.getName()+" §7ist nun Unsichtbar");
			        	  }else if(args[0].equalsIgnoreCase("aus")){
			        		  for(Player all : Bukkit.getOnlinePlayers()) all.showPlayer(target);
			        		  target.sendMessage(Var.pr+"§7Du bist nun für alle Sichtbar");
			        		  p.sendMessage(Var.pr+"§7Der Spieler §6"+target.getName()+" §7ist nun Sichtbar");
			        	  }else{
			        		  p.sendMessage(Var.pr+"§7/§evanish §7<§ean§7/§eaus§7> [§eName§7]"); 
			        	  }
			        	  
			          }else{
			        	  p.sendMessage(Var.pr+"§cDer Spieler §6"+args[1]+" §cist nicht online§7!");
			          }
					
					
					
				}else{
					 p.sendMessage(Var.pr+"§7/§evanish §7<§ean§7/§eaus§7> [§eName§7]");
				}
				
				
			}else{
				p.sendMessage(Var.noP);
			}
			
		}else{
			Bukkit.getConsoleSender().sendMessage(Var.console);
			
		}
		
		
	
		
		
		
		
		
		return false;
	}

}
