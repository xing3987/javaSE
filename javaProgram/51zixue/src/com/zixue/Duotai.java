/*多态的使用
	1:编译时参阅的是引用型变量所属类中是否有调用的方法
	2：运行期间参阅对象所属类中的方法
	3：多态的前提：a:必须得类与类之前存在关系，可以是继承关系，也可以是实现关系
			  b:必须得有重写
*/
package com.zixue;

class Animal{
	void sing(){
		System.out.println("唱歌");
	}
}

class Cat2 extends Animal{
	void sing(){
		System.out.println("喵喵的唱歌");
	}
}

class Dog1 extends Animal{
	void sing(){
		System.out.println("汪汪的唱歌");
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
		function(c);//调用多态时，子类不重写，直接调用父类的函数
	}
	
	public static void function(Animal a){//多态方法
		a.sing();
	}
}
