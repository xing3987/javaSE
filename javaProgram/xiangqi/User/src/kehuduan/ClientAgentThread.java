package kehuduan;
import java.io.*;
import java.util.*;
import javax.swing.*;
public class ClientAgentThread extends Thread{
	XiangQi father;
	boolean flag=true;
	DataInputStream dis;
	DataOutputStream dos;
	String tiaoZhanZhe=null;
	public ClientAgentThread(XiangQi father){
		this.father=father;
		try{
			dis=new DataInputStream(father.sc.getInputStream());
			dos=new DataOutputStream(father.sc.getOutputStream());
			String name=father.jtfNickName.getText().trim();
			dos.writeUTF("<#NICK_NAME#>"+name);//发送名称到服务器
		}catch(Exception e){}
	}

	public void run(){
		while(flag){
			try{
				String msg=dis.readUTF().trim();
				if(msg.startsWith("<#NAME_CHONGMING#>")){
					this.name_chongming();
				}else if(msg.startsWith("<#NICK_LIST#>")){
					this.nick_list(msg);
				}else if(msg.startsWith("<#SERVER_DOWN#>")){
					this.server_down(msg);
				}else if(msg.startsWith("<#TIAO_ZHAN#>")){
					this.tiao_zhan(msg);
				}else if(msg.startsWith("<#TONG_YI#>")){
					this.tong_yi(msg);
				}else if(msg.startsWith("<#BUTONG_YI#>")){
					this.butong_yi();
				}else if(msg.startsWith("<#BUSY#>")){
					this.busy(msg);
				}else if(msg.startsWith("<#MOVE#>")){
					this.move(msg);
				}else if(msg.startsWith("<#RENSHU#>")){
					this.renshu(msg);
				}
			}catch(Exception e){}
		}
	}

