package com.saba.report;

//~--- non-JDK imports --------------------------------------------------------

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

//~--- JDK imports ------------------------------------------------------------

import java.net.UnknownHostException;

import java.util.List;

public class ReportEngineImpl implements ReportEngine {
    static DBCollection collection;

    static {
        Mongo mongoClient = null;

        try {
            mongoClient = new Mongo();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        DB db = mongoClient.getDB("test");

        collection = db.getCollection("zips");
    }

    @Override
    public Report runReport(String reportId) {
        ReportMetaData reportMetaData = ReportMetadataManager.getReportMetadata(reportId);
        
        DBObject       filter         = getMetricReportFilter(reportMetaData.getFilters());
        DBObject       columns        = getMetricReportQuery(reportMetaData.getColumns());

        if (filter == null) {
            filter = new BasicDBObject();
        }

        if (columns == null) {
            columns = new BasicDBObject();
        }

        DBCursor dbcursor = collection.find(filter, columns);
        Report   report   = new ReportImpl(dbcursor);

        report.setReportMetaData(reportMetaData);

        return report;
    }

    private static DBObject getMetricReportFilter(List<ReportFilter> list) {
        if (list.size() == 0) {
            return getMetricReportFilter();
        }

        BasicDBObject filter = new BasicDBObject();

        for (int i = list.size() - 1; i >= 0; i--) {
            ReportFilter filterCondition = list.get(i);

            if (filterCondition.getOperator().equals(Operator.EQUAL)) {
                filter.put(filterCondition.getFieldName(), filterCondition.getValue());
            } else {
                filter.put(filterCondition.getFieldName(),
                           new BasicDBObject(filterCondition.getOperator().getSymbol(), filterCondition.getValue()));
            }
        }

        return filter;
    }

    private static DBObject getMetricReportFilter() {
        return new BasicDBObject();
    }

    private static DBObject getMetricReportQuery(List<ReportColumn> list) {
        if (list.size() == 0) {
            return getMetricReport();
        }

        DBObject dbobj = new BasicDBObject();

        for (ReportColumn string : list) {
            dbobj.put(string.getColumnName(), 1);
        }

        return dbobj;
    }

    private static DBObject getMetricReport() {
        return new BasicDBObject();
    }
}
