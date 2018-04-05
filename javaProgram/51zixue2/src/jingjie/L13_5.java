package jingjie;

import java.io.*;
import java.net.*;

public class L13_5 {
	public static void main(String[] args){
		L13_5 aa=new L13_5();
	}
	public L13_5(){
		try{
			ServerSocket ss=new ServerSocket(9999);
			Socket s=ss.accept();
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			L13_use use=(L13_use) ois.readObject();
			System.out.println(use.getName());
			System.out.println(use.getPassword());
		}catch(Exception e){}
	}
}
