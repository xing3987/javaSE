package jiemian;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Zhujiemian extends JWindow implements ActionListener{
	JLabel lb1;Timer timer;JProgressBar pb1;
	public static void main(String[] args){
		Zhujiemian xx=new Zhujiemian();
	}
	public Zhujiemian(){
		lb1=new JLabel(new ImageIcon("image/index.gif"));
		pb1=new JProgressBar();
		pb1.setMaximum(100);pb1.setMinimum(0);pb1.setValue(0);
		pb1.setStringPainted(true);
		pb1.setPreferredSize(new Dimension(100,20));
		pb1.setOrientation(pb1.HORIZONTAL);
		pb1.setBackground(Color.DARK_GRAY);
		pb1.setForeground(Color.pink);
		pb1.setVisible(true);

		this.add(pb1,BorderLayout.SOUTH);
		this.add(lb1);

		this.setVisible(true);
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;//�õ���Ļ�Ŀ��
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;//�õ���Ļ�ĸ߶�
		this.setBounds(width/3,height/5,400,260);

		timer=new Timer(200,this);
		timer.start();//timer���Զ�����ActionLister�����п���ִ�е����

	}
	public void actionPerformed(ActionEvent e) {
		int values=pb1.getValue();
//		if(e.getSource()==timer){
			if(values<100){
				pb1.setValue(++values);
			}else{
				timer.stop();//ʱ���߳�ֹͣ
				Denglu denglu=new Denglu();//����һ�����
				this.dispose();//�رյ�ǰҳ��
//			}
		}

	}

}
