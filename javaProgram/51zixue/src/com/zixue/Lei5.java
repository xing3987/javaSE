//���췽��,����ʱĬ�ϵ��õķ���������ͬ���޷���

package com.zixue;


class Cat1{
	private int age;
	private String name;
	
	//�����д�ع�����Ĭ�ϰ���һ��������ͬ���ķ���
	//��д���췽�������췽��ǰӦ���޶���void��int֮��ķ���ֵ�����췽��Ҫ�뷽����ͬ��
	Cat1(int age,String name){
		this.age=age;
		this.name=name;
		System.out.println("è������Ϊ"+this.name+"è��è��Ϊ"+this.age);//��ӡ�������ж����ֵ�������������ֵ
	}
	
	void get(){
		System.out.println(this.age);
	}
}

public class Lei5 {
	public static void main(String[] args) {
		Cat1 one=new Cat1(2,"����");
		one.get();
	}
}
