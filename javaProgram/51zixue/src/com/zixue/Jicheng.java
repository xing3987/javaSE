//�̳���   ʹ��extends������ӵ�и���ĳ�Ա�����ǲ�ӵ��˽�л��ĳ�Ա�����Զ��׼̳У�Խ�����ϲ�ӵ����������Ĺ��ԣ�


package com.zixue;

class MaoKe {//����
	private String looks="С";//˽�л��������಻�ܵ��ã�ֻ���ڵ�ǰ����
	int age;
	String name="è";
	void Keai(){
		System.out.println(looks+"è�ܿɰ�");
	}
}

class HuaMao extends MaoKe{//���࣬�̳��˸����˽�ж���������Ժͷ���
	String color="��";
	void Meili(){
		System.out.println("è������");
	}
}

class Panda extends HuaMao{//���׼̳�
	String color="�ڰ�";//�����븸��һ���Ķ���(ʵ�ʿ�����һ�㲻�������ã��������븸����������)
	String amount="ϡ��";
	void show(){
		System.out.println(this.color);//this�������ʵ�ǰ�Ķ��󣬿���ʡ��
		System.out.println(super.color);//super�������ʸ���Ķ���
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
