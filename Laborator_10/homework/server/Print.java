package server;

import java.util.List;
import java.util.Map;

public class Print {
    public String print(Map<String, List<String>> network) {
        String returnString="";
        for(Map.Entry entry: network.entrySet())
        {
            returnString+=entry.getKey() + " : " + entry.getValue() + ',';
        }
        return returnString;
    }
}
