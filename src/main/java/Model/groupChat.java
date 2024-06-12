package Model;

import com.mysql.cj.xdevapi.Type;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "groupChat")
public class groupChat extends Chat {
	@Id // khóa chính
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	@Column(name = "groupID")
	public String groupID;
	@Column(name = "groupName")
	public String groupName;
	@Column(name = "msgType")
	String msgType;
	@Column(name = "attribute")
	private Type attribute;

	public groupChat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public groupChat( String groupID, String groupName, String msgType, Type attribute) {
		
		this.groupID = groupID;
		this.groupName = groupName;
		this.msgType = msgType;
		this.attribute = attribute;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getGroupID() {
		return groupID;
	}

	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Type getAttribute() {
		return attribute;
	}

	public void setAttribute(Type attribute) {
		this.attribute = attribute;
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
