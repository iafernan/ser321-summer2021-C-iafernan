package examples.grpcClient;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import service.*;
import test.TestProtobuf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Client that requests `parrot` method from the `EchoServer`.
 */
public class EchoClient {
  private final EchoGrpc.EchoBlockingStub blockingStub;
  private final JokeGrpc.JokeBlockingStub blockingStub2;
  private final RegistryGrpc.RegistryBlockingStub blockingStub3;
  private final CalcGrpc.CalcBlockingStub blockingStub4;
  private final StoryGrpc.StoryBlockingStub blockingStub5;

  /** Construct client for accessing server using the existing channel. */
  public EchoClient(Channel channel, Channel regChannel) {
    // 'channel' here is a Channel, not a ManagedChannel, so it is not this code's
    // responsibility to
    // shut it down.

    // Passing Channels to code makes code easier to test and makes it easier to
    // reuse Channels.
    blockingStub = EchoGrpc.newBlockingStub(channel);
    blockingStub2 = JokeGrpc.newBlockingStub(channel);
    blockingStub3 = RegistryGrpc.newBlockingStub(regChannel);
    blockingStub4 = CalcGrpc.newBlockingStub(channel);
    blockingStub5 = StoryGrpc.newBlockingStub(channel);
  }

  public void askServerToRead(){
    Empty request = Empty.newBuilder().build();
    ReadResponse response;
    try {
      response = blockingStub5.read(request);
    } catch (Exception e) {
      System.err.println("RPC failed: " + e.getMessage());
      return;
    }
    System.out.println("Received from server: " + response.getSentence());
    System.out.println("Received from server: Is success? " + " " + response.getIsSuccess());

  }

  public void askServerToWrite(String sentence){
    WriteRequest request = WriteRequest.newBuilder().setNewSentence(sentence).build();
    WriteResponse response;
    try {
      response = blockingStub5.write(request);
    } catch (Exception e) {
      System.err.println("RPC failed: " + e.getMessage());
      return;
    }
    System.out.println("Received from server: " + response.getStory());
    System.out.println("Received from server: Is success? " + " " + response.getIsSuccess());

  }

  public void askServerToAdd(Double[] numbers){
    CalcRequest request = CalcRequest.newBuilder().addAllNum(Arrays.asList(numbers)).build();
    CalcResponse response;
    try {
      response = blockingStub4.add(request);
    } catch (Exception e) {
      System.err.println("RPC failed: " + e.getMessage());
      return;
    }
    System.out.println("Received from server: " + response.getSolution());
    System.out.println("Received from server: Is success? " + " " + response.getIsSuccess());

  }

  public void askServerToMult(Double[] numbers){
    CalcRequest request = CalcRequest.newBuilder().addAllNum(Arrays.asList(numbers)).build();
    CalcResponse response;
    try {
      response = blockingStub4.multiply(request);
    } catch (Exception e) {
      System.err.println("RPC failed: " + e.getMessage());
      return;
    }
    System.out.println("Received from server: " + response.getSolution());
    System.out.println("Received from server: Is success? " + " " + response.getIsSuccess());

  }

  public void askServerToDivide(Double[] numbers){
    CalcRequest request = CalcRequest.newBuilder().addAllNum(Arrays.asList(numbers)).build();
    CalcResponse response;
    try {
      response = blockingStub4.divide(request);
    } catch (Exception e) {
      System.err.println("RPC failed: " + e.getMessage());
      return;
    }
    System.out.println("Received from server: " + response.getSolution());
    System.out.println("Received from server: Is success? " + " " + response.getIsSuccess());

  }

  public void askServerToSubtract(Double[] numbers){
    CalcRequest request = CalcRequest.newBuilder().addAllNum(Arrays.asList(numbers)).build();
    CalcResponse response;
    try {
      response = blockingStub4.subtract(request);
    } catch (Exception e) {
      System.err.println("RPC failed: " + e.getMessage());
      return;
    }
    System.out.println("Received from server: " + response.getSolution());
    System.out.println("Received from server: Is success? " + " " + response.getIsSuccess());

  }

  public void askServerToParrot(String message) {
    ClientRequest request = ClientRequest.newBuilder().setMessage(message).build();
    ServerResponse response;
    try {
      response = blockingStub.parrot(request);
    } catch (Exception e) {
      System.err.println("RPC failed: " + e.getMessage());
      return;
    }
    System.out.println("Received from server: " + response.getMessage());
  }

  public void askForJokes(int num) {
    JokeReq request = JokeReq.newBuilder().setNumber(num).build();
    JokeRes response;

    try {
      response = blockingStub2.getJoke(request);
    } catch (Exception e) {
      System.err.println("RPC failed: " + e);
      return;
    }
    System.out.println("Your jokes: ");
    for (String joke : response.getJokeList()) {
      System.out.println("--- " + joke);
    }
  }

  public void setJoke(String joke) {
    JokeSetReq request = JokeSetReq.newBuilder().setJoke(joke).build();
    JokeSetRes response;

    try {
      response = blockingStub2.setJoke(request);
      System.out.println(response.getOk());
    } catch (Exception e) {
      System.err.println("RPC failed: " + e);
      return;
    }
  }

