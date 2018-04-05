//简易服务器
package jingjie;
import java.io.*;
import java.net.*;

public class L13_1 {
	public static void main(String[] args){
		L13_1 aa=new L13_1();
	}
	public L13_1(){
		try{
			ServerSocket ss=new ServerSocket(9999);
			System.out.println("服务器启动~~");
			Socket s=ss.accept();
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader(isr);
		//	String back=br.readLine();
		//	System.out.print(back);
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
		//	pw.println("我是服务器中的代码");
			
			InputStreamReader isr2=new InputStreamReader(System.in);//读取键盘输入
			BufferedReader br2=new BufferedReader(isr2);
			
			while(true){
				System.out.print("我是服务器，我说：");
				String word=br2.readLine();
				pw.println(word);
				String back=br.readLine();
				System.out.println("客户端说"+back);
				
			}
			
		}catch(Exception e){}
	}
}
