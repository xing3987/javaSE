//下拉框和下拉列表

package jingjie;
import java.awt.*;
import javax.swing.*;
public class L5_9 extends JFrame{
	JPanel bn1,bn2;
	JLabel cn1,cn2;
	JComboBox dn1;//设置下拉框
	JList en1;//设置下拉列表
	JScrollPane fn1;//和下拉列表伴生的滚动条
	public static void main(String[] args){
		L5_9 aa=new L5_9();
	}
	public L5_9(){
		cn1=new JLabel("籍贯");cn2=new JLabel("学历");
		
		String[] dn={"苏州","北京","上海","南京","外星"};
		dn1=new JComboBox(dn);//建立下拉框，框中内容为先前定义的字符组
		
		String[] en={"高中","大专","本科","硕士","博士"};
		en1=new JList(en);//建立列表，框中内容为定于的字符组
		en1.setVisibleRowCount(3);//设置列表可见数量
		fn1=new JScrollPane(en1);//建立滚动条，以列表为基准建立的
		
		bn1=new JPanel();bn2=new JPanel();
		bn1.add(cn1);bn1.add(dn1);
		bn2.add(cn2);bn2.add(fn1);	//注意这里添加的是列表滚动的组件，该组件包含了列表，千万不要只添加列表本身
		this.setLayout(new GridLayout(2,1));
		this.add(bn1);this.add(bn2);
		this.setTitle("用户调查");
		this.setSize(250,170);
		this.setResizable(false);
		this.setLocation(550,250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}