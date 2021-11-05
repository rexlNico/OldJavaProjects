package de.buugie15.Commands;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.buugie15.Main.Var;

public class Msg implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(p.hasPermission(Var.perm+"msg")){
			if(args.length >= 2){
				Player target = Bukkit.getPlayer(args[0]);
		          if (target != null){
			            String message = "";
			            for (int i = 1; i < args.length; i++) {
			              message = message + args[i] + " ";
			              
				            target.sendMessage(Var.pr+"§a"+ p.getName() +"§8 ➤➤  §a" + target.getName() + "§7:  " + message);
				            p.sendMessage(Var.pr+"§a"+ p.getName() +"§8 ➤➤  §a" + target.getName() + "§7:  " + message);
			              
			              
			              
			            }
		        	  
		        	  
		        	  
		        	  
		        	  
		          }else{
		        	  p.sendMessage(Var.pr+"§cDer Spieler §6"+args[0]+" §cist nicht online§7!");
		          }
				
				
				
				
				
				
				
			}else{
				p.sendMessage(Var.pr+"§7/§eMsg §7[§ename§7] <§eNachricht§7>");
			}
			
			
			
			
			
			
			
		}else{
			p.sendMessage(Var.noP);
		}
		
		
		
		
		
		
		
		return false;
	}

}
