package com.saba.report;

import java.util.List;

import org.testng.annotations.Test;

import com.saba.report.Report;
import com.saba.report.ReportColumn;
import com.saba.report.ReportEngine;
import com.saba.report.ReportEngineImpl;
import com.saba.report.ReportRow;

public class TestReport {
	
	@Test
	public void testExistingReport(){
	
	String reportId = "";
	
	ReportEngine reportEngine = new ReportEngineImpl();
	Report report = reportEngine.runReport(reportId);
	
	
	List<ReportColumn> reportColumns = report.getAllColumns();
	List<ReportRow> reportRows = report.getAllRows();
	
	for(ReportColumn reportColumn:reportColumns){
		System.out.println(reportColumn.getColumnName());
	}
	
	for(ReportRow reportRow:reportRows){
		for(ReportColumn reportColumn:reportColumns){
			System.out.print(reportRow.getData(reportColumn));
		}
		System.out.println();
	}
}
}
