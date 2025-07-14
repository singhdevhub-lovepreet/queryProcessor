package logger.queryprocessor;

import java.util.HashMap;
import java.util.Map;

public class QueryProcessorFactory {

    private static Map<String, QueryProcessor> queryProcessorMap = new HashMap<>();

    static {
        queryProcessorMap.put("select", new SelectQueryProcessor());
        queryProcessorMap.put("find", new FindQueryProcessor());
    }

    public QueryProcessor getQueryProcessor(String query) throws Exception{
        String[] queryElements = query.split(" ");
        if(!queryProcessorMap.containsKey(queryElements[0])){
            throw new RuntimeException("No queryProcessor found");
        }
        return queryProcessorMap.get(queryElements[0]);
    }

}
