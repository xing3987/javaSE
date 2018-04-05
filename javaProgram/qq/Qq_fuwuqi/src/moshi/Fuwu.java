package moshi;
import java.io.*;
import java.net.*;

import gonggong.*;
public class Fuwu {
	public Fuwu(){
		try {
			ServerSocket ss=new ServerSocket(9999);
			while(true){
				Socket s=ss.accept();
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				User u=(User)ois.readObject();
				ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
				Message ms=new Message();
				if(u.getPassword().equals("123456")){					
					ms.setMesTape("1");
					oos.writeObject(ms);
					Xiancheng xc=new Xiancheng(s);
					Xianchengbiaoshi.addXiancheng(u.getName(), xc);
					xc.start();
					xc.tongzhi(u.getName());

				}else{
					ms.setMesTape("2");
					oos.writeObject(ms);
					s.close();
				}

			}
		} catch (Exception e) {}
	}
}
