package com.zixue;

public class Lei1 {
	public static void main(String[] args){
		Person MyPerson=new Person();
		MyPerson.name="����";
		System.out.println(MyPerson.name);
		MyPerson.eat();//�����޲����޷��ط���
		MyPerson.sleep("����");//�����в����޷��صķ���
		int age=MyPerson.getAge(18);//�����в����з��صķ���
		System.out.println(age);
		
		System.out.println(MyPerson.gender);//��Ա����String��δ��ֵʱĬ��ΪNULL
	}
}
