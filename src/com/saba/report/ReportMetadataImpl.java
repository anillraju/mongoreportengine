package com.saba.report;

//~--- JDK imports ------------------------------------------------------------

import java.util.ArrayList;
import java.util.List;

public class ReportMetadataImpl implements ReportMetaData {
    public ReportMetadataImpl(String reportId) {}

    @Override
    public List<ReportFilter> getFilters() {
        List<ReportFilter> f  = new ArrayList<ReportFilter>();
        FilterCondition    f1 = new FilterCondition();

        f1.setFieldName("state");
        f1.setOperator(Operator.EQUAL);
        f1.setValue("WY");

        FilterCondition f2 = new FilterCondition();

        f2.setFieldName("city");
        f2.setOperator(Operator.NOTEQUAL);
        f2.setValue("SMOOT");
        f.add(f1);
        f.add(f2);

        return f;
    }

    @Override
    public List<ReportColumn> getColumns() {
        List<ReportColumn> f  = new ArrayList<ReportColumn>();
        ReportColumn       rc = new ReportColumn();

        rc.setColumnName("state");
        rc.setReportColumnName("state");

        ReportColumn rc1 = new ReportColumn();

        rc1.setColumnName("city");
        rc1.setReportColumnName("city");

        ReportColumn rc2 = new ReportColumn();

        rc2.setColumnName("_id");
        rc2.setReportColumnName("ZipCode");
        f.add(rc);
        f.add(rc1);
        f.add(rc2);

        return f;
    }
}
