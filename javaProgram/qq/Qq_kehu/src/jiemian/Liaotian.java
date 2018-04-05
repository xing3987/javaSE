package jiemian;
import gonggong.Message;
import gonggong.MessageType;
import gongju.Glxc;

import javax.swing.*;

import moxing.*;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Liaotian extends JFrame implements ActionListener{
	JPanel pn1;
	JButton bt1,bt2;
	JTextField tf1;JScrollPane sp1;JTextArea ta1;
	String owerName,friendNo;
	public static void main(String[] args){
		String a="1",b="2";
		Liaotian aa=new Liaotian(a,b);
	}
	public Liaotian(String owerName,String friendNo){
		this.owerName=owerName;this.friendNo=friendNo;
		ta1=new JTextArea();ta1.setEditable(false);ta1.setForeground(Color.red);
		sp1=new JScrollPane(ta1);

		pn1=new JPanel();pn1.setLayout(new BorderLayout());
		bt1=new JButton("发送");bt1.addActionListener(this);
		bt2=new JButton("清空");bt2.addActionListener(this);
		tf1=new JTextField(10);
		pn1.add(tf1);pn1.add(bt1,BorderLayout.EAST);pn1.add(bt2,BorderLayout.WEST);

		this.add(sp1);this.add(pn1,BorderLayout.SOUTH);
		this.setBounds(150,150,300,300);
		this.setResizable(false);
		this.setVisible(true);
		this.setTitle("");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	//	this.setDefaultCloseOperation(3);
		this.setIconImage(new ImageIcon("image/qq.jpg").getImage());
		this.setTitle(this.owerName+"正在和"+this.friendNo+"聊天");

	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt1){
			Message ms=new Message();
			ms.setMesTape(MessageType.message_comm_mes);
			ms.setSender(this.owerName);
			ms.setGetter(this.friendNo);
			ms.setSendTime(Calendar.getInstance().getTime().toLocaleString());
			ms.setCon(tf1.getText().trim()+"      "+ms.getSendTime()+"\r\n");
			try{
				ObjectOutputStream oos=new ObjectOutputStream(Glxc.getLjfwqxc(owerName).getS().getOutputStream());
				oos.writeObject(ms);
			}catch(Exception e1){}
			ta1.append(owerName+"对"+friendNo+"说"+tf1.getText().trim()+"      "+ms.getSendTime()+"\r\n");
			tf1.setText("");
		}else if(e.getSource()==bt2){
			ta1.setText("");
		}
		
	}

	public void showMessage(Message ms) {
		ta1.append(ms.getSender()+"对"+ms.getGetter()+"说："+ms.getCon());
	}
	
}
