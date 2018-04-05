//Object��,�ļ��������ļ����ݵĴ���

package jingjie;
import java.io.*;
public class L7_8 {
	public static void main(String[] args) throws Exception{
		ObjectOutputStream obout=null;
		ObjectInputStream obin=null;
		Teacher one=new Teacher("��è��",001,99.15f);
		Teacher two=null;
		try{
			FileOutputStream file=new FileOutputStream("D:/java/L7_8.txt");//����һ��������ļ�������·��FileOutputStream
			obout=new ObjectOutputStream(file);//������Ӧ�ĵļ��ļ��������ļ����Ǽ�����ڲ����ʽ�ģ����ڴ�������
			obout.writeObject(one);//������д���ļ����У�ʹ��writeObject()����
			
			obin=new ObjectInputStream(new FileInputStream("D:/java/L7_8.txt"));//����������ļ���������������ļ�·��FileInputStream
			two=(Teacher)obin.readObject();//�ѽ��յ��ļ���ת����Teacher�ഫ��two��    readObject()��ȡ���ݣ�����ע����Ҫǿ��ת�����ͣ���Ȼ��ȡ����Object������
			System.out.println(two.getName());
			System.out.println(two.getNumber());
			System.out.println(two.getPoint());
			
		}catch(Exception e){
			System.out.println("���ִ���");
		}
		finally//����������Ƿ��쳣����ִ�У�����֮ǰ��try--catch����в������˳��������䣬���Ǹ����������try-catch�ṹʱ��ÿ���ж�Ҫ�йرյ���䣬�����쳣�����������˳���
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

class Teacher implements Serializable{//�սӿڣ��κ�����ֻҪʵ����Serializable�ӿڣ��Ϳ��Ա����浽�ļ��У�������Ϊ������ͨ�����緢�͵���ĵط���Ҳ�����ùܵ������䵽ϵͳ�����������С������Ӽ���ļ��������ơ�
	private String name;
	private int number;
	private transient float point;//transient�������ǲ��ܽ������ݣ�ʹ�������峣��ʱ�����ղ�������
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