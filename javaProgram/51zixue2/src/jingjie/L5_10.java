//���ͼƬ��ʹ�ÿɲ�ֵ����

package jingjie;
import java.awt.*;
import javax.swing.*;
public class L5_10 extends JFrame{
	JPanel dn1;JButton dn2,dn3;
	JSplitPane an1;//���һ����ֵ����
	JLabel bn1;
	JList cn1;
	public static void main(String[] args){
		L5_10 aa=new L5_10();
	}
	public L5_10(){
		String[] z={"�������","��Ϸ����","ƽ�����","��������","�������"};
		cn1=new JList(z);
		bn1=new JLabel(new ImageIcon("image/1.jpg"));//���ͼƬ��ע��ͼƬ��ʽ��������/�ź��ļ���λ��
		an1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,cn1,bn1);//�����ɲ�ֵ���壬Ϊ���Ҳ�֣����cn1���ұ�bn1
		an1.setOneTouchExpandable(true);
		
		dn2=new JButton("��һҳ");dn3=new JButton("��һҳ");
		dn1=new JPanel();
		dn1.add(dn2);dn1.add(dn3);
		
		this.add(an1);//��Ӳ����嵽BorderLayout��Ĭ��Ϊ�м����������
		this.add(dn1,BorderLayout.NORTH);//������Ӱ�ť���
		this.setTitle("�û�����");
		this.setSize(680,380);
		this.setResizable(false);
		this.setLocation(350,150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}