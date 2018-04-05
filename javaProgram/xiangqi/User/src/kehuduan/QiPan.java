package kehuduan;
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
public class QiPan extends JPanel implements MouseListener{
	private int width;
	boolean focus=false;//是否选中
	int jiang1_i=4;//将的位置坐标
	int jiang1_j=0;
	int jiang2_i=4;
	int jiang2_j=9;
	QiZi[][] qiZi;
	int startI=-1;//棋子的开始位置
	int startJ=-1;
	int endI=-1;//棋子的终止位置
	int endJ=-1;
	XiangQi xiangQi;
	GuiZe guiZe;
	public QiPan(QiZi[][] qiZi,int width,XiangQi xiangQi){
		this.width=width;
		this.qiZi=qiZi;
		this.xiangQi=xiangQi;
		guiZe=new GuiZe(qiZi);
		this.addMouseListener(this);
		this.setBounds(0,0,700,700);
		this.setLayout(null);
	}

	public void paint(Graphics g1){
		Graphics2D g=(Graphics2D) g1;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);//打开抗锯齿
		g.setColor(xiangQi.bgColor);
		g.fill3DRect(60, 30, 580, 630,false);
		g.setColor(Color.black);
		for(int i=80;i<=620;i=i+60){//画横线
			g.drawLine(110, i, 590, i);
		}
		for(int i=110;i<=630;i=i+60){//画竖线
			g.drawLine(i, 80, i,320);
			g.drawLine(i, 380, i, 620);
		}
		g.drawLine(110, 320, 110, 380);
		g.drawLine(590,320,590,380);
		g.setFont(new Font("宋体",Font.ITALIC,30));
		g.drawString("楚   河", 130, 360);
		g.drawString("漢   界",450,360);
		this.smallLine(g,1,2);//绘制红炮所在位置的标志
		this.smallLine(g,7,2);//绘制红炮所在位置的标志
		this.smallLine(g,0,3);//绘制兵所在位置的标志
		this.smallLine(g,2,3);//绘制兵所在位置的标志
		this.smallLine(g,4,3);//绘制兵所在位置的标志
		this.smallLine(g,6,3);//绘制兵所在位置的标志
		this.smallLine(g,8,3);//绘制兵所在位置的标志
		this.smallLine(g,0,6);//绘制卒所在位置的标志
		this.smallLine(g,2,6);//绘制卒所在位置的标志
		this.smallLine(g,4,6);//绘制卒所在位置的标志
		this.smallLine(g,6,6);//绘制卒所在位置的标志
		this.smallLine(g,8,6);//绘制卒所在位置的标志
		this.smallLine(g,1,7);//绘制白炮所在位置的标志
		this.smallLine(g,7,7);//绘制白炮所在位置的标志
		g.setFont(new Font("宋体",Font.BOLD,30));
		for(int i=0;i<9;i++){
			for(int j=0;j<10;j++){
				if(qiZi[i][j]!=null){
					if(this.qiZi[i][j].isFocus()==true){
						g.setColor(XiangQi.focusbg);//选中后的背景色
						g.fillOval(110+i*60-25,80+j*60-25,50,50);//绘制该棋子
						g.setColor(XiangQi.focuschar);//字符的颜色
					}
					else{
						g.fillOval(110+i*60-25,80+j*60-25,50,50);//绘制该棋子
						g.setColor(qiZi[i][j].getColor());//设置画笔颜色
					}
					g.drawString(qiZi[i][j].getName(),110+i*60-15,80+j*60+10);
					g.setColor(Color.black);//设为黑色					
				}
			}
		}
	}

	public void smallLine(Graphics2D g,int i,int j){//把交点处传入（棋子位置）
		int x=110+60*i;//计算坐标
		int y=80+60*j;
		if(i>0){//绘制左上方，左下方的标志
			g.drawLine(x-3,y-3,x-20,y-3);g.drawLine(x-3,y-3,x-3,y-20);
			g.drawLine(x-3,y+3,x-20,y+3);g.drawLine(x-3,y+3,x-3,y+20);
		}
		if(i<8){//绘制右上方，右下方的标志
			g.drawLine(x+3,y-3,x+20,y-3);g.drawLine(x+3,y-3,x+3,y-20);
			g.drawLine(x+3,y+3,x+20,y+3);g.drawLine(x+3,y+3,x+3,y+20);
		}
	}

	public int[] getPos(MouseEvent e){
		int[] pos=new int[2];
		pos[0]=-1;
		pos[1]=-1;
		Point point=e.getPoint();
		double x=point.getX();
		double y=point.getY();
		//判断横坐标
		if(Math.abs((x-110)%60)<=25){
			pos[0]=(int) Math.round((x-110)/60);
		}else if(Math.abs((x-110)%60)>=35){
			pos[0]=(int) Math.round((x-110)/60);
		}
		//判断纵坐标
		if(Math.abs((y-80)%60)<=25){
			pos[1]=(int) Math.round((y-80)/60);
		}else if(Math.abs((y-80)%60)>=35){
			pos[1]=(int) Math.round((y-80)/60);
		}
		return pos;
	}


	public void mouseClicked(MouseEvent e) {
		if(this.xiangQi.caiPan==true){
			int i=-1,j=-1;
			int[] pos=getPos(e);
			i=pos[0];
			j=pos[1];
			if(i>=0&&i<=8&&j>=0&&j<=9){//如果鼠标点击点在棋盘范围内
				if(focus==false){//如果前面没有选中过棋子
					this.noFocus(i,j);
				}else{//如果以前选中过棋子
					if(qiZi[i][j]!=null){//如果该处有棋子
						if(qiZi[i][j].getColor().equals(qiZi[startI][startJ].getColor())){//如果是自己的棋子
							qiZi[startI][startJ].setFocus(false);
							qiZi[i][j].setFocus(true);
							startI=i;
							startJ=j;
						}else{//如果是敌方的棋子
							endI=i;
							endJ=j;
							String name=qiZi[startI][startJ].getName();
							boolean canMove=guiZe.canMove(startI, startJ, endI, endJ, name);
							if(canMove){
								try{//将该移动信息发送给对方
									this.xiangQi.cat.dos.writeUTF("<#MOVE#>"+
											this.xiangQi.cat.tiaoZhanZhe+startI+startJ+endI+endJ);
									this.xiangQi.caiPan=false;
									if(qiZi[endI][endJ].getName().equals("帅")||
											qiZi[endI][endJ].getName().equals("将"))
									{//如果终点处是对方的"将"
										this.success();
									}
									else{//如果终点不是对方的"将"
										this.noJiang();
									}
								}
								catch(Exception ee){ee.printStackTrace();}
							}

						}
					}else{//如果没有棋子
						endI=i;
						endJ=j;
						String name=qiZi[startI][startJ].getName();
						boolean canMove=guiZe.canMove(startI, startJ, endI, endJ, name);
						if(canMove){
							this.noQiZi();
						}
					}
				}
			}
			this.xiangQi.repaint();
		}
	}

	public void noFocus(int i,int j){
		if(qiZi[i][j]!=null){//该位置有棋子时才有反应
			if(this.xiangQi.color==0){//如果是红方
				if(this.qiZi[i][j].getColor().equals(xiangQi.color1)){//如果棋子也是红的
					this.qiZi[i][j].setFocus(true);
					this.focus=true;
					startI=i;
					startJ=j;
				}
			}else{//如果是白方
				if(this.qiZi[i][j].getColor().equals(xiangQi.color2)){
					this.qiZi[i][j].setFocus(true);
					this.focus=true;
					startI=i;
					startJ=j;
				}
			}

		}
	}

	public void noQiZi(){
		try{//将该移动信息发送给对方
			this.xiangQi.cat.dos.writeUTF("<#MOVE#>"+this.xiangQi.cat.tiaoZhanZhe+startI+startJ+endI+endJ);
			this.xiangQi.caiPan=false;
			qiZi[endI][endJ]=qiZi[startI][startJ];
			qiZi[startI][startJ]=null;//走棋
			qiZi[endI][endJ].setFocus(false);//将该棋设为非选中状态
			this.xiangQi.repaint();//重绘
			if(qiZi[endI][endJ].getName().equals("帅")){//如果移动的是"帥"
				jiang1_i=endI;//更新"帥"的位置坐标
				jiang1_j=endJ;
			}
			else if(qiZi[endI][endJ].getName().equals("将")){//如果移动的是"將"
				jiang2_i=endI;//更新"將"的位置坐标
				jiang2_j=endJ;
			}
			if(jiang1_i==jiang2_i)//如果"將"和"帥"在一条竖线上
			{
				int count=0;
				for(int jiang_j=jiang1_j+1;jiang_j<jiang2_j;jiang_j++){//遍历这条竖线
					if(qiZi[jiang1_i][jiang_j]!=null){
						count++;break;
					}
				}
				if(count==0){//如果等于零则照将
					JOptionPane.showMessageDialog(this.xiangQi,"照将！！！你失败了！！！","提示",
							JOptionPane.INFORMATION_MESSAGE);//给出失败信息
					this.xiangQi.cat.tiaoZhanZhe=null;
					this.xiangQi.color=0;//还原棋盘，进入下一盘
					this.xiangQi.caiPan=false;
					this.xiangQi.next();//进入下一盘
					this.xiangQi.jtfHost.setEnabled(false);
					this.xiangQi.jtfPort.setEnabled(false);
					this.xiangQi.jtfNickName.setEnabled(false);//设置各控件状态
					this.xiangQi.jbConnect.setEnabled(false);
					this.xiangQi.jbDisconnect.setEnabled(true);
					this.xiangQi.jbChallenge.setEnabled(true);
					this.xiangQi.jbYChallenge.setEnabled(false);
					this.xiangQi.jbNChallenge.setEnabled(false);
					this.xiangQi.jbFail.setEnabled(false);
					jiang1_i=4;//"帥"的i坐标
					jiang1_j=0;//"帥"的j坐标
					jiang2_i=4;//"將"的i坐标
					jiang2_j=9;//"將"的j坐标
				}
			}
			startI=-1;
			startJ=-1;//还原保存点
			endI=-1;
			endJ=-1;
			focus=false;
		}
		catch(Exception ee){ee.printStackTrace();}
	}

	public void move(int startI,int startJ,int endI,int endJ){
		if(qiZi[endI][endJ]!=null&&(qiZi[endI][endJ].getName().equals("帅")||
				qiZi[endI][endJ].getName().equals("将"))){//如果"将"被吃了
			qiZi[endI][endJ]=qiZi[startI][startJ];
			qiZi[startI][startJ]=null;//走棋
			this.xiangQi.repaint();//重绘
			JOptionPane.showMessageDialog(this.xiangQi,"很遗憾，您失败了！！！","提示",
					JOptionPane.INFORMATION_MESSAGE);//给出失败信息
			this.xiangQi.cat.tiaoZhanZhe=null;
			this.xiangQi.color=0;//还原棋盘进入下一盘
			this.xiangQi.caiPan=false;
			this.xiangQi.next();
			this.xiangQi.jtfHost.setEnabled(false);//还原各个控件的状态
			this.xiangQi.jtfPort.setEnabled(false);
			this.xiangQi.jtfNickName.setEnabled(false);
			this.xiangQi.jbConnect.setEnabled(false);
			this.xiangQi.jbDisconnect.setEnabled(true);
			this.xiangQi.jbChallenge.setEnabled(true);
			this.xiangQi.jbYChallenge.setEnabled(false);
			this.xiangQi.jbNChallenge.setEnabled(false);
			this.xiangQi.jbFail.setEnabled(false);
			jiang1_i=4;//"帥"的i坐标
			jiang1_j=0;//"帥"的j坐标
			jiang2_i=4;//"將"的i坐标
			jiang2_j=9;//"將"的j坐标
		}
		else{//如果不是"将"
			qiZi[endI][endJ]=qiZi[startI][startJ];
			qiZi[startI][startJ]=null;//走棋
			this.xiangQi.repaint();//重绘
			if(qiZi[endI][endJ].getName().equals("帅")){
				jiang1_i=endI;//如果是"帥"
				jiang1_j=endJ;
			}
			else if(qiZi[endI][endJ].getName().equals("将")){
				jiang2_i=endI;//如果是"將"
				jiang2_j=endJ;
			}
			if(jiang1_i==jiang2_i){//如果两将在一条线上
				int count=0;
				for(int jiang_j=jiang1_j+1;jiang_j<jiang2_j;jiang_j++){
					if(qiZi[jiang1_i][jiang_j]!=null){//有棋子
						count++;break;
					}
				}
				if(count==0){
					JOptionPane.showMessageDialog(this.xiangQi,"对方照将！！！你胜利了！！！",
							"提示",JOptionPane.INFORMATION_MESSAGE);//给出失败信息
					this.xiangQi.cat.tiaoZhanZhe=null;
					this.xiangQi.color=0;//还原棋盘，进入下一盘
					this.xiangQi.caiPan=false;
					this.xiangQi.next();
					this.xiangQi.jtfHost.setEnabled(false);
					this.xiangQi.jtfPort.setEnabled(false);//设置各空间位置
					this.xiangQi.jtfNickName.setEnabled(false);
					this.xiangQi.jbConnect.setEnabled(false);
					this.xiangQi.jbDisconnect.setEnabled(true);
					this.xiangQi.jbChallenge.setEnabled(true);
					this.xiangQi.jbYChallenge.setEnabled(false);
					this.xiangQi.jbNChallenge.setEnabled(false);
					this.xiangQi.jbFail.setEnabled(false);
					jiang1_i=4;//"帥"的i坐标
					jiang1_j=0;//"帥"的j坐标
					jiang2_i=4;//"將"的i坐标
					jiang2_j=9;//"將"的j坐标
				}
			}
		}
		this.xiangQi.repaint();//重绘
	}

	public void success(){
		qiZi[endI][endJ]=qiZi[startI][startJ];//吃掉该棋子
		qiZi[startI][startJ]=null;//将原来的位置设为空
		this.xiangQi.repaint();//重绘
		JOptionPane.showMessageDialog(this.xiangQi,"恭喜您，您获胜了","提示",
				JOptionPane.INFORMATION_MESSAGE);//给出获胜信息
		this.xiangQi.cat.tiaoZhanZhe=null;
		this.xiangQi.color=0;
		this.xiangQi.caiPan=false;
		this.xiangQi.next();//还原棋盘，进入下一盘
		this.xiangQi.jtfHost.setEnabled(false);
		this.xiangQi.jtfPort.setEnabled(false);//设置各控件的状态
		this.xiangQi.jtfNickName.setEnabled(false);
		this.xiangQi.jbConnect.setEnabled(false);
		this.xiangQi.jbDisconnect.setEnabled(true);
		this.xiangQi.jbChallenge.setEnabled(true);
		this.xiangQi.jbYChallenge.setEnabled(false);
		this.xiangQi.jbNChallenge.setEnabled(false);
		this.xiangQi.jbFail.setEnabled(false);
		startI=-1;//还原保存点
		startJ=-1;
		endI=-1;
		endJ=-1;
		jiang1_i=4;//"帥"的i坐标
		jiang1_j=0;//"帥"的j坐标
		jiang2_i=4;//"將"的i坐标
		jiang2_j=9;//"將"的j坐标
		focus=false;
	}
	public void noJiang(){
		qiZi[endI][endJ]=qiZi[startI][startJ];
		qiZi[startI][startJ]=null;//走棋
		qiZi[endI][endJ].setFocus(false);//将该棋设为非选中状态
		this.xiangQi.repaint();//重绘
		if(qiZi[endI][endJ].getName().equals("帅")){//如果移动的是"帥"
			jiang1_i=endI;//更新"帥"的位置坐标
			jiang1_j=endJ;
		}
		else if(qiZi[endI][endJ].getName().equals("将")){//如果移动的是"將"
			jiang2_i=endI;//更新"將"的位置坐标
			jiang2_j=endJ;
		}
		if(jiang1_i==jiang2_i){//如果"將"和"帥"在一条竖线上
			int count=0;
			for(int jiang_j=jiang1_j+1;jiang_j<jiang2_j;jiang_j++){//遍历这条竖线
				if(qiZi[jiang1_i][jiang_j]!=null){
					count++;break;
				}
			}
			if(count==0){//如果等于零则照将
				JOptionPane.showMessageDialog(this.xiangQi,"照将！！！你失败了！！！","提示",
						JOptionPane.INFORMATION_MESSAGE);//给出失败信息
				this.xiangQi.cat.tiaoZhanZhe=null;
				this.xiangQi.color=0;//还原棋盘，进入下一盘
				this.xiangQi.caiPan=false;
				this.xiangQi.next();//进入下一盘
				this.xiangQi.jtfHost.setEnabled(false);
				this.xiangQi.jtfPort.setEnabled(false);//设置各控件状态
				this.xiangQi.jtfNickName.setEnabled(false);
				this.xiangQi.jbConnect.setEnabled(false);
				this.xiangQi.jbDisconnect.setEnabled(true);
				this.xiangQi.jbChallenge.setEnabled(true);
				this.xiangQi.jbYChallenge.setEnabled(false);
				this.xiangQi.jbNChallenge.setEnabled(false);
				this.xiangQi.jbFail.setEnabled(false);
				jiang1_i=4;//"帥"的i坐标
				jiang1_j=0;//"帥"的j坐标
				jiang2_i=4;//"將"的i坐标
				jiang2_j=9;//"將"的j坐标
			}
		}
		startI=-1;
		startJ=-1;//还原保存点
		endI=-1;
		endJ=-1;
		focus=false;
	}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}


}
