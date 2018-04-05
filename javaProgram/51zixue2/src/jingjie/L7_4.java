//数据的传输long,string 类型数据的传输

package jingjie;
import java.io.*;
public class L7_4 {
	public static void main(String[] args) throws Exception{
		
		long sj=121545454;//传入一个长整型的值
		//转换为字节数据（注意byte数组和date数组是两个共生的）
		ByteArrayOutputStream bytearray=new ByteArrayOutputStream();//生成一个byte数组
		DataOutputStream data=new DataOutputStream(bytearray);//把byte数组打包成一个数据，该数据是计算机可以识别的二进制模式
		data.writeLong(sj);//把传送来的long型数据写入data中，同时也会传到bytearray中,date是可以用计算机读写传送的数据
		byte[] bytes=bytearray.toByteArray();//把bytearray中接收到的数据转换成byte型的数据
		
		byte[] clone=bytes.clone();//模拟数据传输
		
		//数据的读取（注意byte数组和date数组是两个共生的）
		ByteArrayInputStream bytearray1=new ByteArrayInputStream(clone);//用接收流接收clone传输来的数据，保存到数据流中
		DataInputStream date1=new DataInputStream(bytearray1);
		long save;//创建一个用于接收的Long型变量
		save=date1.readLong();//从data1中读取出数据
		System.out.println("save="+save);
		
		//关闭流，节约内存
		bytearray.close();
		data.close();
		date1.close();
		bytearray1.close();
	}
}
