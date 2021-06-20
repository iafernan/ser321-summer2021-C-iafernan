/**
  File: Performer.java
  Author: Student in Fall 2020B
  Description: Performer class in package taskone.
*/

package taskone;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/**
 * Class: Performer 
 * Description: Threaded Performer for server tasks.
 */
class Performer {

    private StringList state;
    private Socket conn;
    private int count = 0;

    public Performer(Socket sock, StringList strings) {
        this.conn = sock;
        this.state = strings;
    }

    public JSONObject add(String str) {
        JSONObject json = new JSONObject();
        json.put("datatype", 1);
        json.put("type", "add");
        state.add(str);
        count ++;
        json.put("data", state.toString());
        return json;
    }

    public JSONObject pop(){
        String popped;
        JSONObject json = new JSONObject();

        if (this.state.size() == 0){
            json.put("datatype", 2);
            json.put("type", "pop");
            popped = "NULL";
            json.put("data", popped);
            return json;
        } else {
            json.put("datatype", 2);
            json.put("type", "pop");
            popped = state.get(state.size() - 1);
            json.put("data", popped);
            return json;
        }
    }

    public JSONObject display(){
            JSONObject json = new JSONObject();
            json.put("datatype", 3);
            json.put("type", "display");
            json.put("data", state.toString());
            return json;

    }

    public JSONObject count(){
        JSONObject json = new JSONObject();
        json.put("datatype", 4);
        json.put("type", "count");
        json.put("data", count);
        return json;

    }

    public JSONObject switching(int i, int j){
        JSONObject json = new JSONObject();
        json.put("datatype", 5);
        json.put("type", "switching");
        json.put("data", state.toString());
        return json;

    }

    public static JSONObject error(String err) {
        JSONObject json = new JSONObject();
        json.put("error", err);
        return json;
    }

    public void doPerform() {
        boolean quit = false;
        OutputStream out = null;
        InputStream in = null;
        try {
            out = conn.getOutputStream();
            in = conn.getInputStream();
            System.out.println("Server connected to client:");
            while (!quit) {
                byte[] messageBytes = NetworkUtils.receive(in);
                JSONObject message = JsonUtils.fromByteArray(messageBytes);
                JSONObject returnMessage = new JSONObject();
   
                int choice = message.getInt("selected");
                    switch (choice) {
                        case (1):
                            String inStr = (String) message.get("data");
                            returnMessage = add(inStr);
                            break;
                        case (2):
                            returnMessage = pop();
                            break;
                        case (3):
                            returnMessage = display();
                            break;
                        case (4):
                            returnMessage = count();
                            break;
                        case (5):
                            int i = (int) message.get("data");
                            int j = (int) message.get("data");
                            returnMessage = switching(i, j);
                            break;
                        case (0):
                            System.out.println("close the resources of client ");
                            out.close();
                            in.close();
                            break;
                        default:
                            returnMessage = error("Invalid selection: " + choice 
                                    + " is not an option");
                            break;
                    }
                // we are converting the JSON object we have to a byte[]
                byte[] output = JsonUtils.toByteArray(returnMessage);
                NetworkUtils.send(out, output);
            }
            // close the resource
            System.out.println("close the resources of client ");
            out.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
