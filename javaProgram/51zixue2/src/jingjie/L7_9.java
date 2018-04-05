package jingjie;
import java.io.*;
public class L7_9 {
	public static void main(String[] args){
		File a=new File("D:/java/L7_9/aa.txt");//创建文件，但是没有输出所以实际上不存在的
		if(a.exists()){//判断文件是否存在
			System.out.println(a.getAbsolutePath());//打印文件全路径
			System.out.println(a.canRead());//判断文件是否可读
			System.out.println(a.canWrite());//判断文件是否可写			
		}else{
			System.out.println("文件不存在！！");
			try {
				System.out.println("创建新文件aa");
				a.createNewFile();//只能创建文件，但是该文件在文件夹中（该文件夹不存在）所以可以运行，但是创建不出来,
								  //所以运行一次的时候文件创建不了，只是创建了文件夹，再运行一次就发现文件创建出来了
				} catch (IOException e) {
			}
		}
		
		File b=new File("D:/java/L7_9");//创建文件夹
		if(b.isDirectory()){
			System.out.println("该文件夹已经存在");
			File b1[]=b.listFiles();//创建一个文件数组，该数据由b文件夹中的所有文件组成
			for(int i=0;i<b1.length;i++){
				System.out.println("该文件夹中的文件路径为"+b1[i]);//打印文件路径
				System.out.println("该文件夹中的文件名为"+b1[i].getName());//打印所有文件名
			}
		}else{
			System.out.println("文件夹不存在，创建新文件夹L7_9");
			b.mkdir();//创建文件夹
		}
	}
}
