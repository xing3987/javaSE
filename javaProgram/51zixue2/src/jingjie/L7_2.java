//IO�����ֽ�����ʹ��

package jingjie;
import java.io.*;
public class L7_2 {
	public static void main(String[] args) throws Exception{//����IO��ʱҪ���쳣
		//ʹ���ַ������Ƹ�������Ƶ����Ƶ�ļ���ʱ����Ȼ�Ḵ�Ƶ��ǲ��Ų��ˣ��������ֽ����ܳɹ�����
		//	FileReader fz=new FileReader("G:/music/Bobby Tinsley - Missing You.mp3");//����һ���ļ������ַ�����
		//	FileWriter zt=new FileWriter("D:/Bobby Tinsley - Missing You.mp3");//����һ���ļ���������ַ����������е�Ϊ�����ļ�·��
		FileInputStream fz=new FileInputStream("G:/music/Bobby Tinsley - Missing You.mp3");//����һ���ļ������ֽ�����
		FileOutputStream zt=new FileOutputStream("D:/Bobby Tinsley - Missing You.mp3");//����һ���ļ���������ֽ����������е�Ϊ�����ļ�·��

		int aa;
		aa=fz.read();//��ȡһ���ַ���read()��ȡһ���ַ������ַ�Ĭ��ת��������
		System.out.println("�ļ�����Ϊ��");
		while(aa!=-1){//ACSII��ʱ��0��ʼ�����֣�ֻ��ʲô��û�е�ʱ���Ϊ-1
			System.out.print((char)aa);
			zt.write(aa);
			aa=fz.read();//�������¶�
		}
		zt.flush();//��zt������ȫ�����
		fz.close();//�ر�
		zt.close();
	}
}
