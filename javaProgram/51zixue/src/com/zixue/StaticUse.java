//static ��̬��������̬������ʹ��


package com.zixue;

public class StaticUse {
	public static void main(String[] args){
	/*	Student a=new Student("С��");
		a.road="�й�";
		Student b=new Student("С��");
		System.out.println(b.road);					 //ʵ��ʹ��ʱ������Student.country���ʾ�̬����
		Student.buy();								*/
		Tree.gogogo();
	}
}

class Tree{
	String name;
	int age;
	static String country;//��ֵ��̬�������ñ���Ϊ��������
	Tree(String name){
		this.name=name;
	}
	
	Tree(String name,int age){
		this(name);//��this()���ù��췽���е��������췽��
		this.age=age;
	}
	
	static void gogogo(){
		System.out.println("gogogo");
	}
	
}