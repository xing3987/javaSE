package com.zixue;
import java.util.*;
public class SuijiChengji {
	public static void main(String[] args) {
		Scanner a=new Scanner(System.in);
		System.out.println("������Сѧ����");
		int n=a.nextInt();
		int avg=0;int sum=0;
		for(int i=1;i<=n;i++){
			int y=(int)(Math.random()*100);//Math.random()Ϊ�������0-1��������С��
			sum=sum+y;
			System.out.println("��"+i+"��ѧ���ɼ�Ϊ"+y);			
		}	
		avg=sum/n;
		System.out.println("ƽ���ɼ�Ϊ"+avg);				
		a.close();
	}	
}
