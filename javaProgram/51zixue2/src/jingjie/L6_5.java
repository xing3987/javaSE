//���̵߳Ĵ���--��Ʊ����(ͬ���Ľ��)


package jingjie;

public class L6_5{
	public static void main(String[] args){
		Hcz1 xx=new Hcz1();Hcz1 xy=new Hcz1();
		Thread a=new Thread(xx);Thread b=new Thread(xy);//ע�������߳�ʱ��Ҫ��ͬһ��xx����߳�
		a.setName("��һ������");b.setName("�ڶ�������");
		try{
			a.start();b.start();
		}catch(Exception e){

		}

	}
}
class Hcz1 implements Runnable{
	public static int chepiao=100;
    public static String a=new String("1");//��ͬ���ַ���̬����������ͬ�߳���a
	public void run() {
		for(int i=1;;i++){
			synchronized(a){//ʹ��ͬ��������synchronized���ַ������� �÷����ڱ���ִ����ſ��Ը������̼߳���ִ�У���a�����ǹ�����
				if(chepiao<=0){
					break;
				}
				System.out.println( Thread.currentThread().getName()+"��������"+(101-chepiao)+"�ų�Ʊ");
				chepiao--;
			}
		}

	}
}
