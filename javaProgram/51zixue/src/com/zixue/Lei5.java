//构造方法,构造时默认调用的方法，与类同名无返回

package com.zixue;


class Cat1{
	private int age;
	private String name;
	
	//如果不写重构方法默认包含一个与类名同名的方法
	//重写构造方法，构造方法前应该无定义void或int之类的反回值，构造方法要与方法名同名
	Cat1(int age,String name){
		this.age=age;
		this.name=name;
		System.out.println("猫的名字为"+this.name+"猫的猫龄为"+this.age);//打印的是类中对象的值，而不是输入的值
	}
	
	void get(){
		System.out.println(this.age);
	}
}

public class Lei5 {
	public static void main(String[] args) {
		Cat1 one=new Cat1(2,"花子");
		one.get();
	}
}
