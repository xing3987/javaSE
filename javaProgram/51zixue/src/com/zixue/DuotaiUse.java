package com.zixue;

abstract class Demo{
	public final void getTime(){//ģ�鷽�������ܱ�����
		long start=System.currentTimeMillis();//�õ�ϵͳ��ǰʱ��1s����1000ms,��ֵΪ������
		function();
		long end=System.currentTimeMillis();
		System.out.println("�������л���ʱ��Ϊ"+(end-start)+"����");
	}
	public abstract void function();
	
}

class Text extends Demo{
	public void function(){
		for(int i=0;i<666;i++){
		System.out.println("�ú�ѧϰ");
		System.out.println("��������");
		}
	}
}
public class DuotaiUse {
	public static void main(String[] args){
		Text a=new Text();
		a.getTime();
	}	
}
