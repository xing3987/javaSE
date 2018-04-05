package com.zixue;

public class Lei1 {
	public static void main(String[] args){
		Person MyPerson=new Person();
		MyPerson.name="张三";
		System.out.println(MyPerson.name);
		MyPerson.eat();//调用无参数无返回方法
		MyPerson.sleep("树上");//调用有参数无返回的方法
		int age=MyPerson.getAge(18);//调用有参数有返回的方法
		System.out.println(age);
		
		System.out.println(MyPerson.gender);//成员变量String型未赋值时默认为NULL
	}
}
