//���񲼾ֹ������Ĵ�����ʹ��

package jingjie;
import java.awt.*;
import javax.swing.*;
public class L5_5 extends JFrame{
	JButton[] an={null,null,null,null,null,null,null};
	public static void main(String[] args){
		L5_5 aa=new L5_5();
	}
	public L5_5(){
		an[0]=new JButton("�ײ�");
		an[1]=new JButton("�ײ�");
		an[2]=new JButton("�޲�");
		an[3]=new JButton("��");
		an[4]=new JButton("���");
		an[5]=new JButton("���");
		an[6]=new JButton("���");
		this.setLayout(new GridLayout(3,3,10,10));//�������񲼾ֹ�������3*3������,���10*10������
		for(int i=0;i<an.length;i++){
			this.add(an[i]);
		}
		this.setTitle("��ʽ���ֹ�����");
		this.setSize(400,400);
	//	this.setResizable(false);//���ܵ�����С
		this.setLocation(150,150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}