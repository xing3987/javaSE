//IO流，缓冲流的使用

package jingjie;
import java.io.*;
public class L7_3 {
	public static void main(String[] args) throws Exception{//调用IO流时要抛异常
		BufferedInputStream fz=new BufferedInputStream(new FileInputStream("G:/music/Bobby Tinsley - Missing You.mp3"));//创建一个带缓冲的文件流（字节流）
		BufferedOutputStream zt=new BufferedOutputStream(new FileOutputStream("D:/Bobby Tinsley - Missing You.mp3"));//创建一个带缓冲的文件输出流（字节流）括号中的为输入文件路径
		
		byte[] hc=new byte[2048];//创建一个缓冲流，该缓冲流大小为2048字节
		int aa;
		aa=fz.read(hc);//读取一个字符，read()读取一个字符，该字符默认转换成整型,读取的大小为hc（即2048字节）
		System.out.println("文件内容为：");
		while(aa!=-1){//ACSII码时从0开始的数字，只有什么都没有的时候才为-1
			System.out.print((char)aa);
			zt.write(hc,0,aa);//为防止最后一次写入异常（长度与缓冲区大小不同），所以加入从0写到aa的大小的数
			aa=fz.read(hc);//继续往下读
		}
		zt.flush();//将zt中内容全部输出
		fz.close();//关闭
		zt.close();
	}
}