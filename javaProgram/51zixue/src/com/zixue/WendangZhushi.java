package com.zixue;

/**
 �����Ƕ��������ȡֵ�����������
 @author �Ƴ���	
 @version 1.0   
 */
public class WendangZhushi {//public �����ע��
	private WendangZhushi(){//˽�л����캯��ʹ�䲻��ע����ȡ
		
	}
	
	/**
		ȡint����������ֵ
		@param arr ����һ��int����
		@return ����һ��intֵ
	 */	
	public static int maxArray(int[] arr){//�����ֵ
		int max=arr[0];
		for(int i=0;i<arr.length;i++){
			if(arr[i]>max){
				max=arr[i];
			}
		}
		return max;
	}
}
