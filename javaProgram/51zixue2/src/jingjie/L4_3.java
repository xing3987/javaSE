//LinkedList的建立和使用

package jingjie;
import java.util.LinkedList;

public class L4_3 {
	public static void main(String[] args) throws Exception{
		LinkedList<Sp> cc=new LinkedList<Sp>();
		Sp c1=new Sp();
		c1.setName("土豆");
		Sp c2=new Sp();
		c2.setName("萝卜");
		Sp c3=new Sp();
		c3.setName("清菜");
		cc.addFirst(c1);//加入的对象放在数组的顶部
		cc.addFirst(c2);//加入的对象放在数组的顶部
		cc.addLast(c3);//加入的对象放在最底部
		System.out.println(cc.size());
		for(int i=0;i<cc.size();i++){
		System.out.println(cc.get(i).getName());
		}
		System.out.println(cc.getFirst().getName());//cc.getFirst()得到最顶部的对象
		System.out.println(cc.getLast().getName());//cc.getLast()得到最底部的对象
	}
}
