//��ʽ���ֹ������Ĵ�����ʹ��

package jingjie;
import java.awt.*;
import javax.swing.*;
public class L5_4 extends JFrame{
	JButton an1,an2,an3,an4,an5,an6,an7;
	public static void main(String[] args){
		L5_4 aa=new L5_4();
	}
	public L5_4(){
		an1=new JButton("�ײ�");
		an2=new JButton("�ײ�");
		an3=new JButton("�޲�");
		an4=new JButton("��");
		an5=new JButton("���");
		an6=new JButton("���");
		an7=new JButton("���");
		this.setLayout(new FlowLayout());//��ΪĬ�ϵ��Ǳ߽粼�֣��������������ֹ���ʱҪ�ȵ���,Ĭ�����м����
		//this.setLayout(new FlowLayout(FlowLayout.CENTER));//����������Ҷ������ʽ����
		this.add(an1);
		this.add(an2);
		this.add(an3);
		this.add(an4);
		this.add(an5);
		this.add(an6);
		this.add(an7);
		this.setTitle("��ʽ���ֹ�����");
		this.setSize(500,300);
		this.setResizable(false);//���ܵ�����С
		this.setLocation(150,150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
