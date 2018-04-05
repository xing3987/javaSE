package jingjie;

import java.io.*;
import java.net.*;

public class L13_6{
	public static void main(String[] args){
		L13_6 aa=new L13_6();
	}
	public L13_6(){
		try{
			Socket s=new Socket("127.0.0.1",9999);
			ObjectOutputStream ops=new ObjectOutputStream(s.getOutputStream());
			L13_use use=new L13_use();
			use.setName("уехЩ");
			use.setPassword("123456");
			ops.writeObject(use);
		}catch(Exception e){}
	}
}
