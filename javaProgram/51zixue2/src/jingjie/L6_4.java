//���̵߳Ĵ���--��Ʊ����


package jingjie;

public class L6_4{
	public static void main(String[] args){
		Hcz xx=new Hcz();
		Thread a=new Thread(xx);Thread b=new Thread(xx);//ע�������߳�ʱ��Ҫ��ͬһ��xx����߳�
		a.setName("��һ������");b.setName("�ڶ�������");
		try{
			a.start();b.start();
		}catch(Exception e){

		}

	}
}
class Hcz implements Runnable{
	public static int chepiao=100;
    String a=new String("1");
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

