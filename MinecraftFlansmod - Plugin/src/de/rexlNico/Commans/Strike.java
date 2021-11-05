package de.rexlNico.Commans;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.rexlNico.methodes.Var;

public class Strike implements CommandExecutor{

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if(sender instanceof Player){
			Player p = (Player)sender;
			if(p.hasPermission("flansBattle.setstrike")){
				if(args.length == 1){
					Player t = Bukkit.getPlayer(args[0]);
					if(t != null){

						Var.cfg.set(t.getName()+".strike", Var.cfg.getInt(t.getName()+".strike")+1);
						try {
							Var.cfg.save(Var.file);
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						p.sendMessage("§cDu hase dem Spieler §b"+t.getName()+" §cden §e"+Var.cfg.getInt(t.getName()+".strike.int")+". §cStrike gegeben.");
						
						int i = Var.cfg.getInt(t.getName()+".strike.int");
						
						p.sendMessage("§4Du hast nun §e"+i+" §4Strikes");
						
						if(i == 3){
							p.getInventory().clear();
						}else if(i == 4){
							p.setBanned(true);
							p.kickPlayer("");
							Var.cfg.set(p.getName()+".strike.bantime", 300);
							try {
								Var.cfg.save(Var.file);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}else if(i == 5){
							p.setBanned(true);
							p.kickPlayer("");
							Var.cfg.set(p.getName()+".strike.bantime", 1800);
							try {
								Var.cfg.save(Var.file);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}else if(i == 6){
							p.setBanned(true);
							p.kickPlayer("");
							Var.cfg.set(p.getName()+".strike.bantime", 86400);
							try {
								Var.cfg.save(Var.file);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}else if(i == 7){
							p.setBanned(true);
							p.kickPlayer("");
						}
						
					}else{
						p.sendMessage("§cder Spieler "+t.getName()+" ist nicht online.");
					}
				}else{
					p.sendMessage("§cstrike <Name>");
				}
			}
		}
		return false;
	}

}
