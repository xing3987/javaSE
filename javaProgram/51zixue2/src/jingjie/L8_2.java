//�¼��������ؼ��ļ���

package jingjie;
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
public class L8_2 extends JFrame implements ActionListener{
	Wdmb mb;
	JButton bt1,bt2;
	Jtz jtz;
	public static void main(String[] args){
		L8_2 aa=new L8_2();
	}
	public L8_2() {
		mb=new Wdmb();
		bt1=new JButton("��ɫ");bt2=new JButton("��ɫ");
		this.add(bt1,BorderLayout.NORTH);
		this.add(bt2,BorderLayout.SOUTH);
		mb.setBackground(Color.yellow);
		this.add(mb);
		
		Jtz jtz=new Jtz();
		bt1.addActionListener(jtz);//�����һ���Լ������ļ�����
		bt2.addActionListener(jtz);
		
		bt1.addActionListener(this);//����¼�����������ǰ�������ļ�������
		bt1.setActionCommand("bt1");//��Ӽ�����ָ���ָ��Ϊһ���ַ�����*��
		bt2.addActionListener(this);
		bt2.setActionCommand("bt2");
				
		this.setTitle("�¼�����");
		this.setSize(200,200);
		this.setLocation(100,100);
		this.setDefaultCloseOperation(3);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println("��ť��������");
		if(e.getActionCommand().equals("bt1")){//����������õ�ָ�bt1��
			mb.setBackground(Color.blue);
		}else if(e.getActionCommand().equals("bt2")){//����������õ�ָ�bt2��
			mb.setBackground(Color.red);
		}
	}
	
}

class Wdmb extends JPanel{
	public void paint(Graphics g) {
		super.paint(g);
	}
}

class Jtz implements ActionListener{//����һ���Զ���ļ�����
	public void actionPerformed(ActionEvent e) {
		System.out.println("������"+this.getClass().getName()+"��������");
		if(e.getActionCommand().equals("bt1")){//����������õ�ָ�bt1��
			System.out.println("����ɫ");
		}else if(e.getActionCommand().equals("bt2")){//����������õ�ָ�bt2��
			System.out.println("���ɫ");
		}
		
	}
	
}