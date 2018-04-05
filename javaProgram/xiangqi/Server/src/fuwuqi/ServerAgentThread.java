package fuwuqi;
import java.io.*;
import java.net.*;
import java.util.*;
public class ServerAgentThread extends Thread{//用来管理父类端口线程的工具（代理线程）
	Server father;
	Socket sc;
	DataInputStream din;//创建数据输入输出流
	DataOutputStream dout;
	boolean flag=true;
	public ServerAgentThread(Server father,Socket sc){//因为是线程代理线程，所以构造方法要传递父类和父类端口
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
				String msg=din.readUTF().trim();//接收用户返回信息
				if(msg.startsWith("<#NICK_NAME#>")){//信息内容以NICK_NAME开头，收到新用户信息
					this.nick_name(msg);
				}else if(msg.startsWith("<#CLIENT_LEAVE#>")){//收到用户离开信息
					this.client_leave(msg);
				}else if(msg.startsWith("<#TIAO_ZHAN#>")){//收到挑战信息
					this.tiao_zhan(msg);
				}else if(msg.startsWith("<#TONG_YI#>")){//收到同意挑战信息
					this.tong_yi(msg);
				}else if(msg.startsWith("<#BUTONG_YI#>")){//收到不同意挑战信息
					this.butong_yi(msg);
				}else if(msg.startsWith("<#BUSY#>")){//收到用户正在忙（下棋）的信息
					this.busy(msg);
				}else if(msg.startsWith("<#MOVE#>")){//收到用户下棋移动的信息
					this.move(msg);
				}else if(msg.startsWith("<#RENSHU#>")){//收到认输的信息
					this.renshu(msg);
				}
			} catch (Exception e) {}
		}
	}


	public void nick_name(String msg){
		try{
			String name=msg.substring(13);//读取传递来的姓名（因为前13个字符为<#NICK_NAME#>，所以是从第14个字符开始读取（下标13）
			this.setName(name);//为该线程取名
			Vector v=father.onlineList;
			boolean isChongMing=false;
			for(int i=0;i<v.size();i++){
				ServerAgentThread tempSat=(ServerAgentThread) v.get(i);
				if(tempSat.getName().equals(name)){
					isChongMing=true;
					break;
				}
			}
			if(isChongMing){//如果重名
				dout.writeUTF("<#NAME_CHONGMING#>");//将重名信息发送给客户端
				sc.close();
				din.close();
				dout.close();
				flag=false;
			}else{//不重名
				v.add(this);
				father.refreshList();
				String nickListMsg="";
				for(int i=0;i<v.size();i++){
					ServerAgentThread tempSat=(ServerAgentThread) v.get(i);
					nickListMsg=nickListMsg+"|"+tempSat.getName();
				}
				nickListMsg="<#NICK_LIST#>"+nickListMsg;//给信息打上便签以便服务器端读取
				for(int i=0;i<v.size();i++){
					ServerAgentThread tempSat=(ServerAgentThread) v.get(i);
					tempSat.dout.writeUTF(nickListMsg);//把在线用户信息发送给每一个用户
					if(tempSat!=this){
						tempSat.dout.writeUTF("<#MSG#>"+this.getName()+"上线了...");//给除自己外的用户发送消息
					}
				}
			}
			
		}catch(Exception e){}
	}
	public void client_leave(String msg){//用户点击离线事件
		try{
			Vector v=father.onlineList;
			v.remove(this);
			String nickListMsg="";
			for(int i=0;i<v.size();i++){
				ServerAgentThread tempSat=(ServerAgentThread) v.get(i);
				nickListMsg=nickListMsg+"|"+tempSat.getName();
			}
			nickListMsg="<#NICK_LIST#>"+nickListMsg;//给信息打上便签以便服务器端读取
			for(int i=0;i<v.size();i++){
				ServerAgentThread tempSat=(ServerAgentThread) v.get(i);
				tempSat.dout.writeUTF(nickListMsg);//把在线用户信息发送给每一个用户
				if(tempSat!=this){
					tempSat.dout.writeUTF("<#MSG#>"+this.getName()+"离线了...");//给除自己外的用户发送消息
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
				if(tempSat.getName().equals(name2)){//给被挑战者发送挑战信息和挑战者name
					tempSat.dout.writeUTF("<#TIAO_ZHAN#>"+name1);
					break;
				}
			}
		}catch(Exception e){}
	}
	public void tong_yi(String msg){
		try{
			String name=msg.substring(11);//提取挑战者名字
			Vector v=father.onlineList;
			for(int i=0;i<v.size();i++){
				ServerAgentThread tempSat=(ServerAgentThread) v.get(i);
				if(tempSat.getName().equals(name)){//给被挑战者发送挑战信息和挑战者name
					tempSat.dout.writeUTF("<#TONG_YI#>");
					break;
				}
			}
		}catch(Exception e){}
	}
	public void butong_yi(String msg){
		try{
			String name=msg.substring(13);//提取挑战者名字
			Vector v=father.onlineList;
			for(int i=0;i<v.size();i++){
				ServerAgentThread tempSat=(ServerAgentThread) v.get(i);
				if(tempSat.getName().equals(name)){//给被挑战者发送挑战信息和挑战者name
					tempSat.dout.writeUTF("<#BUTONG_YI#>");
					break;
				}
			}
		}catch(Exception e){}
	}
	public void busy(String msg){
		try{
			String name=msg.substring(8);//提取挑战者名字
			Vector v=father.onlineList;
			for(int i=0;i<v.size();i++){
				ServerAgentThread tempSat=(ServerAgentThread) v.get(i);
				if(tempSat.getName().equals(name)){//给被挑战者发送挑战信息和挑战者name
					tempSat.dout.writeUTF("<#BUSY#>");
					break;
				}
			}
		}catch(Exception e){}
	}
	public void move(String msg){
		try{
			String name=msg.substring(8,msg.length()-4);//获得接收方名字
			Vector v=father.onlineList;
			for(int i=0;i<v.size();i++){
				ServerAgentThread tempSat=(ServerAgentThread) v.get(i);
				if(tempSat.getName().equals(name)){//给被挑战者发送挑战信息和挑战者name
					tempSat.dout.writeUTF(msg);
					break;
				}
			}
		}catch(Exception e){}
	}
	public void renshu(String msg){
		try{
			String name=msg.substring(10);//获得接收方名字
			Vector v=father.onlineList;
			for(int i=0;i<v.size();i++){
				ServerAgentThread tempSat=(ServerAgentThread) v.get(i);
				if(tempSat.getName().equals(name)){//给被挑战者发送挑战信息和挑战者name
					tempSat.dout.writeUTF(msg);
					break;
				}
			}
		}catch(Exception e){}
	}
}
