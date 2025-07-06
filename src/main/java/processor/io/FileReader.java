package processor.io;

import processor.entity.Log;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FileReader implements Reader{

    @Override
    public Collection<Log> read(Object source){
        List<Log> logs = new ArrayList<>();

        try{
            String filePath = (String) source;

            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while(true){
                try{
                    Log log = (Log) ois.readObject();
                    logs.add(log);
                }catch (Exception ex){
                    // ignored
                }finally {
                    fis.close();
                    ois.close();
                }
            }

        }catch (Exception ex){

        }
        return  logs;
    }

}
