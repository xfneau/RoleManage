package com.hoolai.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hoolai.DaoImpl.GroupImpl;

public class GroupService {
	
	GroupImpl group = new GroupImpl();
	
	/**
	 * 选择游戏
	 * @return
	 */
	public List<Map<String,String>> selectAllGame(){
		List<Map<String,String>> list=null;
		
		String sql="";
		sql = "select * from d_game";
		list = group.selectAllGame(sql);
		return list;
	}
	
	/**
	 * 选择SN
	 * @return
	 */
	public List<Map<String,String>> selectAllSN(){
		List<Map<String,String>> list=null;
		String sql="";
		sql="select * from d_network";
		list = group.selectAllSN(sql);
		return list;
	}

	/**
	 *选择群组
	 */
	public List<Map<String,String>> selectAllGroup(){
		
		List<Map<String,String>> list=null;
		String sql="";
		sql="select * from tbl_group";
		list = group.selectAllGroup(sql);
		return list;
	}
	/**
	 * 所有用户
	 */
	public List<Map<String,String>> selectAllUser(){
		
		List<Map<String,String>> list=null;
		String sql="";
		sql="select * from tbl_group";
		list = group.selectAllGroup(sql);
		return list;
	}

	/**
	 * 查找组名称
	 * @param groupId
	 * @return
	 */
	public String selectGroupNameById(int groupId) {
		String name="";
		String sql="select group_name from tbl_group where group_id="+groupId;
		name = group.selectGroupNameById(sql);
		return name;
	}

	/**
	 * 查找最大id
	 * @return
	 */
	public int selectMaxId() {
		String sql="";
		sql = "select * from tbl_group where group_id=(select MAX(group_id) from tbl_group)";
		int maxId = group.selectMaxId(sql);
		return maxId;
		
	}
	
	/**
	 * 新增群组
	 */	
	 public Boolean insertGroup(String sql){
		 return group.insertGroup(sql);
	 }

	 /**
	  * 查找出组对应的SN
	  * @param groupId
	  * @return
	  */
	public String selectGroupSNById(int groupId) {
		String str=null;
		String sql=null;
		sql="select * from tbl_group_sn_bind where group_id="+groupId;
		str = group.selectGroupSNById(sql);
		if(str!="")
		str = str.substring(0, str.length()-1);
		return str;
	}

	public String selectGroupGameById(int groupId) {
		String str=null;
		String sql=null;
		sql="select * from tbl_group_game_bind where group_id="+groupId;
		str = group.selectGroupGameById(sql);
		if(str!="")
		str = str.substring(0, str.length()-1);
		return str;
	}

	public void insertGroupSN(int maxId, String[] group_SN) {
		group.insertGroupSN(maxId,group_SN);
		
	}

	public void insertGroupGame(int maxId, String[] group_Game) {
		group.insertGroupGame(maxId,group_Game);
		
	}

}
