package de.rexlNico.GAME.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.rexlNico.GAME.GameStates.GameStateHandler;
import de.rexlNico.GAME.GameStates.LobbyState;
import de.rexlNico.GAME.Methodes.Var;

public class Start implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
			Player p = (Player)sender;
			if(p.hasPermission(Var.perms+"start")){
				if(args.length == 0){
					if(GameStateHandler.getGamestate() instanceof LobbyState){
						LobbyState ls = (LobbyState) GameStateHandler.getGamestate();
						if(ls.getCountdown().getSec() > 10){
							ls.getCountdown().setSec(10);
							p.sendMessage(Var.pr+"§aDu hast die Wartezeit beschleunigt!");
						}else{
							p.sendMessage(Var.pr+"§cDas Spiel startet bereits");
						}
					}
				}else{
					p.sendMessage(Var.error+"Start");
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
