package TestMain;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Model.ServerRunnable;
import Model.SocketClient;

public class ChatApplication {
	  public static void main(String[] args) throws IOException {
	    ExecutorService executor = Executors.newFixedThreadPool(1);
	    ServerRunnable serverThread = new ServerRunnable();
	    executor.submit(serverThread);
	    SocketClient client = new SocketClient();
	    client.startConnection("localhost", 6666);
	    String response = client.sendMessage("ping");
	    System.out.println(response);
	  }
	}
