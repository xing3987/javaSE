//������������б�

package jingjie;
import java.awt.*;
import javax.swing.*;
public class L5_9 extends JFrame{
	JPanel bn1,bn2;
	JLabel cn1,cn2;
	JComboBox dn1;//����������
	JList en1;//���������б�
	JScrollPane fn1;//�������б�����Ĺ�����
	public static void main(String[] args){
		L5_9 aa=new L5_9();
	}
	public L5_9(){
		cn1=new JLabel("����");cn2=new JLabel("ѧ��");
		
		String[] dn={"����","����","�Ϻ�","�Ͼ�","����"};
		dn1=new JComboBox(dn);//���������򣬿�������Ϊ��ǰ������ַ���
		
		String[] en={"����","��ר","����","˶ʿ","��ʿ"};
		en1=new JList(en);//�����б���������Ϊ���ڵ��ַ���
		en1.setVisibleRowCount(3);//�����б�ɼ�����
		fn1=new JScrollPane(en1);//���������������б�Ϊ��׼������
		
		bn1=new JPanel();bn2=new JPanel();
		bn1.add(cn1);bn1.add(dn1);
		bn2.add(cn2);bn2.add(fn1);	//ע��������ӵ����б�����������������������б�ǧ��Ҫֻ����б���
		this.setLayout(new GridLayout(2,1));
		this.add(bn1);this.add(bn2);
		this.setTitle("�û�����");
		this.setSize(250,170);
		this.setResizable(false);
		this.setLocation(550,250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}