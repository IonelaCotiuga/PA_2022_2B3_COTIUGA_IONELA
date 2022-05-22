package server;

import java.util.List;
import java.util.Map;

public class Login {
    public String login(String name, Map<String, List<String>> network, String currentLoginUser){
        String raspuns = "";
        if (currentLoginUser == null) {
            int found = 0;
            for (Map.Entry entry : network.entrySet()) {
                if (name.compareTo(String.valueOf(entry.getKey())) == 0) {
                    raspuns = "Login succesful";
                    found = 1;
                    break;
                }
            }
            if (found == 0) {
                raspuns = "User doesn't exist";
            }
        } else {
            raspuns = "Another user is logged in";
        }
        return raspuns;
    }
}
