//Object流,文件流用于文件数据的传输

package jingjie;
import java.io.*;
public class L7_8 {
	public static void main(String[] args) throws Exception{
		ObjectOutputStream obout=null;
		ObjectInputStream obin=null;
		Teacher one=new Teacher("大猫子",001,99.15f);
		Teacher two=null;
		try{
			FileOutputStream file=new FileOutputStream("D:/java/L7_8.txt");//创建一个输出的文件并设置路径FileOutputStream
			obout=new ObjectOutputStream(file);//创建对应文的件文件流，该文件流是计算机内部码格式的，用于传输数据
			obout.writeObject(one);//把数据写入文件流中，使用writeObject()方法
			
			obin=new ObjectInputStream(new FileInputStream("D:/java/L7_8.txt"));//创建输入的文件流并设置输入的文件路径FileInputStream
			two=(Teacher)obin.readObject();//把接收的文件流转换成Teacher类传给two，    readObject()读取数据，这里注意需要强制转换类型，不然读取的是Object型数据
			System.out.println(two.getName());
			System.out.println(two.getNumber());
			System.out.println(two.getPoint());
			
		}catch(Exception e){
			System.out.println("出现错误");
		}
		finally//该语句无论是否异常都会执行，所以之前的try--catch语句中不能有退出程序的语句，但是该语句里面有try-catch结构时，每个中都要有关闭的语句，用于异常后程序的正常退出；
		{
			try{
				obout.close();
				obin.close();
				System.exit(-1);
			}catch(Exception e){
				System.exit(-1);
			}
		}

	}
}

class Teacher implements Serializable{//空接口，任何类型只要实现了Serializable接口，就可以被保存到文件中，或者作为数据流通过网络发送到别的地方。也可以用管道来传输到系统的其他程序中。这样子极大的简化了类的设计。
	private String name;
	private int number;
	private transient float point;//transient的作用是不能接收数据，使用它定义常量时，接收不到数据
	public Teacher(String name,int number,float point){
		this.name=name;this.number=number;this.point=point;
	}
	public String getName() {
		return name;
	}
	public int getNumber() {
		return number;
	}
	public float getPoint() {
		return point;
	}
}