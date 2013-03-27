//~--- non-JDK imports --------------------------------------------------------

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.saba.report.FilterCondition;
//~--- JDK imports ------------------------------------------------------------
import com.saba.report.Operator;

public class CopyOftest {
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

    /**
     * @param args
     * @throws UnknownHostException
     */
    public static void main(String[] args) throws UnknownHostException {
        String[] columns = "state,city,pop,_id".split(",");
        DBObject query  = getMetricReportQuery(columns);

        
        FilterCondition filterConditions[] = getFilterConditions();
		DBObject filter =getMetricReportFilter(filterConditions);
		DBCursor result = runReport(filter ,query);
        
        for (DBObject dbObject : result) {
            System.out.println(dbObject);
        }
    }

    private static FilterCondition[] getFilterConditions() {
		FilterCondition f[] = new  FilterCondition[1];
		FilterCondition f1 = new FilterCondition();
		f1.setFieldName("city");
		f1.setOperator(Operator.NOTEQUAL);
		f1.setValue("AS");
		f[0] = f1;
		return f;
	}

	private static DBObject getMetricReportFilter() {
		DBObject filter = new BasicDBObject();
		
		return null;
	}

	private static DBCursor runReport(DBObject filter,DBObject columns) {
    	if(filter==null)
    		filter = new BasicDBObject();
    	if(columns==null)
    		columns = new BasicDBObject();
    	
		return collection.find(filter,columns);
		
	}

	private static DBObject getMetricReportQuery(String[] columns) {
        if (columns.length == 0) {
            return getMetricReport();
        }

        DBObject dbobj = new BasicDBObject();

        for (String string : columns) {
            dbobj.put(string, 1);
        }

        return  dbobj;
    }

    private static DBObject getMetricReport() {
        return new BasicDBObject();
    }
}
