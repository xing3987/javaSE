package jingjie;
//import java.awt.*;
import javax.swing.*;
public class L5_1 {
	public static void main(String[] args){
		JFrame aa=new JFrame();//创建界面
		aa.setTitle("用户界面");//设置标题
		JButton an1=new JButton("一个按钮");//添加按钮
		aa.setSize(350,180);//设置界面大小
		aa.setLocation(100, 260);//设计界面位置
		aa.add(an1);//添加按钮
		aa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//启用关闭时移除出内存
		aa.setVisible(true);//显示界面
		
	}
}
