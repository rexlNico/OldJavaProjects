package de.rexlNico.Commands;

import de.rexlNico.Methodes.PartyAPI;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Party extends Command{

	public Party(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		if(sender instanceof ProxiedPlayer){
			ProxiedPlayer p = (ProxiedPlayer) sender;
			if(args.length == 1){
				
				if(args[0].equalsIgnoreCase("list")){
					if(PartyAPI.PartyList(p) == null){
						p.sendMessage("§4Du bist in keiner Party!");
						return;
					}
					String s = "";
					if(p.hasPermission("party.size.8")){
						s = "§4PartyList §e"+PartyAPI.PartySize(p)+"§4/§e8§8:§6";
					}else if(p.hasPermission("party.size.12")){
						s = "§4PartyList §e"+PartyAPI.PartySize(p)+"§4/§e8§12:§6";
					}else if(p.hasPermission("party.size.16")){
						s = "§4PartyList §e"+PartyAPI.PartySize(p)+"§4/§e8§16:§6";
					}else{
						s = "§4PartyList §e"+PartyAPI.PartySize(p)+"§4/§e8§4:§6";
					}
						
					for(int i = 0; i<PartyAPI.PartyList(p).size(); i++){
						if(i == PartyAPI.PartyList(p).size()){
							s = s+" "+PartyAPI.PartyList(p).get(i);
						}else{
							s = s+" "+PartyAPI.PartyList(p).get(i)+",";
						}
					}
					p.sendMessage(s);
				}else if(args[0].equalsIgnoreCase("leave")){
					
				}else{
					p.sendMessage(" ");
					p.sendMessage("§8------§5Party §eHilfe§8------");
					p.sendMessage("§c/Party invite <NAME>");
					p.sendMessage("§c/Party kick <NAME>");
					p.sendMessage("§c/Party promote <NAME>");
					p.sendMessage("§c/Party accept <NAME>");
					p.sendMessage("§c/Party deny <NAME>");
					p.sendMessage("§c/Party leave");
					p.sendMessage("§c/Party list");
					p.sendMessage("§8-----------------------------");
					p.sendMessage(" ");
				}
				
			}else if(args.length == 2){
				if(args[0].equalsIgnoreCase("invite")){
					ProxiedPlayer pp = BungeeCord.getInstance().getPlayer(args[1]);
					if(pp == null){
						p.sendMessage("§4Der Spieler ist nicht online");
					}else{
						if(!pp.isConnected()){
							p.sendMessage("§4Der Spieler ist nicht online");
							return;
						}
						PartyAPI.invitePlayer(p, pp);
					}
				}else if(args[0].equalsIgnoreCase("kick")){
					
				}else if(args[0].equalsIgnoreCase("promote")){
					ProxiedPlayer pp = BungeeCord.getInstance().getPlayer(args[1]);
					if(pp == null){
						p.sendMessage("§4Der Spieler ist nicht online");
					}else{
						if(pp.isConnected()){
							PartyAPI.promotePlayer(p, pp);
						}else{
							p.sendMessage("§4Der Spieler ist nicht online");
						}
					}
				}else if(args[0].equalsIgnoreCase("accept")){
					ProxiedPlayer pp = BungeeCord.getInstance().getPlayer(args[1]);
					if(pp == null){
						p.sendMessage("§4Der Spieler ist nicht online");
					}else{
						if(pp.isConnected()){
							PartyAPI.acceptParty(p, pp);
						}else{
							p.sendMessage("§4Der Spieler ist nicht online");
						}
					}
				}else if(args[0].equalsIgnoreCase("deny")){
					ProxiedPlayer pp = BungeeCord.getInstance().getPlayer(args[1]);
					if(pp == null){
						p.sendMessage("§4Der Spieler ist nicht online");
					}else{
						if(pp.isConnected()){
							PartyAPI.denyParty(p, pp);
						}else{
							p.sendMessage("§4Der Spieler ist nicht online");
						}
					}
				}else{
					p.sendMessage(" ");
					p.sendMessage("§8------§5Party §eHilfe§8------");
					p.sendMessage("§c/Party invite <NAME>");
					p.sendMessage("§c/Party kick <NAME>");
					p.sendMessage("§c/Party promote <NAME>");
					p.sendMessage("§c/Party accept <NAME>");
					p.sendMessage("§c/Party deny <NAME>");
					p.sendMessage("§c/Party leave");
					p.sendMessage("§c/Party list");
					p.sendMessage("§8-----------------------------");
					p.sendMessage(" ");
				}
				
				
			}else{
				p.sendMessage(" ");
				p.sendMessage("§8------§5Party §eHilfe§8------");
				p.sendMessage("§c/Party invite <NAME>");
				p.sendMessage("§c/Party kick <NAME>");
				p.sendMessage("§c/Party promote <NAME>");
				p.sendMessage("§c/Party accept <NAME>");
				p.sendMessage("§c/Party deny <NAME>");
				p.sendMessage("§c/Party leave");
				p.sendMessage("§c/Party list");
				p.sendMessage("§8-----------------------------");
				p.sendMessage(" ");
			}
		}else{
			sender.sendMessage("§4Du bist kein Spieler!");
		}
	}
	
	

}

//   /party invite <NAME> ok
//	 /party kick <NAME> ok
//	 /party promote <NAME> ok
//	 /party leave ok
//	 /party list 
//	 /party accept <NAME> ok
//	 /party deny <NAME> ok
//