//ArrayList �����ã�����Ĺ���

package jingjie;
import java.util.*;
public class L4_1 {
	public static void main(String[] args){
		ArrayList<Xs> xx=new ArrayList<Xs>();//ArrayList<>����һ�����Xs������
		System.out.println(xx.size());
		Xs a1=new Xs("С��",01,80);
		Xs a2=new Xs("С��",02,77);
		Xs a3=new Xs("С��",03,96);
		Xs a4=new Xs("С��",04,76);
		xx.add(a1);//��������Ӷ���Ĭ�϶����±�Ϊ0��ʼ
		xx.add(a2);
		xx.add(a3);
		
		System.out.println(xx.size());
		xx.remove(1);//ɾ������ڡ�1���±��ѧ����Ĭ�ϴ�0��ʼ,ɾ����xx�ж�����Ҳ�����
		xx.add(1,a4);//��a4��ӵ���2��λ�ã�Ĭ��λ�ô�0��ʼ������1Ϊ�ڶ���λ�ã�
		System.out.println(xx.size());
		for(int i=0;i<xx.size();i++){
			Xs b=xx.get(i);//xx.get(i)�õ���i�����󣬸ö���Ϊѧ�����Կ���ǿ��ת����ѧ��
			System.out.println("��"+(i+1)+"��ѧ��������Ϊ"+b.getXingming());
		}		
	}
}


class Xs{
	private String xingming;
	private int xuehao;
	private int chengji;
	
	Xs(String xingming,int xuehao,int chengji){
		this.xingming=xingming;
		this.xuehao=xuehao;
		this.chengji=chengji;
	}
	public String getXingming() {
		return xingming;
	}

	public int getXuehao() {
		return xuehao;
	}

	public int getChengji() {
		return chengji;
	}


	
}