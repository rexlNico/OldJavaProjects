package de.rexlUnity.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.rexlUnity.Methodes.Factory;
import de.rexlUnity.Methodes.Var;

public class Setspawn implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if(sender instanceof Player){
			Player p = (Player)sender;
			if(lable.equalsIgnoreCase("spawn")){
				
				p.teleport(Factory.getConfigLocation("Spawn", Var.Fcfg));
				
			}else if(lable.equalsIgnoreCase("setspawn")){
				if(p.hasPermission(Var.perm+"setspawn")){
				
					Factory.createConfigLocation(p.getLocation(), "Spawn", Var.Fcfgfile, Var.Fcfg);
					p.sendMessage(Var.pr+"§7Du hast den §aSpawn §7gesetzt.");
					
				}else{
					p.sendMessage(Var.noperm);
				}
			}
		}else{
			sender.sendMessage(Var.console);
		}
		return false;
	}


	
}
