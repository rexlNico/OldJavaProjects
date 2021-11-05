package de.rexlUnity.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import de.rexlUnity.Methodes.Factory;
import de.rexlUnity.Methodes.Var;

public class JumpAndRunnSigns implements Listener{
	
	@EventHandler
	public void on(SignChangeEvent e){
		Player p = e.getPlayer();
		if(e.getLine(0).equalsIgnoreCase("Jump")){
			if(!e.getLine(1).equalsIgnoreCase("")){
				e.setLine(0,"§0- §bJampAndRon §0-");
				e.setLine(1, "§7"+e.getLine(1));
			}else{
				e.getBlock().breakNaturally();
				p.sendMessage(Var.pr+"§cSchreibe in zeile §42 §cein Jump namen.");
			}
		}
	}
	
	
	@EventHandler
	public void onSignClick(PlayerInteractEvent e){
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			if(e.getClickedBlock().getState() instanceof Sign){
				Player p = e.getPlayer();
				Sign s = (Sign) e.getClickedBlock().getState();
					p.teleport(Factory.getConfigLocation("jump."+s.getLine(1).replaceAll("§7", ""), Var.Fcfg));
					p.sendMessage(Var.pr+"§7Du wurdest zu §a"+s.getLine(1).replaceAll("§7", "")+"§7 teleportiert");
			}
		}
	}	
}
