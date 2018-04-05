package gonggong;
import java.io.*;
public class Message implements java.io.Serializable{
	private String mesTape;
	private String sender;
	private String getter;
	private String con;
	private String sendTime;
	public String getMesTape() {
		return mesTape;
	}
	public void setMesTape(String mesTape) {
		this.mesTape = mesTape;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getGetter() {
		return getter;
	}
	public void setGetter(String getter) {
		this.getter = getter;
	}
	public String getCon() {
		return con;
	}
	public void setCon(String con) {
		this.con = con;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	
}
