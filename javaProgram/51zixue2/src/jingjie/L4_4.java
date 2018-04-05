//map结构数组(HashMap)的创建和应用,特性是数据有标志不会重复

package jingjie;
import java.util.*;
public class L4_4 {
	public static void main(String[] args){
		HashMap<String,Sp> ee=new HashMap<String,Sp>();//建立数组
		Sp d1=new Sp("002","狗狗",2);//创建商品
		Sp d2=new Sp("003","青菜",4);
		Sp d3=new Sp("006","兔兔",2.22f);
		ee.put("a", d1);//添加商品，使用put添加，每个对象都对应一个String字符
		ee.put("2", d2);
		ee.put("2", d3);//特点，如果键值相同最后的会覆盖前面键值的数据
		System.out.println(ee.get("a").getJiage());//打印对象
		if(ee.containsKey("2")){//查找对象
			Sp sp=ee.get("2");
			System.out.println("商品名称：\t"+sp.getName()+"\t商品价格：\t"+sp.getJiage());
		}
		Iterator<String> it=ee.keySet().iterator();//取出ee数组中的所有键值
		while(it.hasNext()){
			String key=it.next().toString();
			Sp sp=ee.get(key);
			System.out.println("食品名称\t"+sp.getName());
		}
	}
}
