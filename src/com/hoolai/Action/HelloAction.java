package com.hoolai.Action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisShardInfo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.hoolai.Service.UserService;
import com.hoolai.Service.LoginService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport{
	
	private String uname="";
	private String passwd="";
	LoginService loginservice = new LoginService();
	public String execute(){
		
		if( loginservice.loginCheck(uname,passwd) ){
			 ActionContext.getContext().getSession().put(Content.USER_SESSION,uname); 
			return "success";
		}
		return "login";
	}
	public String index(){
//		System.out.println("11");
		return "success";
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public static void main( String args[]){
//        Jedis jedis = new Jedis("192.168.2.241",6379);
//        jedis.set("fu", "fu");
//        jedis.set("fu1", "fu1");
//        System.out.println(jedis.get("tw_appid_NzIujB"));
        Pattern pattern = Pattern.compile("^(http://|https://){1}.*");
        Matcher matcher = pattern.matcher("http://dsds//gfgffdfd>fdf");
	      System.out.println(matcher.matches());
		return;
	}

}
