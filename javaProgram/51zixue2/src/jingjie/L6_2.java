//线程的使用和创建 Thread--继承主线程法


package jingjie;

public class L6_2{
	public static void main(String[] args){
		Ab xx=new Ab();

		xx.start();
		for(int i=0;i<1000;i++){
			System.out.println("主程序运行了"+(i+1)+"次");
		}

	}

}
class Ab extends Thread{
	public void run() {
		for(int i=0;i<1000;i++){
			System.out.println("运行了"+(i+1)+"次");
		}
		
	}
}