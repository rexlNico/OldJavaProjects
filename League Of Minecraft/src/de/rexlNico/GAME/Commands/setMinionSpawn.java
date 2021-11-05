package de.rexlNico.GAME.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.rexlNico.GAME.Methodes.Factory;
import de.rexlNico.GAME.Methodes.MinionFactory;
import de.rexlNico.GAME.Methodes.Var;

public class setMinionSpawn implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String lable, String[] args) {

		Player p = (Player)s;
		
		if(args.length == 1){
		
		if(args[0].equalsIgnoreCase("rot")){
			MinionFactory.CreateConfigLocation(p.getLocation(), Var.cfg, Var.file, Var.Map+".Minion.1.rot");
		}else if(args[0].equalsIgnoreCase("blau")){
			MinionFactory.CreateConfigLocation(p.getLocation(), Var.cfg, Var.file, Var.Map+".Minion.1.blau");
		}else{
			p.sendMessage("setminion <rot/blau>");
		}
		
		}else{
			p.sendMessage("setminion <rot/blau>");
		}
		return false;
	}

	
	
}
