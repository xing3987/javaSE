
package jingjie;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class L10_correct extends JDialog implements ActionListener{
	JLabel lb1,lb2,lb3,lb4,lb5,lb6;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6;
	JButton bt1,bt2;
	JPanel pn1,pn2,pn3,pn4;
	public L10_correct(JFrame frame,String title,boolean r,L10_search tablemodel,int row){
		super(frame,title,r);
		lb1=new JLabel("      学号");lb2=new JLabel("      姓名");
		lb3=new JLabel("      性别");lb4=new JLabel("      年龄");
		lb5=new JLabel("      籍贯");lb6=new JLabel("    所在院系");
		tf1=new JTextField(10);tf1.setText((String)tablemodel.getValueAt(row, 0));tf1.setEditable(false);//设置不能修改
		tf2=new JTextField(10);tf2.setText((String)tablemodel.getValueAt(row, 1));
		tf3=new JTextField(10);tf3.setText((String)tablemodel.getValueAt(row, 2));
		tf4=new JTextField(10);tf4.setText((String)tablemodel.getValueAt(row, 3).toString());
		tf5=new JTextField(10);tf5.setText((String)tablemodel.getValueAt(row, 4));
		tf6=new JTextField(10);tf6.setText((String)tablemodel.getValueAt(row, 5));
		bt1=new JButton("修改");bt2=new JButton("返回");
		bt1.addActionListener(this);bt2.addActionListener(this);
		bt1.setActionCommand("correct");bt2.setActionCommand("back");
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
		
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("correct")){
			Connection ct=null;
			PreparedStatement ps=null;
			try{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				ct=DriverManager.getConnection("jdbc:odbc:sql server","sa","kuangyun398");
				String data=("update xuesheng set xingming=?,xingbie=?,nianling=?,jiguan=?,yxmc=? where xuehao=?" );
				ps=ct.prepareStatement(data);
				ps.setString(1, tf2.getText());ps.setString(2, tf3.getText());
				ps.setString(3, tf4.getText());ps.setString(4, tf5.getText());
				ps.setString(5, tf6.getText());ps.setString(6, tf1.getText());
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