package jingjie;
//import java.awt.*;
import javax.swing.*;
public class L5_2 extends JFrame{//主函数继承界面函数
	JButton an1=null;			//定于所有的组件
	public static void main(String[] args){
		L5_2 aa=new L5_2();		//调用函数
	}
	public L5_2(){//把所有的组件写入构造函数中，用this调用当前JFrame
		this.setTitle("用户界面");
		an1=new JButton("一个按钮");
		this.setSize(350,180);
		this.setLocation(100, 260);
		this.add(an1);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
}
