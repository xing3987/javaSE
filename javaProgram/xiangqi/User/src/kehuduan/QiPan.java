package kehuduan;
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
public class QiPan extends JPanel implements MouseListener{
	private int width;
	boolean focus=false;//�Ƿ�ѡ��
	int jiang1_i=4;//����λ������
	int jiang1_j=0;
	int jiang2_i=4;
	int jiang2_j=9;
	QiZi[][] qiZi;
	int startI=-1;//���ӵĿ�ʼλ��
	int startJ=-1;
	int endI=-1;//���ӵ���ֹλ��
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
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);//�򿪿����
		g.setColor(xiangQi.bgColor);
		g.fill3DRect(60, 30, 580, 630,false);
		g.setColor(Color.black);
		for(int i=80;i<=620;i=i+60){//������
			g.drawLine(110, i, 590, i);
		}
		for(int i=110;i<=630;i=i+60){//������
			g.drawLine(i, 80, i,320);
			g.drawLine(i, 380, i, 620);
		}
		g.drawLine(110, 320, 110, 380);
		g.drawLine(590,320,590,380);
		g.setFont(new Font("����",Font.ITALIC,30));
		g.drawString("��   ��", 130, 360);
		g.drawString("�h   ��",450,360);
		this.smallLine(g,1,2);//���ƺ�������λ�õı�־
		this.smallLine(g,7,2);//���ƺ�������λ�õı�־
		this.smallLine(g,0,3);//���Ʊ�����λ�õı�־
		this.smallLine(g,2,3);//���Ʊ�����λ�õı�־
		this.smallLine(g,4,3);//���Ʊ�����λ�õı�־
		this.smallLine(g,6,3);//���Ʊ�����λ�õı�־
		this.smallLine(g,8,3);//���Ʊ�����λ�õı�־
		this.smallLine(g,0,6);//����������λ�õı�־
		this.smallLine(g,2,6);//����������λ�õı�־
		this.smallLine(g,4,6);//����������λ�õı�־
		this.smallLine(g,6,6);//����������λ�õı�־
		this.smallLine(g,8,6);//����������λ�õı�־
		this.smallLine(g,1,7);//���ư�������λ�õı�־
		this.smallLine(g,7,7);//���ư�������λ�õı�־
		g.setFont(new Font("����",Font.BOLD,30));
		for(int i=0;i<9;i++){
			for(int j=0;j<10;j++){
				if(qiZi[i][j]!=null){
					if(this.qiZi[i][j].isFocus()==true){
						g.setColor(XiangQi.focusbg);//ѡ�к�ı���ɫ
						g.fillOval(110+i*60-25,80+j*60-25,50,50);//���Ƹ�����
						g.setColor(XiangQi.focuschar);//�ַ�����ɫ
					}
					else{
						g.fillOval(110+i*60-25,80+j*60-25,50,50);//���Ƹ�����
						g.setColor(qiZi[i][j].getColor());//���û�����ɫ
					}
					g.drawString(qiZi[i][j].getName(),110+i*60-15,80+j*60+10);
					g.setColor(Color.black);//��Ϊ��ɫ					
				}
			}
		}
	}

	public void smallLine(Graphics2D g,int i,int j){//�ѽ��㴦���루����λ�ã�
		int x=110+60*i;//��������
		int y=80+60*j;
		if(i>0){//�������Ϸ������·��ı�־
			g.drawLine(x-3,y-3,x-20,y-3);g.drawLine(x-3,y-3,x-3,y-20);
			g.drawLine(x-3,y+3,x-20,y+3);g.drawLine(x-3,y+3,x-3,y+20);
		}
		if(i<8){//�������Ϸ������·��ı�־
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
		//�жϺ�����
		if(Math.abs((x-110)%60)<=25){
			pos[0]=(int) Math.round((x-110)/60);
		}else if(Math.abs((x-110)%60)>=35){
			pos[0]=(int) Math.round((x-110)/60);
		}
		//�ж�������
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
			if(i>=0&&i<=8&&j>=0&&j<=9){//���������������̷�Χ��
				if(focus==false){//���ǰ��û��ѡ�й�����
					this.noFocus(i,j);
				}else{//�����ǰѡ�й�����
					if(qiZi[i][j]!=null){//����ô�������
						if(qiZi[i][j].getColor().equals(qiZi[startI][startJ].getColor())){//������Լ�������
							qiZi[startI][startJ].setFocus(false);
							qiZi[i][j].setFocus(true);
							startI=i;
							startJ=j;
						}else{//����ǵз�������
							endI=i;
							endJ=j;
							String name=qiZi[startI][startJ].getName();
							boolean canMove=guiZe.canMove(startI, startJ, endI, endJ, name);
							if(canMove){
								try{//�����ƶ���Ϣ���͸��Է�
									this.xiangQi.cat.dos.writeUTF("<#MOVE#>"+
											this.xiangQi.cat.tiaoZhanZhe+startI+startJ+endI+endJ);
									this.xiangQi.caiPan=false;
									if(qiZi[endI][endJ].getName().equals("˧")||
											qiZi[endI][endJ].getName().equals("��"))
									{//����յ㴦�ǶԷ���"��"
										this.success();
									}
									else{//����յ㲻�ǶԷ���"��"
										this.noJiang();
									}
								}
								catch(Exception ee){ee.printStackTrace();}
							}

						}
					}else{//���û������
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
		if(qiZi[i][j]!=null){//��λ��������ʱ���з�Ӧ
			if(this.xiangQi.color==0){//����Ǻ췽
				if(this.qiZi[i][j].getColor().equals(xiangQi.color1)){//�������Ҳ�Ǻ��
					this.qiZi[i][j].setFocus(true);
					this.focus=true;
					startI=i;
					startJ=j;
				}
			}else{//����ǰ׷�
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
		try{//�����ƶ���Ϣ���͸��Է�
			this.xiangQi.cat.dos.writeUTF("<#MOVE#>"+this.xiangQi.cat.tiaoZhanZhe+startI+startJ+endI+endJ);
			this.xiangQi.caiPan=false;
			qiZi[endI][endJ]=qiZi[startI][startJ];
			qiZi[startI][startJ]=null;//����
			qiZi[endI][endJ].setFocus(false);//��������Ϊ��ѡ��״̬
			this.xiangQi.repaint();//�ػ�
			if(qiZi[endI][endJ].getName().equals("˧")){//����ƶ�����"��"
				jiang1_i=endI;//����"��"��λ������
				jiang1_j=endJ;
			}
			else if(qiZi[endI][endJ].getName().equals("��")){//����ƶ�����"��"
				jiang2_i=endI;//����"��"��λ������
				jiang2_j=endJ;
			}
			if(jiang1_i==jiang2_i)//���"��"��"��"��һ��������
			{
				int count=0;
				for(int jiang_j=jiang1_j+1;jiang_j<jiang2_j;jiang_j++){//������������
					if(qiZi[jiang1_i][jiang_j]!=null){
						count++;break;
					}
				}
				if(count==0){//������������ս�
					JOptionPane.showMessageDialog(this.xiangQi,"�ս���������ʧ���ˣ�����","��ʾ",
							JOptionPane.INFORMATION_MESSAGE);//����ʧ����Ϣ
					this.xiangQi.cat.tiaoZhanZhe=null;
					this.xiangQi.color=0;//��ԭ���̣�������һ��
					this.xiangQi.caiPan=false;
					this.xiangQi.next();//������һ��
					this.xiangQi.jtfHost.setEnabled(false);
					this.xiangQi.jtfPort.setEnabled(false);
					this.xiangQi.jtfNickName.setEnabled(false);//���ø��ؼ�״̬
					this.xiangQi.jbConnect.setEnabled(false);
					this.xiangQi.jbDisconnect.setEnabled(true);
					this.xiangQi.jbChallenge.setEnabled(true);
					this.xiangQi.jbYChallenge.setEnabled(false);
					this.xiangQi.jbNChallenge.setEnabled(false);
					this.xiangQi.jbFail.setEnabled(false);
					jiang1_i=4;//"��"��i����
					jiang1_j=0;//"��"��j����
					jiang2_i=4;//"��"��i����
					jiang2_j=9;//"��"��j����
				}
			}
			startI=-1;
			startJ=-1;//��ԭ�����
			endI=-1;
			endJ=-1;
			focus=false;
		}
		catch(Exception ee){ee.printStackTrace();}
	}

	public void move(int startI,int startJ,int endI,int endJ){
		if(qiZi[endI][endJ]!=null&&(qiZi[endI][endJ].getName().equals("˧")||
				qiZi[endI][endJ].getName().equals("��"))){//���"��"������
			qiZi[endI][endJ]=qiZi[startI][startJ];
			qiZi[startI][startJ]=null;//����
			this.xiangQi.repaint();//�ػ�
			JOptionPane.showMessageDialog(this.xiangQi,"���ź�����ʧ���ˣ�����","��ʾ",
					JOptionPane.INFORMATION_MESSAGE);//����ʧ����Ϣ
			this.xiangQi.cat.tiaoZhanZhe=null;
			this.xiangQi.color=0;//��ԭ���̽�����һ��
			this.xiangQi.caiPan=false;
			this.xiangQi.next();
			this.xiangQi.jtfHost.setEnabled(false);//��ԭ�����ؼ���״̬
			this.xiangQi.jtfPort.setEnabled(false);
			this.xiangQi.jtfNickName.setEnabled(false);
			this.xiangQi.jbConnect.setEnabled(false);
			this.xiangQi.jbDisconnect.setEnabled(true);
			this.xiangQi.jbChallenge.setEnabled(true);
			this.xiangQi.jbYChallenge.setEnabled(false);
			this.xiangQi.jbNChallenge.setEnabled(false);
			this.xiangQi.jbFail.setEnabled(false);
			jiang1_i=4;//"��"��i����
			jiang1_j=0;//"��"��j����
			jiang2_i=4;//"��"��i����
			jiang2_j=9;//"��"��j����
		}
		else{//�������"��"
			qiZi[endI][endJ]=qiZi[startI][startJ];
			qiZi[startI][startJ]=null;//����
			this.xiangQi.repaint();//�ػ�
			if(qiZi[endI][endJ].getName().equals("˧")){
				jiang1_i=endI;//�����"��"
				jiang1_j=endJ;
			}
			else if(qiZi[endI][endJ].getName().equals("��")){
				jiang2_i=endI;//�����"��"
				jiang2_j=endJ;
			}
			if(jiang1_i==jiang2_i){//���������һ������
				int count=0;
				for(int jiang_j=jiang1_j+1;jiang_j<jiang2_j;jiang_j++){
					if(qiZi[jiang1_i][jiang_j]!=null){//������
						count++;break;
					}
				}
				if(count==0){
					JOptionPane.showMessageDialog(this.xiangQi,"�Է��ս���������ʤ���ˣ�����",
							"��ʾ",JOptionPane.INFORMATION_MESSAGE);//����ʧ����Ϣ
					this.xiangQi.cat.tiaoZhanZhe=null;
					this.xiangQi.color=0;//��ԭ���̣�������һ��
					this.xiangQi.caiPan=false;
					this.xiangQi.next();
					this.xiangQi.jtfHost.setEnabled(false);
					this.xiangQi.jtfPort.setEnabled(false);//���ø��ռ�λ��
					this.xiangQi.jtfNickName.setEnabled(false);
					this.xiangQi.jbConnect.setEnabled(false);
					this.xiangQi.jbDisconnect.setEnabled(true);
					this.xiangQi.jbChallenge.setEnabled(true);
					this.xiangQi.jbYChallenge.setEnabled(false);
					this.xiangQi.jbNChallenge.setEnabled(false);
					this.xiangQi.jbFail.setEnabled(false);
					jiang1_i=4;//"��"��i����
					jiang1_j=0;//"��"��j����
					jiang2_i=4;//"��"��i����
					jiang2_j=9;//"��"��j����
				}
			}
		}
		this.xiangQi.repaint();//�ػ�
	}

	public void success(){
		qiZi[endI][endJ]=qiZi[startI][startJ];//�Ե�������
		qiZi[startI][startJ]=null;//��ԭ����λ����Ϊ��
		this.xiangQi.repaint();//�ػ�
		JOptionPane.showMessageDialog(this.xiangQi,"��ϲ��������ʤ��","��ʾ",
				JOptionPane.INFORMATION_MESSAGE);//������ʤ��Ϣ
		this.xiangQi.cat.tiaoZhanZhe=null;
		this.xiangQi.color=0;
		this.xiangQi.caiPan=false;
		this.xiangQi.next();//��ԭ���̣�������һ��
		this.xiangQi.jtfHost.setEnabled(false);
		this.xiangQi.jtfPort.setEnabled(false);//���ø��ؼ���״̬
		this.xiangQi.jtfNickName.setEnabled(false);
		this.xiangQi.jbConnect.setEnabled(false);
		this.xiangQi.jbDisconnect.setEnabled(true);
		this.xiangQi.jbChallenge.setEnabled(true);
		this.xiangQi.jbYChallenge.setEnabled(false);
		this.xiangQi.jbNChallenge.setEnabled(false);
		this.xiangQi.jbFail.setEnabled(false);
		startI=-1;//��ԭ�����
		startJ=-1;
		endI=-1;
		endJ=-1;
		jiang1_i=4;//"��"��i����
		jiang1_j=0;//"��"��j����
		jiang2_i=4;//"��"��i����
		jiang2_j=9;//"��"��j����
		focus=false;
	}
	public void noJiang(){
		qiZi[endI][endJ]=qiZi[startI][startJ];
		qiZi[startI][startJ]=null;//����
		qiZi[endI][endJ].setFocus(false);//��������Ϊ��ѡ��״̬
		this.xiangQi.repaint();//�ػ�
		if(qiZi[endI][endJ].getName().equals("˧")){//����ƶ�����"��"
			jiang1_i=endI;//����"��"��λ������
			jiang1_j=endJ;
		}
		else if(qiZi[endI][endJ].getName().equals("��")){//����ƶ�����"��"
			jiang2_i=endI;//����"��"��λ������
			jiang2_j=endJ;
		}
		if(jiang1_i==jiang2_i){//���"��"��"��"��һ��������
			int count=0;
			for(int jiang_j=jiang1_j+1;jiang_j<jiang2_j;jiang_j++){//������������
				if(qiZi[jiang1_i][jiang_j]!=null){
					count++;break;
				}
			}
			if(count==0){//������������ս�
				JOptionPane.showMessageDialog(this.xiangQi,"�ս���������ʧ���ˣ�����","��ʾ",
						JOptionPane.INFORMATION_MESSAGE);//����ʧ����Ϣ
				this.xiangQi.cat.tiaoZhanZhe=null;
				this.xiangQi.color=0;//��ԭ���̣�������һ��
				this.xiangQi.caiPan=false;
				this.xiangQi.next();//������һ��
				this.xiangQi.jtfHost.setEnabled(false);
				this.xiangQi.jtfPort.setEnabled(false);//���ø��ؼ�״̬
				this.xiangQi.jtfNickName.setEnabled(false);
				this.xiangQi.jbConnect.setEnabled(false);
				this.xiangQi.jbDisconnect.setEnabled(true);
				this.xiangQi.jbChallenge.setEnabled(true);
				this.xiangQi.jbYChallenge.setEnabled(false);
				this.xiangQi.jbNChallenge.setEnabled(false);
				this.xiangQi.jbFail.setEnabled(false);
				jiang1_i=4;//"��"��i����
				jiang1_j=0;//"��"��j����
				jiang2_i=4;//"��"��i����
				jiang2_j=9;//"��"��j����
			}
		}
		startI=-1;
		startJ=-1;//��ԭ�����
		endI=-1;
		endJ=-1;
		focus=false;
	}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}


}
