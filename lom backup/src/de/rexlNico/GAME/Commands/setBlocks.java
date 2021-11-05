package de.rexlNico.GAME.Commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.rexlNico.GAME.Methodes.BlockFactory;
import de.rexlNico.GAME.Methodes.Var;

public class setBlocks implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if(sender instanceof Player){
			Player p = (Player) sender;
			if(p.hasPermission(Var.perms+"setblock")){
				if(args.length == 0){
					p.sendMessage(Var.error+"setblock <Tower> [Aram/Wald/Kluft] [Rot/Blau]");
					p.sendMessage(Var.error+"setblock <Nexus> [Aram/Wald/Kluft] [Rot/Blau]");
					p.sendMessage(Var.error+"setblock <Inhibitor> [Aram/Wald/Kluft] [id(1-3)] [Rot/Blau]");
				}else if(args.length == 3){
					Location loc = p.getLocation();
					loc.setY(p.getLocation().getY()-1);
					//Inhibitor
					if(args[0].equalsIgnoreCase("nexus")){
						
						if(args[1].equalsIgnoreCase("Aram")){
							if(args[2].equalsIgnoreCase("rot")){
								
								
								BlockFactory.CreateConfigLocation(loc, Var.cfg, Var.file, "ARAM.rot.nexus");
								p.sendMessage(Var.pr+"Der Block wurde gesetzt.");
							}else if(args[2].equalsIgnoreCase("blau")){
								BlockFactory.CreateConfigLocation(loc, Var.cfg, Var.file, "ARAM.blau.nexus");
								p.sendMessage(Var.pr+"Der Block wurde gesetzt.");
							}
						}else if(args[1].equalsIgnoreCase("wald")){
							if(args[2].equalsIgnoreCase("rot")){
								BlockFactory.CreateConfigLocation(loc, Var.cfg, Var.file, "WALD.rot.nexus");
								p.sendMessage(Var.pr+"Der Block wurde gesetzt.");
							}else if(args[2].equalsIgnoreCase("blau")){
								BlockFactory.CreateConfigLocation(loc, Var.cfg, Var.file, "WALD.blau.nexus");
								p.sendMessage(Var.pr+"Der Block wurde gesetzt.");
							}
						}else if(args[1].equalsIgnoreCase("Kluft")){
							if(args[2].equalsIgnoreCase("rot")){
								BlockFactory.CreateConfigLocation(loc, Var.cfg, Var.file, "KLUFT.rot.nexus");
								p.sendMessage(Var.pr+"Der Block wurde gesetzt.");
							}else if(args[2].equalsIgnoreCase("blau")){
								BlockFactory.CreateConfigLocation(loc, Var.cfg, Var.file, "KLUFT.blau.nexus");
								p.sendMessage(Var.pr+"Der Block wurde gesetzt.");
							}
						}else{
							p.sendMessage(Var.error+"setblock <Tower> [Aram/Wald/Kluft] [id(1-11)] [Rot/Blau]");
							p.sendMessage(Var.error+"setblock <Nexus> [Aram/Wald/Kluft] [Rot/Blau]");
							p.sendMessage(Var.error+"setblock <Inhibitor> [Aram/Wald/Kluft] [id(1-3)] [Rot/Blau]");
						}
					}else{
						p.sendMessage(Var.error+"setblock <Tower> [Aram/Wald/Kluft] [id(1-11)] [Rot/Blau]");
						p.sendMessage(Var.error+"setblock <Nexus> [Aram/Wald/Kluft] [Rot/Blau]");
						p.sendMessage(Var.error+"setblock <Inhibitor> [Aram/Wald/Kluft] [id(1-3)] [Rot/Blau]");
					}
				}else if(args.length == 4){
					
					//TWOER
					
					if(args[0].equalsIgnoreCase("tower")){
						
						Location loc = p.getLocation();
						loc.setY(p.getLocation().getY()-1);
						
						if(args[1].equalsIgnoreCase("Aram")){
							
							if(args[2].equalsIgnoreCase("rot")){
								
								BlockFactory.CreateConfigLocation(loc, Var.cfg, Var.file, "ARAM.rot.tower");
								p.sendMessage(Var.pr+"Der Block wurde gesetzt.");
							}else if(args[2].equalsIgnoreCase("blau")){
								BlockFactory.CreateConfigLocation(loc, Var.cfg, Var.file, "ARAM.blau.tower");
								p.sendMessage(Var.pr+"Der Block wurde gesetzt.");
							}
						}else if(args[1].equalsIgnoreCase("wald")){
							if(args[2].equalsIgnoreCase("rot")){
								BlockFactory.CreateConfigLocation(loc, Var.cfg, Var.file, "WALD.rot.tower");
								p.sendMessage(Var.pr+"Der Block wurde gesetzt.");
							}else if(args[2].equalsIgnoreCase("blau")){
								BlockFactory.CreateConfigLocation(loc, Var.cfg, Var.file, "WALD.blau.tower");
								p.sendMessage(Var.pr+"Der Block wurde gesetzt.");
							}
						}else if(args[1].equalsIgnoreCase("Kluft")){
							if(args[2].equalsIgnoreCase("rot")){
								BlockFactory.CreateConfigLocation(loc, Var.cfg, Var.file, "KLUFT.rot.tower");
								p.sendMessage(Var.pr+"Der Block wurde gesetzt.");
							}else if(args[2].equalsIgnoreCase("blau")){
								BlockFactory.CreateConfigLocation(loc, Var.cfg, Var.file, "KLUFT.blau.tower");
								p.sendMessage(Var.pr+"Der Block wurde gesetzt.");
							}
						}else{
							p.sendMessage(Var.error+"setblock <Tower> [Aram/Wald/Kluft] [id(1-11)] [Rot/Blau]");
							p.sendMessage(Var.error+"setblock <Nexus> [Aram/Wald/Kluft] [Rot/Blau]");
							p.sendMessage(Var.error+"setblock <Inhibitor> [Aram/Wald/Kluft] [id(1-3)] [Rot/Blau]");
						}
					}else{
						p.sendMessage(Var.error+"setblock <Tower> [Aram/Wald/Kluft] [id(1-11)] [Rot/Blau]");
						p.sendMessage(Var.error+"setblock <Nexus> [Aram/Wald/Kluft] [Rot/Blau]");
						p.sendMessage(Var.error+"setblock <Inhibitor> [Aram/Wald/Kluft] [id(1-3)] [Rot/Blau]");
					}
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
