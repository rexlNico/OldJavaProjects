package de.buugie15.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.buugie15.Main.Var;

public class Fly implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(sender instanceof Player){
			if(p.hasPermission(Var.perm+"fly")){
				if(args.length == 0){
				if(p.getAllowFlight() == true){
					p.setAllowFlight(false);
					p.sendMessage(Var.pr+"§7Du kannst jetzt nicht mehr fliegen.");
					
				}else{
					p.setAllowFlight(true);
					p.sendMessage(Var.pr+"§7Du kannst jetzt fliegen.");
				}
				
				}else if(args.length == 1){
					Player target = Bukkit.getPlayer(args[0]);
			          if (target != null){
			        	  if(target.getAllowFlight() == true){
			        		  target.setAllowFlight(false);
			        		  target.sendMessage(Var.pr+"§7Du kannst jetzt nichtmehr fliegen.");
			        		  p.sendMessage(Var.pr+"§7Der Spieler §6"+target.getName()+" §7kann jetzt nicht mehr fliegen!");
			        		 
			        	  }else{
			        		  target.setAllowFlight(true);
			        		  target.sendMessage(Var.pr+"§7Du kannst jetzt fliegen.");
			        		  p.sendMessage(Var.pr+"§7Der Spieler §6"+target.getName()+" §7kann jetzt fliegen!");
			        	  }
			        	  
			          }else{
			        	  p.sendMessage(Var.pr+"§cDer Spieler §6"+args[0]+" §cist nicht online§7!");
			          }
					
					
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
