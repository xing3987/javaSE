//GUI综合应用----聊天窗口

package jingjie;
import java.awt.*;
import javax.swing.*;
public class L5_11 extends JFrame{
	JPanel pn1;
	JButton bn1;
	JComboBox cb1;
	JTextField tf1;
	JTextArea ta1;
	JScrollPane sp1;
	public static void main(String[] args){
		L5_11 aa=new L5_11();
	}
	public L5_11(){
		String[] z={"猫猫","狗狗","兔兔","猪猪","驴儿"};
		cb1=new JComboBox(z);
		ta1=new JTextArea();
		sp1=new JScrollPane(ta1);
		bn1=new JButton("发送");
		tf1=new JTextField(10);
		pn1=new JPanel();pn1.add(cb1);pn1.add(tf1);pn1.add(bn1);
		this.add(sp1);
		this.add(pn1,BorderLayout.SOUTH);

		this.setTitle("聊天窗口");
		this.setIconImage((new ImageIcon("image/qq.jpg")).getImage());//标题栏改变图标
		this.setSize(280,180);
		this.setResizable(false);
		this.setLocation(350,150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}