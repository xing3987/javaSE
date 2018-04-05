//ArrayList 的运用，数组的管理

package jingjie;
import java.util.*;
public class L4_1 {
	public static void main(String[] args){
		ArrayList<Xs> xx=new ArrayList<Xs>();//ArrayList<>建立一个存放Xs的数组
		System.out.println(xx.size());
		Xs a1=new Xs("小明",01,80);
		Xs a2=new Xs("小王",02,77);
		Xs a3=new Xs("小红",03,96);
		Xs a4=new Xs("小狗",04,76);
		xx.add(a1);//数组中添加对象，默认对象下标为0开始
		xx.add(a2);
		xx.add(a3);
		
		System.out.println(xx.size());
		xx.remove(1);//删除对象第【1】下标的学生，默认从0开始,删除后xx中对象数也会减少
		xx.add(1,a4);//把a4添加到第2个位置（默认位置从0开始，所以1为第二个位置）
		System.out.println(xx.size());
		for(int i=0;i<xx.size();i++){
			Xs b=xx.get(i);//xx.get(i)得到第i个对象，该对象为学生所以可以强制转换成学生
			System.out.println("第"+(i+1)+"个学生的姓名为"+b.getXingming());
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