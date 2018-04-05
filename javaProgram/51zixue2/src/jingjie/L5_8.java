//单选框和复选框

package jingjie;
import java.awt.*;
import javax.swing.*;
public class L5_8 extends JFrame{
	JButton an1,an2;
	JPanel bn1,bn2,bn3;
	JLabel cn1,cn2;
	JCheckBox dn1,dn2,dn3;//定义复选框
	JRadioButton en1,en2;//定义单选框
	ButtonGroup ee;//定义单选框的组，这个组和单选框是同步的
	public static void main(String[] args){
		L5_8 aa=new L5_8();
	}
	public L5_8(){
		an1=new JButton("注册");an2=new JButton("取消");
		bn1=new JPanel();bn2=new JPanel();bn3=new JPanel();
		cn1=new JLabel("特长");cn2=new JLabel("性别");
		dn1=new JCheckBox("音乐");dn2=new JCheckBox("体育");dn3=new JCheckBox("文艺");
		en1=new JRadioButton("男");en2=new JRadioButton("女");
		ee=new ButtonGroup();ee.add(en1);ee.add(en2);//把两个单选框放入组中，那么这两个单选框就具备了单选的特性		
		bn1.add(cn1);bn1.add(dn1);bn1.add(dn2);bn1.add(dn3);
		bn2.add(cn2);bn2.add(en1);bn2.add(en2);
		bn3.add(an1);bn3.add(an2);
		this.setLayout(new GridLayout(3,1));
		this.add(bn1);this.add(bn2);this.add(bn3);
		this.setTitle("用户登陆");
		this.setSize(290,160);
		this.setResizable(false);
		this.setLocation(550,250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}