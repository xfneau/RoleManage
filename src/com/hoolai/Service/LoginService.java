package com.hoolai.Service;

import com.hoolai.DaoImpl.LoginImpl;

public class LoginService {

	LoginImpl loginimpl = new LoginImpl();
	public Boolean loginCheck(String uname,String passwd){
		
		String sql="select * from user_admin where uname='"+uname+"' and passwd='"+passwd+"'";
		
		if( !loginimpl.logincheck(sql) ){
			return false;
		}
		
		return true;
	}
}
