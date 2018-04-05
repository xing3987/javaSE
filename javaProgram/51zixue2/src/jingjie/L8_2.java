//事件监听，控件的监听

package jingjie;
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
public class L8_2 extends JFrame implements ActionListener{
	Wdmb mb;
	JButton bt1,bt2;
	Jtz jtz;
	public static void main(String[] args){
		L8_2 aa=new L8_2();
	}
	public L8_2() {
		mb=new Wdmb();
		bt1=new JButton("蓝色");bt2=new JButton("红色");
		this.add(bt1,BorderLayout.NORTH);
		this.add(bt2,BorderLayout.SOUTH);
		mb.setBackground(Color.yellow);
		this.add(mb);
		
		Jtz jtz=new Jtz();
		bt1.addActionListener(jtz);//添加另一个自己创建的监听器
		bt2.addActionListener(jtz);
		
		bt1.addActionListener(this);//添加事件监听器（当前主函数的监听器）
		bt1.setActionCommand("bt1");//添加监听的指令该指令为一个字符串“*”
		bt2.addActionListener(this);
		bt2.setActionCommand("bt2");
				
		this.setTitle("事件监听");
		this.setSize(200,200);
		this.setLocation(100,100);
		this.setDefaultCloseOperation(3);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println("按钮起作用了");
		if(e.getActionCommand().equals("bt1")){//如果监听器得到指令“bt1”
			mb.setBackground(Color.blue);
		}else if(e.getActionCommand().equals("bt2")){//如果监听器得到指令“bt2”
			mb.setBackground(Color.red);
		}
	}
	
}

class Wdmb extends JPanel{
	public void paint(Graphics g) {
		super.paint(g);
	}
}

class Jtz implements ActionListener{//创建一个自定义的监听器
	public void actionPerformed(ActionEvent e) {
		System.out.println("监听器"+this.getClass().getName()+"起作用了");
		if(e.getActionCommand().equals("bt1")){//如果监听器得到指令“bt1”
			System.out.println("变蓝色");
		}else if(e.getActionCommand().equals("bt2")){//如果监听器得到指令“bt2”
			System.out.println("变红色");
		}
		
	}
	
}