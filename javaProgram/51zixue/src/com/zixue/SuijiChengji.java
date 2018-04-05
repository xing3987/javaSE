package com.zixue;
import java.util.*;
public class SuijiChengji {
	public static void main(String[] args) {
		Scanner a=new Scanner(System.in);
		System.out.println("请输入小学生数");
		int n=a.nextInt();
		int avg=0;int sum=0;
		for(int i=1;i<=n;i++){
			int y=(int)(Math.random()*100);//Math.random()为随机生成0-1的数包含小数
			sum=sum+y;
			System.out.println("第"+i+"个学生成绩为"+y);			
		}	
		avg=sum/n;
		System.out.println("平均成绩为"+avg);				
		a.close();
	}	
}
