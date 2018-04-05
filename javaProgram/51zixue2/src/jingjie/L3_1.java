//equals方法

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

	
	public boolean equals(B a){//覆盖方法，便于使用判断需要相等的部分
		if (this.i==a.i){
			return true;
		}else{
			return false;
		}
	}
}

class C extends B{//创建一个B的子类C
	private int j;
	C(int j){
		super(j);//运行后，B类中的i值就等于j,如果不写默认super()会报错，因为父类重写了构造语句
		this.j=j;
	}
	public boolean equals(B a){//覆盖方法，使用多态传递一个B类数据，实际强制转为C类调用C类函数
		C x=(C)a;
		if (this.j==x.j){
			return true;
		}else{
			return false;
		}
	}	
	
}