//���׿ͻ���L13_1Ϊ������

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
			System.out.println("���ǿͻ���");
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);//(���λ�ã��Ƿ��Զ�ˢ��)
		//	pw.println("���ǿͻ���");
			InputStreamReader isr=new InputStreamReader(s.getInputStream());//��ȡ���������
			BufferedReader br=new BufferedReader(isr);
		//	String back=br.readLine();
		//	System.out.print(back);
			
			InputStreamReader isr2=new InputStreamReader(System.in);//��ȡ��������
			BufferedReader br2=new BufferedReader(isr2);
			
			while(true){
				String back=br.readLine();
				System.out.println("������˵:"+back);
				
				System.out.print("���ǿͻ��ˣ���˵��");
				String word=br2.readLine();
				pw.println(word);
				
			}
			
		}catch(Exception e){}
	}
}