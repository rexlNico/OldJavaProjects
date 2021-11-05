package de.rexlNico.Main;

import de.rexlNico.Commands.Party;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin{

	@Override
	public void onEnable() {
		ProxyServer.getInstance().getPluginManager().registerCommand(this, new Party("party"));
		super.onEnable();
	}
	
}
