//实例坦克大战

package jingjie;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class L9_1 extends JFrame implements ActionListener{
	JMenuBar mb1;
	JMenu mn1;
	JMenuItem mi1,mi2,mi3,mi4;
	MyPanel91 pn1;KsPanel kspanel;
	public static void main(String[] args) {
		L9_1 aa=new L9_1();
	}
	public L9_1(){
		//	pn1=new MyPanel91();
		//	pn1.setSize(500,500);
		//	this.addKeyListener(pn1);
		//	Thread mp91=new Thread(pn1);
		//	mp91.start();
		//	this.add(pn1);
		kspanel=new KsPanel();
		kspanel.setSize(500,500);
		Thread ksp=new Thread(kspanel);
		ksp.start();

		mb1=new JMenuBar();
		mn1=new JMenu("游戏(G)");mn1.setMnemonic('G');
		mi1=new JMenuItem("新游戏(N)");mi1.setMnemonic('N');
		mi1.addActionListener(this);mi1.setActionCommand("new");
		mi2=new JMenuItem("退出游戏(O)");mi2.setMnemonic('O');
		mi2.addActionListener(this);mi2.setActionCommand("out");
		mi3=new JMenuItem("存盘退出(S)");mi3.setMnemonic('S');
		mi3.addActionListener(this);mi3.setActionCommand("save");
		mi4=new JMenuItem("继续游戏(C)");mi4.setMnemonic('C');
		mi4.addActionListener(this);mi4.setActionCommand("continue");

		mn1.add(mi1);mn1.add(mi2);mn1.add(mi3);mn1.add(mi4);mb1.add(mn1);
		this.setJMenuBar(mb1);
		this.add(kspanel);
		this.setSize(700, 553);
		this.setLocation(200,100);
		this.setTitle("坦克大战");
		this.setIconImage(new ImageIcon("image/tank.jpg").getImage());
		//this.setResizable(false);
		this.setDefaultCloseOperation(3);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {//按键监听控制
		if(e.getActionCommand().equals("new")){
			this.remove(kspanel);
			if(pn1!=null){
				this.remove(pn1);
			}
			pn1=new MyPanel91();
			pn1.setSize(700,553);
			this.addKeyListener(pn1);
			Thread mp91=new Thread(pn1);
			mp91.start();
			this.add(pn1);
		}else if(e.getActionCommand().equals("out")){
			System.exit(0);
		}else if(e.getActionCommand().equals("save")){
			Jilu.cptc();
			System.exit(0);

		}else if(e.getActionCommand().equals("continue")){
			this.remove(kspanel);
			if(pn1!=null){
				this.remove(pn1);
			}
			pn1=new MyPanel91();
			pn1.mytank=Jilu.mtjl.get(0);
			pn1.setSize(700,553);
			this.addKeyListener(pn1);
			Thread mp91=new Thread(pn1);
			mp91.start();
			Jilu.jxyx();
			this.add(pn1);
		}

	}
}
class KsPanel extends JPanel implements Runnable{
	int time=0;
	public KsPanel(){

	}
	public void paint(Graphics g){
		super.paint(g);
		g.fillRect(0, 0, 500, 500);
		if(time%2==0){
			g.setColor(Color.yellow);
			g.setFont(new Font("华文行楷",Font.BOLD,38));
			g.drawString("第一关", 180, 240);
		}
	}

	public void run() {
		while(true){
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
			}
			this.repaint();
			time++;
		}

	}

}

class MyPanel91 extends JPanel implements KeyListener,Runnable{

