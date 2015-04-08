package com.hoolai.Action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hoolai.Service.ReportingHistoryService;
import com.opensymphony.xwork2.ActionSupport;

public class ReportingHistoryAction extends ActionSupport {

	private List<Map<String, String>> listHistory = new ArrayList<Map<String, String>>();

	private ReportingHistoryService reportService = new ReportingHistoryService();
	
	private String reportName;

	private String jsonStr;
	
	public String execute() {
		
		return "success";
	}

	public String getQueryList() {
		listHistory = reportService.getListHistory(reportName);
		if( listHistory == null ){
			jsonStr = "{\"status\":\"error\"}";
		}else{
			jsonStr = "{\"status\":\"ok\"}";
		}
		return "success";
	}

	public String deleteReportHistory(){
//		System.out.println("ReportingHistoryAction:"+reportName);
		reportService.deleteRportHistory(reportName);
		return "success";
	}
	
	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getResult() {
		return jsonStr;
	}

	public void setResult(String result) {
		this.jsonStr = result;
	}

	public List<Map<String, String>> getListHistory() {
		return listHistory;
	}

	public void setListHistory(List<Map<String, String>> listHistory) {
		this.listHistory = listHistory;
	}

	public String getJsonStr() {
		return jsonStr;
	}

	public void setJsonStr(String jsonStr) {
		this.jsonStr = jsonStr;
	}
	
	
}
