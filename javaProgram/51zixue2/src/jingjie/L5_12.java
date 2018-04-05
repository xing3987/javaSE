//GUI综合应用----复杂QQ聊天窗口

package jingjie;
import java.awt.*;

import javax.swing.*;
public class L5_12 extends JFrame{
	JLabel lb1;//北部
	JPanel pn1;JButton bt1,bt2,bt3;//南部
	
	JPanel pn2,pn3,pn4;JLabel lb2,lb3,lb4,lb5;JTextField tf1;JPasswordField pw1;
	JCheckBox cb1,cb2;JButton bt4;JTabbedPane tp1;//中部
	public static void main(String[] args){
		L5_12 aa=new L5_12();
	}
	public L5_12(){
		lb1=new JLabel(new ImageIcon("image/qq2.jpg"));//北部
		
		pn1=new JPanel();bt1=new JButton("登陆");bt2=new JButton("取消");bt3=new JButton(new ImageIcon("image/help.jpg"));
		pn1.add(bt1);pn1.add(bt2);pn1.add(bt3);//南部
		
		tp1=new JTabbedPane();pn2=new JPanel();pn3=new JPanel();pn4=new JPanel();
		tp1.add("普通用户",pn2);tp1.add("QQ会员",pn3);tp1.add("管理员",pn4);
		lb2=new JLabel("qq号码",JLabel.CENTER);lb3=new JLabel("qq密码",JLabel.CENTER);
		lb4=new JLabel("忘记密码",JLabel.CENTER);lb4.setFont(new Font("宋体",Font.PLAIN,16));lb4.setForeground(Color.red);//设置字体颜色
		bt4=new JButton(new ImageIcon("image/clear.gif"));cb1=new JCheckBox("隐身登陆");cb2=new JCheckBox("记住密码");
		lb5=new JLabel("<html><a href='www.qq.com'>申请密码保护</a>");//设置连接和显示字体
		lb5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//设置选到时指针变成手指状
		tf1=new JTextField(10);pw1=new JPasswordField(10);
		pn3.setBackground(Color.yellow);pn4.setBackground(Color.green);
		pn2.setLayout(new GridLayout(3,3));
		pn2.add(lb2);pn2.add(tf1);pn2.add(bt4);
		pn2.add(lb3);pn2.add(pw1);pn2.add(lb4);
		pn2.add(cb1);pn2.add(cb2);pn2.add(lb5);
		
		this.add(lb1,BorderLayout.NORTH);this.add(pn1,BorderLayout.SOUTH);
		this.add(tp1);
		this.setTitle("聊天窗口");
		this.setIconImage((new ImageIcon("image/qq.jpg")).getImage());//标题栏改变图标
		this.setSize(330,280);
		this.setResizable(false);
		this.setLocation(350,150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}