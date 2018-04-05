package com.zixue;

/**
 此类是对数组进行取值，排序操作的
 @author 黄辰星	
 @version 1.0   
 */
public class WendangZhushi {//public 类才能注释
	private WendangZhushi(){//私有化构造函数使其不被注释提取
		
	}
	
	/**
		取int数组里的最大值
		@param arr 传入一个int数组
		@return 返回一个int值
	 */	
	public static int maxArray(int[] arr){//求最大值
		int max=arr[0];
		for(int i=0;i<arr.length;i++){
			if(arr[i]>max){
				max=arr[i];
			}
		}
		return max;
	}
}
