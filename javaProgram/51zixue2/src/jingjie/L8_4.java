//�¼����������ļ���

package jingjie;
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
public class L8_4 extends JFrame{
	MyPanel4 mp4;
	public static void main(String[] args){
		L8_4 aa=new L8_4();
	}
	public L8_4(){
		mp4=new MyPanel4();
		this.add(mp4);
		mp4.setBackground(Color.red);
		this.addMouseListener(mp4);//���Ҫ�������Ķ���
		this.addMouseMotionListener(mp4);//���Ҫ����ƶ������Ķ���

		this.setSize(200,200);
		this.setLocation(100,100);
		this.setDefaultCloseOperation(3);
		this.setVisible(true);
	}


}

class MyPanel4 extends JPanel implements MouseListener,MouseMotionListener{

	public void paint(Graphics g){
		super.paint(g);		
	}

	public void mouseClicked(MouseEvent e) {//�����
		System.out.println("���λ��Ϊ��");
		System.out.println("������"+e.getX());
		System.out.println("������"+e.getY());
		
	}
	
	public void mouseEntered(MouseEvent e) {//������
		System.out.println("��������");
			}
	
	public void mouseExited(MouseEvent e) {//����Ƴ�
		System.out.println("����Ƴ���");
		
	}
	
	public void mousePressed(MouseEvent e) {//��갴��
		
		
	}
	
	public void mouseReleased(MouseEvent e) {//��굯��
		
		
	}

	
	public void mouseDragged(MouseEvent e) {//�����ק
		System.out.println("���˶���");
		
	}

	
	public void mouseMoved(MouseEvent e) {//����ڶ������ƶ�
		System.out.println("��굱ǰλ��Ϊ��");
		System.out.println("������"+e.getX());
		System.out.println("������"+e.getY());
		
	}
}