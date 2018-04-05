//IO流

package jingjie;
import java.io.*;
public class L7_1 {
	public static void main(String[] args) throws Exception{//调用IO流时要抛异常
		FileReader wj=new FileReader("D:/java/51zixue2/src/jingjie/L7_1.java");//创建一个文件流（字符流）
	//	FileInputStream wj=new FileInputStream("D:/java/51zixue2/src/jingjie/L7_1.java");//创建一个文件流（字节流）
									//字节流由于时一个个字节读取，汉字是两个字节所以读出来的是乱码
		
		int aa;
		aa=wj.read();//读取一个字符，read()读取一个字符，该字符默认转换成整型
		System.out.println("文件内容为：");
		while(aa!=-1){//ACSII码时从0开始的数字，只有什么都没有的时候才为-1
			System.out.print((char)aa);
			aa=wj.read();//继续往下读
		}
		wj.close();//关闭
	}
}
