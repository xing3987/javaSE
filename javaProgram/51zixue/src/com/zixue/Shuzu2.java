
package com.zixue;
//����Ӣ����ĸ�����򲢲���

import java.util.*;
public class Shuzu2 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("��������ĸ��");
		int num=in.nextInt();
		String array[]=new String[num];
		for(int i=0;i<array.length;i++){
			System.out.println("�������"+(i+1)+"����ĸ");
			array[i]=in.next();
		}
		
		Arrays.sort(array);//�������С��������
		for (int i=0;i<array.length;i++){
			System.out.print(array[i]+"\t");
		}
		System.out.println("");
	//������Ӵ�С��ӡ
		for (int i=array.length-1;i>=0;i--){
			System.out.print(array[i]+"\t");
		}		
		System.out.println("");
	//�����������Ƿ���һ���������ĸ	
		System.out.println("������Ҫ���ҵ���ĸ");
		String x=in.next();
		boolean flag=false;
		for (int i=0;i<array.length;i++){
			if(x.equals(array[i])){//���ú���equals()�ж�x�Ƿ��������е�����ͬ
				flag=true;
				break;
			}
		}
		if(flag==true){
			System.out.println("����������Ҫ����ĸ");
		}else{
			System.out.println("������û����Ҫ����ĸ");
		}
		
		in.close();
		
		System.out.println("");
	}
}