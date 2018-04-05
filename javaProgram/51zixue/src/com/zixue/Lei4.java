//属性的封装

package com.zixue;

class Dog{
	private char gender;//把属性定义成该类私有的（封装第一步）
	
	public char getGender(){//使用方法得到该对象属性值（封装第二步）
		return this.gender;
	}
	
	public  void setGender(char gender){//使用方法重新设置属性值（封装第三步）（圈定输入属性值的范围）
		if (gender=='公'||gender=='母'){
			this.gender=gender;
		}else{
			System.out.println("请输入正确性别");
		}
	}
}

public class Lei4 {
	public static void main(String[] args) {
		Dog a=new Dog();
		a.setGender('公');//用方法来设置对象
		System.out.println(a.getGender());//用方法调用对象并打印
		
		
	}
}
