package taskone;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import org.json.JSONObject;


/**
 * Class: ThreadedServer
 * Description: Unbounded incoming connections to the Server.
 * @author ivanFernandez
 * date: 6/18/2021
 */

public class ThreadedServer implements Runnable{
    private static int port;
    private static StringList strings = new StringList();

    public static void main(String[] args) throws Exception {

        if (args.length != 1) {
            // gradle runServer -Pport=9099 -q --console=plain
            System.out.println("Usage: gradle runServer -Pport=9099 -q --console=plain");
            System.exit(1);
        }
        port = -1;
        try {
            port = Integer.parseInt(args[0]);
        } catch (NumberFormatException nfe) {
            System.out.println("[Port] must be an integer");
            System.exit(2);
        }

    }

    @Override
    public void run() {
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Server Started...");
        while (true) {
            System.out.println("Accepting a Request...");
            Socket sock = null;
            try {
                sock = server.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Performer performer = new Performer(sock, strings);
            performer.doPerform();
            try {
                System.out.println("close socket of client ");
                sock.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