	MyTank mytank=null;
	Vector<DiTank>  ditank=new Vector<DiTank>();//创建不知道具体数量的数组时用集合类，因为是多线程的所以用Vector,单线程(不联网，单控制玩家)可用ArrayList
	Vector<Baoza> baoza=new Vector<Baoza>();
	int number=3;
	int numberdt=20;
	int numbermt=3;
	Image tp1,tp2,tp3;
	public MyPanel91(){
		
		mytank=new MyTank(150,430);
		Jilu.mtjl.add(mytank);
		tp1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bzxg1.gif"));
		tp2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bzxg2.gif"));
		tp3=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bzxg3.gif"));
		Music ms=new Music("image/tank.wav");
		ms.start();
	}
	public void paint(Graphics g){
		if(ditank.size()==0){
			for(int i=0;i<number;i++){
				DiTank dt=new DiTank(231*i+1,0);
				Thread t=new Thread(dt);
				t.start();
				ditank.add(dt);
				Jilu.dtkjl.add(dt);
			}
		}
		g.setColor(Color.white);
		g.fillRect(0, 0, 700, 563);
		g.setColor(Color.black);
		g.fillRect(0, 0,500,500);
		if(mytank.life==true){
			this.drawTank(mytank.getX(), mytank.getY(), g, 0, mytank.forward);
		}
		for(int i=0;i<ditank.size();i++){
			DiTank dt=ditank.get(i);
			if(dt.life){
				this.drawTank(dt.getX(), dt.getY(), g, 1, dt.getForward());
			}else if(dt.life==false){
				Baoza bz=new Baoza(dt.getX(),dt.getY());
				baoza.add(bz);
				ditank.remove(dt);
				Jilu.dtkjl.remove(i);
			}
		}

		if(baoza.size()>0){
			for(int i=0;i<baoza.size();i++){
				Baoza bz=baoza.get(i);
				if(bz.life){
					if(bz.time>=6){
						g.drawImage(tp1, bz.x, bz.y,20, 30,this);
					}else if(bz.time>=3){
						g.drawImage(tp2, bz.x, bz.y,20, 30,this);
					}else if(bz.time>=0){
						g.drawImage(tp3, bz.x, bz.y,20, 30,this);
					}
					bz.qidong();
				}else if(bz.life==false){
					baoza.remove(bz);
				}
			}

		}
		for(int i=0;i<mytank.aa.size();i++){

			Zidan zd=mytank.aa.get(i);
			if(zd!=null&&zd.life==true){
				g.setColor(Color.white);
				g.fill3DRect(zd.getX(), zd.getY(), 3, 3, false);			
			}else if(zd.life==false){
				mytank.aa.remove(zd);
			}
		}
		for(int i=0;i<ditank.size();i++){
			DiTank dt=ditank.get(i);
			for(int j=0;j<dt.bb.size();j++){
				Zidan zd=dt.bb.get(j);
				if(zd!=null&&zd.life==true){
					g.setColor(Color.white);
					g.fill3DRect(zd.getX(), zd.getY(), 3, 3, false);			
				}else if(zd.life==false){
					dt.bb.remove(zd);
				}
			}
		}
		g.setFont(new Font("华文云彩",Font.BOLD,15));
		g.setColor(Color.black);
		g.drawString("你消灭的坦克数", 520, 440);
		g.drawString(Jilu.getRecord()+"", 650, 440);
		g.drawString(numberdt+"", 560, 80);
		g.drawString(numbermt+"", 560, 40);
		this.drawTank(520, 20, g, 0, 0);
		this.drawTank(520, 60, g, 1, 0);

	}


	public void drawTank(int x,int y,Graphics g,int style,int forward){
		switch(style){
		case 0:
			g.setColor(Color.yellow);
			break;
		case 1:
			g.setColor(Color.green);
			break;		
		case 2:
			g.setColor(Color.pink);
			break;
		case 3:
			g.setColor(Color.cyan);
			break;
		case 4:
			g.setColor(Color.BLUE);
			break;
		}
		switch(forward){
		case 0:
			g.fill3DRect(x, y, 5, 30,false);
			g.fill3DRect(x+5, y+5, 10, 20,false);
			g.fill3DRect(x+15, y, 5, 30, false);
			g.fillOval(x+5, y+10, 10, 10);
			g.drawLine(x+10, y-5, x+10, y+15);
			break;
		case 1:
			g.fill3DRect(x, y, 5, 30,false);
			g.fill3DRect(x+5, y+5, 10, 20,false);
			g.fill3DRect(x+15, y, 5, 30, false);
			g.fillOval(x+5, y+10, 10, 10);
			g.drawLine(x+10, y+15, x+10, y+35);
			break;
		case 2:
			g.fill3DRect(x, y, 30, 5,false);
			g.fill3DRect(x+5, y+5, 20, 10,false);
			g.fill3DRect(x, y+15, 30, 5, false);
			g.fillOval(x+10, y+5, 10, 10);
			g.drawLine(x-5, y+10, x+15, y+10);
			break;
		case 3:
			g.fill3DRect(x, y, 30, 5,false);
			g.fill3DRect(x+5, y+5, 20, 10,false);
			g.fill3DRect(x, y+15, 30, 5, false);
			g.fillOval(x+10, y+5, 10, 10);
			g.drawLine(x+15, y+10, x+35, y+10);
			break;
		}
	}

