package com.zixue;
import java.util.*;
public class Shuzu {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("请输入学生数");
		int num=in.nextInt();
		int array[]=new int[num];
		int sum=0;
		for(int i=0;i<array.length;i++){
			System.out.println("请输入第"+(i+1)+"个学生成绩");
			array[i]=in.nextInt();
			sum+=array[i];
		}
		System.out.println("学生总成绩为"+sum);
		System.out.println("学生平均成绩为"+sum/num);
		in.close();
	}
}
