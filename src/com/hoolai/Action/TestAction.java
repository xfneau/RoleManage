package com.hoolai.Action;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.hoolai.Service.TestService;
import com.opensymphony.xwork2.ActionSupport;

//import org.apache.commons.codec.binary.Hex;

public class TestAction extends ActionSupport {  

	private String username;
	
	public String execute(){
		try {
			Thread.sleep(5000);
			System.out.println(username+":"+TestService.num++);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "success";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}  