//IO������������ʹ��

package jingjie;
import java.io.*;
public class L7_3 {
	public static void main(String[] args) throws Exception{//����IO��ʱҪ���쳣
		BufferedInputStream fz=new BufferedInputStream(new FileInputStream("G:/music/Bobby Tinsley - Missing You.mp3"));//����һ����������ļ������ֽ�����
		BufferedOutputStream zt=new BufferedOutputStream(new FileOutputStream("D:/Bobby Tinsley - Missing You.mp3"));//����һ����������ļ���������ֽ����������е�Ϊ�����ļ�·��
		
		byte[] hc=new byte[2048];//����һ�����������û�������СΪ2048�ֽ�
		int aa;
		aa=fz.read(hc);//��ȡһ���ַ���read()��ȡһ���ַ������ַ�Ĭ��ת��������,��ȡ�Ĵ�СΪhc����2048�ֽڣ�
		System.out.println("�ļ�����Ϊ��");
		while(aa!=-1){//ACSII��ʱ��0��ʼ�����֣�ֻ��ʲô��û�е�ʱ���Ϊ-1
			System.out.print((char)aa);
			zt.write(hc,0,aa);//Ϊ��ֹ���һ��д���쳣�������뻺������С��ͬ�������Լ����0д��aa�Ĵ�С����
			aa=fz.read(hc);//�������¶�
		}
		zt.flush();//��zt������ȫ�����
		fz.close();//�ر�
		zt.close();
	}
}