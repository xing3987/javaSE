//���캯���Ĵ������໥��ĵ��ã����췽����������ͬ���ķ��������޷���ֵ�������ж�������ڳ�ʼ����


package com.zixue;

public class Gouzao {
	public static void main(String[] args){
		Student a=new Student("С��");
		System.out.println(a.name);
		Student b=new Student("С��",13);
		System.out.println(b.name);
		Student c=new Student("Сè",13,"����");
		System.out.println(c.name);
	}
}

class Student{
	String name;
	int age;
	static String road;
	String country;//��ֵ��̬�������ñ���Ϊ��������
	Student(String name){
		this.name=name;
	}
	
	Student(String name,int age){
		this(name);//��this()���ù��췽���е��������췽��
		this.age=age;
	}
	
	Student(String name,int age,String country){
		this(name,age);//��this()���ù��췽���е��������췽��
		this.country=country;
	}
	
	static void buy(){//��̬������ʹ�õĶ������Ҳ�Ǿ�̬��
		String aa="���";//���Դ����ֲ�����
		System.out.println(road);//ֻ��ʹ�þ�̬�ĳ�Ա����
		System.out.println(aa);
	}
	
	{
		System.out.println("���Ƿ����Ĺ������飬Ϊÿ���������õĲ��֣�ÿ����һ������������ִ�У�������ʼ�����췽��");
	}
}
