//��̬��Ӧ�ã�������Σ���߳���Ŀ���չ�ԣ���ߴ���Ч�ʣ�
//abstract:�ڳ�����࣬����ķ���


package com.zixue;
import java.util.*;
abstract class Fk{//���࣬������࣬����ֱ�ӱ����ã�������New����
	abstract void bx();//����ķ��������У����еľ������ݣ�����Ҫ�����ڳ�������У�����Ҫ��д����ĵĳ��󷽷������Ǿ����࣬���ܱ�New��������������Ҳ��һ��������	
	void printout(){//�������п����о������;��巽��
		String a="����";
		System.out.println(a);
	}
}

class Fk_lzx extends Fk{//���࣬�̳й�ϵ
	void bx(){
		System.out.println("�����εı���");
	}
}
class Fk_zzx extends Fk{//���࣬�̳й�ϵ
	void bx(){
		System.out.println("z���εı���");
	}
}
class Fk_ctx extends Fk{//���࣬�̳й�ϵ
	void bx(){
		System.out.println("�����εı���");
	}
}
class Fk_tzx extends Fk{//���࣬�̳й�ϵ
	void bx(){
		System.out.println("T���εı���");
	}
}

public class Duotai1 {
	public static void main(String[] args){
		Random a=new Random();//����һ�������
		int b=a.nextInt(4);//���0123
		
		Fk ff=null;//����һ�����飨��Ϊ�����ǳ����಻��New������Ϊ�գ����������еķ���Ҫʹ�ã�������������д������Ȼ�󴴽��������������
		switch(b){//��̬��Ӧ��
		case 0:
			ff=new Fk_lzx();//������Խ�������Ķ���
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
