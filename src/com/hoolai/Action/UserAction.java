package com.hoolai.Action;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.hoolai.Service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{

	UserService userservice = new UserService();
	private List<Map<String,String>> userlist=null;
	private Map<String,String> userinfo=null;
	public List<Map<String,String>> groupofuser=null;
	public List<Map<String,String>> listGroup=null;
	private String username="";
	private String userid;
	private String email;
	private String realname;
	private String jsonStr="";
	private String userJsonStr="";

	public String execute(){
		//System.out.println("111");
		userlist = userservice.selectAllUser();
		return "success";
	}

	/**
	 * 提取user信息
	 * @return
	 */
	public String editUser(){
		//System.out.println(userid+"  "+username);
		userinfo = userservice.selectUserById(Integer.parseInt(userid));
		listGroup = userservice.selectAllGroup();
		jsonStr = userservice.selectRole_id(Integer.parseInt(userid));
		jsonStr = jsonStr.substring(1, jsonStr.length()-1);
		jsonStr = "[{'role_id':'"+jsonStr+"'}]";
//		System.out.println(jsonStr);
		return "success";
	}
	
	/**
	 * 跟新user信息
	 * @return
	 */
	public String updateUser(){
		//System.out.println(username+"    "+userid+"    "+email+"    "+realname+"  "+jsonStr);
		JSONArray json = JSONArray.fromObject(jsonStr);
		JSONObject role_id = (JSONObject) json.get(0);
		String groupofuser = role_id.getString("groupofuser");
		if( "".equals(groupofuser) ){
			return "success";
		}
		groupofuser = ","+groupofuser+",";
		String sql="update user set username='"+username+"',email='"+email+"',role_id='"+groupofuser+"',realname='"+realname+"' where userid='"+userid+"'";
		userservice.updateUser(sql);
		return "success";
	}

	/**
	 * 新建user
	 * @return
	 */
	public String bulidUser(){
		JSONArray json = JSONArray.fromObject(jsonStr);
		JSONObject role_id = (JSONObject) json.get(0);
		String groupofuser = role_id.getString("groupofuser");
		if( "".equals(groupofuser) ){
			return "success";
		}
		groupofuser = ","+groupofuser+",";
		int maxId = userservice.selectMaxId()+1;
		String sql="insert into user (userid,username,password,email,role_id,last_login,realname,init_pwd,exclude) " +
					"values ('"+maxId+"','"+username+"','"+username+"','"+email+"','"+groupofuser+"',date_format(now(),'%Y-%m-%d'),'"+realname+"','1','')";
		userservice.updateUser(sql);
//		System.out.println(sql);
		return "success";
	}
	
	/**
	 * 跳转新建页面
	 * @return
	 */
	public String newUser(){
		listGroup = userservice.selectAllGroup();
		return "success";
	}
	
	/**
	 * 删除用户
	 * @return
	 */
	public String deleUser(){
		String sql="delete from user where userid='"+userid+"'";
		userservice.updateUser(sql);
		return "success";
	}
	
	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}

	public List<Map<String, String>> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<Map<String, String>> userlist) {
		this.userlist = userlist;
	}

	public List<Map<String, String>> getGroupofuser() {
		return groupofuser;
	}

	public void setGroupofuser(List<Map<String, String>> groupofuser) {
		this.groupofuser = groupofuser;
	}

	public List<Map<String, String>> getListGroup() {
		return listGroup;
	}

	public void setListGroup(List<Map<String, String>> listGroup) {
		this.listGroup = listGroup;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getJsonStr() {
		return jsonStr;
	}

	public void setJsonStr(String jsonStr) {
		this.jsonStr = jsonStr;
	}

	public String getUserJsonStr() {
		return userJsonStr;
	}

	public void setUserJsonStr(String userJsonStr) {
		this.userJsonStr = userJsonStr;
	}

	public Map<String, String> getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Map<String, String> userinfo) {
		this.userinfo = userinfo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}
	
	
	
	
	
}
