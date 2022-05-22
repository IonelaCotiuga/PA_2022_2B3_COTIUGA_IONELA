package server;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Friend {
    public String friend(String[] data, Map<String, List<String>> network, String currentLoginUser){
        String raspuns = "";
        if (currentLoginUser != null) {
            List<String> friends = new ArrayList<>();
            for (int i = 1; i < data.length; i++) {
                friends.add(i - 1, data[i]);
            }
            network.put(currentLoginUser, friends);
            raspuns = "Au fost adaugati prietenii";
        } else {
            raspuns = "You need to log in";
        }
        return raspuns;
    }
}
