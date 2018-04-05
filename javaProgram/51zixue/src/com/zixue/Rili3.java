//输入相隔年月日，判断之间相隔天数

package com.zixue;
import java.util.*;
public class Rili3 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int sum1=0;int sum2=0;int sum=0;
		System.out.println("请输入开始年");
		int year1=in.nextInt();
		System.out.println("请输入开始月");
		int month1=in.nextInt();
		System.out.println("请输入开始日");
		int day1=in.nextInt();		
		System.out.println("请输入结束年");
		int year2=in.nextInt();
		System.out.println("请输入结束月");
		int month2=in.nextInt();
		System.out.println("请输入结束日");
		int day2=in.nextInt();
		
		if (year2==year1){//如果是同一年则计算两个日期距离1月1日的天数，互减得到天数
			for(;month1>0;month1--){
			switch(month1-1){
				case 0:
					break;
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				    sum1=sum1+31;
				    break;
				case 4:
				case 6:
				case 9:
				case 11:
					sum1=sum1+30;
					break;
				case 2:
					if(year1%4==0&&year1%100!=0||year1%400==0){
						sum1=sum1+29;
					}else{
						sum1=sum1+28;
					}
					break;
			}
			
			}
			sum1=sum1+day1;
			for(;month2>0;month2--){
			switch(month2-1){
				case 0:
					break;
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				    sum2=sum2+31;
				    break;
				case 4:
				case 6:
				case 9:
				case 11:
					sum2=sum2+30;
					break;
				case 2:
					if(year1%4==0&&year1%100!=0||year1%400==0){
						sum2=sum2+29;
					}else{
						sum2=sum2+28;
					}
					break;
			}
			
			}
			sum2=sum2+day2;
			sum=sum2-sum1;
			System.out.println("两个日期间相差"+sum+"天");
		}else if(year2>year1){//两个日期不是同一年的话，计算第一年距离年末的时间，加上中间年数的时间，加上末年离末年年初的时间及相隔日期
			for(;month1>0;month1--){
			switch(month1-1){
				case 0:
					break;
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				    sum1=sum1+31;
				    break;
				case 4:
				case 6:
				case 9:
				case 11:
					sum1=sum1+30;
					break;
				case 2:
					if(year1%4==0&&year1%100!=0||year1%400==0){
						sum1=sum1+29;
					}else{
						sum1=sum1+28;
					}
					break;
			}
			
			}
			sum1=sum1+day1;//第一年距离年初的时间
			if(year1%4==0&&year1%100!=0||year1%400==0){//第一年是闰年或者平年距离年末的时间
				sum1=366-sum1;
			}else{
				sum1=365-sum1;
			}
					
			for(;month2>0;month2--){
			switch(month2-1){
				case 0:
					break;
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				    sum2=sum2+31;
				    break;
				case 4:
				case 6:
				case 9:
				case 11:
					sum2=sum2+30;
					break;
				case 2:
					if(year1%4==0&&year1%100!=0||year1%400==0){
						sum2=sum2+29;
					}else{
						sum2=sum2+28;
					}
					break;
			}
			
			}
			sum2=sum2+day2;

				for(;year1+1<year2;year1++){
					if((year1+1)%4==0&&(year1+1)%100!=0||(year1+1)%400==0){
						sum+=366;
					}else{
						sum+=365;
					}
				}
				sum+=sum2+sum1;
				System.out.println("两个日期间相差"+sum+"天");
			
		}
		in.close();


	}
}
