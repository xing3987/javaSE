package com.zixue;

class Print{
	public String print(String n){
		System.out.println(n);
		return n;//����һ��Stringֵ����д�ᱨ��
	}
}


class Return{
	public void print1(int a){
		if(a==0){
			System.out.println("���");
		}else if(a==1){
			return;//����������ǰ����void�޲�������ֵ�ķ���
		}
		System.out.println("��Ҳ��");
	}
}

public class Lei2 {//����ֻ��һ��������public����ֻ��һ����Ȼ�ᱨ��
	public static void main(String[] args) {
		Print a=new Print();//������
		a.print("С��");//�������еķ���
		String name=a.print("С��");//���÷���������ֵ
		System.out.println(name);
		
		Return b=new Return();
		b.print1(0);
		b.print1(1);
	}
}
