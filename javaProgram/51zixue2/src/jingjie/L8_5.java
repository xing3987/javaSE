//�¼����������ڵļ���

package jingjie;
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
public class L8_5 extends JFrame{
	MyPanel5 mp5;
	public static void main(String[] args){
		L8_5 aa=new L8_5();
	}
	public L8_5(){
		mp5=new MyPanel5();
		this.add(mp5);
		mp5.setBackground(Color.blue);
		this.addWindowListener(mp5);

		this.setSize(200,200);
		this.setLocation(100,100);
		this.setDefaultCloseOperation(3);
		this.setVisible(true);
	}


}

class MyPanel5 extends JPanel implements WindowListener{

	public void paint(Graphics g){
		super.paint(g);		
	}

	
	public void windowActivated(WindowEvent e) {
		
		System.out.println("���ڱ�����");
	}

	
	public void windowClosed(WindowEvent e) {

		
	}

	
	public void windowClosing(WindowEvent e) {
		
		System.out.println("���ڹر�");
	}

	
	public void windowDeactivated(WindowEvent e) {
		
		
	}

	
	public void windowDeiconified(WindowEvent e) {
		
		System.out.println("��С����ԭ");
	}


	public void windowIconified(WindowEvent e) {
		System.out.println("������С��");
		
	}

	
	public void windowOpened(WindowEvent arg0) {
		
		
	}


}