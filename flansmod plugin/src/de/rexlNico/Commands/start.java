package de.rexlNico.Commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class start implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		
			if(sender.hasPermission("battle.start")){
				File file = new File("plugins/fmb/config.yml");
				YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				cfg.set("start", true);
				try {
					cfg.save(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		return false;
	}

}
