package com.hoolai.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hoolai.DaoImpl.ReportingHistoryImpl;

public class ReportingHistoryService {
	
	private List<Map<String, String>> listHistory = new ArrayList<Map<String, String>>();

	private ReportingHistoryImpl reportImpl = new ReportingHistoryImpl();
	
	public List<Map<String, String>> getListHistory(String reportName) {
		listHistory = reportImpl.getListHistory(reportName);
		
		return listHistory;
	}

	public void deleteRportHistory(String reportName) {
//		System.out.println("ReportingHistoryService:"+reportName);
		reportImpl.deleteReportHistory(reportName);
	}

}
