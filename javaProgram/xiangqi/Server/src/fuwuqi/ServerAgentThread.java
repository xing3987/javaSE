package fuwuqi;
import java.io.*;
import java.net.*;
import java.util.*;
public class ServerAgentThread extends Thread{//����������˿��̵߳Ĺ��ߣ������̣߳�
	Server father;
	Socket sc;
	DataInputStream din;//�����������������
	DataOutputStream dout;
	boolean flag=true;
	public ServerAgentThread(Server father,Socket sc){//��Ϊ���̴߳����̣߳����Թ��췽��Ҫ���ݸ���͸���˿�
		this.father=father;
		this.sc=sc;
		try {
			din=new DataInputStream(sc.getInputStream());
			dout=new DataOutputStream(sc.getOutputStream());
		} catch (IOException e) {}
	}

	public void run(){
		while(flag){
			try {
				String msg=din.readUTF().trim();//�����û�������Ϣ
				if(msg.startsWith("<#NICK_NAME#>")){//��Ϣ������NICK_NAME��ͷ���յ����û���Ϣ
					this.nick_name(msg);
				}else if(msg.startsWith("<#CLIENT_LEAVE#>")){//�յ��û��뿪��Ϣ
					this.client_leave(msg);
				}else if(msg.startsWith("<#TIAO_ZHAN#>")){//�յ���ս��Ϣ
					this.tiao_zhan(msg);
				}else if(msg.startsWith("<#TONG_YI#>")){//�յ�ͬ����ս��Ϣ
					this.tong_yi(msg);
				}else if(msg.startsWith("<#BUTONG_YI#>")){//�յ���ͬ����ս��Ϣ
					this.butong_yi(msg);
				}else if(msg.startsWith("<#BUSY#>")){//�յ��û�����æ�����壩����Ϣ
					this.busy(msg);
				}else if(msg.startsWith("<#MOVE#>")){//�յ��û������ƶ�����Ϣ
					this.move(msg);
				}else if(msg.startsWith("<#RENSHU#>")){//�յ��������Ϣ
					this.renshu(msg);
				}
			} catch (Exception e) {}
		}
	}


