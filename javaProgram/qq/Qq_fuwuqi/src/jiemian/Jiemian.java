package jiemian;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import moshi.*;
import javax.swing.*;
public class Jiemian extends JFrame implements ActionListener{
	JPanel pn1;
	JButton bt1,bt2;
	public static void main(String[] args){
		Jiemian aa=new Jiemian();
	}
	public Jiemian(){
		pn1=new JPanel();
		bt1=new JButton("启动服务器");bt1.addActionListener(this);
		bt2=new JButton("关闭服务器");bt2.addActionListener(this);
		pn1.add(bt1);pn1.add(bt2);
		this.add(pn1);
		this.setBounds(200,200,200,120);
		this.setResizable(false);
		this.setVisible(true);
		this.setTitle("服务器");
		this.setDefaultCloseOperation(3);
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt1){
			new Fuwu();
		}else if(e.getSource()==bt2){
			System.exit(0);
		}
		
	}
}
