//转换流

package jingjie;
import java.io.*;
public class L7_6 {
	public static void main(String[] args) throws Exception{
		BufferedReader a=new BufferedReader(new InputStreamReader(System.in));//把键盘输入的字节流数据，转换成了字符流数据
		//BufferedWriter c=new BufferedWriter(new FileWriter("D:/aa.text"));创建一个输入字节流，保存的路径为D:/aa.text
		String b=a.readLine();//readLine()读出来的数据是字节型的
		System.out.println(b);
	}
}
