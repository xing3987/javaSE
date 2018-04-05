//布局管理器的综合应用

package jingjie;
import java.awt.*;
import javax.swing.*;
public class L5_6 extends JFrame{
	JButton an1,an2,an3,an4,an5;
	JPanel bn1,bn2;//面板组件默认是流式布局
	public static void main(String[] args){
		L5_6 aa=new L5_6();
	}
	public L5_6(){
		an1=new JButton("罗卜");//先定义各组件的属性
		an2=new JButton("大豆");
		an3=new JButton("隧道");
		an4=new JButton("屠夫");
		an5=new JButton("懂不");
		bn1=new JPanel();//然后定义各个面板属性
		bn2=new JPanel();
		bn1.add(an1);bn1.add(an2);//然后把组件添加到各子的板块上
		bn2.add(an3);bn2.add(an4);
		this.add(bn1,BorderLayout.NORTH);//把各个板块加入到界面中去
		this.add(bn2,BorderLayout.SOUTH);
		this.add(an5);//默认添加到中间
		this.setTitle("综合管理器");
		this.setSize(300,300);
		this.setLocation(150,150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}