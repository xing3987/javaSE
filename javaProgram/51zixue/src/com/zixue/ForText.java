package com.zixue;
import java.util.*;
public class ForText {
	public static void main(String[] args) {
		Scanner a=new Scanner(System.in);
		for(;;){//没有条件也会运行，但容易死循环，内部一定要有break跳出循环
			System.out.println("还跑么");
			String flag=a.next();
			if(flag.equals("yes")){//调用函数等于。equals()
				System.out.println("继续跑");
			}else{
				break;
			}
		}
		a.close();
	}
}
