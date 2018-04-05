package jiemian;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.*;

import zidingyi.ImagePanel;
import zidingyi.MyFont;

public class Caozuo extends JFrame implements ActionListener,MouseListener{
	public static void main(String[] args){
		String x="aa";
		Caozuo cz=new Caozuo(x);
	}
	String position;
	JMenuBar mb1;
	JMenu mu1,mu2,mu3,mu4,mu5,mu6;
	JMenuItem mi1,mi2,mi3,mi4,mi5;
	ImageIcon ic1,ic2,ic3,ic4,ic5;
	JToolBar tb1;
	JButton bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt10;
	ImagePanel ip1;Image im;
	JPanel pn1;
	JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8;
	JPanel pn2;CardLayout card;
	JLabel lb20,lb21,lb22,lb23,lb24,lb25,lb26,lb27;
	JSplitPane jsp1;
	JLabel timenow;ImagePanel ip2;Image im2;
	Timer timer;

	public void menu(){//菜单面板
		ic1=new ImageIcon("image/jm1_icon1.jpg");
		ic2=new ImageIcon("image/jm1_icon2.jpg");
		ic3=new ImageIcon("image/jm1_icon3.jpg");
		ic4=new ImageIcon("image/jm1_icon4.jpg");
		ic5=new ImageIcon("image/jm1_icon5.jpg");
		mi1=new JMenuItem("切换用户",ic1);mi1.setFont(MyFont.f2);mi1.addActionListener(this);
		mi2=new JMenuItem("切换到收款界面",ic2);mi1.setFont(MyFont.f2);
		mi3=new JMenuItem("登陆管理",ic3);mi1.setFont(MyFont.f2);
		mi4=new JMenuItem("万年历",ic4);mi1.setFont(MyFont.f2);
		mi5=new JMenuItem("退出",ic5);mi1.setFont(MyFont.f2);
		mu1=new JMenu("系统管理(X)");mu1.setMnemonic('X');
		mu2=new JMenu("人事管理(R)");mu2.setMnemonic('R');
		mu3=new JMenu("菜单服务(M)");mu3.setMnemonic('M');
		mu4=new JMenu("报表统计(B)");mu4.setMnemonic('B');
		mu5=new JMenu("成本及库房(C)");mu5.setMnemonic('C');
		mu6=new JMenu("帮助(H)");mu6.setMnemonic('H');
		mu1.add(mi1);mu1.add(mi2);mu1.add(mi3);mu1.add(mi4);mu1.add(mi5);
		mb1=new JMenuBar();mb1.add(mu1);mb1.add(mu2);mb1.add(mu3);
		mb1.add(mu4);mb1.add(mu5);mb1.add(mu6);
		this.setJMenuBar(mb1);
	}

	public void toolbar(){//工具条
		bt1=new JButton(new ImageIcon("image/jb1.jpg"));
		bt2=new JButton(new ImageIcon("image/jb2.jpg"));
		bt3=new JButton(new ImageIcon("image/jb3.jpg"));
		bt4=new JButton(new ImageIcon("image/jb4.jpg"));
		bt5=new JButton(new ImageIcon("image/jb5.jpg"));
		bt6=new JButton(new ImageIcon("image/jb6.jpg"));
		bt7=new JButton(new ImageIcon("image/jb7.jpg"));
		bt8=new JButton(new ImageIcon("image/jb8.jpg"));
		bt9=new JButton(new ImageIcon("image/jb9.jpg"));
		bt10=new JButton(new ImageIcon("image/jb10.jpg"));
		tb1=new JToolBar();
		tb1.add(bt1);tb1.add(bt2);tb1.add(bt3);tb1.add(bt4);tb1.add(bt5);
		tb1.add(bt6);tb1.add(bt7);tb1.add(bt8);tb1.add(bt9);tb1.add(bt10);
		tb1.setFloatable(false);//设置工具条不可移动
		this.add(tb1,BorderLayout.NORTH);
	}