	public void name_chongming(){
		JOptionPane.showMessageDialog(this.father, "当前姓名已经被占用","错误",JOptionPane.ERROR_MESSAGE);
		try{
			dos.close();
			dis.close();
			this.father.jtfHost.setEnabled(!false);//将用于输入主机名的文本框设为可用
			this.father.jtfPort.setEnabled(!false);//将用于输入端口号的文本框设为可用
			this.father.jtfNickName.setEnabled(!false);//将用于输入昵称的文本框设为可用
			this.father.jbConnect.setEnabled(!false);//将"连接"按钮设为可用
			this.father.jbDisconnect.setEnabled(!true);//将"断开"按钮设为不可用
			this.father.jbChallenge.setEnabled(!true);//将"挑战"按钮设为不可用
			this.father.jbYChallenge.setEnabled(false);//将"接受挑战"按钮设为不可用
			this.father.jbNChallenge.setEnabled(false);//将"拒绝挑战"按钮设为不可用
			this.father.jbFail.setEnabled(false);//将"认输"按钮设为不可用
			father.sc.close();
			father.sc=null;
			father.cat=null;
			this.flag=false;
		}catch(Exception e){}
	}
	public void nick_list(String msg){
		String s=msg.substring(13);//得到姓名列表的字符串，前13个字符为<#NICK_LIST#>
		String na[]=s.split("\\|");
		Vector v=new Vector();//创建Vector对象
		for(int i=0;i<na.length;i++){
			if(na[i].trim().length()!=0&&(!na[i].trim().equals(father.jtfNickName.getText().trim()))){
				v.add(na[i]);//将昵称全部添加到Vector中
			}
		}
		father.jcbNickList.setModel(new DefaultComboBoxModel(v));//设置下拉列表的值
	}
	public void server_down(String msg){
		this.father.jtfHost.setEnabled(!false);//将用于输入主机名的文本框设为可用
		this.father.jtfPort.setEnabled(!false);;//将用于输入端口号的文本框设为可用
		this.father.jtfNickName.setEnabled(!false);//将用于输入昵称的文本框设为可用
		this.father.jbConnect.setEnabled(!false);//将"连接"按钮设为可用
		this.father.jbDisconnect.setEnabled(!true);//将"断开"按钮设为不可用
		this.father.jbChallenge.setEnabled(!true);//将"挑战"按钮设为不可用
		this.father.jbYChallenge.setEnabled(false);//将"接受挑战"按钮设为不可用
		this.father.jbNChallenge.setEnabled(false);//将"拒绝挑战"按钮设为不可用
		this.father.jbFail.setEnabled(false);//将"认输"按钮设为不可用
		this.flag=false;//终止该客户端代理线程
		father.cat=null;
		JOptionPane.showMessageDialog(this.father,"服务器停止！！！","提示",
		           JOptionPane.INFORMATION_MESSAGE);//给出服务器离开的提示信息
	}
	public void tiao_zhan(String msg){
		try{
			String name=msg.substring(13);//获得挑战者的昵称
			if(this.tiaoZhanZhe==null){//如果玩家空闲
				tiaoZhanZhe=msg.substring(13);//将tiaoZhanZhe的值赋为挑战者的昵称
				this.father.jtfHost.setEnabled(false);//将用于输入主机名的文本框设为不可用
				this.father.jtfPort.setEnabled(false);//将用于输入端口号的文本框设为不可用
				this.father.jtfNickName.setEnabled(false);//将用于输入昵称的文本框设为不可用
				this.father.jbConnect.setEnabled(false);//将"连接"按钮设为不可用
				this.father.jbDisconnect.setEnabled(!true);//将"断开"按钮设为不可用
				this.father.jbChallenge.setEnabled(!true);//将"挑战"按钮设为不可用
				this.father.jbYChallenge.setEnabled(!false);//将"接受挑战"按钮设为可用
				this.father.jbNChallenge.setEnabled(!false);//将"拒绝挑战"按钮设为可用
				this.father.jbFail.setEnabled(false);//将"认输"按钮设为不可用
				JOptionPane.showMessageDialog(this.father,tiaoZhanZhe+"向你挑战!!!",
				           "提示",JOptionPane.INFORMATION_MESSAGE);//给出挑战信息
			}
			else{//如果该玩家忙碌中 ，则返回一个<#BUSY#>开头的信息
				this.dos.writeUTF("<#BUSY#>"+name);
			}
		}
		catch(IOException e){e.printStackTrace();}
	}
	public void tong_yi(String msg){
		this.father.caiPan=true;//*****************设置成走棋状态
		this.father.jtfHost.setEnabled(false);//将用于输入主机名的文本框设为不可用
		this.father.jtfPort.setEnabled(false);//将用于输入端口号的文本框设为不可用
		this.father.jtfNickName.setEnabled(false);//将用于输入昵称的文本框设为不可用
		this.father.jbConnect.setEnabled(false);//将"连接"按钮设为不可用
		this.father.jbDisconnect.setEnabled(!true);//将"断开"按钮设为不可用
		this.father.jbChallenge.setEnabled(!true);//将"挑战"按钮设为不可用
		this.father.jbYChallenge.setEnabled(false);//将"接受挑战"按钮设为不可用
		this.father.jbNChallenge.setEnabled(false);//将"拒绝挑战"按钮设为不可用
		this.father.jbFail.setEnabled(!false);//将"认输"按钮设为不可用
		JOptionPane.showMessageDialog(this.father,"对方接受您的挑战!您先走棋(红棋)",
		                           "提示",JOptionPane.INFORMATION_MESSAGE);
	}
	public void butong_yi(){
		this.father.caiPan=false;//将caiPan设为false
		this.father.color=0;//将color设为0
		this.father.jtfHost.setEnabled(false);//将用于输入主机名的文本框设为不可用
		this.father.jtfPort.setEnabled(false);//将用于输入端口号的文本框设为不可用
		this.father.jtfNickName.setEnabled(false);//将用于输入昵称的文本框设为不可用
		this.father.jbConnect.setEnabled(false);//将"连接"按钮设为不可用
		this.father.jbDisconnect.setEnabled(true);//将"断开"按钮设为可用
		this.father.jbChallenge.setEnabled(true);//将"挑战"按钮设为可用
		this.father.jbYChallenge.setEnabled(false);//将"接受挑战"按钮设为不可用
		this.father.jbNChallenge.setEnabled(false);//将"拒绝挑战"按钮设为不可用
		this.father.jbFail.setEnabled(false);//将"认输"按钮设为不可用
		JOptionPane.showMessageDialog(this.father,"对方拒绝您的挑战!","提示",
		            JOptionPane.INFORMATION_MESSAGE);//给出对方拒绝挑战的提示信息
		this.tiaoZhanZhe=null;
	}
	public void busy(String msg){
		this.father.caiPan=false;//将caiPan设为false
		this.father.color=0;//将color设为0
		this.father.jtfHost.setEnabled(false);//将用于输入主机名的文本框设为不可用
		this.father.jtfPort.setEnabled(false);//将用于输入端口号的文本框设为不可用
		this.father.jtfNickName.setEnabled(false);//将用于输入昵称的文本框设为不可用
		this.father.jbConnect.setEnabled(false);//将"连接"按钮设为不可用
		this.father.jbDisconnect.setEnabled(true);//将"断开"按钮设为可用
		this.father.jbChallenge.setEnabled(true);//将"挑战"按钮设为可用
		this.father.jbYChallenge.setEnabled(false);//将"接受挑战"按钮设为不可用
		this.father.jbNChallenge.setEnabled(false);//将"拒绝挑战"按钮设为不可用
		this.father.jbFail.setEnabled(false);//将"认输"按钮设为不可用
		JOptionPane.showMessageDialog(this.father,"对方忙碌中！！！","提示",
		            JOptionPane.INFORMATION_MESSAGE);//给出对方忙碌的提示信息
		this.tiaoZhanZhe=null;
	}
	public void move(String msg){
		int length=msg.length();
		int startI=Integer.parseInt(msg.substring(length-4,length-3));//获得棋子的原始位置
		int startJ=Integer.parseInt(msg.substring(length-3,length-2));
		int endI=Integer.parseInt(msg.substring(length-2,length-1));//获得走后的位置
		int endJ=Integer.parseInt(msg.substring(length-1));
		this.father.jpz.move(startI,startJ,endI,endJ);//调用方法走棋
		this.father.caiPan=true;//将caiPan设为true
	}
	public void renshu(String msg){
		JOptionPane.showMessageDialog(this.father,"恭喜你,你获胜,对方认输","提示",
	             JOptionPane.INFORMATION_MESSAGE);//给出获胜信息
	this.tiaoZhanZhe=null;//将挑战者设为空
	this.father.color=0;//将color设为0
	this.father.caiPan=false;//将caiPan设为false
	this.father.next();//进入下一盘
	this.father.jtfHost.setEnabled(false);//将用于输入主机名的文本框设为不可用
	this.father.jtfPort.setEnabled(false);//将用于输入端口号的文本框设为不可用
	this.father.jtfNickName.setEnabled(false);//将用于输入昵称的文本框设为不可用
	this.father.jbConnect.setEnabled(false);//将"连接"按钮设为不可用
	this.father.jbDisconnect.setEnabled(true);//将"断开"按钮设为可用
	this.father.jbChallenge.setEnabled(true);//将"挑战"按钮设为可用
	this.father.jbYChallenge.setEnabled(false);//将"接受挑战"按钮设为不可用
	this.father.jbNChallenge.setEnabled(false);//将"拒绝挑战"按钮设为不可用
	this.father.jbFail.setEnabled(false);//将"认输"按钮设为不可用
	}
}
