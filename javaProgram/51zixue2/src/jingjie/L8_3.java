//�¼����������̵ļ���

package jingjie;
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
public class L8_3 extends JFrame{
	MyPanel3 mp3;
	public static void main(String[] args){
		L8_3 aa=new L8_3();
	}
	public L8_3(){
		mp3=new MyPanel3();
		this.add(mp3);
		mp3.setBackground(Color.red);
		this.addKeyListener(mp3);//���Ҫ�����Ķ���

		this.setSize(200,200);
		this.setLocation(100,100);
		this.setDefaultCloseOperation(3);
		this.setVisible(true);
	}


}

class MyPanel3 extends JPanel implements KeyListener{
	int x=20,y=20;
	public void paint(Graphics g){
		super.paint(g);		
		g.fill3DRect(x, y, 40, 40,true);
	}
	public void keyPressed(KeyEvent e) {//���ⰴ������������
		System.out.println("���̱�����"+(char)e.getKeyCode());//ȡ�ð��µİ�����Ϣ

		if(e.getKeyCode()==KeyEvent.VK_UP){
			System.out.println("��");
			if(y>0){
				y-=5;
			}else{
				System.out.println("��ͷ��");
			}
		}else if(e.getKeyCode()==KeyEvent.VK_DOWN){
			System.out.println("��");
			if(y<125){
				y+=5;
			}else{
				System.out.println("��ͷ��");
			}
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT){
			System.out.println("��");
			x-=5;
		}else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			System.out.println("��");
			x+=5;
		}
		this.repaint();//���¹�ͼ

	}

	public void keyReleased(KeyEvent e) {//���̰���̧�������

	}

	public void keyTyped(KeyEvent e) {//��ĸ�������ְ���������

	}
}