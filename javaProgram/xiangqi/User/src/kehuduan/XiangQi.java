package kehuduan;
import java.awt.*;
import java.util.*;

import javax.swing.*;

import java.net.*;
import java.io.*;
import java.awt.event.*;

public class XiangQi extends JFrame implements ActionListener{
	public static final Color bgColor=new Color(245,250,160);//棋盘背景色
	public static final Color focusbg=new Color(242,242,242);//棋子选中后的背景色
	public static final Color focuschar=new Color(96,95,91);//棋子选中后的字符颜色
	public static final Color color1=new Color(249,183,173);//红方的颜色
	public static final Color color2=Color.WHITE;//白方棋子颜色
	JLabel jlHost=new JLabel("主机名");
	JLabel jlPort=new JLabel("端口号");
	JLabel jlNickName=new JLabel("昵  称");
	JTextField jtfHost=new JTextField("127.0.0.1");
	JTextField jtfPort=new JTextField("9999");
	JTextField jtfNickName=new JTextField("play1");
	JButton jbConnect=new JButton("连接");
	JButton jbDisconnect=new JButton("断开");
	JButton jbFail=new JButton("认输");
	JButton jbChallenge=new JButton("挑战");
	JButton jbYChallenge=new JButton("接收挑战");
	JButton jbNChallenge=new JButton("拒绝挑战");
	JComboBox jcbNickList=new JComboBox();
	int width=60;//棋盘两线间的距离
	QiZi[][] qiZi=new QiZi[9][10];//棋盘棋子类
	QiPan jpz=new QiPan(qiZi,width,this);
	//	JPanel jpz=new JPanel();//左边棋盘面板
	JPanel jpy=new JPanel();//右边用户数据面板
	JSplitPane jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jpz,jpy);//创建横向分隔面板
	boolean caiPan=false;//是否可走起
	int color=0;//0表示红，1表示蓝
	Socket sc;
	ClientAgentThread cat;


	public XiangQi(){
		this.initialComponent();//初始化控件
		this.addListener();//为相应控件注册事件监听器
		this.initialState();//初始化状态
		this.initialQiZi();//初始化棋子
		this.initialFrame();//初始化窗体
	}

	public void initialComponent(){//初始化控件
		jpy.setLayout(null);
		jlHost.setBounds(10,10,40,20);jpy.add(jlHost);
		jlPort.setBounds(10,40,40,20);jpy.add(jlPort);
		jlNickName.setBounds(10,70,40,20);jpy.add(jlNickName);
		jtfHost.setBounds(70,10,70,20);jpy.add(jtfHost);
		jtfPort.setBounds(70,40,70,20);jpy.add(jtfPort);
		jtfNickName.setBounds(70,70,70,20);jpy.add(jtfNickName);
		JTextField jtfHost=new JTextField("127.0.0.1");
		JTextField jtfPort=new JTextField("9999");
		JTextField jtfNickName=new JTextField("play1");
		jbConnect.setBounds(5,100,90,20);jpy.add(jbConnect);
		jbDisconnect.setBounds(95,100,90,20);jpy.add(jbDisconnect);
		jbChallenge.setBounds(5,160,90,20);jpy.add(jbChallenge);
		jbFail.setBounds(95,160,90,20);jpy.add(jbFail);
		jbYChallenge.setBounds(5,190,90,20);jpy.add(jbYChallenge);
		jbNChallenge.setBounds(95,190,90,20);jpy.add(jbNChallenge);
		jcbNickList.setBounds(15,130,150,20);jpy.add(jcbNickList);
	}

	public void addListener(){//添加监听
		jbConnect.addActionListener(this);
		jbDisconnect.addActionListener(this);
		jbChallenge.addActionListener(this);
		jbFail.addActionListener(this);
		jbYChallenge.addActionListener(this);
		jbNChallenge.addActionListener(this);
	}

	public void initialState(){//初始化状态
		this.jbDisconnect.setEnabled(false);//将"断开"按钮设为不可用
		this.jbChallenge.setEnabled(false);//将"挑战"按钮设为不可用
		this.jbYChallenge.setEnabled(false);//将"接受挑战"按钮设为不可用
		this.jbNChallenge.setEnabled(false);//将"拒绝挑战"按钮设为不可用
		this.jbFail.setEnabled(false);//将"认输"按钮设为不可用
	}

	public void initialQiZi(){//初始化棋子
		qiZi[0][0]=new QiZi(color1,"車",0,0);
		qiZi[1][0]=new QiZi(color1,"馬",1,0);
		qiZi[2][0]=new QiZi(color1,"相",2,0);
		qiZi[3][0]=new QiZi(color1,"仕",3,0);
		qiZi[4][0]=new QiZi(color1,"帅",4,0);
		qiZi[5][0]=new QiZi(color1,"仕",5,0);
		qiZi[6][0]=new QiZi(color1,"相",6,0);
		qiZi[7][0]=new QiZi(color1,"馬",7,0);
		qiZi[8][0]=new QiZi(color1,"車",8,0);
		qiZi[1][2]=new QiZi(color1,"炮",1,2);
		qiZi[7][2]=new QiZi(color1,"炮",7,2);
		qiZi[0][3]=new QiZi(color1,"兵",0,3);
		qiZi[2][3]=new QiZi(color1,"兵",2,3);
		qiZi[4][3]=new QiZi(color1,"兵",4,3);
		qiZi[6][3]=new QiZi(color1,"兵",6,3);
		qiZi[8][3]=new QiZi(color1,"兵",8,3);

		qiZi[0][9]=new QiZi(color2,"車",0,9);
		qiZi[1][9]=new QiZi(color2,"馬",1,9);
		qiZi[2][9]=new QiZi(color2,"象",2,9);
		qiZi[3][9]=new QiZi(color2,"士",3,9);
		qiZi[4][9]=new QiZi(color2,"将",4,9);
		qiZi[5][9]=new QiZi(color2,"士",5,9);
		qiZi[6][9]=new QiZi(color2,"象",6,9);
		qiZi[7][9]=new QiZi(color2,"馬",7,9);
		qiZi[8][9]=new QiZi(color2,"車",8,9);
		qiZi[1][7]=new QiZi(color2,"炮",1,7);
		qiZi[7][7]=new QiZi(color2,"炮",7,7);
		qiZi[0][6]=new QiZi(color2,"卒",0,6);
		qiZi[2][6]=new QiZi(color2,"卒",2,6);
		qiZi[4][6]=new QiZi(color2,"卒",4,6);
		qiZi[6][6]=new QiZi(color2,"卒",6,6);
		qiZi[8][6]=new QiZi(color2,"卒",8,6);


	}

	public void initialFrame(){
		this.add(jsp);//添加分隔面板
		jsp.setDividerLocation(730);//设置分割线位置
		jsp.setDividerSize(5);//设置分隔线宽度
		this.setBounds(100,0,930,730);
		this.setTitle("象棋客户端");
		this.setDefaultCloseOperation(3);
		this.setVisible(true);
		this.setResizable(false);
		this.addWindowListener(
				new WindowAdapter(){
					public void windowClosing(WindowEvent e){
						if(cat==null){
							System.exit(0);
							return;
						}else{
							if(cat.tiaoZhanZhe!=null){//如果正在游戏中
								try{
									cat.dos.writeUTF("<#RENSHU#>"+cat.tiaoZhanZhe);//通过服务器向对方玩家发送认输消息
								}catch(Exception e1){}
							}
							try{
								cat.dos.writeUTF("<#CLIENT_LEAVE#>");//向服务器发送离开消息
								cat.flag=false;
								cat=null;
							}catch(Exception e2){}
							System.exit(0);
						}
					}

				}
				);
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbConnect){
			this.jbConnect_event();
		}else if(e.getSource()==jbDisconnect){
			this.jbDisconnect_event();
		}else if(e.getSource()==jbChallenge){
			this.jbChallenge_event();
		}else if(e.getSource()==jbFail){
			this.jbFail_event();
		}else if(e.getSource()==jbYChallenge){
			this.jbYChallenge_event();
		}else if(e.getSource()==jbNChallenge){
			this.jbNChallenge_event();
		}
	}	

	public void jbConnect_event(){//点击连接事件
		int port=0;
		try{//判断端口为整型，数值0-65533间
			port=Integer.parseInt(jtfPort.getText().trim());
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "端口只能为整型","错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(port>65535||port<0){
			JOptionPane.showMessageDialog(this, "端口只能为0~65535间的整数","错误",JOptionPane.ERROR_MESSAGE);
			return;
		}

		String name=jtfNickName.getText().trim();
		if(name.length()==0){//判断姓名不能为空
			JOptionPane.showMessageDialog(this,"姓名不能为空","错误",JOptionPane.ERROR_MESSAGE);
			return;
		}

		try{
			sc=new Socket(this.jtfHost.getText().trim(),port);//连接服务器
			cat=new ClientAgentThread(this);
			cat.start();
			this.jtfHost.setEnabled(false);//将用于输入主机名的文本框设为不可用
			this.jtfPort.setEnabled(false);//将用于输入端口号的文本框设为不可用
			this.jtfNickName.setEnabled(false);//将用于输入昵称的文本框设为不可用
			this.jbConnect.setEnabled(false);//将"连接"按钮设为不可用
			this.jbDisconnect.setEnabled(true);//将"断开"按钮设为可用
			this.jbChallenge.setEnabled(true);//将"挑战"按钮设为可用
			this.jbYChallenge.setEnabled(false);//将"接受挑战"按钮设为不可用
			this.jbNChallenge.setEnabled(false);//将"拒绝挑战"按钮设为不可用
			this.jbFail.setEnabled(false);//将"认输"按钮设为不可用
			JOptionPane.showMessageDialog(this, "成功连接到服务器","提示",JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception ee){
			JOptionPane.showMessageDialog(this,"连接服务器失败","错误",JOptionPane.ERROR_MESSAGE);//连接失败，给出提示信息
			return;
		}
	}
	public void jbDisconnect_event(){//点击断开连接事件
		try{
			this.cat.dos.writeUTF("<#CLIENT_LEAVE#>");
			this.cat.flag=false;
			this.cat=null;
		}catch(Exception e){}
		this.jtfHost.setEnabled(!false);//将用于输入主机名的文本框设为可用
		this.jtfPort.setEnabled(!false);//将用于输入端口号的文本框设为可用
		this.jtfNickName.setEnabled(!false);//将用于输入昵称的文本框设为可用
		this.jbConnect.setEnabled(!false);//将"连接"按钮设为可用
		this.jbDisconnect.setEnabled(!true);//将"断开"按钮设为不可用
		this.jbChallenge.setEnabled(!true);//将"挑战"按钮设为不可用
		this.jbYChallenge.setEnabled(false);//将"接受挑战"按钮设为不可用
		this.jbNChallenge.setEnabled(false);//将"拒绝挑战"按钮设为不可用
		this.jbFail.setEnabled(false);//将"认输"按钮设为不可用
	}



	public void jbChallenge_event(){//点击挑战按钮事件
		Object o=this.jcbNickList.getSelectedItem();
		if(o==null||((String)o).equals("")){
			JOptionPane.showMessageDialog(this, "被挑战者不能为空","错误",JOptionPane.ERROR_MESSAGE);
			return;
		}else{
			String name2=(String)o;
			try{
				this.jtfHost.setEnabled(false);//将用于输入主机名的文本框设为不可用
				this.jtfPort.setEnabled(false);//将用于输入端口号的文本框设为不可用
				this.jtfNickName.setEnabled(false);//将用于输入昵称的文本框设为不可用
				this.jbConnect.setEnabled(false);//将"连接"按钮设为不可用
				this.jbDisconnect.setEnabled(!true);//将"断开"按钮设为不可用
				this.jbChallenge.setEnabled(!true);//将"挑战"按钮设为不可用
				this.jbYChallenge.setEnabled(false);//将"接受挑战"按钮设为不可用
				this.jbNChallenge.setEnabled(false);//将"拒绝挑战"按钮设为不可用
				this.jbFail.setEnabled(false);//将"认输"按钮设为不可用
				this.cat.tiaoZhanZhe=name2;//设置挑战对象
	//******	this.caiPan=true;
				this.color=0;
				this.cat.dos.writeUTF("<#TIAO_ZHAN#>"+name2);//发出挑战信息
				JOptionPane.showMessageDialog(this, "已经发出挑战请等待","提示",JOptionPane.INFORMATION_MESSAGE);
			}catch(Exception e){}
		}

	}
	public void jbFail_event(){//点击投降按钮事件
		try{
			this.cat.dos.writeUTF("<#RENSHU#>"+this.cat.tiaoZhanZhe);
			this.cat.tiaoZhanZhe=null;
		}catch(Exception e){}
		this.color=0;//将color设为0
		this.caiPan=false;//将caiPan设为false
		this.next();//初始化下一局
		this.jtfHost.setEnabled(false);//将用于输入主机名的文本框设为不可用
		this.jtfPort.setEnabled(false);//将用于输入端口号的文本框设为不可用
		this.jtfNickName.setEnabled(false);//将用于输入昵称的文本框设为不可用
		this.jbConnect.setEnabled(false);//将"连接"按钮设为不可用
		this.jbDisconnect.setEnabled(true);//将"断开"按钮设为可用
		this.jbChallenge.setEnabled(true);//将"挑战"按钮设为可用
		this.jbYChallenge.setEnabled(false);//将"接受挑战"按钮设为不可用
		this.jbNChallenge.setEnabled(false);//将"拒绝挑战"按钮设为不可用
		this.jbFail.setEnabled(false);//将"认输"按钮设为不可用
	}
	public void jbYChallenge_event(){//点击接收挑战按钮事件
		try{
			this.cat.dos.writeUTF("<#TONG_YI#>"+this.cat.tiaoZhanZhe);
		}catch(Exception e){}
		this.caiPan=false;//将caiPan设为false
		this.color=1;//将color设为1
		this.jtfHost.setEnabled(false);//将用于输入主机名的文本框设为不可用
		this.jtfPort.setEnabled(false);//将用于输入端口号的文本框设为不可用
		this.jtfNickName.setEnabled(false);//将用于输入昵称的文本框设为不可用
		this.jbConnect.setEnabled(false);//将"连接"按钮设为不可用
		this.jbDisconnect.setEnabled(!true);//将"断开"按钮设为不可用
		this.jbChallenge.setEnabled(!true);//将"挑战"按钮设为不可用
		this.jbYChallenge.setEnabled(false);//将"接受挑战"按钮设为不可用
		this.jbNChallenge.setEnabled(false);//将"拒绝挑战"按钮设为不可用
		this.jbFail.setEnabled(!false);//将"认输"按钮设为可用
	}
	public void jbNChallenge_event(){//点击拒绝挑战按钮事件
		try{   //发送拒绝挑战的信息
			this.cat.dos.writeUTF("<#BUTONG_YI#>"+this.cat.tiaoZhanZhe);
			this.cat.tiaoZhanZhe=null;//将tiaoZhanZhe设为空
			this.jtfHost.setEnabled(false);//将用于输入主机名的文本框设为不可用
			this.jtfPort.setEnabled(false);//将用于输入端口号的文本框设为不可用
			this.jtfNickName.setEnabled(false);//将用于输入昵称的文本框设为不可用
			this.jbConnect.setEnabled(false);//将"连接"按钮设为不可用
			this.jbDisconnect.setEnabled(true);//将"断开"按钮设为可用
			this.jbChallenge.setEnabled(true);//将"挑战"按钮设为可用
			this.jbYChallenge.setEnabled(false);//将"接受挑战"按钮设为不可用
			this.jbNChallenge.setEnabled(false);//将"拒绝挑战"按钮设为不可用
			this.jbFail.setEnabled(false);//将"认输"按钮设为不可用
		}
		catch(Exception ee){ee.printStackTrace();}
	}

	public void next(){

		for(int i=0;i<9;i++){
			for(int j=0;j<10;j++){
				this.qiZi[i][j]=null;
			}
		}
		this.caiPan=false;
		this.initialQiZi();
		this.repaint();
	}
	public static void main(String[] args){
		new XiangQi();
	}



}
