package jingjie;
import java.io.*;
public class L7_9 {
	public static void main(String[] args){
		File a=new File("D:/java/L7_9/aa.txt");//�����ļ�������û���������ʵ���ϲ����ڵ�
		if(a.exists()){//�ж��ļ��Ƿ����
			System.out.println(a.getAbsolutePath());//��ӡ�ļ�ȫ·��
			System.out.println(a.canRead());//�ж��ļ��Ƿ�ɶ�
			System.out.println(a.canWrite());//�ж��ļ��Ƿ��д			
		}else{
			System.out.println("�ļ������ڣ���");
			try {
				System.out.println("�������ļ�aa");
				a.createNewFile();//ֻ�ܴ����ļ������Ǹ��ļ����ļ����У����ļ��в����ڣ����Կ������У����Ǵ���������,
								  //��������һ�ε�ʱ���ļ��������ˣ�ֻ�Ǵ������ļ��У�������һ�ξͷ����ļ�����������
				} catch (IOException e) {
			}
		}
		
		File b=new File("D:/java/L7_9");//�����ļ���
		if(b.isDirectory()){
			System.out.println("���ļ����Ѿ�����");
			File b1[]=b.listFiles();//����һ���ļ����飬��������b�ļ����е������ļ����
			for(int i=0;i<b1.length;i++){
				System.out.println("���ļ����е��ļ�·��Ϊ"+b1[i]);//��ӡ�ļ�·��
				System.out.println("���ļ����е��ļ���Ϊ"+b1[i].getName());//��ӡ�����ļ���
			}
		}else{
			System.out.println("�ļ��в����ڣ��������ļ���L7_9");
			b.mkdir();//�����ļ���
		}
	}
}
