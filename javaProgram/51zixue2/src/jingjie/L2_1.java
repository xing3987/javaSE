package jingjie;
import java.util.Scanner;
public class L2_1 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int a,b,c;
		try{
			System.out.println("������һ������");
			a=in.nextInt();
			System.out.println("��������һ������");
			b=in.nextInt();
			c=a%b;
			System.out.println(a+"��"+b+"������Ϊ"+c);			
		}catch(Exception e){
			System.out.println("�������");			
		}		
		System.out.println("������������");
		
		in.close();
	}
}
