//GUI�ۺ�Ӧ��----����QQ���촰��

package jingjie;
import java.awt.*;

import javax.swing.*;
public class L5_12 extends JFrame{
	JLabel lb1;//����
	JPanel pn1;JButton bt1,bt2,bt3;//�ϲ�
	
	JPanel pn2,pn3,pn4;JLabel lb2,lb3,lb4,lb5;JTextField tf1;JPasswordField pw1;
	JCheckBox cb1,cb2;JButton bt4;JTabbedPane tp1;//�в�
	public static void main(String[] args){
		L5_12 aa=new L5_12();
	}
	public L5_12(){
		lb1=new JLabel(new ImageIcon("image/qq2.jpg"));//����
		
		pn1=new JPanel();bt1=new JButton("��½");bt2=new JButton("ȡ��");bt3=new JButton(new ImageIcon("image/help.jpg"));
		pn1.add(bt1);pn1.add(bt2);pn1.add(bt3);//�ϲ�
		
		tp1=new JTabbedPane();pn2=new JPanel();pn3=new JPanel();pn4=new JPanel();
		tp1.add("��ͨ�û�",pn2);tp1.add("QQ��Ա",pn3);tp1.add("����Ա",pn4);
		lb2=new JLabel("qq����",JLabel.CENTER);lb3=new JLabel("qq����",JLabel.CENTER);
		lb4=new JLabel("��������",JLabel.CENTER);lb4.setFont(new Font("����",Font.PLAIN,16));lb4.setForeground(Color.red);//����������ɫ
		bt4=new JButton(new ImageIcon("image/clear.gif"));cb1=new JCheckBox("�����½");cb2=new JCheckBox("��ס����");
		lb5=new JLabel("<html><a href='www.qq.com'>�������뱣��</a>");//�������Ӻ���ʾ����
		lb5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//����ѡ��ʱָ������ָ״
		tf1=new JTextField(10);pw1=new JPasswordField(10);
		pn3.setBackground(Color.yellow);pn4.setBackground(Color.green);
		pn2.setLayout(new GridLayout(3,3));
		pn2.add(lb2);pn2.add(tf1);pn2.add(bt4);
		pn2.add(lb3);pn2.add(pw1);pn2.add(lb4);
		pn2.add(cb1);pn2.add(cb2);pn2.add(lb5);
		
		this.add(lb1,BorderLayout.NORTH);this.add(pn1,BorderLayout.SOUTH);
		this.add(tp1);
		this.setTitle("���촰��");
		this.setIconImage((new ImageIcon("image/qq.jpg")).getImage());//�������ı�ͼ��
		this.setSize(330,280);
		this.setResizable(false);
		this.setLocation(350,150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}