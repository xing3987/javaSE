package kehuduan;
import java.awt.*;
import java.util.*;

import javax.swing.*;

import java.net.*;
import java.io.*;
import java.awt.event.*;

public class XiangQi extends JFrame implements ActionListener{
	public static final Color bgColor=new Color(245,250,160);//���̱���ɫ
	public static final Color focusbg=new Color(242,242,242);//����ѡ�к�ı���ɫ
	public static final Color focuschar=new Color(96,95,91);//����ѡ�к���ַ���ɫ
	public static final Color color1=new Color(249,183,173);//�췽����ɫ
	public static final Color color2=Color.WHITE;//�׷�������ɫ
	JLabel jlHost=new JLabel("������");
	JLabel jlPort=new JLabel("�˿ں�");
	JLabel jlNickName=new JLabel("��  ��");
	JTextField jtfHost=new JTextField("127.0.0.1");
	JTextField jtfPort=new JTextField("9999");
	JTextField jtfNickName=new JTextField("play1");
	JButton jbConnect=new JButton("����");
	JButton jbDisconnect=new JButton("�Ͽ�");
	JButton jbFail=new JButton("����");
	JButton jbChallenge=new JButton("��ս");
	JButton jbYChallenge=new JButton("������ս");
	JButton jbNChallenge=new JButton("�ܾ���ս");
	JComboBox jcbNickList=new JComboBox();
	int width=60;//�������߼�ľ���
	QiZi[][] qiZi=new QiZi[9][10];//����������
	QiPan jpz=new QiPan(qiZi,width,this);
	//	JPanel jpz=new JPanel();//����������
	JPanel jpy=new JPanel();//�ұ��û��������
	JSplitPane jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jpz,jpy);//��������ָ����
	boolean caiPan=false;//�Ƿ������
	int color=0;//0��ʾ�죬1��ʾ��
	Socket sc;
	ClientAgentThread cat;


	public XiangQi(){
		this.initialComponent();//��ʼ���ؼ�
		this.addListener();//Ϊ��Ӧ�ؼ�ע���¼�������
		this.initialState();//��ʼ��״̬
		this.initialQiZi();//��ʼ������
		this.initialFrame();//��ʼ������
	}

	public void initialComponent(){//��ʼ���ؼ�
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

	public void addListener(){//��Ӽ���
		jbConnect.addActionListener(this);
		jbDisconnect.addActionListener(this);
		jbChallenge.addActionListener(this);
		jbFail.addActionListener(this);
		jbYChallenge.addActionListener(this);
		jbNChallenge.addActionListener(this);
	}

	public void initialState(){//��ʼ��״̬
		this.jbDisconnect.setEnabled(false);//��"�Ͽ�"��ť��Ϊ������
		this.jbChallenge.setEnabled(false);//��"��ս"��ť��Ϊ������
		this.jbYChallenge.setEnabled(false);//��"������ս"��ť��Ϊ������
		this.jbNChallenge.setEnabled(false);//��"�ܾ���ս"��ť��Ϊ������
		this.jbFail.setEnabled(false);//��"����"��ť��Ϊ������
	}

	public void initialQiZi(){//��ʼ������
		qiZi[0][0]=new QiZi(color1,"܇",0,0);
		qiZi[1][0]=new QiZi(color1,"�R",1,0);
		qiZi[2][0]=new QiZi(color1,"��",2,0);
		qiZi[3][0]=new QiZi(color1,"��",3,0);
		qiZi[4][0]=new QiZi(color1,"˧",4,0);
		qiZi[5][0]=new QiZi(color1,"��",5,0);
		qiZi[6][0]=new QiZi(color1,"��",6,0);
		qiZi[7][0]=new QiZi(color1,"�R",7,0);
		qiZi[8][0]=new QiZi(color1,"܇",8,0);
		qiZi[1][2]=new QiZi(color1,"��",1,2);
		qiZi[7][2]=new QiZi(color1,"��",7,2);
		qiZi[0][3]=new QiZi(color1,"��",0,3);
		qiZi[2][3]=new QiZi(color1,"��",2,3);
		qiZi[4][3]=new QiZi(color1,"��",4,3);
		qiZi[6][3]=new QiZi(color1,"��",6,3);
		qiZi[8][3]=new QiZi(color1,"��",8,3);

		qiZi[0][9]=new QiZi(color2,"܇",0,9);
		qiZi[1][9]=new QiZi(color2,"�R",1,9);
		qiZi[2][9]=new QiZi(color2,"��",2,9);
		qiZi[3][9]=new QiZi(color2,"ʿ",3,9);
		qiZi[4][9]=new QiZi(color2,"��",4,9);
		qiZi[5][9]=new QiZi(color2,"ʿ",5,9);
		qiZi[6][9]=new QiZi(color2,"��",6,9);
		qiZi[7][9]=new QiZi(color2,"�R",7,9);
		qiZi[8][9]=new QiZi(color2,"܇",8,9);
		qiZi[1][7]=new QiZi(color2,"��",1,7);
		qiZi[7][7]=new QiZi(color2,"��",7,7);
		qiZi[0][6]=new QiZi(color2,"��",0,6);
		qiZi[2][6]=new QiZi(color2,"��",2,6);
		qiZi[4][6]=new QiZi(color2,"��",4,6);
		qiZi[6][6]=new QiZi(color2,"��",6,6);
		qiZi[8][6]=new QiZi(color2,"��",8,6);


	}

	public void initialFrame(){
		this.add(jsp);//��ӷָ����
		jsp.setDividerLocation(730);//���÷ָ���λ��
		jsp.setDividerSize(5);//���÷ָ��߿��
		this.setBounds(100,0,930,730);
		this.setTitle("����ͻ���");
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
							if(cat.tiaoZhanZhe!=null){//���������Ϸ��
								try{
									cat.dos.writeUTF("<#RENSHU#>"+cat.tiaoZhanZhe);//ͨ����������Է���ҷ���������Ϣ
								}catch(Exception e1){}
							}
							try{
								cat.dos.writeUTF("<#CLIENT_LEAVE#>");//������������뿪��Ϣ
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

	public void jbConnect_event(){//��������¼�
		int port=0;
		try{//�ж϶˿�Ϊ���ͣ���ֵ0-65533��
			port=Integer.parseInt(jtfPort.getText().trim());
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "�˿�ֻ��Ϊ����","����",JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(port>65535||port<0){
			JOptionPane.showMessageDialog(this, "�˿�ֻ��Ϊ0~65535�������","����",JOptionPane.ERROR_MESSAGE);
			return;
		}

		String name=jtfNickName.getText().trim();
		if(name.length()==0){//�ж���������Ϊ��
			JOptionPane.showMessageDialog(this,"��������Ϊ��","����",JOptionPane.ERROR_MESSAGE);
			return;
		}

		try{
			sc=new Socket(this.jtfHost.getText().trim(),port);//���ӷ�����
			cat=new ClientAgentThread(this);
			cat.start();
			this.jtfHost.setEnabled(false);//�������������������ı�����Ϊ������
			this.jtfPort.setEnabled(false);//����������˿ںŵ��ı�����Ϊ������
			this.jtfNickName.setEnabled(false);//�����������ǳƵ��ı�����Ϊ������
			this.jbConnect.setEnabled(false);//��"����"��ť��Ϊ������
			this.jbDisconnect.setEnabled(true);//��"�Ͽ�"��ť��Ϊ����
			this.jbChallenge.setEnabled(true);//��"��ս"��ť��Ϊ����
			this.jbYChallenge.setEnabled(false);//��"������ս"��ť��Ϊ������
			this.jbNChallenge.setEnabled(false);//��"�ܾ���ս"��ť��Ϊ������
			this.jbFail.setEnabled(false);//��"����"��ť��Ϊ������
			JOptionPane.showMessageDialog(this, "�ɹ����ӵ�������","��ʾ",JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception ee){
			JOptionPane.showMessageDialog(this,"���ӷ�����ʧ��","����",JOptionPane.ERROR_MESSAGE);//����ʧ�ܣ�������ʾ��Ϣ
			return;
		}
	}
	public void jbDisconnect_event(){//����Ͽ������¼�
		try{
			this.cat.dos.writeUTF("<#CLIENT_LEAVE#>");
			this.cat.flag=false;
			this.cat=null;
		}catch(Exception e){}
		this.jtfHost.setEnabled(!false);//�������������������ı�����Ϊ����
		this.jtfPort.setEnabled(!false);//����������˿ںŵ��ı�����Ϊ����
		this.jtfNickName.setEnabled(!false);//�����������ǳƵ��ı�����Ϊ����
		this.jbConnect.setEnabled(!false);//��"����"��ť��Ϊ����
		this.jbDisconnect.setEnabled(!true);//��"�Ͽ�"��ť��Ϊ������
		this.jbChallenge.setEnabled(!true);//��"��ս"��ť��Ϊ������
		this.jbYChallenge.setEnabled(false);//��"������ս"��ť��Ϊ������
		this.jbNChallenge.setEnabled(false);//��"�ܾ���ս"��ť��Ϊ������
		this.jbFail.setEnabled(false);//��"����"��ť��Ϊ������
	}



	public void jbChallenge_event(){//�����ս��ť�¼�
		Object o=this.jcbNickList.getSelectedItem();
		if(o==null||((String)o).equals("")){
			JOptionPane.showMessageDialog(this, "����ս�߲���Ϊ��","����",JOptionPane.ERROR_MESSAGE);
			return;
		}else{
			String name2=(String)o;
			try{
				this.jtfHost.setEnabled(false);//�������������������ı�����Ϊ������
				this.jtfPort.setEnabled(false);//����������˿ںŵ��ı�����Ϊ������
				this.jtfNickName.setEnabled(false);//�����������ǳƵ��ı�����Ϊ������
				this.jbConnect.setEnabled(false);//��"����"��ť��Ϊ������
				this.jbDisconnect.setEnabled(!true);//��"�Ͽ�"��ť��Ϊ������
				this.jbChallenge.setEnabled(!true);//��"��ս"��ť��Ϊ������
				this.jbYChallenge.setEnabled(false);//��"������ս"��ť��Ϊ������
				this.jbNChallenge.setEnabled(false);//��"�ܾ���ս"��ť��Ϊ������
				this.jbFail.setEnabled(false);//��"����"��ť��Ϊ������
				this.cat.tiaoZhanZhe=name2;//������ս����
	//******	this.caiPan=true;
				this.color=0;
				this.cat.dos.writeUTF("<#TIAO_ZHAN#>"+name2);//������ս��Ϣ
				JOptionPane.showMessageDialog(this, "�Ѿ�������ս��ȴ�","��ʾ",JOptionPane.INFORMATION_MESSAGE);
			}catch(Exception e){}
		}

	}
	public void jbFail_event(){//���Ͷ����ť�¼�
		try{
			this.cat.dos.writeUTF("<#RENSHU#>"+this.cat.tiaoZhanZhe);
			this.cat.tiaoZhanZhe=null;
		}catch(Exception e){}
		this.color=0;//��color��Ϊ0
		this.caiPan=false;//��caiPan��Ϊfalse
		this.next();//��ʼ����һ��
		this.jtfHost.setEnabled(false);//�������������������ı�����Ϊ������
		this.jtfPort.setEnabled(false);//����������˿ںŵ��ı�����Ϊ������
		this.jtfNickName.setEnabled(false);//�����������ǳƵ��ı�����Ϊ������
		this.jbConnect.setEnabled(false);//��"����"��ť��Ϊ������
		this.jbDisconnect.setEnabled(true);//��"�Ͽ�"��ť��Ϊ����
		this.jbChallenge.setEnabled(true);//��"��ս"��ť��Ϊ����
		this.jbYChallenge.setEnabled(false);//��"������ս"��ť��Ϊ������
		this.jbNChallenge.setEnabled(false);//��"�ܾ���ս"��ť��Ϊ������
		this.jbFail.setEnabled(false);//��"����"��ť��Ϊ������
	}
	public void jbYChallenge_event(){//���������ս��ť�¼�
		try{
			this.cat.dos.writeUTF("<#TONG_YI#>"+this.cat.tiaoZhanZhe);
		}catch(Exception e){}
		this.caiPan=false;//��caiPan��Ϊfalse
		this.color=1;//��color��Ϊ1
		this.jtfHost.setEnabled(false);//�������������������ı�����Ϊ������
		this.jtfPort.setEnabled(false);//����������˿ںŵ��ı�����Ϊ������
		this.jtfNickName.setEnabled(false);//�����������ǳƵ��ı�����Ϊ������
		this.jbConnect.setEnabled(false);//��"����"��ť��Ϊ������
		this.jbDisconnect.setEnabled(!true);//��"�Ͽ�"��ť��Ϊ������
		this.jbChallenge.setEnabled(!true);//��"��ս"��ť��Ϊ������
		this.jbYChallenge.setEnabled(false);//��"������ս"��ť��Ϊ������
		this.jbNChallenge.setEnabled(false);//��"�ܾ���ս"��ť��Ϊ������
		this.jbFail.setEnabled(!false);//��"����"��ť��Ϊ����
	}
	public void jbNChallenge_event(){//����ܾ���ս��ť�¼�
		try{   //���;ܾ���ս����Ϣ
			this.cat.dos.writeUTF("<#BUTONG_YI#>"+this.cat.tiaoZhanZhe);
			this.cat.tiaoZhanZhe=null;//��tiaoZhanZhe��Ϊ��
			this.jtfHost.setEnabled(false);//�������������������ı�����Ϊ������
			this.jtfPort.setEnabled(false);//����������˿ںŵ��ı�����Ϊ������
			this.jtfNickName.setEnabled(false);//�����������ǳƵ��ı�����Ϊ������
			this.jbConnect.setEnabled(false);//��"����"��ť��Ϊ������
			this.jbDisconnect.setEnabled(true);//��"�Ͽ�"��ť��Ϊ����
			this.jbChallenge.setEnabled(true);//��"��ս"��ť��Ϊ����
			this.jbYChallenge.setEnabled(false);//��"������ս"��ť��Ϊ������
			this.jbNChallenge.setEnabled(false);//��"�ܾ���ս"��ť��Ϊ������
			this.jbFail.setEnabled(false);//��"����"��ť��Ϊ������
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
