//GUI综合应用----复杂记事本

package jingjie;
import java.awt.*;
//import java.awt.event.*;

import javax.swing.*;
public class L5_13 extends JFrame{
	JMenuBar mb1;JMenu mn1,mn2,mn3,mn4,mn5;//菜单栏和菜单选项
	JMenuItem mi1,mi2,mi3,mi4,mi5,mi6;//最终极的菜单选项
	JMenu mn6;JMenuItem mi7,mi8;
	
	JToolBar tb1;JButton bt1,bt2,bt3,bt4,bt5,bt6;//工具条
	JTextArea ta1;JScrollPane sp1;
	
	
	public static void main(String[] args){
		L5_13 aa=new L5_13();
	}
	public L5_13(){
		mb1=new JMenuBar();//设置菜单栏
		mn1=new JMenu("文件(F)");mn1.setMnemonic('F');//设置快捷键
		mn2=new JMenu("编辑(E)");mn2.setMnemonic('E');
		mn3=new JMenu("格式(O)");mn3.setMnemonic('O');
		mn4=new JMenu("查看(V)");mn4.setMnemonic('V');
		mn5=new JMenu("帮助(H)");mn5.setMnemonic('H');
		
		mn6=new JMenu("新建");
		mi7=new JMenuItem("文件",new ImageIcon("image/jsb.jpg"));//设置二级菜单和添加菜单图标
		mi8=new JMenuItem("模版",new ImageIcon("image/mb.jpg"));
		mi1=new JMenuItem("打开");mi2=new JMenuItem("保存");mi3=new JMenuItem("另存为");
		mi4=new JMenuItem("页面设置");mi5=new JMenuItem("打印");mi6=new JMenuItem("退出");
		
		tb1=new JToolBar();//设置工具条以及鼠标移动到按钮时的默认注释
		bt1=new JButton(new ImageIcon("image/xj.jpg"));bt1.setToolTipText("新建");
		bt2=new JButton(new ImageIcon("image/dk.jpg"));bt2.setToolTipText("打开");
		bt3=new JButton(new ImageIcon("image/bc.jpg"));bt3.setToolTipText("保存");
		bt4=new JButton(new ImageIcon("image/fz.jpg"));bt4.setToolTipText("复制");
		bt5=new JButton(new ImageIcon("image/jq.jpg"));bt5.setToolTipText("剪切");
		bt6=new JButton(new ImageIcon("image/zt.jpg"));bt6.setToolTipText("粘贴");
		
		ta1=new JTextArea();sp1=new JScrollPane(ta1);
		
		mn6.add(mi7);mn6.add(mi8);
		mn1.add(mn6);mn1.add(mi1);mn1.add(mi2);mn1.add(mi3);
		mn1.addSeparator();//增加一条分隔线
		mn1.add(mi4);mn1.add(mi5);
		mn1.addSeparator();//增加一条分隔线
		mn1.add(mi6);
		
		mb1.add(mn1);mb1.add(mn2);mb1.add(mn3);mb1.add(mn4);mb1.add(mn5);
		tb1.add(bt1);tb1.add(bt2);tb1.add(bt3);tb1.add(bt4);tb1.add(bt5);tb1.add(bt6);
		
		this.setJMenuBar(mb1);//添加菜单栏
		;this.add(tb1,BorderLayout.NORTH);this.add(sp1);
		
		this.setTitle("记事本");
		this.setIconImage((new ImageIcon("image/jsb.jpg")).getImage());//标题栏改变图标
		this.setSize(330,280);
		//this.setResizable(false);
		this.setLocation(350,150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}