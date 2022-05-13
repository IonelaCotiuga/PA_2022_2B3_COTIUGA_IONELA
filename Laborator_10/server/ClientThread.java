package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientThread extends Thread {
    private Socket socket = null ;
    public ClientThread (Socket socket) { this.socket = socket ; }
    public void run () {
        try {
            // Get the request from the input stream: client → server

            boolean isRunning = true;
            SocialNetwork socialNetwork = new SocialNetwork();
            while (isRunning){
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                String request = in.readLine();

                PrintWriter out = new PrintWriter(socket.getOutputStream());
                String raspuns = null;
                if(request.compareTo("stop") != 0){
                    raspuns = socialNetwork.interpretCommand(request);
                }

                if(request.compareTo("stop") == 0){
                    isRunning = false;
                    raspuns = "Server stopped";
                }

                // Send the response to the oputput stream: server → client
                out.println(raspuns);
                out.flush();

                if(isRunning == false){
                    socket.close();
                    System.exit(0);
                }
            }

        } catch (IOException e) {
            System.out.println("Client deconnected..." + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) { System.err.println (e); }
        }
    }
}