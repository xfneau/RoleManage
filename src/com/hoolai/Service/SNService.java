package com.hoolai.Service;

import java.util.List;
import java.util.Map;

import com.hoolai.DaoImpl.GroupImpl;
import com.hoolai.DaoImpl.SNImpl;

public class SNService {

	private SNImpl snImpl = new SNImpl();
	private GroupImpl groupImpl = new GroupImpl();
	
	public List<Map<String, String>> getListSn() {
		String sql = "select * from d_network";
		return groupImpl.selectAllSN(sql);
	}

	public int updateSn(Map snMap) {
		String sql = "update d_network set sn_name='"+snMap.get("sn_name")+"', "
				+ "img='"+snMap.get("img")+"',level="+snMap.get("level")+
				" where sn_id="+snMap.get("sn_id");
		System.out.println(sql);
		return snImpl.updateSn(sql);
	}

	public void deleteSN(int id) {
		String sql = "delete from d_network where sn_id="+id;
		System.out.println(sql);
		snImpl.deleteSN(sql,id);
	}

	public boolean newSn(Map snMap) {
		String sql = "insert into d_network(sn_id,sn_name,img,level) values(1,'"+snMap.get("sn_name")+"'"
				+ ",'"+snMap.get("img")+"',"+snMap.get("level")+")";
		System.out.println(sql);
		return snImpl.newSn(sql);
	}

}
