package chatserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author RYU
 */
public class ClientThread implements Runnable {

    Socket socket;
    BufferedReader in;
    PrintWriter out;
    ArrayList<ClientThread> clients;

    public ClientThread(Socket socket, ArrayList<ClientThread> clients) {
        this.socket = socket;
        this.clients = clients;
    }

    @Override
    public void run() {
        /*while socket is open:
        - read client's command
        - process command
         */

        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("ClientThread started");
            while (!socket.isClosed()) {
                String input = in.readLine();
                System.out.println(input);
                if (input != null) {
                    for (ClientThread client : clients) {
                        System.out.println("Message to clients: " + input);
                        client.getWriter().println(input);
                    }
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public PrintWriter getWriter() {
        return out;
    }
}
