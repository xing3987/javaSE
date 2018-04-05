
package com.zixue;
//输入英文字母，排序并查找

import java.util.*;
public class Shuzu2 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("请输入字母数");
		int num=in.nextInt();
		String array[]=new String[num];
		for(int i=0;i<array.length;i++){
			System.out.println("请输入第"+(i+1)+"个字母");
			array[i]=in.next();
		}
		
		Arrays.sort(array);//将数组从小到大排列
		for (int i=0;i<array.length;i++){
			System.out.print(array[i]+"\t");
		}
		System.out.println("");
	//将数组从大到小打印
		for (int i=array.length-1;i>=0;i--){
			System.out.print(array[i]+"\t");
		}		
		System.out.println("");
	//查找数据中是否有一个输入的字母	
		System.out.println("请输入要查找的字母");
		String x=in.next();
		boolean flag=false;
		for (int i=0;i<array.length;i++){
			if(x.equals(array[i])){//调用函数equals()判断x是否与数组中的数相同
				flag=true;
				break;
			}
		}
		if(flag==true){
			System.out.println("数组中有你要的字母");
		}else{
			System.out.println("数组中没有你要的字母");
		}
		
		in.close();
		
		System.out.println("");
	}
}