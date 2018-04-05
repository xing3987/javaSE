//静态应用工具类的创建和使用

package com.zixue;

public class ArrayOperate {
	private ArrayOperate(){//私有化封装该类，使之不能用NEW调用

	}

	 static int maxArray(int[] arr){//求最大值
		int max=arr[0];
		for(int i=0;i<arr.length;i++){
			if(arr[i]>max){
				max=arr[i];
			}
		}
		return max;
	}

	static int minArray(int[] arr){//求最小值
		int min=arr[0];
		for(int i=0;i<arr.length;i++){
			if(arr[i]<min){
				min=arr[i];
			}
		}
		return min;
	}

	static void maoSort(int[] arr){//冒泡排序
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-1;j++){
				replace(arr,j,j+1);
			}
		}
	}

	static void xuanzeSort(int[] arr){//选择排序
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length-1;j++){
				replace(arr,i,j);
			}
		}
	}

	static void printArray(int[] arr){//打印数组
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+"\t");
		}
		System.out.println("");
	}

	public static void replace(int[] arr,int a,int b){//两个数从小到大排列
		if(arr[a]>arr[b]){
			int t=arr[a];
			arr[a]=arr[b];
			arr[b]=t;
		}
	}

}
