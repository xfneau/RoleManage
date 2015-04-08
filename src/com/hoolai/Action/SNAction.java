package com.hoolai.Action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hoolai.Service.SNService;
import com.opensymphony.xwork2.ActionSupport;

public class SNAction extends ActionSupport {

	private int id;
	private int sn_id;
	private String sn_name;
	private String img;
	private String level;
	private String jsonStr;
	Map snMap = new HashMap();
	private SNService snService = new SNService();
	private List<Map<String,String>> listSn = new ArrayList<Map<String,String>>();
	
	/**
	 * sn列表
	 */
	public String execute(){
		listSn = snService.getListSn();
//		System.out.println(listSn);
		return "success";
	}
	/**
	 * 新增
	 */
	public String newSn(){
		boolean b = false;
		try{
			snMap.put("sn_name", sn_name);
			snMap.put("img", img);
			snMap.put("level", level);
			b = snService.newSn(snMap);
		}catch(Exception e){
			e.printStackTrace();
		}
		jsonStr = "{id:"+b+"}";
		return "success";
	}
	
	/**
	 * sn修改
	 */
	public String editSn(){
		snMap.put("sn_id", sn_id);
		snMap.put("sn_name", sn_name);
		snMap.put("img", img);
		snMap.put("level", level);
		id = snService.updateSn(snMap);
		jsonStr = "{id:"+id+"}";
		System.out.println(jsonStr);
		return "success";
	}
	
	/**
	 * sn删除
	 */
	public String deleteSn(){
		try{
			snService.deleteSN(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "success";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSn_id() {
		return sn_id;
	}

	public void setSn_id(int sn_id) {
		this.sn_id = sn_id;
	}

	public String getSn_name() {
		return sn_name;
	}

	public void setSn_name(String sn_name) {
		this.sn_name = sn_name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public List<Map<String, String>> getListSn() {
		return listSn;
	}

	public void setListSn(List<Map<String, String>> listSn) {
		this.listSn = listSn;
	}
	public String getJsonStr() {
		return jsonStr;
	}
	public void setJsonStr(String jsonStr) {
		this.jsonStr = jsonStr;
	}
	
	
}
