//创建类

package com.zixue;

public class Person {
	
	//定义成员变量
	String name;
	String gender;
	int age;
	
	//定义无参数无返回方法
	public void eat(){
		System.out.println("我在吃放");
	}
	
	//定义有参数无返回方法
	public void sleep(String A){//void 为无返回的意思
		System.out.println("我在"+A+"睡觉");
	}
	
	
	//定义有参有返回方法
	public int getAge(int a){//返回类型为int,方法为取值方法--get+N；赋值方法set+N
		return a;//返回参数为a
	}
	
}
