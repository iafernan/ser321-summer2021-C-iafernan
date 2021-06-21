package taskone;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/**
 * Class: ThreadPoolServer
 * Description: Threaded Performer for server tasks.
 * @author ivanFernandez
 * date: 6/18/2021
 */

class Clientele implements Runnable {
    protected int id;
    protected int sleepDelay;

    public Clientele (int assignedID, int sd) {
        id = assignedID;
        sleepDelay = sd;
    }

    public void run() {
            System.out.println("Hello from " + id );
            try {
                Thread.sleep(sleepDelay);
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }



public class ThreadPoolServer {
    public static void main(String args[]) throws Exception {
        if (args.length != 3) {
            System.out.println("Expected Arguments: <workers(int)> <sleep(int)> <loop count(int)>");
            System.exit(0);
        }
        int port = 9099; // default value
        int connections = 25; // default value
        int sleepDelay = 5; // default value
        try {
            port = Integer.parseInt(args[0]);
            connections = Integer.parseInt(args[1]);

        } catch (NumberFormatException nfe) {
            System.out.println("[workers|sleep|loop count] must be integer");
            System.exit(0);
        }
        if (connections < 6) {
            connections = 6;
        }
        int poolSize = connections - 5;

        // lower thread pool than numWorkers;
        Executor pool = Executors.newFixedThreadPool(poolSize);

        for (int i = 0; i < connections; i++) {
            pool.execute(new Clientele(i, sleepDelay));
        }
    }
}
