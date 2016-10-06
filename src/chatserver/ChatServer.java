package chatserver;

/**
 *
 * @author RYU
 */
import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class ChatServer {

    public ArrayList<ClientThread> clients = new ArrayList<>();

    /*Constructor for ChatServer*/
    ChatServer() {
    }

    /*Serve() method*/
    void serve() throws IOException {

        try {

            /*Define variables for Server Socket, port address and accepting socket,
            which are need for communicating with the server.*/
            ServerSocket server = new ServerSocket(0, 3);
            int portaddress = server.getLocalPort();
            System.out.println(portaddress);
            Socket socket;


            /*While loop for waiting the server to accept the connection. When connection is established,
            start run the CommandInterpreter as a Thread.*/
            //while (true) {
            for (int i = 0; i < 10; i++) {
                System.out.println("Waiting ....");

                socket = server.accept();

                System.out.println("New client accdepted");
                //CommandInterpreter i = new CommandInterpreter(socket.getInputStream(), new PrintStream(socket.getOutputStream()));

                //Thread t = new Thread((Runnable) i);
                ClientThread client = new ClientThread(socket, clients);
                Thread c = new Thread(client);
                clients.add(client);
                c.start();
                // t.start();
            }

        } catch (IOException e) {

            /*If connection can't be established, quit the application.*/
            System.out.println("Could not listen.");
            System.exit(-1);
        }
    }
}
