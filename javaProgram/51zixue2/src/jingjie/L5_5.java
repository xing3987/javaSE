//网格布局管理器的创建和使用

package jingjie;
import java.awt.*;
import javax.swing.*;
public class L5_5 extends JFrame{
	JButton[] an={null,null,null,null,null,null,null};
	public static void main(String[] args){
		L5_5 aa=new L5_5();
	}
	public L5_5(){
		an[0]=new JButton("白茶");
		an[1]=new JButton("白菜");
		an[2]=new JButton("罗卜");
		an[3]=new JButton("大豆");
		an[4]=new JButton("青菜");
		an[5]=new JButton("青菜");
		an[6]=new JButton("青菜");
		this.setLayout(new GridLayout(3,3,10,10));//调用网格布局管理器，3*3的网格,相隔10*10的像素
		for(int i=0;i<an.length;i++){
			this.add(an[i]);
		}
		this.setTitle("流式布局管理器");
		this.setSize(400,400);
	//	this.setResizable(false);//不能调整大小
		this.setLocation(150,150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}