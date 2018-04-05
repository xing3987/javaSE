//进度条的学习和使用

package jingjie;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.*;
public class L11_0 extends JFrame implements ChangeListener, ActionListener{
	JButton bt1;JLabel lb1;JProgressBar pb1;Timer timer;JPanel pn1;
	public static void main(String[] args){
		L11_0 L11=new L11_0();
	}
	public L11_0(){
		timer=new Timer(100,this);//创建时间线程，this必须实现ActionListener接口，100表示每隔100ms计算一下
		bt1=new JButton("运行");bt1.addActionListener(this);
		pn1=new JPanel();
		pb1=new JProgressBar();
		pb1.setOrientation(pb1.HORIZONTAL);//设置进度条的方向必须为水平或者垂直
		pb1.setMaximum(100);pb1.setMinimum(0);//设置最大值最小值
		pb1.setValue(0);//设置当前值
		pb1.setStringPainted(true);//设置是否显示进度字符串
		pb1.addChangeListener(this);
		pb1.setPreferredSize(new Dimension(100,20));//设置进度条的宽高，宽会随borderlayout自动调整（preferredsize）
		pb1.setBorderPainted(true);
		pb1.setBackground(Color.pink);
		lb1=new JLabel("点击运行按钮开始：",lb1.CENTER);
		
		pn1.add(bt1);
		this.add(pn1,BorderLayout.NORTH );
		this.add(lb1,BorderLayout.CENTER);
		this.add(pb1,BorderLayout.SOUTH);
		
		this.setBounds(100,100,400,130);
		this.setTitle("进度条使用");
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
		this.setResizable(false);
	}
	
	
	public void stateChanged(ChangeEvent e) {
		int values=pb1.getValue();
		lb1.setText("目前完成进度"+values+"%");
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt1){
			timer.start();
		}
		if(e.getSource()==timer){
			int values=pb1.getValue();
			if(values<100){
				pb1.setValue(++values);
			}else{
				timer.stop();
				this.dispose();
			}
		}
		
	}
}