	public void center(){//内容中左边的面板
		try {
			im=ImageIO.read(new File("image/jp1_bg.jpg"));
		} catch (IOException e) {}
		ip1=new ImagePanel(im);
		Cursor cursor=new Cursor(Cursor.HAND_CURSOR);//创建鼠标手型指示
		ip1.setLayout(new GridLayout(8,1));
		lb1=new JLabel(new ImageIcon("image/label_1.gif"));
		lb2=new JLabel("人事管理  ",new ImageIcon("image/label_2.jpg"),0);lb2.setFont(MyFont.f4);lb2.setCursor(cursor);
		lb2.setEnabled(false);lb2.addMouseListener(this);
		lb3=new JLabel("登陆管理  ",new ImageIcon("image/label_3.jpg"),0);lb3.setFont(MyFont.f4);lb3.setCursor(cursor);
		lb3.setEnabled(false);lb3.addMouseListener(this);
		lb4=new JLabel("菜谱价格  ",new ImageIcon("image/label_4.jpg"),0);lb4.setFont(MyFont.f4);lb4.setCursor(cursor);
		lb4.setEnabled(false);lb4.addMouseListener(this);
		lb5=new JLabel("报表统计  ",new ImageIcon("image/label_5.jpg"),0);lb5.setFont(MyFont.f4);lb5.setCursor(cursor);
		lb5.setEnabled(false);lb5.addMouseListener(this);
		lb6=new JLabel("成本及库房",new ImageIcon("image/label_6.jpg"),0);lb6.setFont(MyFont.f4);lb6.setCursor(cursor);
		lb6.setEnabled(false);lb6.addMouseListener(this);
		lb7=new JLabel("系统设置  ",new ImageIcon("image/label_7.jpg"),0);lb7.setFont(MyFont.f4);lb7.setCursor(cursor);
		lb7.setEnabled(false);lb7.addMouseListener(this);
		lb8=new JLabel("动画帮助  ",new ImageIcon("image/label_8.jpg"),0);lb8.setFont(MyFont.f4);lb8.setCursor(cursor);
		lb8.setEnabled(false);lb8.addMouseListener(this);
		ip1.add(lb1);ip1.add(lb2);ip1.add(lb3);ip1.add(lb4);
		ip1.add(lb5);ip1.add(lb6);ip1.add(lb7);ip1.add(lb8);
		pn1=new JPanel();pn1.add(ip1);

		pn2=new JPanel();card=new CardLayout();
		pn2.setLayout(card);
		lb20=new JLabel(new ImageIcon("image/jp3_0.jpg"));
		lb21=new JLabel(new ImageIcon("image/jp3_1.jpg"));
		lb22=new JLabel(new ImageIcon("image/jp3_2.jpg"));
		lb23=new JLabel(new ImageIcon("image/jp3_3.jpg"));
		lb24=new JLabel(new ImageIcon("image/jp3_4.jpg"));
		lb25=new JLabel(new ImageIcon("image/jp3_5.jpg"));
		lb26=new JLabel(new ImageIcon("image/jp3_6.jpg"));
		lb27=new JLabel(new ImageIcon("image/jp3_7.jpg"));
		pn2.add(lb20,"0");pn2.add(lb21, "1");pn2.add(lb22,"2");pn2.add(lb23,"3");pn2.add(lb24,"4");
		pn2.add(lb25,"5");pn2.add(lb26,"6");pn2.add(lb27,"7");

		jsp1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,ip1,pn2);jsp1.setOneTouchExpandable(true);
		jsp1.setDividerLocation(150);//设置出现的位置
		this.add(jsp1);
	}
	
	public void timePane(){
		try {
			im2=ImageIO.read(new File("image/time_bg.jpg"));
		} catch (IOException e) {}
		ip2=new ImagePanel(im2);
		ip2.setLayout(new BorderLayout());
		timer=new Timer(1000,this);timer.start();
		timenow=new JLabel("当前系统时间："+Calendar.getInstance().getTime().toLocaleString()+" ");
		timenow.setFont(MyFont.f3);
		ip2.add(timenow,BorderLayout.EAST);
		this.add(ip2,BorderLayout.SOUTH);
	}
	
	public Caozuo(String position){
		this.position=position;
		this.menu();
		this.toolbar();
		this.center();
		this.timePane();
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(width,height-30);
		this.setDefaultCloseOperation(3);
		this.setVisible(true);
		this.setTitle("满汉楼餐饮管理系统"+"---"+position);
		this.setIconImage(new ImageIcon("image/title.gif").getImage());
	}


	public void mouseEntered(MouseEvent e) {//设置鼠标进入事件
		if(position.equals("经理")||position.equals("主管")){
			if(e.getSource()==lb2){
				lb2.setEnabled(true);
			}else if(e.getSource()==lb3){
				lb3.setEnabled(true);
			}else if(e.getSource()==lb4){
				lb4.setEnabled(true);
			}else if(e.getSource()==lb5){
				lb5.setEnabled(true);
			}else if(e.getSource()==lb6){
				lb6.setEnabled(true);
			}else if(e.getSource()==lb7){
				lb7.setEnabled(true);
			}else if(e.getSource()==lb8){
				lb8.setEnabled(true);
			}
		}else if(position.equals("会计")){
			if(e.getSource()==lb4){
				lb4.setEnabled(true);
			}else if(e.getSource()==lb5){
				lb5.setEnabled(true);
			}else if(e.getSource()==lb6){
				lb6.setEnabled(true);
			}
		}
	}


	public void mouseExited(MouseEvent e) {//设置鼠标离开事件
		if(e.getSource()==lb2){
			lb2.setEnabled(false);
		}else if(e.getSource()==lb3){
			lb3.setEnabled(false);
		}else if(e.getSource()==lb4){
			lb4.setEnabled(false);
		}else if(e.getSource()==lb5){
			lb5.setEnabled(false);
		}else if(e.getSource()==lb6){
			lb6.setEnabled(false);
		}else if(e.getSource()==lb7){
			lb7.setEnabled(false);
		}else if(e.getSource()==lb8){
			lb8.setEnabled(false);
		}

	}


	public void mousePressed(MouseEvent e) {//设置鼠标点击事件
		if(position.equals("经理")||position.equals("主管")){
		if(e.getSource()==lb2){
			this.card.show(pn2,"1");
		}else if(e.getSource()==lb3){
			this.card.show(pn2,"2");
		}else if(e.getSource()==lb4){
			this.card.show(pn2,"3");
		}else if(e.getSource()==lb5){
			this.card.show(pn2,"4");
		}else if(e.getSource()==lb6){
			this.card.show(pn2,"5");
		}else if(e.getSource()==lb7){
			this.card.show(pn2,"6");
		}else if(e.getSource()==lb8){
			this.card.show(pn2,"7");
		}
		}else if(position.equals("会计")){
			if(e.getSource()==lb4){
				this.card.show(pn2,"3");
			}else if(e.getSource()==lb5){
				this.card.show(pn2,"4");
			}else if(e.getSource()==lb6){
				this.card.show(pn2,"5");
			}
		}

	}
	
	public void actionPerformed(ActionEvent e) {	
		this.timenow.setText("当前系统时间："+Calendar.getInstance().getTime().toLocaleString()+" ");
		if(e.getSource()==mi1){
			Denglu dl=new Denglu();
			this.dispose();
		}
	}

	
	public void mouseReleased(MouseEvent arg0) {}

	public void mouseClicked(MouseEvent arg0) {}
}
