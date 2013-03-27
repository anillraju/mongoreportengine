//~--- non-JDK imports --------------------------------------------------------

import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.ReadPreference;

//~--- JDK imports ------------------------------------------------------------

import java.net.UnknownHostException;

import java.util.Set;

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

        
        DBCursor result = runReport(null,query);
        
        for (DBObject dbObject : result) {
            System.out.println(dbObject);
        }
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
