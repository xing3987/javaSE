//print流和data流
package jingjie;
import java.io.*;
public class L7_5 {
	public static void main(String[] args) throws Exception{
		DataOutputStream data=new DataOutputStream(new FileOutputStream("D:/java/L7_5.txt"));//创建数据流并设定保存路径
		data.writeLong(15412);//把数据写入文件中，打开文件会发现是不正确数据，因为data流保存的是二进制数据（计算机使用的数据），data的写入方法为write*()
		data.close();
		
		PrintStream ps=new PrintStream(new FileOutputStream("D:/java/L7_5_1.txt"));//创建一个打印流并设定路径
		ps.println(26587);//print流的写入方法println
		System.setOut(ps);//设置输出的路径为ps流中的文件里
		System.out.println("hello world!");//发现输出的内容不在控制台显示而在文件中
		ps.close();		
		
	}
}
