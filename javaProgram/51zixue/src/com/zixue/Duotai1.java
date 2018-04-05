//多态的应用，方块变形（提高程序的可拓展性，提高代码效率）
//abstract:在抽象的类，抽象的方法


package com.zixue;
import java.util.*;
abstract class Fk{//父类，抽象的类，不能直接被引用，即不能New出来
	abstract void bx();//抽象的方法不含有｛｝中的具体内容，必须要存在于抽象的类中，子类要重写父类的的抽象方法才能是具体类，才能被New创建，否则子类也是一个抽象类	
	void printout(){//抽象类中可以有具体对象和具体方法
		String a="变形";
		System.out.println(a);
	}
}

class Fk_lzx extends Fk{//子类，继承关系
	void bx(){
		System.out.println("人字形的变形");
	}
}
class Fk_zzx extends Fk{//子类，继承关系
	void bx(){
		System.out.println("z字形的变形");
	}
}
class Fk_ctx extends Fk{//子类，继承关系
	void bx(){
		System.out.println("长条形的变形");
	}
}
class Fk_tzx extends Fk{//子类，继承关系
	void bx(){
		System.out.println("T字形的变形");
	}
}

public class Duotai1 {
	public static void main(String[] args){
		Random a=new Random();//创建一个随机数
		int b=a.nextInt(4);//随机0123
		
		Fk ff=null;//创建一个方块（因为父类是抽象类不能New创建，为空），抽象类中的方法要使用，必须有子类重写方法，然后创建子类对象来调用
		switch(b){//多态的应用
		case 0:
			ff=new Fk_lzx();//父类可以接收子类的对象
			break;
		case 1:
			ff=new Fk_zzx();
			break;
		case 2:
			ff=new Fk_ctx();
			break;
		case 3:
			ff=new Fk_tzx();
			break;			
		}
		ff.bx();
	}
}
