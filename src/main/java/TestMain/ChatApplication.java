package TestMain;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import Model.ClientChat;
import Model.ServerChat;

public class ChatApplication {
	 public static void main(String[] args) {
		 int port=99;
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			ClientChat clientChat = new ClientChat("localhost", port);

	                Socket clientSocket = serverSocket.accept();
	                ServerChat mp = new ServerChat(clientSocket);
	                mp.start();
	                } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
         
	    }

}
