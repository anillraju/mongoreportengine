package com.saba.report;

//~--- JDK imports ------------------------------------------------------------

import java.util.List;

public interface ReportMetaData {
    public List<ReportFilter> getFilters();

    public List<ReportColumn> getColumns();
}
