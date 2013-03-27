package com.saba.report;

import java.util.List;

public interface Report {

	List<ReportColumn> getAllColumns();

	List<ReportRow> getAllRows();

}
