package gongju;
import java.util.*;
public class Glxc {
	private static  HashMap hm=new HashMap<String,Ljfwqxc>();
	public static void addLjfwqxc(String ltId,Ljfwqxc ljxc)
	{
		hm.put(ltId,ljxc);
	}	
	public static Ljfwqxc getLjfwqxc(String ltId)
	{
		return (Ljfwqxc)hm.get(ltId);
	}
}
