package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServerChat extends Thread {
	private Socket socket;

	public ServerChat(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			// Xử lí sau
			Thread.sleep(500);

			// đọc dữ liệu từ socket
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// ghi dữ liệu lên socket
			PrintWriter writer = new PrintWriter(socket.getOutputStream());

			System.out.println("pong");

			// gửi tin nhắn
			System.out.println("Server: ");
			writer.println("Server pong ");
			writer.flush();
		} catch (Exception e) {
		}
	}
}