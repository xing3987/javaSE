//GUI�ۺ�Ӧ��----���Ӽ��±�

package jingjie;
import java.awt.*;
//import java.awt.event.*;

import javax.swing.*;
public class L5_13 extends JFrame{
	JMenuBar mb1;JMenu mn1,mn2,mn3,mn4,mn5;//�˵����Ͳ˵�ѡ��
	JMenuItem mi1,mi2,mi3,mi4,mi5,mi6;//���ռ��Ĳ˵�ѡ��
	JMenu mn6;JMenuItem mi7,mi8;
	
	JToolBar tb1;JButton bt1,bt2,bt3,bt4,bt5,bt6;//������
	JTextArea ta1;JScrollPane sp1;
	
	
	public static void main(String[] args){
		L5_13 aa=new L5_13();
	}
	public L5_13(){
		mb1=new JMenuBar();//���ò˵���
		mn1=new JMenu("�ļ�(F)");mn1.setMnemonic('F');//���ÿ�ݼ�
		mn2=new JMenu("�༭(E)");mn2.setMnemonic('E');
		mn3=new JMenu("��ʽ(O)");mn3.setMnemonic('O');
		mn4=new JMenu("�鿴(V)");mn4.setMnemonic('V');
		mn5=new JMenu("����(H)");mn5.setMnemonic('H');
		
		mn6=new JMenu("�½�");
		mi7=new JMenuItem("�ļ�",new ImageIcon("image/jsb.jpg"));//���ö����˵�����Ӳ˵�ͼ��
		mi8=new JMenuItem("ģ��",new ImageIcon("image/mb.jpg"));
		mi1=new JMenuItem("��");mi2=new JMenuItem("����");mi3=new JMenuItem("���Ϊ");
		mi4=new JMenuItem("ҳ������");mi5=new JMenuItem("��ӡ");mi6=new JMenuItem("�˳�");
		
		tb1=new JToolBar();//���ù������Լ�����ƶ�����ťʱ��Ĭ��ע��
		bt1=new JButton(new ImageIcon("image/xj.jpg"));bt1.setToolTipText("�½�");
		bt2=new JButton(new ImageIcon("image/dk.jpg"));bt2.setToolTipText("��");
		bt3=new JButton(new ImageIcon("image/bc.jpg"));bt3.setToolTipText("����");
		bt4=new JButton(new ImageIcon("image/fz.jpg"));bt4.setToolTipText("����");
		bt5=new JButton(new ImageIcon("image/jq.jpg"));bt5.setToolTipText("����");
		bt6=new JButton(new ImageIcon("image/zt.jpg"));bt6.setToolTipText("ճ��");
		
		ta1=new JTextArea();sp1=new JScrollPane(ta1);
		
		mn6.add(mi7);mn6.add(mi8);
		mn1.add(mn6);mn1.add(mi1);mn1.add(mi2);mn1.add(mi3);
		mn1.addSeparator();//����һ���ָ���
		mn1.add(mi4);mn1.add(mi5);
		mn1.addSeparator();//����һ���ָ���
		mn1.add(mi6);
		
		mb1.add(mn1);mb1.add(mn2);mb1.add(mn3);mb1.add(mn4);mb1.add(mn5);
		tb1.add(bt1);tb1.add(bt2);tb1.add(bt3);tb1.add(bt4);tb1.add(bt5);tb1.add(bt6);
		
		this.setJMenuBar(mb1);//��Ӳ˵���
		;this.add(tb1,BorderLayout.NORTH);this.add(sp1);
		
		this.setTitle("���±�");
		this.setIconImage((new ImageIcon("image/jsb.jpg")).getImage());//�������ı�ͼ��
		this.setSize(330,280);
		//this.setResizable(false);
		this.setLocation(350,150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}