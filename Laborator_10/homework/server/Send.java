package server;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Send {
    public boolean existUser(String user, Map<String, List<String>> network){
        for(Map.Entry entry: network.entrySet())
        {
            if(entry.getKey().toString().compareTo(user) == 0)
                return true;
        }
        return false;
    }

    public String send(String currentLoginUser, Map<String, List<String>> network, String request, Map<String, List<String>> messageMap){
        String raspuns = "";
        if (currentLoginUser != null) {
            String message = request.substring(4);
            List<String> friends = network.get(currentLoginUser); // prietenii userului logat curent

            if(friends != null) {
                for (String friend : friends){
                    if(existUser(friend, network)){ // daca prietenul este inregistrat
                        List<String> listOfMessages = new ArrayList<>();

                        listOfMessages = messageMap.get(friend);
                        String newMessage = currentLoginUser + " : " + message;
                        listOfMessages.add(newMessage);
                        messageMap.put(friend, listOfMessages);
                    }
                }
                raspuns = "mesajul a fost trimis";
            }
            else raspuns = "nu exista prieteni in lista";
        }
        return raspuns;
    }
}
