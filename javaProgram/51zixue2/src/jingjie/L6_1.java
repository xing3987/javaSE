//�̵߳�ʹ�úʹ��� Thread--ʵ�ֽӿڷ������е��̶߳���ͬ���ģ�


package jingjie;

public class L6_1{
	public static void main(String[] args){
		Aa xx=new Aa();
		Ba xy=new Ba();
		Thread a=new Thread(xx);
		a.setName("��һ���߳�");//�����߳�����		
		Thread b=new Thread(xy);
		b.setPriority(Thread.NORM_PRIORITY+4);//�����߳����ȼ���Ĭ��Norm_PriorityΪ5   +4�ӵ�������ȼ�Խ��
		b.setName("�ڶ����߳�");
		a.start();
		b.start();
	/*	for(int i=0;i<1000;i++){
			System.out.print(Thread.currentThread().getName()+"��ִ��");//�õ���ǰ�߳�����
			System.out.println("������"+(i+1)+"��");
		}*/
	}

}
class Aa implements Runnable{
	public void run() {
		for(int i=0;i<1000;i++){
			System.out.print("��һ���߳�������"+(i+1)+"��");
			System.out.println(Thread.currentThread().getName()+"��ִ��");
			try{
				Thread.sleep(1000);//����1000ms==1s,�÷���ʹ��ʱҪ�����쳣,���쳣����ʱ�������ϼ�throws����Ϊ�ϼ���run()����û��throws�쳣
			}catch(Exception e){
				
			}
		}
		
	}
}

class Ba implements Runnable{
	public void run() {
		for(int i=0;i<1000;i++){
			System.out.print("�ڶ����߳�������"+(i+1)+"��");
			System.out.println(Thread.currentThread().getName()+"��ִ��");
			
			
		}
		
	}
}