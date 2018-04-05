//求输入两年间隔多少天，润年366天，平年365天

package com.zixue;
import java.util.*;
public class Rili2 {
	public static void main(String[] args) {
		Scanner a=new Scanner(System.in);
		int sum=0;
		System.out.println("开始年");
		int b=a.nextInt();
		System.out.println("结束年");
		int c=a.nextInt();
		for(int i=b;i<c;i++){
			if(i%4==0&&i%100!=0||i%400==0){
				sum+=366;//sum=sum+366
			}else{
				sum=sum+365;
			}
		}
		
		System.out.println("总共"+sum+"天");
		a.close();
	}
}
