package com.zixue;

abstract class Demo{
	public final void getTime(){//模块方法，不能被覆盖
		long start=System.currentTimeMillis();//得到系统当前时间1s等于1000ms,数值为长整型
		function();
		long end=System.currentTimeMillis();
		System.out.println("程序运行花费时间为"+(end-start)+"毫秒");
	}
	public abstract void function();
	
}

class Text extends Demo{
	public void function(){
		for(int i=0;i<666;i++){
		System.out.println("好好学习");
		System.out.println("天天向上");
		}
	}
}
public class DuotaiUse {
	public static void main(String[] args){
		Text a=new Text();
		a.getTime();
	}	
}
