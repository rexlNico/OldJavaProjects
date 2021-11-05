package de.buugie15.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.buugie15.Main.Var;

public class Enderchest implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(sender instanceof Player){
			if(p.hasPermission(Var.perm+"enderchest")){
				if(args.length == 0){
					p.openInventory(p.getEnderChest());
					p.sendMessage(Var.pr+"§aDeine Enderchest wurde geöffnet§7.");
					
				}else if(args.length == 1){
			          Player target = Bukkit.getPlayer(args[0]);
			          if (target != null){
			        	  p.openInventory(target.getEnderChest());
			        	  p.sendMessage(Var.pr+"§aDu hast die Enderchest von §6"+target.getName()+" §ageöffnet§7.");
			        	  
			        	  
			        	  
			        	  
			        	  
			          }
					
					
				}else{
					p.sendMessage(Var.pr+"§7/§eEnderchest §7[§eName§7]");
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
