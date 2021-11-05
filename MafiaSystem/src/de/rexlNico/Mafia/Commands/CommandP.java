package de.rexlNico.Mafia.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.rexlNico.Mafia.Api.Mafia;

public class CommandP implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if(sender instanceof Player){
			Player p = (Player)sender;
			if(args.length == 0){
				p.sendMessage(" ");
				p.sendMessage("§7----§8# §4Help §8#§7----");
				p.sendMessage("");
				p.sendMessage("§7/§5Mafia erstellen <Name> <Kürzel>");
				p.sendMessage("§7/§5Mafia addmitglied <Name>");
				p.sendMessage("§7/§5Mafia kickmitglied <Name>");
				p.sendMessage("§7/§5Mafia info  [Name]");
				p.sendMessage("§7/§5Mafia setbanner");
				p.sendMessage("§7/§5Mafia setcolor");
				p.sendMessage("§7/§5Mafia delete");
				p.sendMessage("");
				p.sendMessage("§7----§8# §4Help §8#§7----");
				p.sendMessage(" ");
			}else if(args.length == 1){
				if(args[0].equalsIgnoreCase("delete")){
					
				}else if(args[0].equalsIgnoreCase("setbanner")){
					
				}else if(args[0].equalsIgnoreCase("setcolor")){
					
				}else if(args[0].equalsIgnoreCase("info")){
					
				}
			}else if(args.length == 2){
				if(args[0].equalsIgnoreCase("addmitglied")){
					
				}else if(args[0].equalsIgnoreCase("kickmitglied")){
					
				}else if(args[0].equalsIgnoreCase("info")){
					
				}
			}else if(args.length == 3){
				if(args[0].equalsIgnoreCase("erstellen")){
					String name = args[1];
					String k = args[2];
					if(Mafia.IsInAMafia(p)){
						if(Mafia.isMafiaBoss("", p)){
							p.sendMessage("§4Du hast bereits deine eigene Mafia");
							return false;
						}
						p.sendMessage("§4Du bist bereits in einer Mafia");
						return false;
					}
					if(name.length() > 16){
						p.sendMessage("§4Der Mafianame ist zu lang!");
						return false;
					}
					if(k.length() > 5){
						p.sendMessage("§4Der Kürzel ist zu lang!");
						return false;
					}
					
					Mafia.createMafia(p, name, k);
					p.sendMessage("§4Die Mafia §5"+name+" §4mit dem Kürzel §6"+k+" §4wurde erstellt!");
					
				}
			}
		}else{
			sender.sendMessage("§4Nur ein Splieler darf das!");
		}
		return false;
	}

}
