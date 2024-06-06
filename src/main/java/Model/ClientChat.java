package Model;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.*;
import java.net.*;

public class ClientChat extends Thread{
    private Socket socket;

    public ClientChat(Socket socket) {
        this.socket = socket;
    }

	public ClientChat(String string, int port) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int port =123;
        try {
			Socket socket =new Socket("localhost", port);
			
			  //Xử lí sau
			Thread.sleep(500);
			
			//đọc dữ liệu từ socket
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			//ghi dữ liệu lên socket
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			
			
			System.out.println("ping ");

			while(true){
             //gửi tin nhắn
            writer.println("Client ping ... ");
            //vừa nhắn xong gửi đi liền 
            writer.flush();

			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}}
