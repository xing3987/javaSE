//构造函数的创建和相互间的调用（构造方法就是与类同名的方法，它无返回值，可以有多个，用于初始化）


package com.zixue;

public class Gouzao {
	public static void main(String[] args){
		Student a=new Student("小王");
		System.out.println(a.name);
		Student b=new Student("小狗",13);
		System.out.println(b.name);
		Student c=new Student("小猫",13,"外星");
		System.out.println(c.name);
	}
}

class Student{
	String name;
	int age;
	static String road;
	String country;//赋值静态变量，该变量为公共变量
	Student(String name){
		this.name=name;
	}
	
	Student(String name,int age){
		this(name);//用this()调用构造方法中的其他构造方法
		this.age=age;
	}
	
	Student(String name,int age,String country){
		this(name,age);//用this()调用构造方法中的其他构造方法
		this.country=country;
	}
	
	static void buy(){//静态方法中使用的对象必须也是静态的
		String aa="你好";//可以创建局部变量
		System.out.println(road);//只能使用静态的成员变量
		System.out.println(aa);
	}
	
	{
		System.out.println("这是方法的构造代码块，为每个方法公用的部分，每调用一个方法都会先执行，用来初始化构造方法");
	}
}
