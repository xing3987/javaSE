//equals����

package jingjie;

public class L3_1 {
	public static void main(String[] args){
		B b1=new B(10);
		B b2=new B(10);
		System.out.println(b1.equals(b2));
		C c1=new C(10);
		C c2=new C(110);
		System.out.println(c1.equals(c2));
	}
}

class B{
	private int i;
	B(int i){
		this.i=i;
	}

	
	public boolean equals(B a){//���Ƿ���������ʹ���ж���Ҫ��ȵĲ���
		if (this.i==a.i){
			return true;
		}else{
			return false;
		}
	}
}

class C extends B{//����һ��B������C
	private int j;
	C(int j){
		super(j);//���к�B���е�iֵ�͵���j,�����дĬ��super()�ᱨ����Ϊ������д�˹������
		this.j=j;
	}
	public boolean equals(B a){//���Ƿ�����ʹ�ö�̬����һ��B�����ݣ�ʵ��ǿ��תΪC�����C�ຯ��
		C x=(C)a;
		if (this.j==x.j){
			return true;
		}else{
			return false;
		}
	}	
	
}