package com.zixue;

class Cat{
	String name;
	int age;
	String color;
	public void Set(String a,int age,String c){
		this.name=a;//ʹ�ò����¶������еĶ���
		this.age=age;//this ���Խ�����뷽������������
		this.color=c;
	}
	public String toString(){
		return "����"+name+"\t����"+age+"\t��ɫ"+color;
	}
	
	public Cat a(){
		return this;//����Cat�����еĶ���
	}
}

public class Lei3 {
	public static void main(String[] args) {
		Cat one=new Cat();
		Cat two=new Cat();
		Cat three=new Cat();
		one.Set("��һֻè", 12, "��ɫ");
		System.out.println(one);//ֱ��д������Ĭ�ϵ���ToString����
		two.Set("�ڶ�ֻè", 3, "��ɫ");
		System.out.println(two);
		three=two.a();//����two�еķ���a()�õ�two�Ķ����������ֵ
		System.out.println(three);
	}
}
