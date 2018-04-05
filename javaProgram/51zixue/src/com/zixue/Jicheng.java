//继承类   使用extends，子类拥有父类的成员，但是不拥有私有化的成员，可以多套继承（越是最上层拥有所有子类的共性）


package com.zixue;

class MaoKe {//父类
	private String looks="小";//私有化变量子类不能调用，只用于当前函数
	int age;
	String name="猫";
	void Keai(){
		System.out.println(looks+"猫很可爱");
	}
}

class HuaMao extends MaoKe{//子类，继承了父类除私有对象外的属性和方法
	String color="花";
	void Meili(){
		System.out.println("猫很美丽");
	}
}

class Panda extends HuaMao{//多套继承
	String color="黑白";//建立与父类一样的对象(实际开发中一般不会这样用，不会有与父类重名变量)
	String amount="稀少";
	void show(){
		System.out.println(this.color);//this用来访问当前的对象，可以省略
		System.out.println(super.color);//super用来访问父类的对象
	}
}
public class Jicheng {
	public static void main(String[] args){
		Panda a=new Panda();
		System.out.println(a.name);
		a.Keai();
		System.out.println(a.color);
		a.show();
	}
	
}
