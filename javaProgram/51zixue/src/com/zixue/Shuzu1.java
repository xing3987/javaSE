package com.zixue;
import java.util.*;
public class Shuzu1 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("������ѧ����");
		int num=in.nextInt();
		int array[]=new int[num];
		int sum=0;
		for(int i=0;i<array.length;i++){
			System.out.println("�������"+(i+1)+"��ѧ���ɼ�");
			array[i]=in.nextInt();
			sum+=array[i];
		}
		System.out.println("ѧ���ܳɼ�Ϊ"+sum);
		System.out.println("ѧ��ƽ���ɼ�Ϊ"+sum/num);
		in.close();
		
		int max=0;int n=0;
		for (int i=0;i<array.length;i++){
			if(array[i]>max){
				max=array[i];
				n=i;
			}
		}
		System.out.println("ѧ����߷�Ϊ��"+(n+1)+"��ͬѧ"+max+"��");
	}
}