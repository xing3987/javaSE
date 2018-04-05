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
			dos.writeUTF("<#NICK_NAME#>"+name);//�������Ƶ�������
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
		JOptionPane.showMessageDialog(this.father, "��ǰ�����Ѿ���ռ��","����",JOptionPane.ERROR_MESSAGE);
		try{
			dos.close();
			dis.close();
			this.father.jtfHost.setEnabled(!false);//�������������������ı�����Ϊ����
			this.father.jtfPort.setEnabled(!false);//����������˿ںŵ��ı�����Ϊ����
			this.father.jtfNickName.setEnabled(!false);//�����������ǳƵ��ı�����Ϊ����
			this.father.jbConnect.setEnabled(!false);//��"����"��ť��Ϊ����
			this.father.jbDisconnect.setEnabled(!true);//��"�Ͽ�"��ť��Ϊ������
			this.father.jbChallenge.setEnabled(!true);//��"��ս"��ť��Ϊ������
			this.father.jbYChallenge.setEnabled(false);//��"������ս"��ť��Ϊ������
			this.father.jbNChallenge.setEnabled(false);//��"�ܾ���ս"��ť��Ϊ������
			this.father.jbFail.setEnabled(false);//��"����"��ť��Ϊ������
			father.sc.close();
			father.sc=null;
			father.cat=null;
			this.flag=false;
		}catch(Exception e){}
	}
	public void nick_list(String msg){
		String s=msg.substring(13);//�õ������б���ַ�����ǰ13���ַ�Ϊ<#NICK_LIST#>
		String na[]=s.split("\\|");
		Vector v=new Vector();//����Vector����
		for(int i=0;i<na.length;i++){
			if(na[i].trim().length()!=0&&(!na[i].trim().equals(father.jtfNickName.getText().trim()))){
				v.add(na[i]);//���ǳ�ȫ����ӵ�Vector��
			}
		}
		father.jcbNickList.setModel(new DefaultComboBoxModel(v));//���������б��ֵ
	}
	public void server_down(String msg){
		this.father.jtfHost.setEnabled(!false);//�������������������ı�����Ϊ����
		this.father.jtfPort.setEnabled(!false);;//����������˿ںŵ��ı�����Ϊ����
		this.father.jtfNickName.setEnabled(!false);//�����������ǳƵ��ı�����Ϊ����
		this.father.jbConnect.setEnabled(!false);//��"����"��ť��Ϊ����
		this.father.jbDisconnect.setEnabled(!true);//��"�Ͽ�"��ť��Ϊ������
		this.father.jbChallenge.setEnabled(!true);//��"��ս"��ť��Ϊ������
		this.father.jbYChallenge.setEnabled(false);//��"������ս"��ť��Ϊ������
		this.father.jbNChallenge.setEnabled(false);//��"�ܾ���ս"��ť��Ϊ������
		this.father.jbFail.setEnabled(false);//��"����"��ť��Ϊ������
		this.flag=false;//��ֹ�ÿͻ��˴����߳�
		father.cat=null;
		JOptionPane.showMessageDialog(this.father,"������ֹͣ������","��ʾ",
		           JOptionPane.INFORMATION_MESSAGE);//�����������뿪����ʾ��Ϣ
	}
	public void tiao_zhan(String msg){
		try{
			String name=msg.substring(13);//�����ս�ߵ��ǳ�
			if(this.tiaoZhanZhe==null){//�����ҿ���
				tiaoZhanZhe=msg.substring(13);//��tiaoZhanZhe��ֵ��Ϊ��ս�ߵ��ǳ�
				this.father.jtfHost.setEnabled(false);//�������������������ı�����Ϊ������
				this.father.jtfPort.setEnabled(false);//����������˿ںŵ��ı�����Ϊ������
				this.father.jtfNickName.setEnabled(false);//�����������ǳƵ��ı�����Ϊ������
				this.father.jbConnect.setEnabled(false);//��"����"��ť��Ϊ������
				this.father.jbDisconnect.setEnabled(!true);//��"�Ͽ�"��ť��Ϊ������
				this.father.jbChallenge.setEnabled(!true);//��"��ս"��ť��Ϊ������
				this.father.jbYChallenge.setEnabled(!false);//��"������ս"��ť��Ϊ����
				this.father.jbNChallenge.setEnabled(!false);//��"�ܾ���ս"��ť��Ϊ����
				this.father.jbFail.setEnabled(false);//��"����"��ť��Ϊ������
				JOptionPane.showMessageDialog(this.father,tiaoZhanZhe+"������ս!!!",
				           "��ʾ",JOptionPane.INFORMATION_MESSAGE);//������ս��Ϣ
			}
			else{//��������æµ�� ���򷵻�һ��<#BUSY#>��ͷ����Ϣ
				this.dos.writeUTF("<#BUSY#>"+name);
			}
		}
		catch(IOException e){e.printStackTrace();}
	}
	public void tong_yi(String msg){
		this.father.caiPan=true;//*****************���ó�����״̬
		this.father.jtfHost.setEnabled(false);//�������������������ı�����Ϊ������
		this.father.jtfPort.setEnabled(false);//����������˿ںŵ��ı�����Ϊ������
		this.father.jtfNickName.setEnabled(false);//�����������ǳƵ��ı�����Ϊ������
		this.father.jbConnect.setEnabled(false);//��"����"��ť��Ϊ������
		this.father.jbDisconnect.setEnabled(!true);//��"�Ͽ�"��ť��Ϊ������
		this.father.jbChallenge.setEnabled(!true);//��"��ս"��ť��Ϊ������
		this.father.jbYChallenge.setEnabled(false);//��"������ս"��ť��Ϊ������
		this.father.jbNChallenge.setEnabled(false);//��"�ܾ���ս"��ť��Ϊ������
		this.father.jbFail.setEnabled(!false);//��"����"��ť��Ϊ������
		JOptionPane.showMessageDialog(this.father,"�Է�����������ս!��������(����)",
		                           "��ʾ",JOptionPane.INFORMATION_MESSAGE);
	}
	public void butong_yi(){
		this.father.caiPan=false;//��caiPan��Ϊfalse
		this.father.color=0;//��color��Ϊ0
		this.father.jtfHost.setEnabled(false);//�������������������ı�����Ϊ������
		this.father.jtfPort.setEnabled(false);//����������˿ںŵ��ı�����Ϊ������
		this.father.jtfNickName.setEnabled(false);//�����������ǳƵ��ı�����Ϊ������
		this.father.jbConnect.setEnabled(false);//��"����"��ť��Ϊ������
		this.father.jbDisconnect.setEnabled(true);//��"�Ͽ�"��ť��Ϊ����
		this.father.jbChallenge.setEnabled(true);//��"��ս"��ť��Ϊ����
		this.father.jbYChallenge.setEnabled(false);//��"������ս"��ť��Ϊ������
		this.father.jbNChallenge.setEnabled(false);//��"�ܾ���ս"��ť��Ϊ������
		this.father.jbFail.setEnabled(false);//��"����"��ť��Ϊ������
		JOptionPane.showMessageDialog(this.father,"�Է��ܾ�������ս!","��ʾ",
		            JOptionPane.INFORMATION_MESSAGE);//�����Է��ܾ���ս����ʾ��Ϣ
		this.tiaoZhanZhe=null;
	}
	public void busy(String msg){
		this.father.caiPan=false;//��caiPan��Ϊfalse
		this.father.color=0;//��color��Ϊ0
		this.father.jtfHost.setEnabled(false);//�������������������ı�����Ϊ������
		this.father.jtfPort.setEnabled(false);//����������˿ںŵ��ı�����Ϊ������
		this.father.jtfNickName.setEnabled(false);//�����������ǳƵ��ı�����Ϊ������
		this.father.jbConnect.setEnabled(false);//��"����"��ť��Ϊ������
		this.father.jbDisconnect.setEnabled(true);//��"�Ͽ�"��ť��Ϊ����
		this.father.jbChallenge.setEnabled(true);//��"��ս"��ť��Ϊ����
		this.father.jbYChallenge.setEnabled(false);//��"������ս"��ť��Ϊ������
		this.father.jbNChallenge.setEnabled(false);//��"�ܾ���ս"��ť��Ϊ������
		this.father.jbFail.setEnabled(false);//��"����"��ť��Ϊ������
		JOptionPane.showMessageDialog(this.father,"�Է�æµ�У�����","��ʾ",
		            JOptionPane.INFORMATION_MESSAGE);//�����Է�æµ����ʾ��Ϣ
		this.tiaoZhanZhe=null;
	}
	public void move(String msg){
		int length=msg.length();
		int startI=Integer.parseInt(msg.substring(length-4,length-3));//������ӵ�ԭʼλ��
		int startJ=Integer.parseInt(msg.substring(length-3,length-2));
		int endI=Integer.parseInt(msg.substring(length-2,length-1));//����ߺ��λ��
		int endJ=Integer.parseInt(msg.substring(length-1));
		this.father.jpz.move(startI,startJ,endI,endJ);//���÷�������
		this.father.caiPan=true;//��caiPan��Ϊtrue
	}
	public void renshu(String msg){
		JOptionPane.showMessageDialog(this.father,"��ϲ��,���ʤ,�Է�����","��ʾ",
	             JOptionPane.INFORMATION_MESSAGE);//������ʤ��Ϣ
	this.tiaoZhanZhe=null;//����ս����Ϊ��
	this.father.color=0;//��color��Ϊ0
	this.father.caiPan=false;//��caiPan��Ϊfalse
	this.father.next();//������һ��
	this.father.jtfHost.setEnabled(false);//�������������������ı�����Ϊ������
	this.father.jtfPort.setEnabled(false);//����������˿ںŵ��ı�����Ϊ������
	this.father.jtfNickName.setEnabled(false);//�����������ǳƵ��ı�����Ϊ������
	this.father.jbConnect.setEnabled(false);//��"����"��ť��Ϊ������
	this.father.jbDisconnect.setEnabled(true);//��"�Ͽ�"��ť��Ϊ����
	this.father.jbChallenge.setEnabled(true);//��"��ս"��ť��Ϊ����
	this.father.jbYChallenge.setEnabled(false);//��"������ս"��ť��Ϊ������
	this.father.jbNChallenge.setEnabled(false);//��"�ܾ���ս"��ť��Ϊ������
	this.father.jbFail.setEnabled(false);//��"����"��ť��Ϊ������
	}
}
