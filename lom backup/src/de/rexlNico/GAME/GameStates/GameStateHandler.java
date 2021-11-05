package de.rexlNico.GAME.GameStates;

import java.util.ArrayList;

public class GameStateHandler {

	private static GameState current;
	private static ArrayList<GameState> state = new ArrayList<>();
	
	public GameStateHandler(){
		state.add(new LobbyState());
		state.add(new IngameState());
		state.add(new EndState());
	}
	
	public static void setGameState(int id){
		if(current != null) current.end();
		current = state.get(id);
		current.init();
	}
	
	public static GameState getGamestate(){
		return current;
	}
	
}
