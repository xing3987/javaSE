package jingjie;
//import java.awt.*;
import javax.swing.*;
public class L5_2 extends JFrame{//�������̳н��溯��
	JButton an1=null;			//�������е����
	public static void main(String[] args){
		L5_2 aa=new L5_2();		//���ú���
	}
	public L5_2(){//�����е����д�빹�캯���У���this���õ�ǰJFrame
		this.setTitle("�û�����");
		an1=new JButton("һ����ť");
		this.setSize(350,180);
		this.setLocation(100, 260);
		this.add(an1);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
}
