/*�ӿڵĴ�����ʹ��  
   ��interface ����class�����ӿ�
  ��implements���ӽӿ�
  
  �ӿ�֮���м̳У�extends����ϵ
  ������֮���м̳У�extends����ϵ
  ����ӿ�֮����ʵ�֣�implements����ϵ
*/

package com.zixue;

interface Smoke{//��interface�����ӿ�
	void smoke();//Ĭ�ϻ��Ϊpublic static void smoke();
}

interface Game extends Smoke{
	void game();
}

class Student8 implements Smoke,Game{//��implements���ӽӿڣ������ж���ӿ��ö��Ÿ���
	public void smoke(){//��д�ӿ��еĳ�������ע��ʹ��Public
		System.out.println("����");
	};
	public void game(){//���к�����Ҫ��д���������Ҳ�ǳ�����
		System.out.println("����Ϸ");
	};
}
public class Jiekou {
	public static void main(String[] args){
		Student8 a=new Student8();
		a.smoke();
		a.game();
	}
}