  public void getServices() {
    GetServicesReq request = GetServicesReq.newBuilder().build();
    ServicesListRes response;
    try {
      response = blockingStub3.getServices(request);
      System.out.println(response.toString());
    } catch (Exception e) {
      System.err.println("RPC failed: " + e);
      return;
    }
  }

  public void findServer(String name) {
    FindServerReq request = FindServerReq.newBuilder().setServiceName(name).build();
    SingleServerRes response;
    try {
      response = blockingStub3.findServer(request);
      System.out.println(response.toString());
    } catch (Exception e) {
      System.err.println("RPC failed: " + e);
      return;
    }
  }

  public void findServers(String name) {
    FindServersReq request = FindServersReq.newBuilder().setServiceName(name).build();
    ServerListRes response;
    try {
      response = blockingStub3.findServers(request);
      System.out.println(response.toString());
    } catch (Exception e) {
      System.err.println("RPC failed: " + e);
      return;
    }
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 6) {
      System.out
          .println("Expected arguments: <host(String)> <port(int)> <regHost(string)> <regPort(int)> <message(String)> <auto(int)>");
      System.exit(1);
    }
    boolean notQuit = true;
    int port = 9099;
    int regPort = 9003;
    String host = args[0];
    String regHost = args[2];
    String message = args[4];
    int auto = Integer.parseInt(args[5]);
    try {
      port = Integer.parseInt(args[1]);
      regPort = Integer.parseInt(args[3]);
    } catch (NumberFormatException nfe) {
      System.out.println("[Port] must be an integer");
      System.exit(2);
    }

    // Create a communication channel to the server, known as a Channel. Channels
    // are thread-safe
    // and reusable. It is common to create channels at the beginning of your
    // application and reuse
    // them until the application shuts down.
    String target = host + ":" + port;
    ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
        // Channels are secure by default (via SSL/TLS). For the example we disable TLS
        // to avoid
        // needing certificates.
        .usePlaintext().build();

