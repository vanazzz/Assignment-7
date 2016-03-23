
import java.util.Date;
import java.io.*;
import java.net.*;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.*;

public class WebServer {

    static final int DEFAULT_PORT = 9999;

    public static void main(String[] args) throws IOException {
        int port = 0;

        if (args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("usage:  java WebServer [port]");
                System.exit(1);
            }
        } else {
            port = DEFAULT_PORT;
        }
        ServerSocket listenSocket = new ServerSocket(port);
        while (true) {
            Socket connectedSocket = listenSocket.accept();
            DataOutputStream out = new DataOutputStream(connectedSocket.getOutputStream());
            Date now = new Date();

            String output1 = ("Your IP address is the following: " + connectedSocket.getInetAddress());
            String output2 = ("It is now " + now.toString());

            out.writeBytes(output1 + '\n');
            out.writeBytes(output2);
            connectedSocket.close();
        }
    }
}
