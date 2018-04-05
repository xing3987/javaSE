//添加图片和使用可拆分的面板

package jingjie;
import java.awt.*;
import javax.swing.*;
public class L5_10 extends JFrame{
	JPanel dn1;JButton dn2,dn3;
	JSplitPane an1;//添加一个拆分的面板
	JLabel bn1;
	JList cn1;
	public static void main(String[] args){
		L5_10 aa=new L5_10();
	}
	public L5_10(){
		String[] z={"软件开发","游戏开发","平面设计","动画制作","室内设计"};
		cn1=new JList(z);
		bn1=new JLabel(new ImageIcon("image/1.jpg"));//添加图片，注意图片格式括号引号/号和文件夹位置
		an1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,cn1,bn1);//创建可拆分的面板，为左右拆分，左边cn1，右边bn1
		an1.setOneTouchExpandable(true);
		
		dn2=new JButton("上一页");dn3=new JButton("下一页");
		dn1=new JPanel();
		dn1.add(dn2);dn1.add(dn3);
		
		this.add(an1);//添加拆分面板到BorderLayout中默认为中间向四周填充
		this.add(dn1,BorderLayout.NORTH);//北部添加按钮面板
		this.setTitle("用户调查");
		this.setSize(680,380);
		this.setResizable(false);
		this.setLocation(350,150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}