//�̵߳�ʹ�ã��̵߳��ò�������


package jingjie;

public class L6_3{
	public static void main(String[] args){
		Ab1 xa=new Ab1();
		Thread xx=new Thread(xa);
		xx.start();
		try{
			xx.join();//ʹ�ø����ʱ��������xx�̣߳�ִ������̺߳�ż���ִ�У��ú���Ҫ�����쳣
		}catch(Exception e){
			
		}
		for(int i=0;i<1000;i++){
			System.out.println("������������"+(i+1)+"��");

		}

	}

}
class Ab1 implements Runnable{
	public void run() {
		for(int i=0;i<1000;i++){
			System.out.println("�γ���������"+(i+1)+"��");
			if(i%5==0){
				Thread.yield();//�̵߳��ò�
			}
		}
		
	}
}