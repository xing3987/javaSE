//���ֹ��������ۺ�Ӧ��

package jingjie;
import java.awt.*;
import javax.swing.*;
public class L5_6 extends JFrame{
	JButton an1,an2,an3,an4,an5;
	JPanel bn1,bn2;//������Ĭ������ʽ����
	public static void main(String[] args){
		L5_6 aa=new L5_6();
	}
	public L5_6(){
		an1=new JButton("�޲�");//�ȶ�������������
		an2=new JButton("��");
		an3=new JButton("���");
		an4=new JButton("����");
		an5=new JButton("����");
		bn1=new JPanel();//Ȼ��������������
		bn2=new JPanel();
		bn1.add(an1);bn1.add(an2);//Ȼ��������ӵ����ӵİ����
		bn2.add(an3);bn2.add(an4);
		this.add(bn1,BorderLayout.NORTH);//�Ѹ��������뵽������ȥ
		this.add(bn2,BorderLayout.SOUTH);
		this.add(an5);//Ĭ����ӵ��м�
		this.setTitle("�ۺϹ�����");
		this.setSize(300,300);
		this.setLocation(150,150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}