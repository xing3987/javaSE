//����ͼ��

package jingjie;
import java.awt.*;

import javax.swing.*;
public class L8_1 extends JFrame{
	MyPanel mp=null;	
	MyPanel11 mp1=null;
	public static void main(String[] args){
		L8_1 aa=new L8_1();
	}
	public L8_1(){
		MyPanel mp=new MyPanel();
		MyPanel11 mp1=new MyPanel11();
		
		this.setLayout(new GridLayout(2,1));
		this.add(mp);
		this.add(mp1);
		this.setSize(400,400);
		this.setLocation(200,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

class MyPanel extends JPanel{//����һ���Զ������壬�������JPanel������չ
	public void paint(Graphics g){//����JPannel�����ͼ����������G��
									//�÷�������������ᱻ���ã�1�����򴴽�ʱ�������ʱ      2���ı��Сʱ������϶��߿�ı��С��3������repaint����ʱ
		System.out.println("����������");//ÿ�ε��ø÷�����ӡ���
		g.drawOval(0, 0, 30, 30);//��Բ���ߣ���ʼ��ᣬ��ʼ���ݣ������С�������С��
		g.drawLine(40, 15, 70, 30);//���߹��ߣ���ʼ��ᣬ��ʼ���ݣ�������ᣬ�������ݣ�
		g.drawRect(100, 30, 30, 50);//���ι��ߣ���ʼ��ᣬ��ʼ���ݣ������С�������С��
		g.draw3DRect(150, 30, 50, 50,true);////���ι��ߣ���ʼ��ᣬ��ʼ���ݣ������С�������С,3D���أ�
		g.setColor(Color.cyan);//���û�����ɫΪ��ɫ��֮�����ͼ���Ǹ���ɫ����������ɫĬ��Ϊ��ɫ
		g.fillRect(250, 30, 35, 40);//�����ι��ߣ���ʼ��ᣬ��ʼ���ݣ������С�������С��fill�������
		g.setColor(Color.pink);
		g.fillOval(40, 100, 50, 50);//���Բ����
	}
}

class MyPanel11 extends JPanel{//����һ���Զ������壬�������JPanel������չ
	public void paint(Graphics g){
		Image tp=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/L8_1.jpg"));//����������ͼƬ����ͼƬҪ���뵽ͬһ���ļ���src��
		g.drawImage(tp, 0,0,400,200, this);//��ͼ����(ͼƬ����ʼ�ᣬ��ʼ�ݣ������С�������С�����λ��)
		g.setColor(Color.red);
		g.setFont(new Font("����",Font.BOLD,50));//�������壨�����塱������Ӵ֣��ֺţ�
		g.drawString("��Һã���", 50, 50);//д�֣������ݡ�,��ʼ�ᣬ��ʼ�ݣ�
	}
	
}