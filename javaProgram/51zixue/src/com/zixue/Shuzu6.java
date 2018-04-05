//学生成绩系统管理

package com.zixue;
import java.util.*;

public class Shuzu6 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("请输入学生人数：");
		int n=in.nextInt();
		System.out.println("请输入学科数：");
		int num=in.nextInt();
		String[] class1=new String[num];
		String[] name=new String[n];
		int[][] array=new int[n][num];
		int[] sum=new int[n];
		int[] avg=new int[n];
		String[] line=new String[n];
		String line1="";//定义一个空白字符串
		
		//录入学科名
		for(int i=0;i<num;i++){
			System.out.println("请输入定义第"+(i+1)+"门学科的名字");
			class1[i]=in.next();
		}
		
		//录入学生名字和各科成绩		
		for(int i=0;i<n;i++){
			System.out.println("请输入第"+(i+1)+"个学生的名字");
			name[i]=in.next();
			for(int j=0;j<num;j++){
				System.out.println("请输入"+name[i]+class1[j]+"的成绩");
				array[i][j]=in.nextInt();
			}
		}
		in.close();
		
		//打印标题栏
		System.out.print("学生\t");
		for(int i=0;i<class1.length;i++){
			System.out.print(class1[i]+"\t");
		}
		System.out.print("总分\t平均分\t排行版");
		System.out.println();
		
		//汇总数据
		for(int i=0;i<n;i++){			
			for(int j=0;j<num;j++){
				sum[i]+=array[i][j];
				line1+=array[i][j]+"\t";//把分数汇总到一个line1数组中
			}
			avg[i]=sum[i]/num;
			line[i]=name[i]+"\t"+line1+sum[i]+"\t"+avg[i];//把要显示的学生名字和成绩汇总到一行	
			line1="";//清空line1里的组距以便循环中继续使用
		}
		
		//计算排名并打印
		for (int i=0;i<n;i++){
			for(int j=0;j<n-1;j++){
				if(sum[j]<sum[j+1]){//如果总分比后面的数小，则总分互换，整行也对应互换
					int t1=sum[j];		String t2=line[j];
					sum[j]=sum[j+1];	line[j]=line[j+1];	
					sum[j+1]=t1;		line[j+1]=t2;
				}
			}
			System.out.println(line[i]+"\t"+"第"+(i+1)+"名");
		}
		
	}
}
