package fuwuqi;
import java.io.IOException;
import java.net.*;
public class ServerThread extends Thread{//服务类的线程
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
				Socket sc=ss.accept();//等待客户连接
				ServerAgentThread sat=new ServerAgentThread(father,sc);//连接上后创建代理线程
				sat.start();//启动代理线程
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
