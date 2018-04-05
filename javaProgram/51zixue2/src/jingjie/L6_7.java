//仓库的生产消费问题，进程同步的解决,名字固定为a-h

package jingjie;

public class L6_7 {
	public static void main(String[] args){
		Ck1 ck=new Ck1();Xf1 xf=new Xf1(ck);Sc1 sc=new Sc1(ck);
		Thread xc1=new Thread(xf);
		Thread xc2=new Thread(sc);
		xc1.start();xc2.start();
	}
}

class Sc1 implements Runnable{
	private Ck1 xx=null;
	public Sc1(Ck1 xx){
		this.xx=xx;
	}
	public void run(){
		for(int j=0;j<26;j++){
			xx.produce();
		}
	}
}

class Xf1 implements Runnable{
	private Ck1 xy=null;
	public Xf1(Ck1 xy){
		this.xy=xy;
	}
	public void run(){
		while(true){
			xy.sale();
		}
	}
}
class Ck1{

	private int wp=0;
	private char name='A';

	public synchronized void produce(){

		while(wp==8){
			try{
				this.wait();
			}catch(Exception e){
			}

		}
		this.notify();++wp;
		System.out.println("正在生产第"+wp+"个产品该产品名为:"+name);
		name=(char)(name+1);
	}

	public synchronized void sale(){		
			while(wp==0){
				try{
					this.wait();
				}catch(Exception e){
				}
			}
			this.notify();			
			name=(char)(name-1);
			System.out.println("正在消费第"+wp+"个产品该产品名为:"+name);
			wp--;
		
	}
}