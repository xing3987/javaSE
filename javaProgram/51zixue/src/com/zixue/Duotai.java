/*��̬��ʹ��
	1:����ʱ���ĵ��������ͱ������������Ƿ��е��õķ���
	2�������ڼ���Ķ����������еķ���
	3����̬��ǰ�᣺a:�����������֮ǰ���ڹ�ϵ�������Ǽ̳й�ϵ��Ҳ������ʵ�ֹ�ϵ
			  b:���������д
*/
package com.zixue;

class Animal{
	void sing(){
		System.out.println("����");
	}
}

class Cat2 extends Animal{
	void sing(){
		System.out.println("�����ĳ���");
	}
}

class Dog1 extends Animal{
	void sing(){
		System.out.println("�����ĳ���");
	}
}

class Pig extends Animal{

	
}


public class Duotai {
	public static void main(String[] args){
		Cat2 a=new Cat2();
		function(a);
		Dog1 b=new Dog1();
		function(b);
		Pig c=new Pig();
		function(c);//���ö�̬ʱ�����಻��д��ֱ�ӵ��ø���ĺ���
	}
	
	public static void function(Animal a){//��̬����
		a.sing();
	}
}
