package moshi;

import gonggong.*;

import java.net.*;
import java.util.HashMap;
import java.util.Iterator;
import java.io.*;

public class Xiancheng extends Thread{
	Socket s;

	public Xiancheng(Socket s){
		this.s=s;
	}
	public void tongzhi(String id){
		HashMap hm=Xianchengbiaoshi.hm;
		Iterator it=hm.keySet().iterator();
		while(it.hasNext()){
			Message ms=new Message();
			ms.setCon(id);
			ms.setMesTape(MessageType.message_ret_onLineFriend);
			String OnlineId=it.next().toString();
			try{
				ObjectOutputStream oos=new ObjectOutputStream(Xianchengbiaoshi.getXiancheng(OnlineId).s.getOutputStream());
				ms.setGetter(OnlineId);
				oos.writeObject(ms);
			}catch(Exception e){}
		}
	}
	public void run(){
		while(true){
			try {
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				Message ms=(Message)ois.readObject();
				if(ms.getMesTape().equals(MessageType.message_comm_mes)){
					Xiancheng xc=Xianchengbiaoshi.getXiancheng(ms.getGetter());
					ObjectOutputStream oos=new ObjectOutputStream(xc.s.getOutputStream());
					oos.writeObject(ms);
				}else if(ms.getMesTape().equals(MessageType.message_get_onLineFriend)){
					String res=Xianchengbiaoshi.getZaixianyonghu();
					Message ms1=new Message();
					ms1.setMesTape(MessageType.message_ret_onLineFriend);
					ms1.setCon(res);
					ms1.setGetter(ms.getSender());
					ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
					oos.writeObject(ms1);
				}
			} catch(Exception e) {}



		}
	}


}
