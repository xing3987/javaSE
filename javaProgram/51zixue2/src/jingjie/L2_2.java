package jingjie;
import java.util.Scanner;
public class L2_2 {
	public static void main(String[] args){
		try{
			
			A.yushu();//静态方法可以直接创建引用			
		}catch(Exception e){
			System.out.println("输入错误");			
		}		
		System.out.println("程序正在运行");
	}
}
class A{
	static void yushu() throws Exception {//throws 是程序出异常时把异常往上级抛，让上级解决，上级必须要有 try....catch接收异常，或者throws再向上抛
		Scanner in=new Scanner(System.in);
		int a,b,c;
		System.out.println("请输入一个整数");
		a=in.nextInt();
		System.out.println("请再输入一个整数");
		b=in.nextInt();
		c=a%b;
		System.out.println(a+"与"+b+"的余数为"+c);
		in.close();
	}
}
