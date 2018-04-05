//事件监听，键盘的监听

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
		this.addKeyListener(mp3);//添加要监听的东西

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
	public void keyPressed(KeyEvent e) {//任意按键按下起作用
		System.out.println("键盘被按下"+(char)e.getKeyCode());//取得按下的按键信息

		if(e.getKeyCode()==KeyEvent.VK_UP){
			System.out.println("上");
			if(y>0){
				y-=5;
			}else{
				System.out.println("到头了");
			}
		}else if(e.getKeyCode()==KeyEvent.VK_DOWN){
			System.out.println("下");
			if(y<125){
				y+=5;
			}else{
				System.out.println("到头了");
			}
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT){
			System.out.println("左");
			x-=5;
		}else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			System.out.println("右");
			x+=5;
		}
		this.repaint();//重新构图

	}

	public void keyReleased(KeyEvent e) {//键盘按键抬起的作用

	}

	public void keyTyped(KeyEvent e) {//字母或者数字按下起作用

	}
}