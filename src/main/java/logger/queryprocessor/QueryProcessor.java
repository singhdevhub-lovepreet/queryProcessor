package logger.queryprocessor;

public interface QueryProcessor {

    void process(String query, Object source) throws Exception;

}
