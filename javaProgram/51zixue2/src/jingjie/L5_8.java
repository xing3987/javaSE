//��ѡ��͸�ѡ��

package jingjie;
import java.awt.*;
import javax.swing.*;
public class L5_8 extends JFrame{
	JButton an1,an2;
	JPanel bn1,bn2,bn3;
	JLabel cn1,cn2;
	JCheckBox dn1,dn2,dn3;//���帴ѡ��
	JRadioButton en1,en2;//���嵥ѡ��
	ButtonGroup ee;//���嵥ѡ����飬�����͵�ѡ����ͬ����
	public static void main(String[] args){
		L5_8 aa=new L5_8();
	}
	public L5_8(){
		an1=new JButton("ע��");an2=new JButton("ȡ��");
		bn1=new JPanel();bn2=new JPanel();bn3=new JPanel();
		cn1=new JLabel("�س�");cn2=new JLabel("�Ա�");
		dn1=new JCheckBox("����");dn2=new JCheckBox("����");dn3=new JCheckBox("����");
		en1=new JRadioButton("��");en2=new JRadioButton("Ů");
		ee=new ButtonGroup();ee.add(en1);ee.add(en2);//��������ѡ��������У���ô��������ѡ��;߱��˵�ѡ������		
		bn1.add(cn1);bn1.add(dn1);bn1.add(dn2);bn1.add(dn3);
		bn2.add(cn2);bn2.add(en1);bn2.add(en2);
		bn3.add(an1);bn3.add(an2);
		this.setLayout(new GridLayout(3,1));
		this.add(bn1);this.add(bn2);this.add(bn3);
		this.setTitle("�û���½");
		this.setSize(290,160);
		this.setResizable(false);
		this.setLocation(550,250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}