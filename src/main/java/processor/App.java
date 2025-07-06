package processor;

import processor.queryprocessor.QueryProcessor;
import processor.queryprocessor.QueryProcessorFactory;
import processor.utils.FilePathCheck;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String asciiLogger =
                " _                            _  _   \n" +
                        "| |    ___   ___  _ __   __| || |_ \n" +
                        "| |   / _ \\ / _ \\| '_ \\ / _` || __|\n" +
                        "| |__| (_) | (_) | | | | (_| || |_ \n" +
                        "|_____\\___/ \\___/|_| |_|\\__,_| \\__|\n";

        System.out.print(asciiLogger);
        String filePath = "";

        Scanner scanner = new Scanner(System.in);
        boolean filePathSuccess = false;
        while(true){
            System.out.println("Press ? for help or enter the absolute file path");
            String input = scanner.next();
            switch (input){
                case "?":
                    System.out.println("FIND and SELECT range query is supported");
                    System.out.println("SELECT * from test.log where data LIKE 'db connected' and TIME BETWEEN ('', '') ORDER BY TIME");
                    System.out.println("FIND 'hello world' FROM test.log");
                    break;

                case "":
                    System.out.println("Press ? for help or enter the absolute file path");
                    break;
                default:
                    filePath = input;
                    if(FilePathCheck.validFilePath(input)){
                        filePathSuccess = true;
                    }
                    break;
            }
            if(filePathSuccess){
                scanner.nextLine();
                break;
            }
        }

        while(true){
            System.out.println("Query: ");
            String query = scanner.nextLine(); // select, find

            try{
                QueryProcessorFactory queryProcessorFactory = new QueryProcessorFactory();
                QueryProcessor processor = queryProcessorFactory.getQueryProcessor(query);
                processor.process(query, filePath);
            }catch (Exception ex){
                System.out.print("Please use valid query, select and find");
            }
        }

    }
}
