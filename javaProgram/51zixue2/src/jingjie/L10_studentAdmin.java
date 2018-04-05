//简单的学生管理系统
//先配置数据源student数据库
package jingjie;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class L10_studentAdmin extends JFrame implements ActionListener{
	L10_search tablemodel;//创建一个自定义的tablemodel
	JLabel lb1;JTextField tf1;JButton bt1;JPanel pn1,pn2;  //上
	JTable tb1;JScrollPane sp1;Vector ziduan,jilu;	//中
	Connection ct=null;PreparedStatement ps=null;ResultSet rs=null;//中
	JButton bt2,bt3,bt4,bt5;	//下
	public static void main(String[] args){
		L10_studentAdmin aa=new L10_studentAdmin();
	}
	public L10_studentAdmin(){
		//上
		lb1=new JLabel("请输入姓名");tf1=new JTextField(10);bt1=new JButton("查询");pn1=new JPanel();
		bt1.addActionListener(this);bt1.setActionCommand("chaxun");

		//中
		tablemodel=new L10_search();
		tb1=new JTable(tablemodel);
		sp1=new JScrollPane(tb1);

		//下
		bt2=new JButton("添加");bt3=new JButton("修改");bt4=new JButton("删除");bt5=new JButton("刷新");pn2=new JPanel();
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
		this.setTitle("学生管理系统");
		this.setLocation(150,150);
		this.setDefaultCloseOperation(3);
		this.setVisible(true);
		this.setResizable(false);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("chaxun")){
			String xingming=this.tf1.getText().trim();//姓名的文本域中的值（去除头尾的空格）
			tablemodel=new L10_search("select * from xuesheng where xingming='"+xingming+"'");
			tb1.setModel(tablemodel);
		}else if(e.getActionCommand().equals("tianjia")){
			L10_add add=new L10_add(this,"添加学生",true);
			tablemodel=new L10_search();
			tb1.setModel(tablemodel);
		}else if(e.getActionCommand().equals("xiugai")){
			int row=this.tb1.getSelectedRow();
			if(row==-1){
				JOptionPane.showMessageDialog(this, "请选中要修改的学生");
				return;
			}else{
				L10_correct correct=new L10_correct(this,"修改学生信息",true,tablemodel,row);
				tablemodel=new L10_search();
				tb1.setModel(tablemodel);
			}
		}else if(e.getActionCommand().equals("shanchu")){
			int row=this.tb1.getSelectedRow();
			if(row==-1){
				JOptionPane.showMessageDialog(this, "请选中要删除的学生");
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
