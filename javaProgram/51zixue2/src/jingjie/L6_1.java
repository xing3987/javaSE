//线程的使用和创建 Thread--实现接口法（所有的线程都是同步的）


package jingjie;

public class L6_1{
	public static void main(String[] args){
		Aa xx=new Aa();
		Ba xy=new Ba();
		Thread a=new Thread(xx);
		a.setName("第一个线程");//设置线程名字		
		Thread b=new Thread(xy);
		b.setPriority(Thread.NORM_PRIORITY+4);//设置线程优先级，默认Norm_Priority为5   +4加的最大优先级越高
		b.setName("第二个线程");
		a.start();
		b.start();
	/*	for(int i=0;i<1000;i++){
			System.out.print(Thread.currentThread().getName()+"在执行");//得到当前线程名字
			System.out.println("运行了"+(i+1)+"次");
		}*/
	}

}
class Aa implements Runnable{
	public void run() {
		for(int i=0;i<1000;i++){
			System.out.print("第一个线程运行了"+(i+1)+"次");
			System.out.println(Thread.currentThread().getName()+"在执行");
			try{
				Thread.sleep(1000);//休眠1000ms==1s,该方法使用时要处理异常,该异常处理时不能往上级throws，因为上级的run()程序没有throws异常
			}catch(Exception e){
				
			}
		}
		
	}
}

class Ba implements Runnable{
	public void run() {
		for(int i=0;i<1000;i++){
			System.out.print("第二个线程运行了"+(i+1)+"次");
			System.out.println(Thread.currentThread().getName()+"在执行");
			
			
		}
		
	}
}