package gongju;
import java.io.*;
import java.util.*;

import jiemian.*;
public class Glhylb {
	private static HashMap hm=new HashMap<String,Liebiao>();
	public static void addLiebiao(String It,Liebiao lb){
		hm.put(It, lb);
	}
	public static Liebiao getQqfriendList(String It){
		return (Liebiao)hm.get(It);
	}
}
