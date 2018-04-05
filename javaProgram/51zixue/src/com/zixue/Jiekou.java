/*接口的创建和使用  
   用interface 代替class创建接口
  用implements连接接口
  
  接口之间有继承（extends）关系
  类与类之间有继承（extends）关系
  类与接口之间有实现（implements）关系
*/

package com.zixue;

interface Smoke{//用interface创建接口
	void smoke();//默认会改为public static void smoke();
}

interface Game extends Smoke{
	void game();
}

class Student8 implements Smoke,Game{//用implements连接接口，可以有多个接口用逗号隔开
	public void smoke(){//重写接口中的抽象函数，注意使用Public
		System.out.println("吸烟");
	};
	public void game(){//所有函数都要重写，否则该类也是抽象类
		System.out.println("玩游戏");
	};
}
public class Jiekou {
	public static void main(String[] args){
		Student8 a=new Student8();
		a.smoke();
		a.game();
	}
}
