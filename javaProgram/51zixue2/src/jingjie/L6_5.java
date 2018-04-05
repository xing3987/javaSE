//多线程的处理--卖票问题(同步的解决)


package jingjie;

public class L6_5{
	public static void main(String[] args){
		Hcz1 xx=new Hcz1();Hcz1 xy=new Hcz1();
		Thread a=new Thread(xx);Thread b=new Thread(xy);//注意生成线程时都要是同一个xx类的线程
		a.setName("第一个窗口");b.setName("第二个窗口");
		try{
			a.start();b.start();
		}catch(Exception e){

		}

	}
}
class Hcz1 implements Runnable{
	public static int chepiao=100;
    public static String a=new String("1");//把同步字符静态化，两个不同线程抢a
	public void run() {
		for(int i=1;;i++){
			synchronized(a){//使用同步方法，synchronized（字符）｛｝ 该方法内必须执行完才可以给其他线程继续执行，该a必须是公共的
				if(chepiao<=0){
					break;
				}
				System.out.println( Thread.currentThread().getName()+"正在卖第"+(101-chepiao)+"张车票");
				chepiao--;
			}
		}

	}
}
