package Model;

import java.io.IOException;

public class ServerRunnable implements Runnable {
	  private final SocketServer server = new SocketServer();
	  
	  @Override
	  public void run() {
	    try {
	      server.start(6666);
	    } catch (IOException e) {
	      throw new RuntimeException(e);
	    }
	  }
	}