package com.zixue;
import java.util.*;
public class ForText {
	public static void main(String[] args) {
		Scanner a=new Scanner(System.in);
		for(;;){//û������Ҳ�����У���������ѭ�����ڲ�һ��Ҫ��break����ѭ��
			System.out.println("����ô");
			String flag=a.next();
			if(flag.equals("yes")){//���ú������ڡ�equals()
				System.out.println("������");
			}else{
				break;
			}
		}
		a.close();
	}
}
