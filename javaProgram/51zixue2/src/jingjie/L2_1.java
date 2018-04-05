package jingjie;
import java.util.Scanner;
public class L2_1 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int a,b,c;
		try{
			System.out.println("请输入一个整数");
			a=in.nextInt();
			System.out.println("请再输入一个整数");
			b=in.nextInt();
			c=a%b;
			System.out.println(a+"与"+b+"的余数为"+c);			
		}catch(Exception e){
			System.out.println("输入错误");			
		}		
		System.out.println("程序正在运行");
		
		in.close();
	}
}
