//LinkedList�Ľ�����ʹ��

package jingjie;
import java.util.LinkedList;

public class L4_3 {
	public static void main(String[] args) throws Exception{
		LinkedList<Sp> cc=new LinkedList<Sp>();
		Sp c1=new Sp();
		c1.setName("����");
		Sp c2=new Sp();
		c2.setName("�ܲ�");
		Sp c3=new Sp();
		c3.setName("���");
		cc.addFirst(c1);//����Ķ����������Ķ���
		cc.addFirst(c2);//����Ķ����������Ķ���
		cc.addLast(c3);//����Ķ��������ײ�
		System.out.println(cc.size());
		for(int i=0;i<cc.size();i++){
		System.out.println(cc.get(i).getName());
		}
		System.out.println(cc.getFirst().getName());//cc.getFirst()�õ�����Ķ���
		System.out.println(cc.getLast().getName());//cc.getLast()�õ���ײ��Ķ���
	}
}
