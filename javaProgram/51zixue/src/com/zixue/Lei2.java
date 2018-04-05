package com.zixue;

class Print{
	public String print(String n){
		System.out.println(n);
		return n;//返回一个String值，不写会报错
	}
}


class Return{
	public void print1(int a){
		if(a==0){
			System.out.println("你好");
		}else if(a==1){
			return;//结束方法（前期是void无参数返回值的方法
		}
		System.out.println("我也好");
	}
}

public class Lei2 {//主类只有一个，就是public的类只有一个不然会报错
	public static void main(String[] args) {
		Print a=new Print();//调用类
		a.print("小明");//调用类中的方法
		String name=a.print("小红");//调用方法并返回值
		System.out.println(name);
		
		Return b=new Return();
		b.print1(0);
		b.print1(1);
	}
}
