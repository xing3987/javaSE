//ѧ���ɼ�ϵͳ����

package com.zixue;
import java.util.*;

public class Shuzu6 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("������ѧ��������");
		int n=in.nextInt();
		System.out.println("������ѧ������");
		int num=in.nextInt();
		String[] class1=new String[num];
		String[] name=new String[n];
		int[][] array=new int[n][num];
		int[] sum=new int[n];
		int[] avg=new int[n];
		String[] line=new String[n];
		String line1="";//����һ���հ��ַ���
		
		//¼��ѧ����
		for(int i=0;i<num;i++){
			System.out.println("�����붨���"+(i+1)+"��ѧ�Ƶ�����");
			class1[i]=in.next();
		}
		
		//¼��ѧ�����ֺ͸��Ƴɼ�		
		for(int i=0;i<n;i++){
			System.out.println("�������"+(i+1)+"��ѧ��������");
			name[i]=in.next();
			for(int j=0;j<num;j++){
				System.out.println("������"+name[i]+class1[j]+"�ĳɼ�");
				array[i][j]=in.nextInt();
			}
		}
		in.close();
		
		//��ӡ������
		System.out.print("ѧ��\t");
		for(int i=0;i<class1.length;i++){
			System.out.print(class1[i]+"\t");
		}
		System.out.print("�ܷ�\tƽ����\t���а�");
		System.out.println();
		
		//��������
		for(int i=0;i<n;i++){			
			for(int j=0;j<num;j++){
				sum[i]+=array[i][j];
				line1+=array[i][j]+"\t";//�ѷ������ܵ�һ��line1������
			}
			avg[i]=sum[i]/num;
			line[i]=name[i]+"\t"+line1+sum[i]+"\t"+avg[i];//��Ҫ��ʾ��ѧ�����ֺͳɼ����ܵ�һ��	
			line1="";//���line1�������Ա�ѭ���м���ʹ��
		}
		
		//������������ӡ
		for (int i=0;i<n;i++){
			for(int j=0;j<n-1;j++){
				if(sum[j]<sum[j+1]){//����ֱܷȺ������С�����ֻܷ���������Ҳ��Ӧ����
					int t1=sum[j];		String t2=line[j];
					sum[j]=sum[j+1];	line[j]=line[j+1];	
					sum[j+1]=t1;		line[j+1]=t2;
				}
			}
			System.out.println(line[i]+"\t"+"��"+(i+1)+"��");
		}
		
	}
}
