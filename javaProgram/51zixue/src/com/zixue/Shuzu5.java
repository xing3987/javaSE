//多维数组

package com.zixue;

public class Shuzu5 {
	public static void main(String[] args) {
		int[][] array=new int[3][];//声明一个含有3个二维数组的多维数组
		array[0]=new int[3];//声明第一个二维数组中含有3个数据
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
