//流式布局管理器的创建和使用

package jingjie;
import java.awt.*;
import javax.swing.*;
public class L5_4 extends JFrame{
	JButton an1,an2,an3,an4,an5,an6,an7;
	public static void main(String[] args){
		L5_4 aa=new L5_4();
	}
	public L5_4(){
		an1=new JButton("白茶");
		an2=new JButton("白菜");
		an3=new JButton("罗卜");
		an4=new JButton("大豆");
		an5=new JButton("青菜");
		an6=new JButton("青菜");
		an7=new JButton("青菜");
		this.setLayout(new FlowLayout());//因为默认的是边界布局，所以用其他布局管理时要先调用,默认是中间对齐
		//this.setLayout(new FlowLayout(FlowLayout.CENTER));//创建组件向右对齐的流式布局
		this.add(an1);
		this.add(an2);
		this.add(an3);
		this.add(an4);
		this.add(an5);
		this.add(an6);
		this.add(an7);
		this.setTitle("流式布局管理器");
		this.setSize(500,300);
		this.setResizable(false);//不能调整大小
		this.setLocation(150,150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
