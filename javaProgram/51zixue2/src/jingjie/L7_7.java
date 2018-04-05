//print流的使用

package jingjie;
import java.io.*;
import java.util.*;
public class L7_7 {
	public static void main(String[] args) throws Exception{
		PrintStream right=new PrintStream(new FileOutputStream("D:/java/L7_7.txt"));
		PrintStream err=new PrintStream(new FileOutputStream("D:/java/L7_7_1.txt"));
		Scanner in=new Scanner(System.in);
		try{
			int a;
			System.setOut(right);//设置输出的地方
			System.setErr(err);//设置输出错误的地方
			while(true){
				a=in.nextInt();
				System.out.println(a);
			}
		}catch(Exception e){
			System.err.println("输入有误");
		}
		in.close();
		right.close();
		err.close();
	}
}
