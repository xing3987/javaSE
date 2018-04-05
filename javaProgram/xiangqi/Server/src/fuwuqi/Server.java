package fuwuqi;
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.util.*;
public class Server extends JFrame implements ActionListener{
	JLabel jlPort=new JLabel("�˿ں�");
	JTextField jtfPort=new JTextField("9999");
	JButton jbStart=new JButton("����");
	JButton jbStop=new JButton("ֹͣ");
	JPanel jp1=new JPanel();
	JList jlUserOnline=new JList();
	JScrollPane jsp=new JScrollPane(jlUserOnline);
	JSplitPane splitPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jsp,jp1);
	ServerSocket ss;
	ServerThread st;
	Vector onlineList=new Vector();//�����̼߳����࣬һ�������̵߳�name����һ���û���name

	public Server(){
		this.initialComponent();//��ʼ���ؼ�
		this.addListener();//��Ӽ���
		this.initialFrame();//��ʼ������
	}

	public void initialComponent(){//��ʼ���ؼ�
		jp1.setLayout(null);
		jlPort.setBounds(15,10,40,20);
		jtfPort.setBounds(65,10,40,20);
		jbStart.setBounds(5,50,60,20);
		jbStop.setBounds(65,50,60,20);
		jp1.add(jlPort);jp1.add(jtfPort);jp1.add(jbStart);jp1.add(jbStop);
		jbStop.setEnabled(false);
	}

	public void addListener(){//��Ӽ���
		jbStart.addActionListener(this);
		jbStop.addActionListener(this);
	}

	public void initialFrame(){//��ʼ������
		splitPane.setDividerLocation(200);
		splitPane.setDividerSize(4);
		this.add(splitPane);
		this.setBounds(100,100,350,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
		this.setTitle("�������������");
		this.setIconImage(new ImageIcon("").getImage());
		this.addWindowListener(//���Ӵ����¼�����,�������Ӳ��ڴ������ӣ�Ϊ�˾������
				new WindowAdapter(){//ֻ�Ǹ�����д��Ҫ�Ĺ��캯��
					public void windowClosing(WindowEvent e){
						if(st==null){
							System.exit(0);
							return;
						}else{
							try{
								Vector v=onlineList;
								for(int i=0;i<v.size();i++){
									ServerAgentThread tempSat=(ServerAgentThread) v.get(i);
									tempSat.dout.writeUTF("<#SERVER_DOWN#>");
									tempSat.flag=false;
								}
								st.flag=false;
								st=null;
								ss.close();
								v.clear();
								refreshList();
							}catch(Exception e1){}
							System.exit(0);
						}

					}
				}
				);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbStart){
			this.jbStart_event();
		}else if(e.getSource()==jbStop){
			this.jbStop_event();
		}

	}	

	public void jbStart_event(){//�����ʼ��ť�¼�
		int port=0;
		try{
			port=Integer.parseInt(jtfPort.getText().trim());
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "�˿�ֻ��������","����",JOptionPane.ERROR_MESSAGE);//(��ǰ������ʾ�����ݣ�������������ͼ��)
			return;
		}
		if(port>65535||port<0){
			JOptionPane.showMessageDialog(this,"�˿ں�ֻ����0-65535������","����",JOptionPane.ERROR_MESSAGE);
			return;
		}
		try{
			jtfPort.setEnabled(false);
			jbStart.setEnabled(false);
			jbStop.setEnabled(true);
			ss=new ServerSocket(port);
			st=new ServerThread(this);
			st.start();
			JOptionPane.showMessageDialog(this,"�������Ѿ�����");
		
		}catch(Exception e1){
			JOptionPane.showMessageDialog(this, "��������������","����",JOptionPane.ERROR_MESSAGE);
			jbStop.setEnabled(false);
			jbStart.setEnabled(true);
			jtfPort.setEnabled(true);
		}
	}

	public void jbStop_event(){//����رհ�ť�¼�
		try{
			Vector v=onlineList;
			for(int i=0;i<v.size();i++){
				ServerAgentThread tempSat=(ServerAgentThread) v.get(i);
				tempSat.dout.writeUTF("<#SERVER_DOWN#>");
				tempSat.flag=false;
			}
			st.flag=false;
			st=null;
			ss.close();
			v.clear();
			refreshList();
		}catch(Exception e){}
		JOptionPane.showMessageDialog(this, "������ֹͣ");
		jbStop.setEnabled(false);
		jbStart.setEnabled(true);
		jtfPort.setEnabled(true);
	}

	public void refreshList(){//����������Ϣ
		Vector vList=new Vector();
		Vector v=onlineList;
		for(int i=0;i<v.size();i++){
			ServerAgentThread tempSat=(ServerAgentThread) v.get(i);
			String vListString=tempSat.sc.getInetAddress().toString();
			vListString+="|"+tempSat.getName();
			vList.add(vListString);
		}
		jlUserOnline.setListData(vList);//�����б�����
	}

	public static void main(String[] args){
		new Server();
	}



}
