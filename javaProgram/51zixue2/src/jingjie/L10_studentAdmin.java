//�򵥵�ѧ������ϵͳ
//����������Դstudent���ݿ�
package jingjie;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class L10_studentAdmin extends JFrame implements ActionListener{
	L10_search tablemodel;//����һ���Զ����tablemodel
	JLabel lb1;JTextField tf1;JButton bt1;JPanel pn1,pn2;  //��
	JTable tb1;JScrollPane sp1;Vector ziduan,jilu;	//��
	Connection ct=null;PreparedStatement ps=null;ResultSet rs=null;//��
	JButton bt2,bt3,bt4,bt5;	//��
	public static void main(String[] args){
		L10_studentAdmin aa=new L10_studentAdmin();
	}
	public L10_studentAdmin(){
		//��
		lb1=new JLabel("����������");tf1=new JTextField(10);bt1=new JButton("��ѯ");pn1=new JPanel();
		bt1.addActionListener(this);bt1.setActionCommand("chaxun");

		//��
		tablemodel=new L10_search();
		tb1=new JTable(tablemodel);
		sp1=new JScrollPane(tb1);

		//��
		bt2=new JButton("���");bt3=new JButton("�޸�");bt4=new JButton("ɾ��");bt5=new JButton("ˢ��");pn2=new JPanel();
		bt2.addActionListener(this);bt2.setActionCommand("tianjia");
		bt3.addActionListener(this);bt3.setActionCommand("xiugai");
		bt4.addActionListener(this);bt4.setActionCommand("shanchu");
		bt5.addActionListener(this);bt5.setActionCommand("shuaxin");

		pn1.add(lb1);pn1.add(tf1);pn1.add(bt1);
		pn2.add(bt2);pn2.add(bt3);pn2.add(bt4);pn2.add(bt5);

		this.add(pn1,BorderLayout.NORTH);
		this.add(sp1);
		this.add(pn2,BorderLayout.SOUTH);
		this.setSize(600,500);
		this.setTitle("ѧ������ϵͳ");
		this.setLocation(150,150);
		this.setDefaultCloseOperation(3);
		this.setVisible(true);
		this.setResizable(false);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("chaxun")){
			String xingming=this.tf1.getText().trim();//�������ı����е�ֵ��ȥ��ͷβ�Ŀո�
			tablemodel=new L10_search("select * from xuesheng where xingming='"+xingming+"'");
			tb1.setModel(tablemodel);
		}else if(e.getActionCommand().equals("tianjia")){
			L10_add add=new L10_add(this,"���ѧ��",true);
			tablemodel=new L10_search();
			tb1.setModel(tablemodel);
		}else if(e.getActionCommand().equals("xiugai")){
			int row=this.tb1.getSelectedRow();
			if(row==-1){
				JOptionPane.showMessageDialog(this, "��ѡ��Ҫ�޸ĵ�ѧ��");
				return;
			}else{
				L10_correct correct=new L10_correct(this,"�޸�ѧ����Ϣ",true,tablemodel,row);
				tablemodel=new L10_search();
				tb1.setModel(tablemodel);
			}
		}else if(e.getActionCommand().equals("shanchu")){
			int row=this.tb1.getSelectedRow();
			if(row==-1){
				JOptionPane.showMessageDialog(this, "��ѡ��Ҫɾ����ѧ��");
				return;
			}else{
				String bh=(String)tablemodel.getValueAt(row, 0);
				String sql="delete from xuesheng where xuehao='"+bh+"'";
				tablemodel=new L10_search(sql);
				tablemodel=new L10_search();
				tb1.setModel(tablemodel);
			}
		}else if(e.getActionCommand().equals("shuaxin")){
			tablemodel=new L10_search();
			tb1.setModel(tablemodel);
		}


	}
}
