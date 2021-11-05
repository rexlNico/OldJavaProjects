package de.buugie15.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.buugie15.Main.Var;

public class ClearChat implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(p.hasPermission(Var.perm+"cc")){
			for(Player all : Bukkit.getOnlinePlayers()){
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				all.sendMessage("");
				
				if(args.length == 0){
					all.sendMessage(Var.pr+"§cDer Chat wurde von §6"+p.getName()+"§c gelöscht");
				}else if(args.length >= 1){
					String msg = "";
		            for (int i = 0; i < args.length; i++) {
		              msg = msg + args[i] + " ";
		            }
		            all.sendMessage(Var.pr+"§cDer Chat wurde von §6"+ p.getName() +" §cgelöscht§7. §cGrund§7:  §c " + msg.replaceAll("&", "§"));
				}
				
			}
			
			
			
		}else{
			p.sendMessage(Var.perm);
		}
		
		
		
		
		
		

		
		
		return false;
	}

}
