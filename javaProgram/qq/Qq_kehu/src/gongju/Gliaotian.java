package gongju;
import java.util.*;

import jiemian.*;
public class Gliaotian {
	public static HashMap hm=new HashMap<String,Liaotian>();
	public static void addLiaotian(String haoyou,Liaotian liaotian){
		hm.put(haoyou, liaotian);
	}
	public static Liaotian getLiaotian(String haoyou){
		return (Liaotian) hm.get(haoyou);
	}
}
