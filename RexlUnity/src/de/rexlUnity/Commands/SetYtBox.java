package de.rexlUnity.Commands;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.rexlUnity.Methodes.Var;

public class SetYtBox implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if(sender instanceof Player){
			Player p = (Player)sender;
			if(p.hasPermission(Var.perm+"setytbox")){
				if(args.length == 2){
					if(args[1].equalsIgnoreCase("Button")){
						
						int id = Integer.valueOf(args[0]);
						
						Var.YTcfg.set(id+".Box.x", p.getEyeLocation().getX());
						Var.YTcfg.set(id+".Box.y", p.getEyeLocation().getY());
						Var.YTcfg.set(id+".Box.z", p.getEyeLocation().getZ());
						Var.YTcfg.set(id+".Box.w", p.getLocation().getWorld());
						
						try {
							Var.YTcfg.save(Var.YTcfgfile);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						int y = (int) p.getEyeLocation().getY() -1;
						int z = (int) p.getEyeLocation().getZ();
						int x = (int) p.getEyeLocation().getX();
						
						if(Bukkit.getWorld("world").getBlockAt(x,y,z).getState() instanceof Sign){
							Sign s = (Sign) Bukkit.getWorld("world").getBlockAt(x,y,z).getState();
							if(s.getLine(2).equalsIgnoreCase("")){
								s.setLine(2, "§0"+id);
								s.update();
							}
						}
						p.sendMessage(Var.pr+"§7der Button der Youtuber Box §a"+id+" §7wurde erfolgreich gesetzt.");
						
						
					}else if(args[1].equalsIgnoreCase("Spawn")){
						
						int id = Integer.valueOf(args[0]);
						
						Var.YTcfg.set(id+".Box.tp.x", p.getLocation().getX());
						Var.YTcfg.set(id+".Box.tp.y", p.getLocation().getY());
						Var.YTcfg.set(id+".Box.tp.z", p.getLocation().getZ());
						Var.YTcfg.set(id+".Box.tp.Yaw", p.getLocation().getYaw());
						Var.YTcfg.set(id+".Box.tp.Pitch", p.getLocation().getPitch());
						
						try {
							Var.YTcfg.save(Var.YTcfgfile);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						p.sendMessage(Var.pr+"§7der Spawn der Youtuber Box §a"+id+" §7wurde erfolgreich gesetzt.");
						
					}else{
						p.sendMessage(Var.error+"setjtbox <ID> [Button/Spawn]");
					}
				}else{
					p.sendMessage(Var.error+"setjtbox <ID> [Button/Spawn]");
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
