//map�ṹ����(HashMap)�Ĵ�����Ӧ��,�����������б�־�����ظ�

package jingjie;
import java.util.*;
public class L4_4 {
	public static void main(String[] args){
		HashMap<String,Sp> ee=new HashMap<String,Sp>();//��������
		Sp d1=new Sp("002","����",2);//������Ʒ
		Sp d2=new Sp("003","���",4);
		Sp d3=new Sp("006","����",2.22f);
		ee.put("a", d1);//�����Ʒ��ʹ��put��ӣ�ÿ�����󶼶�Ӧһ��String�ַ�
		ee.put("2", d2);
		ee.put("2", d3);//�ص㣬�����ֵ��ͬ���ĻḲ��ǰ���ֵ������
		System.out.println(ee.get("a").getJiage());//��ӡ����
		if(ee.containsKey("2")){//���Ҷ���
			Sp sp=ee.get("2");
			System.out.println("��Ʒ���ƣ�\t"+sp.getName()+"\t��Ʒ�۸�\t"+sp.getJiage());
		}
		Iterator<String> it=ee.keySet().iterator();//ȡ��ee�����е����м�ֵ
		while(it.hasNext()){
			String key=it.next().toString();
			Sp sp=ee.get(key);
			System.out.println("ʳƷ����\t"+sp.getName());
		}
	}
}
