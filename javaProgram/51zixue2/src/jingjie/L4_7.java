package jingjie;
import java.lang.reflect.Method;
//import java.util.*;
public class L4_7 {
	public static void main(String[] args){
		//Bh<String> hw1=new Bh<String>("百货");
		Bh<Wj> hw2=new Bh<Wj>(new Wj());
		//hw1.lxmc();
		hw2.lxmc();
	}	
}
class Wj{
	public void wan(){
		System.out.println("正在玩游戏");
	}
	public int jiafa(int a,int b){
		return a+b;
	}
}

class Bh<L>{
	private L l;
	Bh(L l){
		this.l=l;
	}
	
	public void lxmc(){
		System.out.println("类型名称是："+l.getClass().getName());//取函数名
		Method [] a=l.getClass().getDeclaredMethods();//取出L类型中的所有方法，赋值给方法数组a（Method[]为默认的方法数组需要调用java.lang.reflect.Method）
		for(int i=0;i<a.length;i++){
			System.out.println("函数名称为"+a[i].getName());
		}
	}
}