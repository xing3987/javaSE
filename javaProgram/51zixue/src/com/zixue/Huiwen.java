package com.zixue;
import java.util.*;
public class Huiwen {

	public static void main(String[] args) {
		Scanner a=new Scanner(System.in);
		System.out.println("������һ����");
		int number=a.nextInt();
		int x=number;
		int c=0;
		while (number!=0){
		    int b=number%10;
			c=c*10+b;
			number=number/10;
		}
		System.out.println(c);
		if(c==x){
			System.out.println("�ǻ�����");
		}else{
			System.out.println("���ǻ�����");
		}
		a.close();//�ر�����򣬽�Լ�ڴ������
	}

}
