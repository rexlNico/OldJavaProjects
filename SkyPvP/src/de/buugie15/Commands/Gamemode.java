package de.buugie15.Commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.buugie15.Main.Var;

public class Gamemode implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(sender instanceof Player){
			if(p.hasPermission(Var.perm+"gamemode")){
				if(args.length == 0){
					if(p.getGameMode() == GameMode.CREATIVE){
						p.setGameMode(GameMode.SURVIVAL);
						p.sendMessage(Var.pr+"§7Du bist jetzt im §aSurvival §7mode§7.");
					}else{
						p.setGameMode(GameMode.CREATIVE);
						p.sendMessage(Var.pr+"§7Du bist jetzt im §aCreative §7mode§7.");
						
					}
					

					
					
				}else if(args.length == 1){
			        	   if(args[0].equals("1")){
			        	  p.setGameMode(GameMode.CREATIVE);
			        	  p.sendMessage(Var.pr+"§7Du bist jetzt im §aCreative §7mode§7.");

			          		}else if(args[0].equals("2")){
			          			p.setGameMode(GameMode.ADVENTURE);
			          			p.sendMessage(Var.pr+"§7Du bist jetzt im §aAdventure §7mode§7.");
			          		}else if(args[0].equals("3")){
			          			p.setGameMode(GameMode.SPECTATOR);
			          			p.sendMessage(Var.pr+"§7Du bist jetzt im §aSpectator §7mode§7.");
			          		}else if(args[0].equals("0")){
			          			p.setGameMode(GameMode.SURVIVAL);
			          			p.sendMessage(Var.pr+"§7Du bist jetzt im §aSurvival §7mode§7.");
			          		}else{
			          			p.sendMessage(Var.pr+"§6"+args[0]+"§c ist keine gültige Zahl§7!");
			          			
			          		}
			          }else if(args.length == 2){
			        	  Player target = Bukkit.getPlayer(args[1]);
				          if (target != null){
				        	  if(args[0].equals("1")){
					        	  target.setGameMode(GameMode.CREATIVE);
					        	  target.sendMessage(Var.pr+"§7Du wurdest von §6"+p.getName()+" §7in den §aCreative §7modus gesetzt§7.");
					        	  p.sendMessage(Var.pr+"§7Du hast§6 "+target.getName()+" §7in den §aCreative §7modus gesetzt§7.");

					          		}else if(args[0].equals("2")){
					          			target.setGameMode(GameMode.ADVENTURE);
					          			 target.sendMessage(Var.pr+"§7Du wurdest von §6"+p.getName()+" §7in den §aAdventure §7modus gesetzt§7.");
					          			 p.sendMessage(Var.pr+"§7Du hast§6 "+target.getName()+" §7in den §aAdventure §7modus gesetzt§7.");
					          			 
					          		}else if(args[0].equals("3")){
					          			target.setGameMode(GameMode.SPECTATOR);
					          			 target.sendMessage(Var.pr+"§aDu wurdest von §5"+p.getName()+" §ain den §6Spectator §amodus gesetzt§7.");
					          			 p.sendMessage(Var.pr+"§7Du hast§6 "+target.getName()+" §7in den §aSpectator §7modus gesetzt§7.");
					          			 
					          		}else if(args[0].equals("0")){
					          			target.setGameMode(GameMode.SURVIVAL);
					          			 target.sendMessage(Var.pr+"§7Du wurdest von §6"+p.getName()+" §ain den §aSurvival §7modus gesetzt§7.");
					          			 p.sendMessage(Var.pr+"§7Du hast§6 "+target.getName()+" §7in den §aSurvival §7modus gesetzt§7.");
					          			 
					          		}else{
					          			p.sendMessage(Var.pr+"§6"+args[0]+"§c ist keine gültige Zahl§7!");
					          			
					          		}
				        	  
				        	  
				        	  
				          }else{
				        	  p.sendMessage(Var.pr+"§cDer Spieler §6"+args[1]+" §cist nicht online§7!");
				          }
			        	  
			        	  
			          }else{
			        	  p.sendMessage(Var.pr+"§7/§eGamemode §7<§e0§7/§e1§7/§e2§7/§e3§7> [§eName§7]");
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
