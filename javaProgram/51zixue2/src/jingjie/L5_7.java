//���ֹ��������ۺ�Ӧ��

package jingjie;
import java.awt.*;
import javax.swing.*;
public class L5_7 extends JFrame{
	JButton an1,an2;
	JPanel bn1,bn2,bn3;
	JLabel cn1,cn2;
	JTextField dn1;
	JPasswordField en1;
	public static void main(String[] args){
		L5_7 aa=new L5_7();
	}
	public L5_7(){
		an1=new JButton("��½");an2=new JButton("ȡ��");
		bn1=new JPanel();bn2=new JPanel();bn3=new JPanel();
		cn1=new JLabel("�û���");cn2=new JLabel("��     ��");
		dn1=new JTextField(10);//�½�һ��10�ַ����ȵ��ı���,ֻ���ı������ĳ��Ȳ������������ݵĳ���
		en1=new JPasswordField(10);//�½�һ��10�ַ����ȵ������
		bn1.add(cn1);bn1.add(dn1);//���û������ı������һ�����
		bn2.add(cn2);bn2.add(en1);//���������������һ�����
		bn3.add(an1);bn3.add(an2);//��������ť����һ�����
		this.setLayout(new GridLayout(3,1));
		this.add(bn1);this.add(bn2);this.add(bn3);
		this.setTitle("�û���½");
		this.setSize(230,150);
		this.setResizable(false);
		this.setLocation(550,250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}