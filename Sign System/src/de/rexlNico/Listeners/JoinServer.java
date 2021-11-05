package de.rexlNico.Listeners;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import de.rexlNico.Api.Server;
import de.rexlNico.Api.SignApi;
import de.rexlNico.Commands.AddSign;
import de.rexlNico.Main.Main;

public class JoinServer implements Listener{

	@EventHandler
	public void on(PlayerInteractEvent e){
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			if(e.getClickedBlock().getState() instanceof Sign){
				List<String> list = AddSign.cfg.getStringList("AllServer");
				for(int i = 0; i< list.size(); i++){
					Sign s = SignApi.getSign(AddSign.cfg, list.get(i));
					if(s.getBlock().getLocation().equals(e.getClickedBlock().getLocation())){
						ByteArrayDataOutput out = ByteStreams.newDataOutput();
						Server server = new Server(SignApi.getIp(list.get(i)), SignApi.getPort(list.get(i)));
						server.ping();
						if(!server.getOnline()){
							return;
						}
						if(server.getOnlineplayers() == server.getMaxplayers()){
							return;
						}
						e.getPlayer().sendMessage("§cVerbinden...");
						out.writeUTF("Connect");
						out.writeUTF(s.getLine(1).replace("- ", "").replace(" -", ""));
						e.getPlayer().sendPluginMessage(Main.getInstance(), "BungeeCord", out.toByteArray());
						return;
					}
				}
			}
		}
	}
}
