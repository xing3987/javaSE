//���ݵĴ���long,string �������ݵĴ���

package jingjie;
import java.io.*;
public class L7_4 {
	public static void main(String[] args) throws Exception{
		
		long sj=121545454;//����һ�������͵�ֵ
		//ת��Ϊ�ֽ����ݣ�ע��byte�����date���������������ģ�
		ByteArrayOutputStream bytearray=new ByteArrayOutputStream();//����һ��byte����
		DataOutputStream data=new DataOutputStream(bytearray);//��byte��������һ�����ݣ��������Ǽ��������ʶ��Ķ�����ģʽ
		data.writeLong(sj);//�Ѵ�������long������д��data�У�ͬʱҲ�ᴫ��bytearray��,date�ǿ����ü������д���͵�����
		byte[] bytes=bytearray.toByteArray();//��bytearray�н��յ�������ת����byte�͵�����
		
		byte[] clone=bytes.clone();//ģ�����ݴ���
		
		//���ݵĶ�ȡ��ע��byte�����date���������������ģ�
		ByteArrayInputStream bytearray1=new ByteArrayInputStream(clone);//�ý���������clone�����������ݣ����浽��������
		DataInputStream date1=new DataInputStream(bytearray1);
		long save;//����һ�����ڽ��յ�Long�ͱ���
		save=date1.readLong();//��data1�ж�ȡ������
		System.out.println("save="+save);
		
		//�ر�������Լ�ڴ�
		bytearray.close();
		data.close();
		date1.close();
		bytearray1.close();
	}
}
