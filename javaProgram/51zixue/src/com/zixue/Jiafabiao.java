package com.zixue;
import java.util.*;
public class Jiafabiao {
	public static void main(String[] args) {
		Scanner a=new Scanner(System.in);
		System.out.println("请输入一个数");
		int number=a.nextInt();
		for(int i=0,j=number;i<=number;i++){
			System.out.println(i+"+"+j+"="+number);
			j--;
		}
		a.close();
	}
}
