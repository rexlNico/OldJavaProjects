package de.rexlUnity.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.rexlUnity.Methodes.Factory;
import de.rexlUnity.Methodes.Var;

public class SetJumpAndRun implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if(sender instanceof Player){
			Player p = (Player)sender;
			if(p.hasPermission(Var.perm+"setjump")){
				if(args.length == 1){
					Factory.createConfigLocation(p.getLocation(), "jump."+args[0], Var.Fcfgfile, Var.Fcfg);
					p.sendMessage(Var.pr+"§7Das JumpAndRun §a"+args[0]+" §7wurde gesetzt.");
				}else{
					p.sendMessage(Var.error+"setJump <Name>");
				}
			}else{
				p.sendMessage(Var.noperm);
			}
		}else{
			sender.sendMessage(Var.console);
		}
		return false;
	}

}
