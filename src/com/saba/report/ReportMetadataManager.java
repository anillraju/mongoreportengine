package com.saba.report;

public class ReportMetadataManager {
    public static ReportMetaData getReportMetadata(String reportId) {
        return new ReportMetadataImpl(reportId);
    }
}
