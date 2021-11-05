package de.rexlNico.GAME.Methodes;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;

public class BlockFactory {

	public static void CreateConfigLocation(Location loc, YamlConfiguration cfg, File file, String path){
		
		cfg.set(path+".Welt", loc.getWorld().getName());
		cfg.set(path+".X", loc.getX());
		cfg.set(path+".Y", loc.getY());
		cfg.set(path+".Z", loc.getZ());
		
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Location getConfigLocation(String path, YamlConfiguration cfg){
		
		World welt = Bukkit.getWorld(cfg.getString(path+".Welt"));
		double x = cfg.getDouble(path+".X");
		double y = cfg.getDouble(path+".Y");
		double z = cfg.getDouble(path+".Z");
		
		return new Location(welt, x, y, z);
	}
	
}
