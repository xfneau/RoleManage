package com.hoolai.Action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.hoolai.Service.GroupService;
import com.opensymphony.xwork2.ActionSupport;

public class GroupAction extends ActionSupport{
	
	GroupService group = new GroupService();
	List<Map<String,String>> listGame=null;
	List<Map<String,String>> listSN=null;
	List<Map<String,String>> listGroup=null;
	List<Map<String,String>> groupOfGame=null;
	List<Map<String,String>> groupOfSN=null;
	private String groupName="";
	private int groupId;
	private String jsonStr="";
	private String groupJsonStr="";


	public String execute(){
		listGroup = group.selectAllGroup();
		return "success";
	}
	
	/**
	 * 删除组
	 * @return
	 */
	public String deleGroup(){
		String sql1="delete from tbl_group where group_id="+groupId;
		String sql2="delete from tbl_group_game_bind where group_id="+groupId;
		String sql3="delete from tbl_group_sn_bind where group_id="+groupId;
		group.insertGroup(sql1);
		group.insertGroup(sql2);
		group.insertGroup(sql3);
		return "success";
	}
	
	/**
	 * 编辑组
	 * @return
	 */
	public String editGroup(){//获取组群信息
//		System.out.println(groupId);
		listGame = group.selectAllGame();
		listSN = group.selectAllSN();
		groupName = group.selectGroupNameById(groupId);
		
		String group_SN = group.selectGroupSNById(groupId);//获取组的SN
		if(group_SN!=""){
			jsonStr = jsonStr+"[{'group_SN':'"+group_SN+"'";
		}else{
			jsonStr = jsonStr+"[{";
		}
				
		String group_Game = group.selectGroupGameById(groupId);//获取组的Game
		if(group_Game!=""){
			if(group_SN!=""){
				jsonStr=jsonStr+",";
			}
			jsonStr = jsonStr+"'group_Game':'"+group_Game+"'}]";
		}else{
			jsonStr = jsonStr+"}]";
		}
		
		//System.out.println(jsonStr);
//		jsonStr="[{'1','1''1'}]";
		return "success";
	}
	
	/**
	 * 新建组信息
	 * @return
	 */
	public String newGroup(){
		listGame = group.selectAllGame();
		listSN = group.selectAllSN();
		groupName = group.selectGroupNameById(groupId);
		return "success";
	}
	
	/**
	 * 新建组
	 * @return
	 */
	public String bulidGroup(){
		HttpServletRequest request = ServletActionContext.getRequest();
		//System.out.println(groupJsonStr);
		String groupJsonStr = request.getParameter("groupJsonStr");
		if(groupJsonStr!="" && groupJsonStr!=null){
			JSONArray json = JSONArray.fromObject(groupJsonStr);
			listGroup = group.selectAllGroup();
			int maxId = group.selectMaxId()+1;
			String sql = "insert into tbl_group(group_id,group_name) values ("+maxId+",'"+groupName+"')";
			group.insertGroup(sql);
			
				JSONObject object = (JSONObject)json.get(0);
				String group_sn = object.getString("groupsn");
				String group_game = object.getString("groupgame");
				
				String group_SN[];//更新tbl_group_sn_bind
				group_SN = group_sn.split(",");
//				for( int i = 0; i < group_SN.length; i++ ){
//					String sql1="insert into tbl_group_sn_bind(group_id,sn_id) values ("+maxId+","+Integer.parseInt(group_SN[i])+")";
					group.insertGroupSN( maxId,group_SN);
//				}
				
				String group_Game[];//更新tbl_group_game_bind
				group_Game = group_game.split(",");
//				for( int i = 0; i < group_Game.length; i++ ){
//					String sql2 = "insert into tbl_group_game_bind(group_id,game_id) values ("+maxId+","+Integer.parseInt(group_Game[i])+")";
					group.insertGroupGame(maxId,group_Game);
//				}

		}
		return "success";
	}
	
	/**
	 * 更新群组信息
	 * @return
	 */
	public String updateGroup(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String groupJsonStr = request.getParameter("groupJsonStr");
		if(groupJsonStr!="" && groupJsonStr!=null){
			JSONArray json = JSONArray.fromObject(groupJsonStr);
			listGroup = group.selectAllGroup();
			int maxId = group.selectMaxId()+1;
			String sql = "update tbl_group set group_name='"+groupName+"' where group_id="+groupId;
			 group.insertGroup(sql);
			//System.out.println(groupJsonStr);
				JSONObject object = (JSONObject)json.get(0);
				String group_sn = object.getString("groupsn");
				String group_game = object.getString("groupgame");
				
				String group_SN[];//更新tbl_group_sn_bind
				group_SN = group_sn.split(",");
				String sql3="delete from tbl_group_sn_bind where group_id="+groupId;
				group.insertGroup(sql3);
				
				if(!"".equals(group_SN[0]) ){
					group.insertGroupSN(groupId,group_SN);
				}
					
				
				String group_Game[];//更新tbl_group_game_bind
				group_Game = group_game.split(",");
				String sql4="delete from tbl_group_game_bind where group_id="+groupId;
				group.insertGroup(sql4);
				
				if(!"".equals(group_Game[0])){
					group.insertGroupGame(groupId,group_Game);
				}

		}
		return "success";
	}
	
	
	
	public List<Map<String, String>> getGroupOfGame() {
		return groupOfGame;
	}

	public void setGroupOfGame(List<Map<String, String>> groupOfGame) {
		this.groupOfGame = groupOfGame;
	}

	public List<Map<String, String>> getGroupOfSN() {
		return groupOfSN;
	}

	public void setGroupOfSN(List<Map<String, String>> groupOfSN) {
		this.groupOfSN = groupOfSN;
	}

	public List<Map<String, String>> getListGame() {
		return listGame;
	}
	
	public List<Map<String, String>> getListGroup() {
		return listGroup;
	}

	public void setListGroup(List<Map<String, String>> listGroup) {
		this.listGroup = listGroup;
	}

	public void setListGame(List<Map<String, String>> listGame) {
		this.listGame = listGame;
	}
	
	public List<Map<String, String>> getListSN() {
		return listSN;
	}
	
	public void setListSN(List<Map<String, String>> listSN) {
		this.listSN = listSN;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupJsonStr() {
		return groupJsonStr;
	}

	public void setGroupJsonStr(String groupJsonStr) {
		this.groupJsonStr = groupJsonStr;
	}

	public String getJsonStr() {
		return jsonStr;
	}

	public void setJsonStr(String jsonStr) {
		this.jsonStr = jsonStr;
	}

	

}
