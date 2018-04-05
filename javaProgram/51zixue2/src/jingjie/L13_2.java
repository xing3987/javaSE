//简易客户端L13_1为服务器

package jingjie;
import java.io.*;
import java.net.*;

public class L13_2 {
	public static void main(String[] args){
		L13_2 aa=new L13_2();
	}
	public L13_2(){
		try{
			Socket s=new Socket("127.0.0.1",9999);
			System.out.println("我是客户端");
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);//(输出位置，是否自动刷新)
		//	pw.println("我是客户端");
			InputStreamReader isr=new InputStreamReader(s.getInputStream());//读取服务端内容
			BufferedReader br=new BufferedReader(isr);
		//	String back=br.readLine();
		//	System.out.print(back);
			
			InputStreamReader isr2=new InputStreamReader(System.in);//读取键盘输入
			BufferedReader br2=new BufferedReader(isr2);
			
			while(true){
				String back=br.readLine();
				System.out.println("服务器说:"+back);
				
				System.out.print("我是客户端，我说：");
				String word=br2.readLine();
				pw.println(word);
				
			}
			
		}catch(Exception e){}
	}
}