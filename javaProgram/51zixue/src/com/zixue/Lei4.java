//���Եķ�װ

package com.zixue;

class Dog{
	private char gender;//�����Զ���ɸ���˽�еģ���װ��һ����
	
	public char getGender(){//ʹ�÷����õ��ö�������ֵ����װ�ڶ�����
		return this.gender;
	}
	
	public  void setGender(char gender){//ʹ�÷���������������ֵ����װ����������Ȧ����������ֵ�ķ�Χ��
		if (gender=='��'||gender=='ĸ'){
			this.gender=gender;
		}else{
			System.out.println("��������ȷ�Ա�");
		}
	}
}

public class Lei4 {
	public static void main(String[] args) {
		Dog a=new Dog();
		a.setGender('��');//�÷��������ö���
		System.out.println(a.getGender());//�÷������ö��󲢴�ӡ
		
		
	}
}
