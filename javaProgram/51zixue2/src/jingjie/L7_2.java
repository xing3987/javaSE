//IO流，字节流的使用

package jingjie;
import java.io.*;
public class L7_2 {
	public static void main(String[] args) throws Exception{//调用IO流时要抛异常
		//使用字符流复制歌曲（音频和视频文件）时，虽然会复制但是播放不了，但是用字节流能成功复制
		//	FileReader fz=new FileReader("G:/music/Bobby Tinsley - Missing You.mp3");//创建一个文件流（字符流）
		//	FileWriter zt=new FileWriter("D:/Bobby Tinsley - Missing You.mp3");//创建一个文件输出流（字符流）括号中的为输入文件路径
		FileInputStream fz=new FileInputStream("G:/music/Bobby Tinsley - Missing You.mp3");//创建一个文件流（字节流）
		FileOutputStream zt=new FileOutputStream("D:/Bobby Tinsley - Missing You.mp3");//创建一个文件输出流（字节流）括号中的为输入文件路径

		int aa;
		aa=fz.read();//读取一个字符，read()读取一个字符，该字符默认转换成整型
		System.out.println("文件内容为：");
		while(aa!=-1){//ACSII码时从0开始的数字，只有什么都没有的时候才为-1
			System.out.print((char)aa);
			zt.write(aa);
			aa=fz.read();//继续往下读
		}
		zt.flush();//将zt中内容全部输出
		fz.close();//关闭
		zt.close();
	}
}
