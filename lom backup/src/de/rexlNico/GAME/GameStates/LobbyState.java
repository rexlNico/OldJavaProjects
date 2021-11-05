package de.rexlNico.GAME.GameStates;

import de.rexlNico.GAME.Methodes.countdowns.LobbyCountdown;

public class LobbyState extends GameState {

	public static final int MIN_PLAYERS = 1,
			MAX_PLAYERS = 10;
	
	private LobbyCountdown countdown;
	
	@Override
	public void init() {
		countdown = new LobbyCountdown();
		
	}

	@Override
	public void end() {
		
	}

	public LobbyCountdown getCountdown(){
		return countdown;
		
	}
	
	
}
