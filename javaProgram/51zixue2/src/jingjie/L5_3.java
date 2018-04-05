//边界布局管理器的创建和使用

package jingjie;
import java.awt.*;
import javax.swing.*;
public class L5_3 extends JFrame{
	JButton an1,an2,an3,an4,an5;
	public static void main(String[] args){
		L5_3 aa=new L5_3();
	}
	public L5_3(){
		an1=new JButton("东部");
		an2=new JButton("西部");
		an3=new JButton("南部");
		an4=new JButton("北部");
		an5=new JButton("中部");
		this.add(an1,BorderLayout.EAST);
		this.add(an2,BorderLayout.WEST);
		this.add(an3,BorderLayout.SOUTH);
		this.add(an4,BorderLayout.NORTH);
		this.add(an5,BorderLayout.CENTER);
		this.setTitle("边界管理器");
		this.setSize(300,300);
		this.setLocation(150,150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
