package server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SocialNetwork {
    private String name;
    private Map<String, List<String>> network = new HashMap<>();

    public SocialNetwork() {}

    public void register(String name){
        network.put(name, null);
        this.name = name;
    }

    public void addFriends(List<String> friends){
        network.put(this.name, friends);
    }

    public String interpretCommand(String request){
        String raspuns = null;
        String[] data = request.split(" ");

        if(data[0].compareTo("register") == 0){
            String name = request.substring(9);
            register(name);
            raspuns = "S-a inregistrat user-ul cu numele " + name;
        }
        else if(data[0].compareTo("print") == 0){
            return toString();
        }
        else if(data[0].compareTo("friend") == 0){
            List<String> friends = new ArrayList<>();
            for(int i = 1; i < data.length; i++){
                friends.add(i-1, data[i]);
            }
            addFriends(friends);
            raspuns = "Friends have been add";
        }
        else {
            raspuns = "Server received the request " + request;
        }

        return raspuns;
    }

    @Override
    public String toString() {
        String returnString="";
        for(Map.Entry entry: network.entrySet())
        {
            returnString+=entry.getKey() + " : " + entry.getValue() + ',';
        }
        return returnString;
    }

}
