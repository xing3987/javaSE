package fuwuqi;
import java.io.IOException;
import java.net.*;
public class ServerThread extends Thread{//��������߳�
	Server father;
	ServerSocket ss;
	boolean flag=true;
	public ServerThread(Server father){
		this.father=father;
		this.ss=father.ss;
	}

	public void run() {
		while(flag){
			try {
				Socket sc=ss.accept();//�ȴ��ͻ�����
				ServerAgentThread sat=new ServerAgentThread(father,sc);//�����Ϻ󴴽������߳�
				sat.start();//���������߳�
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
