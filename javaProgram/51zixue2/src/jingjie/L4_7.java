package jingjie;
import java.lang.reflect.Method;
//import java.util.*;
public class L4_7 {
	public static void main(String[] args){
		//Bh<String> hw1=new Bh<String>("�ٻ�");
		Bh<Wj> hw2=new Bh<Wj>(new Wj());
		//hw1.lxmc();
		hw2.lxmc();
	}	
}
class Wj{
	public void wan(){
		System.out.println("��������Ϸ");
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
		System.out.println("���������ǣ�"+l.getClass().getName());//ȡ������
		Method [] a=l.getClass().getDeclaredMethods();//ȡ��L�����е����з�������ֵ����������a��Method[]ΪĬ�ϵķ���������Ҫ����java.lang.reflect.Method��
		for(int i=0;i<a.length;i++){
			System.out.println("��������Ϊ"+a[i].getName());
		}
	}
}