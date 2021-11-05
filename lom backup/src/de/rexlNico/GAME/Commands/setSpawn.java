package de.rexlNico.GAME.Commands;

import java.io.File;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.rexlNico.GAME.Methodes.Factory;
import de.rexlNico.GAME.Methodes.Var;

public class setSpawn implements CommandExecutor{

	private File file = new File("plugins/LOM/spawns.txt");
	private YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
			Player p = (Player)sender;
			if(p.hasPermission(Var.perms+"setspawns")){
				if(args.length == 1){
					if(args[0].equalsIgnoreCase("lobby")){
						Factory.CreateConfigLocation(p.getLocation(), cfg, file, "Lobby");
						p.sendMessage(Var.pr+"Du hast die §aLobby §7gesetzt.");
					}else{
						p.sendMessage(Var.error+"setSpawn <Lobby/Rot/Blau> [Aram,Kluft,Wald]");
					}
				}else if(args.length == 2){
					if(args[0].equalsIgnoreCase("Rot")){
						if(args[1].equalsIgnoreCase("aram")){
							Factory.CreateConfigLocation(p.getLocation(), cfg, file, "ARAM.rot");
							p.sendMessage(Var.pr+"Du hast den §aSpawn für team §4Rot §7auf der Map §bAram §7gesetzt.");
							
						}else if(args[1].equalsIgnoreCase("kluft")){
							Factory.CreateConfigLocation(p.getLocation(), cfg, file, "KLUFT.rot");
							p.sendMessage(Var.pr+"Du hast den §aSpawn für team §4Rot §7auf der Map §bKluft §7gesetzt.");
							
						}else if(args[1].equalsIgnoreCase("wald")){
							Factory.CreateConfigLocation(p.getLocation(), cfg, file, "WALD.rot");
							p.sendMessage(Var.pr+"Du hast den §aSpawn für team §4Rot §7auf der Map §Wald §7gesetzt.");
							
						}else{
							p.sendMessage(Var.error+"setSpawn <Rot> [Aram,Kluft,Wald]");
						}
					}else if(args[0].equalsIgnoreCase("Blau")){
						if(args[1].equalsIgnoreCase("aram")){
							Factory.CreateConfigLocation(p.getLocation(), cfg, file, "ARAM.blau");
							p.sendMessage(Var.pr+"Du hast den §aSpawn für team §1Blau §7auf der Map §bAram §7gesetzt.");
							
						}else if(args[1].equalsIgnoreCase("kluft")){
							Factory.CreateConfigLocation(p.getLocation(), cfg, file, "KLUFT.blau");
							p.sendMessage(Var.pr+"Du hast den §aSpawn für team §1Blau §7auf der Map §bKluft §7gesetzt.");
							
						}else if(args[1].equalsIgnoreCase("wald")){
							Factory.CreateConfigLocation(p.getLocation(), cfg, file, "WALD.blau");
							p.sendMessage(Var.pr+"Du hast den §aSpawn für team §1Blau §7auf der Map §bWald §7gesetzt.");
							
						}else{
							p.sendMessage(Var.error+"setSpawn <Blau> [Aram,Kluft,Wald]");
						}
					}else{
						p.sendMessage(Var.error+"setSpawn <Lobby/Rot/Blau> [Aram,Kluft,Wald]");
					}
				}else{
					p.sendMessage(Var.error+"setSpawn <Lobby/Rot/Blau> [Aram,Kluft,Wald]");
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