	public void keyPressed(KeyEvent e) {

		if(e.getKeyCode()==KeyEvent.VK_W){
			mytank.up();
			mytank.forward=0;
		}else if(e.getKeyCode()==KeyEvent.VK_S){
			mytank.down();
			mytank.forward=1;
		}else if(e.getKeyCode()==KeyEvent.VK_A){
			mytank.left();
			mytank.forward=2;
		}else if(e.getKeyCode()==KeyEvent.VK_D){
			mytank.right();
			mytank.forward=3;
		}

		if((e.getKeyCode()==KeyEvent.VK_J)&&mytank.aa.size()<8){

			this.mytank.shot();
		}
		this.repaint();

	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {	
	}

	public void run() {//线程实时监控
		while(true){
			try{
				Thread.sleep(100);
			}catch(Exception e){
			}
			for(int i=0;i<mytank.aa.size();i++){
				Zidan zd=mytank.aa.get(i);
				for(int j=0;j<ditank.size();j++){
					DiTank dt=ditank.get(j);
					this.jizhong(zd,dt);



				}

			}

			for(int i=0;i<ditank.size();i++){
				DiTank dk=ditank.get(i);
				for(int j=0;j<dk.bb.size();j++){
					Zidan zd1=dk.bb.get(j);
					this.bejizhong(zd1,mytank);

				}

			}
			this.repaint();
			if(numbermt==0){

				try{
					Thread.sleep(9999999);
				}catch(Exception e){

				}
			}
		}

	}

	public void jizhong(Zidan zd,Tank ditank){
		switch(ditank.getForward()){
		case 0:
		case 1:
			if((zd.getX()>ditank.getX())&&(zd.getX()<(ditank.getX()+20))&&zd.getY()>ditank.getY()&&(zd.getY()<(ditank.getY()+30))){
				zd.life=false;
				ditank.life=false;
				numberdt--;
				Jilu.jilu();
			}

			break;
		case 2:
		case 3:
			if((zd.getX()>ditank.getX())&&(zd.getX()<(ditank.getX()+30))&&zd.getY()>ditank.getY()&&(zd.getY()<(ditank.getY()+20))){
				zd.life=false;
				ditank.life=false;
				numberdt--;
				Jilu.jilu();
			}
			break;
		}
	}
	public void bejizhong(Zidan zd,Tank tank){
		switch(tank.getForward()){
		case 0:
		case 1:
			if((zd.getX()>tank.getX())&&(zd.getX()<(tank.getX()+20))&&zd.getY()>tank.getY()&&(zd.getY()<(tank.getY()+30))){
				zd.life=false;
				tank.life=false;
				numbermt--;
				Jilu.mtjl.remove(0);
				if(numbermt>0){
					mytank=new MyTank(150,430);
					Jilu.mtjl.add(mytank);
				}
			}

			break;
		case 2:
		case 3:
			if((zd.getX()>tank.getX())&&(zd.getX()<(tank.getX()+30))&&zd.getY()>tank.getY()&&(zd.getY()<(tank.getY()+20))){
				zd.life=false;
				tank.life=false;
				numbermt--;
				Jilu.mtjl.remove(0);
				if(numbermt>0){
					mytank=new MyTank(150,430);
					Jilu.mtjl.add(mytank);
				}
			}
			break;
		}
	}
}

class Jilu{
	private static int record=0;
	private static FileWriter fw;
	private static BufferedWriter bw;
	private static FileReader fr;
	private static BufferedReader br;
	static Vector<DiTank> dtkjl=new Vector<DiTank>();
	static Vector<MyTank> mtjl=new Vector<MyTank>();

	public static void cptc(){
		try {
			fw =new FileWriter("D:/java/51zixue2/src/jingjie/L9_1.txt");
			bw=new BufferedWriter(fw);
			bw.write(record+"\r\n");
			
			String mtDate=mtjl.get(0).x+" "+mtjl.get(0).y+" "+mtjl.get(0).forward;
			bw.write(mtDate+"\r\n");
			
			
			for(int i=0;i<dtkjl.size();i++){
				DiTank dt=dtkjl.get(i);
				String dtkDate=dt.x+" "+dt.y+" "+dt.getForward();
				bw.write(dtkDate+"\r\n");
			}

			bw.flush();
		} catch (IOException e) {
		}finally{
			try{
				fw.close();
				bw.close();
			}catch(Exception e1){}
		}
	}
	public static void jxyx(){
		try {
			fr =new FileReader("D:/java/51zixue2/src/jingjie/L9_1.txt");
			br=new BufferedReader(fr);
			String s=br.readLine();
			record=Integer.parseInt(s);
			String[] sz=null;
			s=br.readLine();
			sz=s.split(" ");
			mtjl.get(0).x=Integer.parseInt(sz[0]);mtjl.get(0).y=Integer.parseInt(sz[1]);
			mtjl.get(0).forward=Integer.parseInt(sz[2]);
			while((s=br.readLine())!=null){
				sz=s.split(" ");
			}
			
			for(int i=0;i<dtkjl.size();i++){
				
			}
		} catch (IOException e) {
		}finally{
			try{
				fr.close();
				br.close();
			}catch(Exception e1){}
		}
	}


	public static int getRecord() {
		return record;
	}

	public static void setRecord(int record) {
		Jilu.record = record;
	}

	public static void jilu(){
		record++;
	}
}