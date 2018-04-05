package com.zixue;

class Cat{
	String name;
	int age;
	String color;
	public void Set(String a,int age,String c){
		this.name=a;//使用并重新定义类中的对象
		this.age=age;//this 可以解决类与方法的重名问题
		this.color=c;
	}
	public String toString(){
		return "姓名"+name+"\t年龄"+age+"\t颜色"+color;
	}
	
	public Cat a(){
		return this;//返回Cat类型中的对象
	}
}

public class Lei3 {
	public static void main(String[] args) {
		Cat one=new Cat();
		Cat two=new Cat();
		Cat three=new Cat();
		one.Set("第一只猫", 12, "蓝色");
		System.out.println(one);//直接写类名，默认调用ToString方法
		two.Set("第二只猫", 3, "绿色");
		System.out.println(two);
		three=two.a();//调用two中的方法a()得到two的对象参数返回值
		System.out.println(three);
	}
}