	public void nick_name(String msg){
		try{
			String name=msg.substring(13);//��ȡ����������������Ϊǰ13���ַ�Ϊ<#NICK_NAME#>�������Ǵӵ�14���ַ���ʼ��ȡ���±�13��
			this.setName(name);//Ϊ���߳�ȡ��
			Vector v=father.onlineList;
			boolean isChongMing=false;
			for(int i=0;i<v.size();i++){
				ServerAgentThread tempSat=(ServerAgentThread) v.get(i);
				if(tempSat.getName().equals(name)){
					isChongMing=true;
					break;
				}
			}
			if(isChongMing){//�������
				dout.writeUTF("<#NAME_CHONGMING#>");//��������Ϣ���͸��ͻ���
				sc.close();
				din.close();
				dout.close();
				flag=false;
			}else{//������
				v.add(this);
				father.refreshList();
				String nickListMsg="";
				for(int i=0;i<v.size();i++){
					ServerAgentThread tempSat=(ServerAgentThread) v.get(i);
					nickListMsg=nickListMsg+"|"+tempSat.getName();
				}
				nickListMsg="<#NICK_LIST#>"+nickListMsg;//����Ϣ���ϱ�ǩ�Ա�������˶�ȡ
				for(int i=0;i<v.size();i++){
					ServerAgentThread tempSat=(ServerAgentThread) v.get(i);
					tempSat.dout.writeUTF(nickListMsg);//�������û���Ϣ���͸�ÿһ���û�
					if(tempSat!=this){
						tempSat.dout.writeUTF("<#MSG#>"+this.getName()+"������...");//�����Լ�����û�������Ϣ
					}
				}
			}
			
		}catch(Exception e){}
	}
	public void client_leave(String msg){//�û���������¼�
		try{
			Vector v=father.onlineList;
			v.remove(this);
			String nickListMsg="";
			for(int i=0;i<v.size();i++){
				ServerAgentThread tempSat=(ServerAgentThread) v.get(i);
				nickListMsg=nickListMsg+"|"+tempSat.getName();
			}
			nickListMsg="<#NICK_LIST#>"+nickListMsg;//����Ϣ���ϱ�ǩ�Ա�������˶�ȡ
			for(int i=0;i<v.size();i++){
				ServerAgentThread tempSat=(ServerAgentThread) v.get(i);
				tempSat.dout.writeUTF(nickListMsg);//�������û���Ϣ���͸�ÿһ���û�
				if(tempSat!=this){
					tempSat.dout.writeUTF("<#MSG#>"+this.getName()+"������...");//�����Լ�����û�������Ϣ
				}
			}
			father.refreshList();
			flag=false;
			sc.close();			//____________________________________________
			din.close();		//____________________________________________
			dout.close();		//____________________________________________
			
		}catch(Exception e){}
	}
	public void tiao_zhan(String msg){
		try{
			String name1=this.getName();
			String name2=msg.substring(13);
			Vector v=father.onlineList;
			for(int i=0;i<v.size();i++){
				ServerAgentThread tempSat=(ServerAgentThread) v.get(i);
				if(tempSat.getName().equals(name2)){//������ս�߷�����ս��Ϣ����ս��name
					tempSat.dout.writeUTF("<#TIAO_ZHAN#>"+name1);
					break;
				}
			}
		}catch(Exception e){}
	}
	public void tong_yi(String msg){
		try{
			String name=msg.substring(11);//��ȡ��ս������
			Vector v=father.onlineList;
			for(int i=0;i<v.size();i++){
				ServerAgentThread tempSat=(ServerAgentThread) v.get(i);
				if(tempSat.getName().equals(name)){//������ս�߷�����ս��Ϣ����ս��name
					tempSat.dout.writeUTF("<#TONG_YI#>");
					break;
				}
			}
		}catch(Exception e){}
	}
	public void butong_yi(String msg){
		try{
			String name=msg.substring(13);//��ȡ��ս������
			Vector v=father.onlineList;
			for(int i=0;i<v.size();i++){
				ServerAgentThread tempSat=(ServerAgentThread) v.get(i);
				if(tempSat.getName().equals(name)){//������ս�߷�����ս��Ϣ����ս��name
					tempSat.dout.writeUTF("<#BUTONG_YI#>");
					break;
				}
			}
		}catch(Exception e){}
	}
	public void busy(String msg){
		try{
			String name=msg.substring(8);//��ȡ��ս������
			Vector v=father.onlineList;
			for(int i=0;i<v.size();i++){
				ServerAgentThread tempSat=(ServerAgentThread) v.get(i);
				if(tempSat.getName().equals(name)){//������ս�߷�����ս��Ϣ����ս��name
					tempSat.dout.writeUTF("<#BUSY#>");
					break;
				}
			}
		}catch(Exception e){}
	}
	public void move(String msg){
		try{
			String name=msg.substring(8,msg.length()-4);//��ý��շ�����
			Vector v=father.onlineList;
			for(int i=0;i<v.size();i++){
				ServerAgentThread tempSat=(ServerAgentThread) v.get(i);
				if(tempSat.getName().equals(name)){//������ս�߷�����ս��Ϣ����ս��name
					tempSat.dout.writeUTF(msg);
					break;
				}
			}
		}catch(Exception e){}
	}
	public void renshu(String msg){
		try{
			String name=msg.substring(10);//��ý��շ�����
			Vector v=father.onlineList;
			for(int i=0;i<v.size();i++){
				ServerAgentThread tempSat=(ServerAgentThread) v.get(i);
				if(tempSat.getName().equals(name)){//������ս�߷�����ս��Ϣ����ս��name
					tempSat.dout.writeUTF(msg);
					break;
				}
			}
		}catch(Exception e){}
	}
}