    String regTarget = regHost + ":" + regPort;
    ManagedChannel regChannel = ManagedChannelBuilder.forTarget(regTarget).usePlaintext().build();
    try {

      // ##############################################################################
      // ## Assume we know the port here from the service node it is basically set through Gradle
      // here.
      // In your version you should first contact the registry to check which services
      // are available and what the port
      // etc is.

      /**
       * Your client should start off with 
       * 1. contacting the Registry to check for the available services
       * 2. List the services in the terminal and the client can
       *    choose one (preferably through numbering) 
       * 3. Based on what the client chooses
       *    the terminal should ask for input, eg. a new sentence, a sorting array or
       *    whatever the request needs 
       * 4. The request should be sent to one of the
       *    available services (client should call the registry again and ask for a
       *    Server providing the chosen service) should send the request to this service and
       *    return the response in a good way to the client
       * 
       * You should make sure your client does not crash in case the service node
       * crashes or went offline.
       */

      // Just doing some hard coded calls to the service node without using the
      // registry
      // create client
      EchoClient client = new EchoClient(channel, regChannel);

      // call the parrot service on the server
      client.askServerToParrot(message);

      // ask the user for input how many jokes the user wants
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

      if(auto == 1){

        System.out.println("Entering automatic testing mode: ");

        //Testing asking server to Read.
        System.out.println("Reading story, no sentences added yet.");
        client.askServerToRead();

        //Testing asking server to write
        System.out.println("Writing sentences to a story.");
        client.askServerToWrite("There once was a fellow named Ivanho.");
        client.askServerToWrite("He stumbled across a vast forrest.");
        client.askServerToWrite("He met plentiful a creature throughout his trek.");
        client.askServerToWrite("They each made him solve a puzzle to continue along his trip.");

        //Asking server to read again
        System.out.println("Reading story after adding some sentences.");
        client.askServerToRead();

        //Testing asking server to add
        System.out.println("Inputting numbers to add: 14.0, 12.5, 15.3, 8.4, 3.1, 56.5, 77.6.");

        Double[] nums = new Double[]{14.0, 12.5, 15.3, 8.4, 3.1, 56.5, 77.6};

        client.askServerToAdd(nums);

        //Asking server to subtract
        System.out.println("Inputting numbers to subtract: 100, 12, 2, 5, 9, 13, 15, 10.");
        nums = new Double[]{100.0, 12.0, 2.0, 5.0, 9.0, 13.0, 15.0, 10.0};

        client.askServerToSubtract(nums);

        //Asking server to multiply
        System.out.println("Inputting numbers to multiply: 2, 5, 6, 8, 14, 7, 11, 3.");
        nums = new Double[]{2.0, 5.0, 6.0, 8.0, 14.0, 7.0, 11.0, 3.0};

        client.askServerToMult(nums);

        //Asking server to divide
        System.out.println("Inputting numbers to divide: 1000, 10, 2, 3, 8, 9, 4, 7.");
        nums = new Double[]{1000.0, 10.0, 2.0, 3.0, 8.0, 9.0, 4.0, 7.0};

        client.askServerToDivide(nums);



      } else {


        // 1. contacting the Registry to check for the available services
        System.out.println("These are the services available to you: ");

        // ############### Contacting the registry just so you see how it can be done

        // Comment these last Service calls while in Activity 1 Task 1, they are not needed and wil throw issues without the Registry running
        // get thread's services
        client.getServices();

        // get divide
        client.findServer("services.Story/read");

        // get divide
        client.findServer("services.Story/write");

        // get divide
        client.findServer("services.Calc/divide");

        // get multiply
        client.findServer("services.Calc/multiply");

        // get subtract
        client.findServer("services.Calc/subtract");

        // get add
        client.findServer("services.Calc/add");

        // get parrot
        client.findServer("services.Echo/parrot");

        // get all setJoke
        client.findServers("services.Joke/setJoke");

        // get getJoke
        client.findServer("services.Joke/getJoke");

        // 2. List the services in the terminal and the client can
        //       *    choose one (preferably through numbering)
        while (notQuit) {
          System.out.println("Please make a selection of the available services: ");
          System.out.println("1. Story write.");
          System.out.println("2. Story read.");
          System.out.println("3. Calculation: add.");
          System.out.println("4. Calculation: subtract.");
          System.out.println("5. Calculation: multiply.");
          System.out.println("6. Calculation: divide.");
          System.out.println("7. Parrot, echo message.");
          System.out.println("8. Jokes, set.");
          System.out.println("9. Jokes, get.");
          System.out.println("Type 0 to exit.");

          int choice = Integer.parseInt(reader.readLine());
          switch (choice) {
            case (1):
              try {
                System.out.println("Please add a sentence"); // NO ERROR handling of wrong input here.
                String sent = reader.readLine();

                client.askServerToWrite(sent);
              } catch (Exception e) {
                System.out.println("Please enter a valid Sentence.");
              }
              break;
            case (2):
              System.out.println("Reading ....");
              client.askServerToRead();
              break;
            case (3):
              try {
                System.out.println("Input Numbers to add: ");
                String numbers = reader.readLine();
                String[] numList = numbers.split(" ");
                Double[] nums = new Double[numList.length];
                for (int i = 0; i < numList.length; i++) {
                  nums[i] = Double.parseDouble(numList[i]);
                }

                client.askServerToAdd(nums);
              } catch (Exception e) {
                System.out.println("Please enter valid inputs.");
              }
              break;
            case (4):
              try {
                System.out.println("Input Numbers to subtract: ");

                String numbers = reader.readLine();
                String[] numList = numbers.split(" ");
                Double[] nums = new Double[numList.length];
                for (int i = 0; i < numList.length; i++) {
                  nums[i] = Double.parseDouble(numList[i]);
                }

                client.askServerToSubtract(nums);
              } catch (Exception e) {
                System.out.println("Please enter valid inputs.");
              }

              break;
            case (5):
              try {
                System.out.println("Input Numbers to multiply: ");

                String numbers = reader.readLine();
                String[] numList = numbers.split(" ");
                Double[] nums = new Double[numList.length];
                for (int i = 0; i < numList.length; i++) {
                  nums[i] = Double.parseDouble(numList[i]);
                }

                client.askServerToMult(nums);
              } catch (Exception e) {
                System.out.println("Please enter valid inputs.");
              }

              break;
            case (6):
              try {
                System.out.println("Input Numbers to divide: ");

                String numbers = reader.readLine();
                String[] numList = numbers.split(" ");
                Double[] nums = new Double[numList.length];
                for (int i = 0; i < numList.length; i++) {
                  nums[i] = Double.parseDouble(numList[i]);
                }

                client.askServerToDivide(nums);
              } catch (Exception e) {
                System.out.println("Please enter valid inputs.");
              }

              break;
            case (7):
              try {
                String parrotMessage;
                System.out.println("Please input a message for the Parrot.");
                parrotMessage = reader.readLine();
                client.askServerToParrot(parrotMessage);
              } catch (Exception e) {
                System.out.println("Please enter valid input.");
              }
              break;
            case (8):
              try {
                String joke;
                System.out.println("Please input joke to set.");
                joke = reader.readLine();
                client.setJoke(joke);
              } catch (Exception e) {
                System.out.println("Invalid input.");
              }
              break;
            case (9):
              try {
                // Reading data using readLine
                System.out.println("How many jokes would you like?"); // NO ERROR handling of wrong input here.
                String num = reader.readLine();

                // calling the joked service from the server with num from user input
                client.askForJokes(Integer.valueOf(num));
              } catch (Exception e) {
                System.out.println("Invalid input.  Try again");
              }
              break;
            case (0):
              System.out.println("Close the resources of client ");
              notQuit = false;
              break;
            default:
              System.out.println("Invalid selection: " + choice
                      + " is not an option");
              break;
          }

        }

      }


    } finally {
      // ManagedChannels use resources like threads and TCP connections. To prevent
      // leaking these
      // resources the channel should be shut down when it will no longer be used. If
      // it may be used
      // again leave it running.
      channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
      regChannel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
    }
  }


}
