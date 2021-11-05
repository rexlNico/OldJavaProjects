package de.rexlNico.Mafia.Listeners;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.rexlNico.Mafia.Api.Var;
import de.rexlNico.Mafia.Main.Main;
import de.rexlNico.Mafia.objects.MafiaObj;
import de.rexlNico.Mafia.objects.RGB;

public class Join implements Listener{

	@EventHandler
	public void on(PlayerJoinEvent e){
		Player p = e.getPlayer();
		
		if(Var.cfgusers.contains(p.getUniqueId().toString())){

			String mafianame = Var.cfgusers.getString(p.getUniqueId().toString());
			ArrayList<String> mitglieder = (ArrayList<String>) Var.cfgmafia.getStringList(mafianame+".users");
			ArrayList<String> mafiosis = (ArrayList<String>) Var.cfgmafia.getStringList(mafianame+".mafiosis");
			
			if(Main.getInstance().getMafiaManager().getMafias().containsKey(mafianame) == false){
				Main.getInstance().getMafiaManager().getMafias().put(mafianame, new MafiaObj(mafianame, Var.cfgmafia.getString(mafianame+".kürzel"), new RGB(20, 20, 20), mitglieder, mafiosis, Var.cfgmafia.getString(mafianame+".boss")));
			}
			Var.playersMafia.put(p, mafianame);
		}
	}
	
}
