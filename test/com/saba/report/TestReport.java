package com.saba.report;

//~--- non-JDK imports --------------------------------------------------------

import com.saba.report.Report;
import com.saba.report.ReportColumn;
import com.saba.report.ReportEngine;
import com.saba.report.ReportEngineImpl;
import com.saba.report.ReportRow;

import org.testng.annotations.Test;

//~--- JDK imports ------------------------------------------------------------

import java.util.List;

public class TestReport {
    @Test
    public void testExistingReport() {
        String             reportId      = "";
        ReportEngine       reportEngine  = new ReportEngineImpl();
        Report             report        = reportEngine.runReport(reportId);
        List<ReportColumn> reportColumns = report.getAllColumns();

        for (ReportColumn reportColumn : reportColumns) {
            System.out.print(reportColumn.getColumnName() + ",");
        }

        System.out.println();

        ReportRow nextRow = report.getNextRow();

        while (nextRow != null) {
            for (ReportColumn reportColumn : reportColumns) {
                System.out.print(nextRow.get(reportColumn.getColumnName()) + ",");
            }

            nextRow = report.getNextRow();
            System.out.println();
        }
    }
}
