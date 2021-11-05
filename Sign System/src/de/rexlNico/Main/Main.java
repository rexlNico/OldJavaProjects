package de.rexlNico.Main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.rexlNico.Api.SignApi;
import de.rexlNico.Commands.AddSign;
import de.rexlNico.Listeners.JoinServer;

public class Main extends JavaPlugin{

	private int TaskID;
	private int state = 0;
	public static Main plugin;
	private PluginManager pm = Bukkit.getPluginManager();
	
	@SuppressWarnings("deprecation")
	@Override
	public void onEnable() {
		plugin = this;
		Bukkit.getConsoleSender().sendMessage("§eSign System §aAktiviert!");
		this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		
		getCommand("addSign").setExecutor(new AddSign());
		getCommand("removeSign").setExecutor(new AddSign());
		pm.registerEvents(new JoinServer(), this);
		
		TaskID = Bukkit.getScheduler().scheduleAsyncRepeatingTask(this, new Runnable() {
			
			@Override
			public void run() {
				
				if(state == 3){
					state = 1;
				}else{
					state++;
				}
				SignApi.updateServer(state);
				
			}
		}, 0, 20);
	}
	
	public static Main getInstance(){
		return plugin;
	}
	
	public static String prefix = "§brexlNico.de §8● §7",
			noperm = prefix+"§4Dazu hast du keine Rechte!",
			console = prefix+"§4Das kannst du nur als Spieler!";
	
}
