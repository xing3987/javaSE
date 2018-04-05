//仓库的生产消费问题，进程同步的解决

package jingjie;

public class L6_6 {
	public static void main(String[] args){
		Ck ck=new Ck();Xf xf=new Xf(ck);Sc sc=new Sc(ck);
		Thread xc1=new Thread(xf);
		Thread xc2=new Thread(sc);
		xc1.start();xc2.start();
	}
}

class Sc implements Runnable{
	private Ck xx=null;
	public Sc(Ck xx){
		this.xx=xx;
	}
	public void run(){
		char aa;
		for(int j=0;j<26;j++){
			aa=(char)('A'+j);
			xx.produce(aa);
		}
	}
}

class Xf implements Runnable{
	private Ck xy=null;
	public Xf(Ck xy){
		this.xy=xy;
	}
	public void run(){
		while(true){
			xy.sale();
		}
	}
}
class Ck{
	private char rl[]=new char[8];
	private static int wp=0;


	public synchronized void produce(char aa){

		while(wp==rl.length){
			try{
				this.wait();
			}catch(Exception e){
			}
			
		}
		this.notify();
		rl[wp]=aa;++wp;
		System.out.println("正在生产第"+wp+"个产品该产品名为:"+aa);		
	}

	public synchronized void sale(){
		char aa;
		while(wp==0){
			try{
				this.wait();
			}catch(Exception e){

			}
		}
		this.notify();
		aa=rl[wp-1];
		System.out.println("正在消费第"+wp+"个产品该产品名为:"+aa);
		wp--;

	}
}