package jiemian;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import moxing.Mothed;
import zidingyi.ImagePanel;
import zidingyi.MyFont;

public class Denglu extends JDialog implements ActionListener{//JWindow文本域不能选中，所以只能用JDialog
	ImagePanel ip;Image im;
	JLabel lb1,lb2,lb3;JButton bt1,bt2;JTextField tf1;JPasswordField pw1;

	public static void main(String[] args){
		Denglu denglu=new Denglu();
	}
	public Denglu(){
		try {
			im=ImageIO.read(new File("image/login.gif"));//读取图片，用到ImageIO流
		} catch (IOException e) {}
		ip=new ImagePanel(im);
		ip.setBounds(0,0,360,360);

		lb1=new JLabel("请输入用户名：");
		lb1.setFont(MyFont.f1);
		lb1.setBounds(50,190,150,30);
		this.add(lb1);

		lb2=new JLabel("(或员工号：)");lb2.setFont(MyFont.f2);
		lb2.setForeground(Color.red);lb2.setBounds(70,210,100,30);
		this.add(lb2);

		lb3=new JLabel("请输入密码：");lb3.setFont(MyFont.f1);
		lb3.setBounds(50,250,150,30);
		this.add(lb3);

		tf1=new JTextField(20);tf1.setBounds(160,200,150,30);
		tf1.setFocusable(true);this.add(tf1);
		tf1.setBorder(BorderFactory.createLoweredBevelBorder());//建立一个凹型框

		pw1=new JPasswordField(20);pw1.setBounds(160,250,150,30);
		pw1.setFocusable(true);this.add(pw1);
		pw1.setBorder(BorderFactory.createLoweredBevelBorder());//建立一个凹型框

		bt1=new JButton("确定");bt1.setForeground(Color.blue);
		bt1.setBounds(100,300, 80, 30);
		this.add(bt1);bt1.addActionListener(this);

		bt2=new JButton("取消");bt2.setForeground(Color.blue);
		bt2.setBounds(200,300,80,30);
		this.add(bt2);bt2.addActionListener(this);


		this.add(ip);
		this.setLayout(null);//设置为自由布局模式
		this.setUndecorated(true);//设置为无边框模式
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setBounds(width/3, height/4, 360, 360);
		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt1){
			String name=this.tf1.getText().trim();
	
			String password=new String(this.pw1.getPassword());
			Mothed mothed=new Mothed();
			String position=mothed.checkPass(name, password);
			if(position==null){
				JOptionPane.showMessageDialog(this,"用户名或密码错误");
			}else if(position.equals("主管")||position.equals("经理")||position.equals("会计")){
				Caozuo caozuo=new Caozuo(position);
				this.dispose();
			}
		}else if(e.getSource()==bt2){
			this.dispose();
		}

	}


}
