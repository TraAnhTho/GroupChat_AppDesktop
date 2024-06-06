package Model;

import com.mysql.cj.xdevapi.Type;

public class groupChat extends Chat{
	private int ID;
	
	public String groupID;
	
	public String groupName;
	
	String msgType;
	
	private Type attribute;

	public groupChat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	
	public void connectSession() {
		
	}
public void inviteFriend() {
		
	}
public void addFriend(String username) {
	
}
public void removeFriend(String username) {
	
}
public void leaveGroup(String groupID) {
	
}
public void deleteGroup(String groupID) {
	
}
	
	
}
