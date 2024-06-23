package View;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class OnlineList implements Runnable {
    
	InterfaceMain interfaceMain;
    
    public OnlineList(InterfaceMain interfaceMain){
        this.interfaceMain = interfaceMain;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()){
                String msg = "";
                for(int x=0; x < interfaceMain.clientList.size(); x++){
                    msg = msg+" "+ interfaceMain.clientList.elementAt(x);
                }
                
                for(int x=0; x < interfaceMain.socketList.size(); x++){
                    Socket tsoc = (Socket) interfaceMain.socketList.elementAt(x);
                    DataOutputStream dos = new DataOutputStream(tsoc.getOutputStream());
                    /** CMD_ONLINE [user1] [user2] [user3] **/
                    if(msg.length() > 0){
                        dos.writeUTF("CMD_ONLINE "+ msg);
                    }
                }
                
                Thread.sleep(1900);
            }
        } catch(InterruptedException e){
        	interfaceMain.appendMessage("[InterruptedException]: "+ e.getMessage());
        } catch (IOException e) {
        	interfaceMain.appendMessage("[IOException]: "+ e.getMessage());
        }
    }
    
    
}

