//print����data��
package jingjie;
import java.io.*;
public class L7_5 {
	public static void main(String[] args) throws Exception{
		DataOutputStream data=new DataOutputStream(new FileOutputStream("D:/java/L7_5.txt"));//�������������趨����·��
		data.writeLong(15412);//������д���ļ��У����ļ��ᷢ���ǲ���ȷ���ݣ���Ϊdata��������Ƕ��������ݣ������ʹ�õ����ݣ���data��д�뷽��Ϊwrite*()
		data.close();
		
		PrintStream ps=new PrintStream(new FileOutputStream("D:/java/L7_5_1.txt"));//����һ����ӡ�����趨·��
		ps.println(26587);//print����д�뷽��println
		System.setOut(ps);//���������·��Ϊps���е��ļ���
		System.out.println("hello world!");//������������ݲ��ڿ���̨��ʾ�����ļ���
		ps.close();		
		
	}
}
