package com.hoolai.Action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hoolai.Service.GameService;
import com.hoolai.Service.GroupService;
import com.opensymphony.xwork2.ActionSupport;

public class GameAction extends ActionSupport {
	
	private int gameid;
	private String gamename;
	private String gameimg;
	private String gamelevel;
	private String gamealias;
	private String jsonStr;
	List<Map<String,String>> listGame = null;
	Map gameMap = new HashMap();
	GameService gameService = new GameService();
	
	GroupService group = new GroupService();
	
	/**
	 * 游戏列表
	 */
	public String execute(){
		listGame = group.selectAllGame();
		return "success";
	}
	
	/**
	 * 新建游戏
	 * @return
	 */
	public String newGame(){
		gameMap.put("gamename", gamename);
		gameMap.put("gameimg", gameimg);
		gameMap.put("gamelevel", gamelevel);
		gameMap.put("gamealias", gamealias);
		int id = gameService.newGame(gameMap);
		jsonStr = "{id:"+id+"}";
		return "success";
	}
	
	/**
	 * 编辑游戏
	 * @return
	 */
	public String editGame(){
		gameMap.put("gameid", gameid);
		gameMap.put("gamename", gamename);
		gameMap.put("gameimg", gameimg);
		gameMap.put("gamelevel", gamelevel);
		gameMap.put("gamealias", gamealias);System.out.println(jsonStr);
		int id = gameService.editGame(gameMap);
		jsonStr = "{id:"+id+"}";
		
		return "success";
	}
	
	/**
	 * 删除游戏
	 * @return
	 */
	public String deleteGame(){
		gameService.deleteGame(gameid);
		return "success";
	}
	
	
	
	public String getGamename() {
		return gamename;
	}
	public void setGamename(String gamename) {
		this.gamename = gamename;
	}
	public String getGameimg() {
		return gameimg;
	}
	public void setGameimg(String gameimg) {
		this.gameimg = gameimg;
	}
	public String getGamelevel() {
		return gamelevel;
	}
	public void setGamelevel(String gamelevel) {
		this.gamelevel = gamelevel;
	}
	public String getGamealias() {
		return gamealias;
	}
	public void setGamealias(String gamealias) {
		this.gamealias = gamealias;
	}

	public List<Map<String, String>> getListGame() {
		return listGame;
	}

	public void setListGame(List<Map<String, String>> listGame) {
		this.listGame = listGame;
	}

	public int getGameid() {
		return gameid;
	}

	public void setGameid(int gameid) {
		this.gameid = gameid;
	}

	public String getJsonStr() {
		return jsonStr;
	}

	public void setJsonStr(String jsonStr) {
		this.jsonStr = jsonStr;
	}
	
	
	
	
	
	

}
