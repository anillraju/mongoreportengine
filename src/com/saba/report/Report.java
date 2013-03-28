package com.saba.report;

//~--- JDK imports ------------------------------------------------------------

import java.util.List;

public interface Report {
    List<ReportColumn> getAllColumns();

    ReportRow getNextRow();

    void setReportMetaData(ReportMetaData reportMetaData);
}
