package processor.io;

import processor.entity.Log;

import java.util.Collection;

public interface Reader {

    Collection<Log> read(Object source);

}
