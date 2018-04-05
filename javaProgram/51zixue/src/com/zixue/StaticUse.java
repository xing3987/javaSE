//static 静态变量，静态方法的使用


package com.zixue;

public class StaticUse {
	public static void main(String[] args){
	/*	Student a=new Student("小兔");
		a.road="中国";
		Student b=new Student("小红");
		System.out.println(b.road);					 //实际使用时可以用Student.country访问静态变量
		Student.buy();								*/
		Tree.gogogo();
	}
}

class Tree{
	String name;
	int age;
	static String country;//赋值静态变量，该变量为公共变量
	Tree(String name){
		this.name=name;
	}
	
	Tree(String name,int age){
		this(name);//用this()调用构造方法中的其他构造方法
		this.age=age;
	}
	
	static void gogogo(){
		System.out.println("gogogo");
	}
	
}