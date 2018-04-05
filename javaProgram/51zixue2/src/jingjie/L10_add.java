
package jingjie;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class L10_add extends JDialog implements ActionListener{
	JLabel lb1,lb2,lb3,lb4,lb5,lb6;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6;
	JButton bt1,bt2;
	JPanel pn1,pn2,pn3,pn4;
	public L10_add(JFrame frame,String title,boolean r){//�����壬���⣬�Ƿ����ȴ�����
		super(frame,title,r);//ע���ʽ��
		lb1=new JLabel("      ѧ��");lb2=new JLabel("      ����");
		lb3=new JLabel("      �Ա�");lb4=new JLabel("      ����");
		lb5=new JLabel("      ����");lb6=new JLabel("    ����Ժϵ");
		tf1=new JTextField(10);tf2=new JTextField(10);tf3=new JTextField(10);
		tf4=new JTextField(10);tf5=new JTextField(10);tf6=new JTextField(10);
		bt1=new JButton("����");bt2=new JButton("����");
		bt1.addActionListener(this);bt2.addActionListener(this);
		bt1.setActionCommand("add");bt2.setActionCommand("back");
		pn1=new JPanel();pn2=new JPanel();pn3=new JPanel();pn4=new JPanel();
		pn1.setLayout(new GridLayout(6,2));
		
		pn1.add(lb1);pn1.add(tf1);pn1.add(lb2);pn1.add(tf2);
		pn1.add(lb3);pn1.add(tf3);pn1.add(lb4);pn1.add(tf4);
		pn1.add(lb5);pn1.add(tf5);pn1.add(lb6);pn1.add(tf6);
		
		pn2.add(bt1);pn2.add(bt2);
		
		this.add(pn1);
		this.add(pn2,BorderLayout.SOUTH);this.add(pn3,BorderLayout.EAST);this.add(pn4,BorderLayout.NORTH);
		
		this.setBounds(250, 180, 200, 250);
		this.setResizable(false);
		this.setVisible(true);
	//	this.setDefaultCloseOperation(3);�õ���û����С���ȹ��ܣ������˻ᱨ��
		
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("add")){
			Connection ct=null;
			PreparedStatement ps=null;
			try{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				ct=DriverManager.getConnection("jdbc:odbc:sql server","sa","kuangyun398");
				String data=("insert into xuesheng values(?,?,?,?,?,?)");
				ps=ct.prepareStatement(data);
				ps.setString(1, tf1.getText());ps.setString(2, tf2.getText());
				ps.setString(3, tf3.getText());ps.setString(4, tf4.getText());
				ps.setString(5, tf5.getText());ps.setString(6, tf6.getText());
				ps.executeUpdate();
				this.dispose();
			}catch(Exception e1){
				
			}finally{
				try{
					ct.close();
					
					ps.close();
				}catch(Exception e2){}
			}
			
			
		}else if(e.getActionCommand().equals("back")){
			this.dispose();
		}
		
	}
}