package Model;

import java.sql.Timestamp;

public abstract class Message {
	public int typeMsg;
	public int typeImage;
	public int typeVoice;
	public int typeVideo;
	public int typeLocation;
	public int typeFile;
	public String content;
	Timestamp createAt;
	public int getTypeMsg() {
		return typeMsg;
	}
	public void setTypeMsg(int typeMsg) {
		this.typeMsg = typeMsg;
	}
	public int getTypeImage() {
		return typeImage;
	}
	public void setTypeImage(int typeImage) {
		this.typeImage = typeImage;
	}
	public int getTypeVoice() {
		return typeVoice;
	}
	public void setTypeVoice(int typeVoice) {
		this.typeVoice = typeVoice;
	}
	public int getTypeVideo() {
		return typeVideo;
	}
	public void setTypeVideo(int typeVideo) {
		this.typeVideo = typeVideo;
	}
	public int getTypeLocation() {
		return typeLocation;
	}
	public void setTypeLocation(int typeLocation) {
		this.typeLocation = typeLocation;
	}
	public int getTypeFile() {
		return typeFile;
	}
	public void setTypeFile(int typeFile) {
		this.typeFile = typeFile;
	}
	 public abstract void display();
	
}
