package jingjie;
//import java.awt.*;
import javax.swing.*;
public class L5_1 {
	public static void main(String[] args){
		JFrame aa=new JFrame();//��������
		aa.setTitle("�û�����");//���ñ���
		JButton an1=new JButton("һ����ť");//��Ӱ�ť
		aa.setSize(350,180);//���ý����С
		aa.setLocation(100, 260);//��ƽ���λ��
		aa.add(an1);//��Ӱ�ť
		aa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ùر�ʱ�Ƴ����ڴ�
		aa.setVisible(true);//��ʾ����
		
	}
}
