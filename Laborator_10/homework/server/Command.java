package server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Command {
    private String name;
    private String raspuns;
    private Map<String, List<String>> network = new HashMap<>();
    Map<String, List<String>> messageMap=new HashMap<>();
    private String currentLoginUser;

    public void setCurrentLoginUser(String currentLoginUser) {
        this.currentLoginUser = currentLoginUser;
    }

    Register register = new Register();
    Print print = new Print();
    Login login = new Login();
    Friend friend = new Friend();
    Send send = new Send();
    Read read = new Read();

    public Command() {}

    public String parseRequest(String request){
        String[] data = request.split(" ");

        switch (data[0]){
            case "register":
                String name = request.substring(9);
                raspuns = register.registerMethod(name, network, currentLoginUser);
                messageMap.put(name, new ArrayList<>());
                break;
            case "print":
                raspuns = print.print(network);
                break;
            case "login":
                raspuns = login.login(data[1],network, currentLoginUser);
                if(raspuns.compareTo("Login succesful") == 0){
                    setCurrentLoginUser(data[1]);
                }
                break;
            case "logout":
                setCurrentLoginUser(null);
                raspuns = "Logout ok";
                break;
            case "friend":
                raspuns = friend.friend(data, network, currentLoginUser);
                break;
            case "send":
                raspuns = send.send(currentLoginUser, network, request, messageMap);
                break;
            case "read":
                raspuns = read.read(messageMap, currentLoginUser);
                break;
            default:
                raspuns = "Server received the request " + request;
                break;
        }

        return raspuns;

    }


}
