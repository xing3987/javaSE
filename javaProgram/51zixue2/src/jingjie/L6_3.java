//线程的使用，线程的让步和阻涉


package jingjie;

public class L6_3{
	public static void main(String[] args){
		Ab1 xa=new Ab1();
		Thread xx=new Thread(xa);
		xx.start();
		try{
			xx.join();//使用该语句时，先运行xx线程，执行完该线程后才继续执行，该函数要处理异常
		}catch(Exception e){
			
		}
		for(int i=0;i<1000;i++){
			System.out.println("主程序运行了"+(i+1)+"次");

		}

	}

}
class Ab1 implements Runnable{
	public void run() {
		for(int i=0;i<1000;i++){
			System.out.println("次程序运行了"+(i+1)+"次");
			if(i%5==0){
				Thread.yield();//线程的让步
			}
		}
		
	}
}