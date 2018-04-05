//简易聊天工具服务器

package jingjie;
import java.awt.*;

import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;
public class L13_3 extends JFrame implements ActionListener{
	JPanel pn1;
	JButton bt1,bt2;
	JTextField tf1;JScrollPane sp1;JTextArea ta1;
	PrintWriter pw;


	public static void main(String[] args){
		L13_3 aa=new L13_3();
	}
	public L13_3(){
		ta1=new JTextArea();ta1.setEnabled(false);
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
		this.setTitle("简易聊天工具--服务器");
		this.setDefaultCloseOperation(3);
		this.setIconImage(new ImageIcon("image/qq.jpg").getImage());

		try {
			ServerSocket ss=new ServerSocket(9999);
			Socket s=ss.accept();
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader(isr);
			pw=new PrintWriter(s.getOutputStream(),true);
			while(true){
				ta1.append("客户端说："+br.readLine()+"\r\n");
			}
		} catch (IOException e) {}

	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt1){
			String text=tf1.getText().trim();
			tf1.setText("");
			ta1.append("我说:"+text+"\r\n");
			pw.println(text);
		}else if(e.getSource()==bt2){
			ta1.setText("");
		}

	}
}