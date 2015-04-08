package com.hoolai.Service;

import java.util.Map;

import com.hoolai.DaoImpl.GameImpl;

public class GameService {
	
	GameImpl gameImpl = new GameImpl();

	public void deleteGame(int gameid) {
		gameImpl.deleteGame(gameid);
		
	}

	public int newGame(Map gameMap) {
		
		return gameImpl.newGame(gameMap);
	}

	public int editGame(Map gameMap) {
		
		return gameImpl.editGame(gameMap);
	}

}
