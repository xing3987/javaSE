//事件监听，鼠标的监听

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
		this.addMouseListener(mp4);//添加要鼠标监听的东西
		this.addMouseMotionListener(mp4);//添加要鼠标移动监听的对象

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

	public void mouseClicked(MouseEvent e) {//鼠标点击
		System.out.println("点击位置为：");
		System.out.println("横坐标"+e.getX());
		System.out.println("纵坐标"+e.getY());
		
	}
	
	public void mouseEntered(MouseEvent e) {//鼠标进入
		System.out.println("鼠标进入了");
			}
	
	public void mouseExited(MouseEvent e) {//鼠标移出
		System.out.println("鼠标移出了");
		
	}
	
	public void mousePressed(MouseEvent e) {//鼠标按下
		
		
	}
	
	public void mouseReleased(MouseEvent e) {//鼠标弹起
		
		
	}

	
	public void mouseDragged(MouseEvent e) {//鼠标拖拽
		System.out.println("动了动了");
		
	}

	
	public void mouseMoved(MouseEvent e) {//鼠标在对象中移动
		System.out.println("鼠标当前位置为：");
		System.out.println("横坐标"+e.getX());
		System.out.println("纵坐标"+e.getY());
		
	}
}