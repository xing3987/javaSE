//��ά����

package com.zixue;

public class Shuzu5 {
	public static void main(String[] args) {
		int[][] array=new int[3][];//����һ������3����ά����Ķ�ά����
		array[0]=new int[3];//������һ����ά�����к���3������
		array[1]=new int[5];
		array[2]=new int[4];
		for(int i=0;i<array[0].length;i++){
			array[0][i]=i+5;
		}
		for(int i=0;i<array[0].length;i++){
			System.out.print(array[0][i]);
		}
	}
}
