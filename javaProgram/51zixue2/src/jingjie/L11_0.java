//��������ѧϰ��ʹ��

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
		timer=new Timer(100,this);//����ʱ���̣߳�this����ʵ��ActionListener�ӿڣ�100��ʾÿ��100ms����һ��
		bt1=new JButton("����");bt1.addActionListener(this);
		pn1=new JPanel();
		pb1=new JProgressBar();
		pb1.setOrientation(pb1.HORIZONTAL);//���ý������ķ������Ϊˮƽ���ߴ�ֱ
		pb1.setMaximum(100);pb1.setMinimum(0);//�������ֵ��Сֵ
		pb1.setValue(0);//���õ�ǰֵ
		pb1.setStringPainted(true);//�����Ƿ���ʾ�����ַ���
		pb1.addChangeListener(this);
		pb1.setPreferredSize(new Dimension(100,20));//���ý������Ŀ�ߣ������borderlayout�Զ�������preferredsize��
		pb1.setBorderPainted(true);
		pb1.setBackground(Color.pink);
		lb1=new JLabel("������а�ť��ʼ��",lb1.CENTER);
		
		pn1.add(bt1);
		this.add(pn1,BorderLayout.NORTH );
		this.add(lb1,BorderLayout.CENTER);
		this.add(pb1,BorderLayout.SOUTH);
		
		this.setBounds(100,100,400,130);
		this.setTitle("������ʹ��");
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
		this.setResizable(false);
	}
	
	
	public void stateChanged(ChangeEvent e) {
		int values=pb1.getValue();
		lb1.setText("Ŀǰ��ɽ���"+values+"%");
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
