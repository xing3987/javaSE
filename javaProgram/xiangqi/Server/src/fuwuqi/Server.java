package fuwuqi;
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.util.*;
public class Server extends JFrame implements ActionListener{
	JLabel jlPort=new JLabel("端口号");
	JTextField jtfPort=new JTextField("9999");
	JButton jbStart=new JButton("启动");
	JButton jbStop=new JButton("停止");
	JPanel jp1=new JPanel();
	JList jlUserOnline=new JList();
	JScrollPane jsp=new JScrollPane(jlUserOnline);
	JSplitPane splitPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jsp,jp1);
	ServerSocket ss;
	ServerThread st;
	Vector onlineList=new Vector();//代理线程集合类，一个代理线程的name就是一个用户的name

	public Server(){
		this.initialComponent();//初始化控件
		this.addListener();//添加监听
		this.initialFrame();//初始化窗体
	}

	public void initialComponent(){//初始化控件
		jp1.setLayout(null);
		jlPort.setBounds(15,10,40,20);
		jtfPort.setBounds(65,10,40,20);
		jbStart.setBounds(5,50,60,20);
		jbStop.setBounds(65,50,60,20);
		jp1.add(jlPort);jp1.add(jtfPort);jp1.add(jbStart);jp1.add(jbStop);
		jbStop.setEnabled(false);
	}

	public void addListener(){//添加监听
		jbStart.addActionListener(this);
		jbStop.addActionListener(this);
	}

	public void initialFrame(){//初始化窗体
		splitPane.setDividerLocation(200);
		splitPane.setDividerSize(4);
		this.add(splitPane);
		this.setBounds(100,100,350,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
		this.setTitle("网络象棋服务器");
		this.setIconImage(new ImageIcon("").getImage());
		this.addWindowListener(//增加窗口事件监听,单独增加不在窗口增加，为了精简代码
				new WindowAdapter(){//只是更新重写需要的构造函数
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

	public void jbStart_event(){//点击开始按钮事件
		int port=0;
		try{
			port=Integer.parseInt(jtfPort.getText().trim());
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "端口只能是整数","错误",JOptionPane.ERROR_MESSAGE);//(当前窗口显示，内容，窗口名，错误图标)
			return;
		}
		if(port>65535||port<0){
			JOptionPane.showMessageDialog(this,"端口号只能是0-65535的整数","错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		try{
			jtfPort.setEnabled(false);
			jbStart.setEnabled(false);
			jbStop.setEnabled(true);
			ss=new ServerSocket(port);
			st=new ServerThread(this);
			st.start();
			JOptionPane.showMessageDialog(this,"服务器已经启动");
		
		}catch(Exception e1){
			JOptionPane.showMessageDialog(this, "服务器启动错误","错误",JOptionPane.ERROR_MESSAGE);
			jbStop.setEnabled(false);
			jbStart.setEnabled(true);
			jtfPort.setEnabled(true);
		}
	}

	public void jbStop_event(){//点击关闭按钮事件
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
		JOptionPane.showMessageDialog(this, "服务器停止");
		jbStop.setEnabled(false);
		jbStart.setEnabled(true);
		jtfPort.setEnabled(true);
	}

	public void refreshList(){//更新在线信息
		Vector vList=new Vector();
		Vector v=onlineList;
		for(int i=0;i<v.size();i++){
			ServerAgentThread tempSat=(ServerAgentThread) v.get(i);
			String vListString=tempSat.sc.getInetAddress().toString();
			vListString+="|"+tempSat.getName();
			vList.add(vListString);
		}
		jlUserOnline.setListData(vList);//更新列表数据
	}

	public static void main(String[] args){
		new Server();
	}



}
