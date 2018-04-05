

package com.zixue;

public class StaticUse1 {
	public static void main(String[] args){
		int[] arr={12,13,585,475,697};
		System.out.println(max(arr));
		System.out.println(ArrayOperate.minArray(arr));//等同于ArrayOperate a=new ArrayOperate();a.minArray(arr){需要这样使用时，调用该类的方法要为静态方法}
		ArrayOperate.maoSort(arr);
		ArrayOperate.printArray(arr);
		
		int[] arr1={122,133,545,415,197};
		System.out.println(ArrayOperate.maxArray(arr1));
		System.out.println(ArrayOperate.minArray(arr1));
		ArrayOperate.xuanzeSort(arr1);
		ArrayOperate.printArray(arr1);
		
	}
	
	
	static int max(int[] arr){
		int max=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]>max){
				max=arr[i];
			}
		}
		return max;
	}
}
