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

public class Denglu extends JDialog implements ActionListener{//JWindow�ı�����ѡ�У�����ֻ����JDialog
	ImagePanel ip;Image im;
	JLabel lb1,lb2,lb3;JButton bt1,bt2;JTextField tf1;JPasswordField pw1;

	public static void main(String[] args){
		Denglu denglu=new Denglu();
	}
	public Denglu(){
		try {
			im=ImageIO.read(new File("image/login.gif"));//��ȡͼƬ���õ�ImageIO��
		} catch (IOException e) {}
		ip=new ImagePanel(im);
		ip.setBounds(0,0,360,360);

		lb1=new JLabel("�������û�����");
		lb1.setFont(MyFont.f1);
		lb1.setBounds(50,190,150,30);
		this.add(lb1);

		lb2=new JLabel("(��Ա���ţ�)");lb2.setFont(MyFont.f2);
		lb2.setForeground(Color.red);lb2.setBounds(70,210,100,30);
		this.add(lb2);

		lb3=new JLabel("���������룺");lb3.setFont(MyFont.f1);
		lb3.setBounds(50,250,150,30);
		this.add(lb3);

		tf1=new JTextField(20);tf1.setBounds(160,200,150,30);
		tf1.setFocusable(true);this.add(tf1);
		tf1.setBorder(BorderFactory.createLoweredBevelBorder());//����һ�����Ϳ�

		pw1=new JPasswordField(20);pw1.setBounds(160,250,150,30);
		pw1.setFocusable(true);this.add(pw1);
		pw1.setBorder(BorderFactory.createLoweredBevelBorder());//����һ�����Ϳ�

		bt1=new JButton("ȷ��");bt1.setForeground(Color.blue);
		bt1.setBounds(100,300, 80, 30);
		this.add(bt1);bt1.addActionListener(this);

		bt2=new JButton("ȡ��");bt2.setForeground(Color.blue);
		bt2.setBounds(200,300,80,30);
		this.add(bt2);bt2.addActionListener(this);


		this.add(ip);
		this.setLayout(null);//����Ϊ���ɲ���ģʽ
		this.setUndecorated(true);//����Ϊ�ޱ߿�ģʽ
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
				JOptionPane.showMessageDialog(this,"�û������������");
			}else if(position.equals("����")||position.equals("����")||position.equals("���")){
				Caozuo caozuo=new Caozuo(position);
				this.dispose();
			}
		}else if(e.getSource()==bt2){
			this.dispose();
		}

	}


}
