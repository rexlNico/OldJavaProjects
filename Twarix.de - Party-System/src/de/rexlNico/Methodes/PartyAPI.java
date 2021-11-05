package de.rexlNico.Methodes;

import java.util.ArrayList;
import java.util.HashMap;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class PartyAPI {

//	                          LEADER                   partymembers
	public static HashMap<ProxiedPlayer, ArrayList<ProxiedPlayer>> partys = new HashMap<>();
//						who was invited  who has invited
	public static HashMap<ProxiedPlayer, ArrayList<ProxiedPlayer>> invites = new HashMap<>();
	public static ArrayList<ProxiedPlayer> inAParty = new ArrayList<>();
	
	@SuppressWarnings("deprecation")
	public static void invitePlayer(ProxiedPlayer leader, ProxiedPlayer invited){
		if(partys.containsKey(leader)){
			
		}else if(inAParty.contains(leader)){
			leader.sendMessage("§4Du bist kein Party Leader!");
			return;
		}
		if(hasAnInvite(invited, leader)){
			
			TextComponent msg1 = new TextComponent("§7Du wurdest von §6"+leader+"§7 in eine Party eingeladen.");
			TextComponent msg2 = new TextComponent("§aAnnehmen ");
			msg2.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/party accept "+leader));
			TextComponent msg3 = new TextComponent("§7oder ");
			TextComponent msg4 = new TextComponent("§cAblehnen");
			msg4.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/party deny "+leader));
			
			msg2.addExtra(msg3);
			msg2.addExtra(msg4);
			
			invited.sendMessage(msg1);
			invited.sendMessage(msg2);
			
			if(invites.containsKey(invited)){
			ArrayList<ProxiedPlayer> invite = invites.get(invited);
			invite.add(leader);
			invites.remove(invited);
			invites.put(invited, invite);
			}else{
				ArrayList<ProxiedPlayer> invite = new ArrayList<>();
				invite.add(leader);
				invites.put(invited, invite);
			}
			leader.sendMessage("§4Du hast §6"+invited.getName()+" §4in deine Party eingeladen.");
		}else{
			leader.sendMessage("§4Der Spieler hat bereits eine Einladung bekommen!");
		}
	}
	@SuppressWarnings({ "deprecation" })
	public static void leaveParty(ProxiedPlayer leader, ProxiedPlayer player){
		if(isInAParty(player)){
			
			
		}else{
			if(leader == player){
				player.sendMessage("§4Du bist in keiner Party!");
			}else{
				player.sendMessage("§4Der Spieler ist nicht in deiner Party!");
			}
		}
	}
	@SuppressWarnings("deprecation")
	public static void promotePlayer(ProxiedPlayer oldLeader, ProxiedPlayer newLeader){
		if(partys.containsKey(oldLeader)){
			if(oldLeader == newLeader){
				oldLeader.sendMessage("§4Du bist schon der Partyleiter!");
				return;
			}
			ArrayList<ProxiedPlayer> players = partys.get(oldLeader);
			partys.remove(oldLeader);
			partys.put(newLeader, players);
		}
	}
	@SuppressWarnings("deprecation")
	public static void acceptParty(ProxiedPlayer leader, ProxiedPlayer player){
		if(hasAnInvite(player, leader)){
			if(PartySize(leader) == 0){
				ArrayList<ProxiedPlayer> players = new ArrayList<>();
				players.add(player);
				players.add(leader);
				partys.put(leader, players);
			}else{
				ArrayList<ProxiedPlayer> players = partys.get(leader);
				players.add(player);
				partys.remove(leader);
				partys.put(leader, players);
			}
			player.sendMessage("§4Der Spieler §6"+ player.getName()+"§4ist deiner Party beigetreten.");
			leader.sendMessage("§4Du bist der Party von §6"+leader.getName()+" §4beigetreten.");
		}else{
			
		}
	}
	@SuppressWarnings("deprecation")
	public static void denyParty(ProxiedPlayer leader, ProxiedPlayer player){
		if(hasAnInvite(player, leader)){
			player.sendMessage("§4Der Spieler §6"+ player.getName()+"§4hat deine Partyeinladung abgelehnt");
			leader.sendMessage("§4Du hast die Partyeinladung von §6"+leader.getName()+" §4abgelehnt.");
		}else{
			
		}
	}
	public static ArrayList<ProxiedPlayer> PartyList(ProxiedPlayer player){
		for(int i = 0; i<inAParty.size(); i++){
			if(partys.containsKey(inAParty.get(i))){
				ArrayList<ProxiedPlayer> players = partys.get(inAParty.get(i));
				if(players.contains(player)){
					return players;
				}
			}
		}	
		return null;	
	}
	public static int PartySize(ProxiedPlayer player){
		for(int i = 0; i<inAParty.size(); i++){
			if(partys.containsKey(inAParty.get(i))){
				ArrayList<ProxiedPlayer> players = partys.get(inAParty.get(i));
				if(players.contains(player)){
					return players.size();
				}
			}
		}	
			return 0;
	}
	public static boolean isInAParty(ProxiedPlayer player){
		
		return inAParty.contains(player);
	}
	public static boolean hasAnInvite(ProxiedPlayer player, ProxiedPlayer fromWho){
		if(invites.containsKey(player)){
			ArrayList<ProxiedPlayer> invite = invites.get(player);
			invites.remove(player);
			invites.put(player, invite);
			for(int i = 0; i<invite.size(); i++){
				if(invite.get(i).equals(fromWho)){
					return false;
				}
			}
			return true;
		}else{
			ArrayList<ProxiedPlayer> invite = new ArrayList<>();
			invites.put(player, invite);
				return true;
		}
	}
	
	
}
