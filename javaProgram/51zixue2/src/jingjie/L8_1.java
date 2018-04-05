//绘制图形

package jingjie;
import java.awt.*;

import javax.swing.*;
public class L8_1 extends JFrame{
	MyPanel mp=null;	
	MyPanel11 mp1=null;
	public static void main(String[] args){
		L8_1 aa=new L8_1();
	}
	public L8_1(){
		MyPanel mp=new MyPanel();
		MyPanel11 mp1=new MyPanel11();
		
		this.setLayout(new GridLayout(2,1));
		this.add(mp);
		this.add(mp1);
		this.setSize(400,400);
		this.setLocation(200,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

class MyPanel extends JPanel{//创建一个自定义的面板，该面板是JPanel面板的拓展
	public void paint(Graphics g){//调用JPannel里的制图方法（画笔G）
									//该方法有三种情况会被调用，1：程序创建时，激活窗口时      2：改变大小时（最大化拖动边框改变大小）3：运行repaint方法时
		System.out.println("方法被调用");//每次调用该方法打印标记
		g.drawOval(0, 0, 30, 30);//画圆工具（起始点横，起始点纵，横向大小，纵向大小）
		g.drawLine(40, 15, 70, 30);//划线工具（起始点横，起始点纵，结束点横，结束点纵）
		g.drawRect(100, 30, 30, 50);//矩形工具（起始点横，起始点纵，横向大小，纵向大小）
		g.draw3DRect(150, 30, 50, 50,true);////矩形工具（起始点横，起始点纵，横向大小，纵向大小,3D开关）
		g.setColor(Color.cyan);//设置画笔颜色为青色，之后的作图都是该颜色，不设置颜色默认为黑色
		g.fillRect(250, 30, 35, 40);//填充矩形工具（起始点横，起始点纵，横向大小，纵向大小）fill是填充物
		g.setColor(Color.pink);
		g.fillOval(40, 100, 50, 50);//填充圆工具
	}
}

class MyPanel11 extends JPanel{//创建一个自定义的面板，该面板是JPanel面板的拓展
	public void paint(Graphics g){
		Image tp=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/L8_1.jpg"));//创建并导入图片，该图片要考入到同一个文件夹src下
		g.drawImage(tp, 0,0,400,200, this);//画图工具(图片，起始横，起始纵，横向大小，纵向大小，存放位置)
		g.setColor(Color.red);
		g.setFont(new Font("黑体",Font.BOLD,50));//设置字体（“字体”，字体加粗，字号）
		g.drawString("大家好！！", 50, 50);//写字（“内容”,起始横，起始纵）
	}
	
}