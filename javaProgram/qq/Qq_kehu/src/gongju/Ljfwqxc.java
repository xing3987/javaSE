package gongju;
import java.io.*;
import java.net.*;

import gonggong.*;
import jiemian.*;
public class Ljfwqxc extends Thread{
    private Socket s;
	
	public Ljfwqxc(Socket s)
	{
		this.s=s;
	}
	public Socket getS() {
		return s;
	}

	public void setS(Socket s) {
		this.s = s;
	}
	public void run(){
		while(true){
			try {
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				Message ms=(Message)ois.readObject();
				if(ms.getMesTape().equals(MessageType.message_comm_mes)){
					Liaotian lt=Gliaotian.getLiaotian(ms.getGetter()+" "+ms.getSender());
					lt.showMessage(ms);
				}else if(ms.getMesTape().equals(MessageType.message_ret_onLineFriend)){
					String getter=ms.getGetter();
					Liebiao lb=Glhylb.getQqfriendList(getter);
					if(lb !=null){
						lb.updateFriend(ms);
					}
				}
			} catch (Exception e) {}
			
		}
	}
	
}
