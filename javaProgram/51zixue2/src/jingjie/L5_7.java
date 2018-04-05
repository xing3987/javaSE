//布局管理器的综合应用

package jingjie;
import java.awt.*;
import javax.swing.*;
public class L5_7 extends JFrame{
	JButton an1,an2;
	JPanel bn1,bn2,bn3;
	JLabel cn1,cn2;
	JTextField dn1;
	JPasswordField en1;
	public static void main(String[] args){
		L5_7 aa=new L5_7();
	}
	public L5_7(){
		an1=new JButton("登陆");an2=new JButton("取消");
		bn1=new JPanel();bn2=new JPanel();bn3=new JPanel();
		cn1=new JLabel("用户名");cn2=new JLabel("密     码");
		dn1=new JTextField(10);//新建一个10字符长度的文本框,只是文本框界面的长度不代表里面内容的长度
		en1=new JPasswordField(10);//新建一个10字符长度的密码框
		bn1.add(cn1);bn1.add(dn1);//把用户名和文本框放在一个面板
		bn2.add(cn2);bn2.add(en1);//把密码和密码框放在一个面版
		bn3.add(an1);bn3.add(an2);//把两个按钮放在一个面板
		this.setLayout(new GridLayout(3,1));
		this.add(bn1);this.add(bn2);this.add(bn3);
		this.setTitle("用户登陆");
		this.setSize(230,150);
		this.setResizable(false);
		this.setLocation(550,250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}