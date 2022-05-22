package server;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Register {

    public String registerMethod(String name, Map<String, List<String>> network, String currentLoginUser){
        String raspuns = null;

        if(currentLoginUser == null){
            int alreadyExist = 0;
            for(String str : network.keySet()){
                if(str.compareTo(name) == 0){
                    raspuns = "Exista deja un utilizator inregistrat cu acest nume";
                    alreadyExist = 1;
                    break;
                }
            }
            if(alreadyExist == 0){
                network.put(name, null);
                raspuns = "S-a inregistrat user-ul cu numele " + name;
            }
        }else{
            raspuns = "Altcineva este deja logat";
        }

        return raspuns;
    }

}
