//坦克大战  素材
package jingjie;
import java.io.*;
import java.util.*;

import javax.sound.sampled.*;
class Tank{
	protected int x;
	protected int y;
	protected int forward;
	protected int speed=5;
	boolean life=true;
	protected int getForward() {
		return forward;
	}

	public void setForward(int forward) {
		this.forward = forward;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	public Tank(int x,int y){
		this.x=x;
		this.y=y;
	}

}

class MyTank extends Tank{
	int forward=0;
	Vector<Zidan> aa=new Vector<Zidan>();
	Zidan zd=null;
	public MyTank(int x, int y) {
		super(x, y);
	}
	public void up(){
		if(y>0){
			y-=super.getSpeed();
		}
	}
	public void down(){
		if(y<470){
			y+=super.getSpeed();
		}
	}
	public void left(){
		if(x>0){
			x-=super.getSpeed();
		}
	}
	public void right(){
		if(x<470){
			x+=super.getSpeed();
		}
	}

	public void shot(){
		switch(this.forward){
		case 0:
			zd=new Zidan(x+9,y-8,0);
			aa.add(zd);
			break;
		case 1:
			zd=new Zidan(x+9,y+38,1);
			aa.add(zd);
			break;
		case 2:
			zd=new Zidan(x-8,y+9,2);
			aa.add(zd);
			break;
		case 3:
			zd=new Zidan(x+38,y+9,3);
			aa.add(zd);
			break;
		}
		Thread t=new Thread(zd);
		t.start();
	}
}

class DiTank extends Tank implements Runnable{
	Vector<Zidan> bb=new Vector<Zidan>();
	Zidan zd;
	int time=0;
	private int forward=1;
	int speed=2;
	public int getForward() {
		return forward;
	}


	public void setForward(int forward) {
		this.forward = forward;
	}


	public DiTank(int x,int y){
		super(x, y);
	}


	public void run() {
		while(true){

			switch(forward){
			case 0:
				for(int i=0;i<15;i++){
					if(y>=3){
						y-=speed;
					}
					try{
						Thread.sleep(50);
					}catch(Exception e){

					}
				}
				break;
			case 1:
				for(int i=0;i<15;i++){
					if(y<=467){
						y+=speed;
					}
					try{
						Thread.sleep(50);
					}catch(Exception e){

					}
				}
				break;
			case 2:
				for(int i=0;i<15;i++){
					if(x>=3){
						x-=speed;
					}
					try{
						Thread.sleep(50);
					}catch(Exception e){

					}
				}
				break;
			case 3:
				for(int i=0;i<15;i++){
					if(x<=467){
						x+=speed;
					}
					try{
						Thread.sleep(50);
					}catch(Exception e){

					}
				}
				break;
			}
			time++;
			if(time%2==0){
				if(bb.size()<=5){
					switch(forward){
					case 0:
						zd=new Zidan(x+9,y-8,0);
						break;
					case 1:
						zd=new Zidan(x+9,y+38,1);
						break;
					case 2:
						zd=new Zidan(x-8,y+9,2);
						break;
					case 3:
						zd=new Zidan(x+38,y+9,3);
						break;
					}
					bb.add(zd);
					Thread xx=new Thread(zd);
					xx.start();
				}
			}
			forward=(int) (Math.random()*4);
			if(life==false){
				break;
			}

		}
	}



}

class Zidan implements Runnable{
	private int x,y;
	private int forward;
	private int speed=8;
	boolean life=true;
	public int getForward() {
		return forward;
	}
	public void setForward(int forward) {
		this.forward = forward;
	}


	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Zidan(int x,int y,int forward){
		this.x=x;this.y=y;this.forward=forward;
	}

	public void run() {
		while(true){
			try {
				Thread.sleep(50);//凡是线程下面的死循环里都要有睡眠
			} catch (Exception e) {
			}
			switch(forward){
			case 0:
				y-=speed;
				break;
			case 1:
				y+=speed;
				break;
			case 2:
				x-=speed;
				break;
			case 3:
				x+=speed;
				break;
			}
			if(x<0||x>500||y<0||y>500){
				life=false;
				break;
			}

		}

	}
}

class Baoza{
	int x,y;
	boolean life=true;
	int time=8;
	public Baoza(int x,int y){
		this.x=x;this.y=y;
	}

	public void qidong() {
		if(time>0){
			time-=1;
		}else{
			life=false;
		}
	}

}

class Music extends Thread{//导入音乐线程的制作
	private String musicPath;
	public Music(String a){
		this.musicPath=a;
	}
	
	public void run() {
		File file=new File(musicPath);
		AudioInputStream ais=null;
		try {
			ais=AudioSystem.getAudioInputStream(file);
		} catch (Exception e) {}
		AudioFormat format=ais.getFormat();
		SourceDataLine data=null;
		DataLine.Info info=new DataLine.Info(SourceDataLine.class, format);
		try {
			data=(SourceDataLine)AudioSystem.getLine(info);
			data.open(format);
		} catch (Exception e) {}
		data.start();
		
		int readlong=0;
		byte[] by=new byte[1024];
		try{
			while(readlong!=-1){
				readlong=ais.read(by, 0, by.length);
				if(readlong>=0){
					data.write(by, 0, readlong);
				}
			}
		}catch(Exception e){}
		finally{
			data.flush();
			data.close();
		}
	}
	
}