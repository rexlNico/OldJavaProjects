package de.buugie15.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.buugie15.Main.Var;

public class heal implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender; 
		if(sender instanceof Player){
			if(p.hasPermission(Var.perm+"heal")){
				if(args.length == 0){
					p.setHealth(20);
					p.setFoodLevel(20);
					p.sendMessage(Var.pr+"§aDu wurdest geheilt§7.");
					
				}else if(args.length == 1){
					Player target = Bukkit.getPlayer(args[0]);
			          if (target != null){
			        	  target.setHealth(20);
			        	  target.setFoodLevel(20);
			        	  p.sendMessage(Var.pr+"§aDu hast den Spieler §6"+target.getName()+"§a geheilt§7.");
			        	  target.sendMessage(Var.pr+"§aDu wurdest von §6"+p.getName()+"§a geheilt§7.");
			        	  
			        	  
			        	  
			          }else{
			        	  p.sendMessage(Var.pr+"§cDer Spieler §6"+args[0]+" §cist nicht online§7!");
			          }
					
					
					
				}else{
					p.sendMessage(Var.pr+"§7/§eHeal §7[§eName§7]");
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
