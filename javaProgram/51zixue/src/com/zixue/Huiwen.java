package com.zixue;
import java.util.*;
public class Huiwen {

	public static void main(String[] args) {
		Scanner a=new Scanner(System.in);
		System.out.println("请输入一个数");
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
			System.out.println("是回文数");
		}else{
			System.out.println("不是回文数");
		}
		a.close();//关闭输入框，节约内存防报错
	}

}
