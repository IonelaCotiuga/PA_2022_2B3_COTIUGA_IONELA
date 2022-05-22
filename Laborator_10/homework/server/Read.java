package server;

import java.util.List;
import java.util.Map;

public class Read {
    String raspuns = "";
    public String read(Map<String, List<String>> messageMap, String currentLoginUser){
        String returnString = "";
        for (Map.Entry entry : messageMap.entrySet()) {
            if(currentLoginUser.compareTo(String.valueOf(entry.getKey())) == 0)
                returnString += entry.getKey() + " : {" + entry.getValue() + "} , ";
        }
        raspuns = returnString;
        return raspuns;
    }
}
