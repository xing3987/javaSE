//IO��

package jingjie;
import java.io.*;
public class L7_1 {
	public static void main(String[] args) throws Exception{//����IO��ʱҪ���쳣
		FileReader wj=new FileReader("D:/java/51zixue2/src/jingjie/L7_1.java");//����һ���ļ������ַ�����
	//	FileInputStream wj=new FileInputStream("D:/java/51zixue2/src/jingjie/L7_1.java");//����һ���ļ������ֽ�����
									//�ֽ�������ʱһ�����ֽڶ�ȡ�������������ֽ����Զ�������������
		
		int aa;
		aa=wj.read();//��ȡһ���ַ���read()��ȡһ���ַ������ַ�Ĭ��ת��������
		System.out.println("�ļ�����Ϊ��");
		while(aa!=-1){//ACSII��ʱ��0��ʼ�����֣�ֻ��ʲô��û�е�ʱ���Ϊ-1
			System.out.print((char)aa);
			aa=wj.read();//�������¶�
		}
		wj.close();//�ر�
	}
}
