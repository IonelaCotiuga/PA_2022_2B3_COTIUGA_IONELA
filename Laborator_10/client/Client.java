package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Client {
    public static void main (String[] args) throws IOException {
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8100; // The server's port
        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader (
                        new InputStreamReader(socket.getInputStream())) ) {
            // Send a request to the server

            while (true){
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(System.in));

                String name = reader.readLine();
                String request = name;

                if(request.compareTo("exit") == 0){
                    System.exit(0);
                }

                out.println(request);
                String response = in.readLine ();
                System.out.println(response);
            }

        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
        catch (SocketException s){
            System.out.println("No server listening... " + s);
        }
    }
}