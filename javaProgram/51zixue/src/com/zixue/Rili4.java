package com.zixue;
import java.util.*;
public class Rili4 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		System.out.println("�����������");
		int year=in.nextInt();
		System.out.println("�����������(1��)");
		int month=in.nextInt();
		in.close();
		//�����������1900��1��1�ն����죬�Ӷ��ж�����
		int sum1=0;
		for(int i=1;i<month;i++){
			switch(i){
				case 1:case 3:case 5:case 7:case 8:case 10:
					sum1+=31;
					break;
				case 4:case 6:case 9:case 11:
					sum1+=30;
					break;
				case 2:
					if(year%4==0&&year%100!=0||year%400==0){
						sum1+=29;
					}else{
						sum1+=28;
					}
					break;
			}
		}
		for(int i=1900;i<year;i++){
			if(i%4==0&&i%100!=0||i%400==0){
				sum1+=366;
			}else{
				sum1+=365;
			}
		}
		System.out.println("����1900��1��1��"+sum1+"��");
//���㲢��ӡ����������		
		System.out.println("��\tһ\t��\t��\t��\t��\t��\t");
		sum1++;
//�ж�����ĸ����ж�����		
		int day=0;
		switch(month){
			case 1:case 3:case 5:case 7:case 8:case 10:case 12:
				day+=31;
				break;
			case 4:case 6:case 9:case 11:
				day+=30;
				break;
			case 2:
				if(year%4==0&&year%100!=0||year%400==0){
					day+=29;
				}else{
					day+=28;
				}
				break;		 
		}
			for(int i=1;i<=(sum1%7);i++){
				System.out.print("\t");
			}
			for(int j=1;j<=day;j++,sum1++){
				if(sum1%7==6){
					System.out.print(j+"\n");
				}else{
					System.out.print(j+"\t");
				}
			}
		
	}	
}