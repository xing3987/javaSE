//�̵߳�ʹ�úʹ��� Thread--�̳����̷߳�


package jingjie;

public class L6_2{
	public static void main(String[] args){
		Ab xx=new Ab();

		xx.start();
		for(int i=0;i<1000;i++){
			System.out.println("������������"+(i+1)+"��");
		}

	}

}
class Ab extends Thread{
	public void run() {
		for(int i=0;i<1000;i++){
			System.out.println("������"+(i+1)+"��");
		}
		
	}
}