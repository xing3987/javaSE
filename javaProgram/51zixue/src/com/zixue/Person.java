//������

package com.zixue;

public class Person {
	
	//�����Ա����
	String name;
	String gender;
	int age;
	
	//�����޲����޷��ط���
	public void eat(){
		System.out.println("���ڳԷ�");
	}
	
	//�����в����޷��ط���
	public void sleep(String A){//void Ϊ�޷��ص���˼
		System.out.println("����"+A+"˯��");
	}
	
	
	//�����в��з��ط���
	public int getAge(int a){//��������Ϊint,����Ϊȡֵ����--get+N����ֵ����set+N
		return a;//���ز���Ϊa
	}
	
}
