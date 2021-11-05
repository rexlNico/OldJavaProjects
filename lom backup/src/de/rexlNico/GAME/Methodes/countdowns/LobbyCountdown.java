package de.rexlNico.GAME.Methodes.countdowns;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import de.rexlNico.GAME.GameStates.GameState;
import de.rexlNico.GAME.GameStates.GameStateHandler;
import de.rexlNico.GAME.GameStates.LobbyState;
import de.rexlNico.GAME.Main.Main;
import de.rexlNico.GAME.Methodes.Var;

public class LobbyCountdown extends Countdown{

	private int sec = 30;
	private int taskID, idlID;
	public static boolean isRunning = false, isIdelind = false;
	
	@Override
	public void start() {	
		isRunning = true;
		
		taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
			
			@Override
			public void run() {
				sec--;
				for(Player a : Var.playing){
					a.setLevel(sec);
				}
				
				switch (sec) {
				case 20: case 10: case 15: case 5: case 4: case 3: case 2:
					Bukkit.broadcastMessage(Var.pr+"Das Spiel startet in §b"+sec+" §7sekunden.");
					for(Player a : Var.playing){
						a.playSound(a.getLocation(), Sound.LAVA_POP, 1, 1);
					}
					break;

				case 1:
					Bukkit.broadcastMessage(Var.pr+"Das Spiel startet in §beiner §7sekunde.");
					for(Player a : Var.playing){
						a.playSound(a.getLocation(), Sound.LAVA_POP, 1, 1);
					}
					break;
					
				case 0:
					for(Player a : Var.playing){
						a.playSound(a.getLocation(), Sound.ENDERMAN_TELEPORT, 1, 1);
					}
					GameStateHandler.setGameState(GameState.INGAME_STATE);
					stop();
					break;
				default:
					break;
				}
				
				switch (sec) {
				case 9:
					
					for(Player a:Var.playing){
						a.getInventory().clear(4);
						if(a.getInventory().getName().equals("§bMap Wahl")){
							a.closeInventory();
						}
					}
					
					int i = Var.aram.size();
					Var.Map = "ARAM";
					if(i < Var.wald.size()){
						i = Var.wald.size();
						Var.Map = "WALD";
					}
					if(i < Var.kluft.size()){
						i = Var.kluft.size();
						Var.Map = "KLUFT";
					}
					
					String Mapname = "";
					
					if(Var.Map == "KLUFT"){
						Mapname = "Kluft der Beschwörer";
					}else if(Var.Map == "WALD"){
						Mapname = "Gewundener Wald";
					}else if(Var.Map == "ARAM"){
						Mapname = "Aram";
					}
					
					Bukkit.broadcastMessage("§8------------");
					Bukkit.broadcastMessage("§8            ");
					Bukkit.broadcastMessage("§cMap§8: §e"+Mapname);
					Bukkit.broadcastMessage("§8            ");
					Bukkit.broadcastMessage("§eMap by PxBTV");
					Bukkit.broadcastMessage("§8            ");
					Bukkit.broadcastMessage("§8------------");
					break;
				}
				
			}
		}, 0, 20*1);
	}
	
	public void idle(){
		isIdelind = true;
		idlID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
			
			@Override
			public void run() {
			
				int missing = LobbyState.MIN_PLAYERS - Var.playing.size();
				Bukkit.broadcastMessage(Var.pr+"§cZum Start fehlen noch §b"+missing+"§c Spieler.");
				
			}
		}, 0, 20*30);
	}

	public void stopIdle(){
		if(isIdelind){
			isIdelind = false;
			Bukkit.getScheduler().cancelTask(idlID);
		}
	}
	public void stopCountDown(){
		if(isRunning){
			isRunning = false;
			Bukkit.getScheduler().cancelTask(taskID);
			sec = 60;
		}
	}
	
	public void setSec(int Sec){
		this.sec = Sec;
	}
	
	public int getSec(){
		return sec;
	}
	
	@Override
	public void stop() {
		isIdelind = false;
		isRunning = false;
		Bukkit.getScheduler().cancelTask(taskID);
		Bukkit.getScheduler().cancelTask(idlID);
		sec = 30;
	}

}
