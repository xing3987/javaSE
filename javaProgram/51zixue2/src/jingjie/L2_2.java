package jingjie;
import java.util.Scanner;
public class L2_2 {
	public static void main(String[] args){
		try{
			
			A.yushu();//��̬��������ֱ�Ӵ�������			
		}catch(Exception e){
			System.out.println("�������");			
		}		
		System.out.println("������������");
	}
}
class A{
	static void yushu() throws Exception {//throws �ǳ�����쳣ʱ���쳣���ϼ��ף����ϼ�������ϼ�����Ҫ�� try....catch�����쳣������throws��������
		Scanner in=new Scanner(System.in);
		int a,b,c;
		System.out.println("������һ������");
		a=in.nextInt();
		System.out.println("��������һ������");
		b=in.nextInt();
		c=a%b;
		System.out.println(a+"��"+b+"������Ϊ"+c);
		in.close();
	}
}
