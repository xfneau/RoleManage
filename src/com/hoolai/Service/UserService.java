package com.hoolai.Service;

import java.util.List;
import java.util.Map;

import com.hoolai.DaoImpl.UserImpl;

public class UserService {

	UserImpl userimpl = new UserImpl();
	
	/**
	 * 选择所有用户
	 * @return
	 */
	public List<Map<String,String>> selectAllUser(){
		List<Map<String,String>> list=null;
		String sql="";
		sql = "select * from user";
		list = userimpl.selectAllUser(sql);
		return list;
	}
	
	/**
	 * 查找用户信息
	 * @param groupId
	 * @return
	 */
	public Map<String,String> selectUserById(int userId) {
		String name="";
		Map<String,String> list = null;
		String sql="select * from user where userid="+userId;
		list = userimpl.selectUserNameById(sql);
		return list;
	}

	/**
	 * 选择所有群组
	 * @return
	 */
	public List<Map<String, String>> selectAllGroup() {
		 List<Map<String, String>> list;
		 String sql="select * from tbl_group";
		list = userimpl.selectAllGroup(sql);
		return list;
	}

	public String selectRole_id(int userid) {
		String str="";
		String sql="select * from user where userid="+userid;
		str = userimpl.selectRole_id(sql);
		return str;
	}

	/**
	 * 更新user表
	 */
	public void updateUser(String sql){
		userimpl.updateUser(sql);
	}

	/**
	 * 查找最大ID
	 * @return
	 */
	public int selectMaxId() {
		String sql = "select* from user where userid=(select max(userid) from user)";
		
		return userimpl.selectMaxId(sql);
		
	}
	
	
}
